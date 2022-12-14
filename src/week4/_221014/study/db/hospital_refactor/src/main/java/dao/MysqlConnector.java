package dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class MysqlConnector implements SqlConnector {
    public java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
        Map<String, String> env = System.getenv();
        final String DB_HOST = env.get("DB_HOST");
        final String DB_USER = env.get("DB_USER");
        final String DB_PASSWORD = env.get("DB_PASSWORD");

        java.sql.Connection conn = null;

        Class.forName("com.mysql.cj.jdbc.Driver");

        conn = DriverManager.getConnection(DB_HOST, DB_USER, DB_PASSWORD);

        return conn;
    }
}
