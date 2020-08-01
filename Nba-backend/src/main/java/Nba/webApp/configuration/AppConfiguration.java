package Nba.webApp.configuration;

import Nba.webApp.data.DataAccess;

import java.util.Properties;
import java.util.Set;

public class AppConfiguration {
    private static final AppConfiguration self = new AppConfiguration();

    private String contextPath = null;
    private Properties props = new Properties();
    private DataAccess dataAccess = new DataAccess();

    private AppConfiguration() {}

    public static AppConfiguration getInstance() {
        return self;
    }

    void setup(String contextPath, Properties props) throws AppConfigurationException{
        this.contextPath = contextPath;
        this.props = props;

        try {
            dataAccess.setup(
                    getProperty("db.driver"),
                    getProperty("db.url"),
                    getProperty("db.user"),
                    getProperty("db.pass")
            );
        }
        catch(Exception e) {
            throw new AppConfigurationException(e.getMessage(), e);
        }
    }

    public String getContextPath() {
        return contextPath;
    }

    public String getProperty(String name) {
        return getProperty(name, null);
    }

    public String getProperty(String name, String defaultValue) {
        return props.getProperty(name, defaultValue);
    }

    public Set<String> propertyNames() {
        return props.stringPropertyNames();
    }

    public DataAccess getDataAccess() {
        return dataAccess;
    }
}
