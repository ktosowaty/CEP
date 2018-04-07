package database;

import java.sql.*;

import static java.lang.String.format;

public class DbConnection {
    private Connection connect;
    //jdbc:sqlserver://wat.database.windows.net:1433;database=MW;user=mw@wat;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;
    private String url = format("jdbc:sqlserver://wat.database.windows.net:1433;database=MW;user=mw@wat;password=#superBAZA2017;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
    private Statement statement;
    private String sqlStatement;
    private ResultSet result;

    public void Connect() {
        try {
            connect = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void Disconnect() {
        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnect() {
        return connect;
    }
}
