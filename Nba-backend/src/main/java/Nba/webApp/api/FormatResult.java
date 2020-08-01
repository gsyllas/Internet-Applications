package Nba.webApp.api;

import com.google.gson.stream.JsonWriter;
import Nba.dataModel.PlayerData;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.representation.WriterRepresentation;
import org.restlet.resource.ResourceException;
import Nba.webApp.api.representation.RepresentationGenerator;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.function.Consumer;
import java.lang.String;

public enum FormatResult implements RepresentationGenerator {
    JSON{
            public Representation generateRepresentationPlayer(List<PlayerData> result) {
            return new CustomJsonRepresentation( (JsonWriter w) -> {
                try {
                    w.beginArray(); // [
                    for(PlayerData rec: result) {
                        w.beginObject(); // {
                        w.name("PlayerName").value(rec.getPlayerName());
                        w.name("Height").value(rec.getPlayerHeight());
                        w.name("Weight").value(rec.getPlayerWeight());
                        w.name("College").value(rec.getCollege());
                        w.name("YearBorn").value(rec.getYearBorn());
                        w.name("BirthCity").value(rec.getBirthCity());
                        w.name("BirthState").value(rec.getBirthState());
                        w.name("Position").value(rec.getPosition());
                        w.name("Age").value(rec.getAge());
                        w.name("Team").value(rec.getTeam());
                        w.name("Games").value(rec.getGames());
                        w.name("MinutesPlayed").value(rec.getMinutesPlayed());
                        w.name("MinutesPerGame").value(String.format("%.02f",(float)rec.getMinutesPlayed()/rec.getGames()));
                        w.name("PER").value(String.format("%.02f",rec.getPerformanceIndexrating()));
                        w.name("FG").value(rec.getfG());
                        w.name("FGA").value(rec.getfGA());
                        w.name("FG%").value(String.format("%.02f",(float)rec.getfG()/rec.getfGA()));
                        w.name("3P").value(rec.getT3P());
                        w.name("3PA").value(rec.getT3PA());
                        w.name("3P%").value(String.format("%.02f",(float)rec.getT3P()/rec.getT3PA()));
                        w.name("FT").value(rec.getfT());
                        w.name("FTA").value(rec.getfTA());
                        w.name("FT").value(String.format("%.02f",(float)rec.getfT()/rec.getfTA()));
                        w.name("Rebounds").value(rec.gettRB());
                        w.name("ReboundsPerGame").value(String.format("%.02f",(float)rec.gettRB()/rec.getGames()));
                        w.name("Assists").value(rec.getaST());
                        w.name("AssistsPerGame").value(String.format("%.02f",(float)rec.getaST()/rec.getGames()));
                        w.name("Steals").value(rec.getsTL());
                        w.name("StealsPerGame").value(String.format("%.02f",(float)rec.getsTL()/rec.getGames()));
                        w.name("Blocks").value(rec.getbLK());
                        w.name("BlocksPerGame").value(String.format("%.02f",(float)rec.getbLK()/rec.getGames()));
                        w.name("Turnovers").value(rec.gettOV());
                        w.name("TurnoversPerGame").value(String.format("%.02f",(float)rec.gettOV()/rec.getGames()));
                        w.name("Points").value(rec.getPoints());
                        w.name("PointsPerGame").value(String.format("%.02f",(float)rec.getPoints()/rec.getGames()));
                        w.endObject(); // }
                        w.flush();
                    }
                    w.endArray(); // ]
                } catch (IOException e) {
                    throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
                }
            });
        }

        public Representation generateBestScorers(List<PlayerData> result) {
            return new CustomJsonRepresentation( (JsonWriter w) -> {
                try {
                    w.beginArray(); // [
                    for(PlayerData rec: result) {
                        w.beginObject(); // {
                        w.name("PlayerName").value(rec.getPlayerName());
                        w.name("Height").value(rec.getPlayerHeight());
                        w.name("Weight").value(rec.getPlayerWeight());
                        w.name("College").value(rec.getCollege());
                        w.name("Position").value(rec.getPosition());
                        w.name("Age").value(rec.getAge());
                        w.name("Team").value(rec.getTeam());
                        w.name("Games").value(rec.getGames());
                        w.name("MinutesPerGame").value(String.format("%.02f",(float)rec.getMinutesPlayed()/rec.getGames()));;
                        w.name("FG%").value(String.format("%.02f",(float)rec.getfG()/rec.getfGA()));
                        w.name("3P%").value(String.format("%.02f",(float)rec.getT3P()/rec.getT3PA()));
                        w.name("FT").value(String.format("%.02f",(float)rec.getfT()/rec.getfTA()));
                        w.name("ReboundsPerGame").value(String.format("%.02f",(float)rec.gettRB()/rec.getGames()));
                        w.name("AssistsPerGame").value(String.format("%.02f",(float)rec.getaST()/rec.getGames()));
                        w.name("StealsPerGame").value(String.format("%.02f",(float)rec.getsTL()/rec.getGames()));
                        w.name("BlocksPerGame").value(String.format("%.02f",(float)rec.getbLK()/rec.getGames()));
                        w.name("TurnoversPerGame").value(String.format("%.02f",(float)rec.gettOV()/rec.getGames()));
                        w.name("PointsPerGame").value(String.format("%.02f",(float)rec.getPoints()/rec.getGames()));
                        w.endObject(); // }
                        w.flush();
                    }
                    w.endArray(); // ]
                } catch (IOException e) {
                    throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
                }
            });
        }
    };
    private static final class CustomJsonRepresentation extends WriterRepresentation {

        private final Consumer<JsonWriter> consumer;

        CustomJsonRepresentation(Consumer<JsonWriter> consumer) {
            super(MediaType.APPLICATION_JSON);
            this.consumer = consumer;
        }

        @Override
        public void write(Writer writer) throws IOException {
            JsonWriter jsonWriter = new JsonWriter(writer);
            consumer.accept(jsonWriter);
        }
    }
}
