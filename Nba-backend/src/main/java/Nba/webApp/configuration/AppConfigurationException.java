package Nba.webApp.configuration;

public class AppConfigurationException extends RuntimeException {

    public AppConfigurationException(String msg) {
        super(msg);
    }

    public AppConfigurationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
