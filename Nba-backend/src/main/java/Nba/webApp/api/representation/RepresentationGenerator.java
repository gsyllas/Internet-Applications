package Nba.webApp.api.representation;

import Nba.dataModel.PlayerData;
import org.restlet.representation.Representation;

import java.util.List;

public interface RepresentationGenerator {
    Representation generateRepresentationPlayer(List<PlayerData> result);
    Representation generateBestScorers(List<PlayerData> result);
}
