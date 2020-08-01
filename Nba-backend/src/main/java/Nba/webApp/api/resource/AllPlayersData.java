package Nba.webApp.api.resource;

import Nba.dataModel.PlayerData;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import Nba.webApp.api.FormatResult;
import Nba.webApp.configuration.AppConfiguration;
import Nba.webApp.data.DataAccess;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AllPlayersData extends ServerResource {
    private final DataAccess dataAccess = AppConfiguration.getInstance().getDataAccess();

    static FormatResult parseFormat(String format) {
        Optional<FormatResult> optional = Arrays.stream(FormatResult.values()).
                filter( (FormatResult f) -> f.name().equalsIgnoreCase(format)).
                findFirst();
        return optional.orElse(FormatResult.JSON);
    }
    
    static String sanitize(String s) {
        return s == null ? "" : s.trim();
    }

    protected String getAttributeDecoded(String attr) {
        String value = getAttribute(attr);
        return value == null ?  null : sanitize(URLDecoder.decode(value, StandardCharsets.UTF_8));
    }

    protected String getMandatoryAttribute(String attr, String message) {
    String value = getAttributeDecoded(attr);
    if (value.length() == 0) {
        throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, message);
    }
    return value;
    }

    @Override
    protected Representation get() throws ResourceException {

        // Read the mandatory URI attributes
        String h = getRequest().getHeaders().toString();
        String playerName = getMandatoryAttribute("PlayerName", "PlayerName is missing");




        // Read the format query parameter
        FormatResult format = parseFormat(getQueryValue("format"));

        try {

            List<PlayerData> result = dataAccess.getAllPlayersData(playerName);
            return format.generateRepresentationPlayer(result);
        } catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }

    }
}
