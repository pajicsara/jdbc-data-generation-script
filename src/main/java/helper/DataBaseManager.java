package helper;

import util.TestUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseManager {

    private static final Properties properties = ConfigLoader.loadConfig(TestUtil.CONFIG_FILE_PATH);

    public static Connection connectWithDatabase() throws SQLException {
        String DB_URL = properties.getProperty("db_url");
        String DB_USER = properties.getProperty("db_user");
        String DB_PASSWORD = properties.getProperty("db_password");
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

}
