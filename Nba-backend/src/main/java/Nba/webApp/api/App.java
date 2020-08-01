package Nba.webApp.api;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.data.Method;
import org.restlet.engine.application.CorsFilter;
import org.restlet.routing.Router;
import Nba.webApp.api.resource.AllPlayersData;
import Nba.webApp.api.resource.BestScorers;

import java.util.Set;

public class App extends Application {
    @Override
    public synchronized Restlet createInboundRoot() {

        Router router = new Router(getContext());

        router.attach("/AllPlayers/{PlayerName}", AllPlayersData.class);
        router.attach("/BestScorers/{Year}", BestScorers.class);



        CorsFilter corsFilter = new CorsFilter(getContext(), router);
        corsFilter.setAllowedOrigins(Set.of("*"));
        corsFilter.setAllowedCredentials(true);
        corsFilter.setAllowedHeaders(Set.of("X-OBSERVATORY-AUTH"));
        corsFilter.setDefaultAllowedMethods(Set.of(Method.GET, Method.PUT, Method.POST, Method.DELETE));
        corsFilter.setAllowingAllRequestedHeaders(true);
        corsFilter.setSkippingResourceForCorsOptions(true);
        corsFilter.setMaxAge(10);
        return corsFilter;
    }
}
