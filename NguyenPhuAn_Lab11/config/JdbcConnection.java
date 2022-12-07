package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class JdbcConnection {
        public JdbcConnection() {
        }

        public static Connection getConnection() throws SQLException {
            Connection connection = null;

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=HangKhong";
                connection = DriverManager.getConnection(connectionUrl, "phuan11", "ngphuan11012001");
            } catch (Exception var2) {
                var2.getStackTrace();
            }

            return connection;
        }
    }
