package dao;

import database.DbConnection;
import gui.PoliceManagement;
import model.PojazdModel;
import view.OwnerEventHistoryView;
import view.OwnerHistoryChangeView;
import view.OwnerView;
import view.PoliceView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PoliceDAO {
    private static DbConnection db = new DbConnection();
    private static String sql;
    private static Statement statement;
    private static boolean status;
    private static ResultSet result;
    private static PojazdModel pojazd;

    /**
     * Podając VIN dana statyczna meteoda zwraca status rejestracji(true/false)
     */
    public static PoliceView getPoliceObject(String VIN) throws Exception {
        db.Connect();
        Connection connect = db.getConnect();
        PoliceView police = new PoliceView();

        try{
            statement = connect.createStatement();
            sql = "SELECT * FROM Pojazd WHERE VIN=" + "'" + VIN + "' ";

            result = statement.executeQuery(sql);
            result.next();

            //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date today = new Date();
            Date insurance = result.getDate("WaznoscUbezpieczenia");
            police.setInsuranceStatus(today.before(insurance));

            Date service = result.getDate("WaznoscPrzegladu");
            police.setServiceStatus(today.before(service));

            police.setTheftStatus(result.getBoolean("StatusKradziezy"));
                        
            PoliceManagement.helper = "Pomyślnie zrealizowano wyszukiwanie.";
        } catch (SQLException e) {
            e.printStackTrace();
            PoliceManagement.helper = "Wprowadzono nieprawidłowy numer VIN!";
        }
        db.Disconnect();
        return police;
    }

    public static void setTheftStatus(boolean status, String VIN){
        db.Connect();
        Connection connect = db.getConnect();
        int x=1;
        if(status==true) x = 1;
        else x = 0;
        try{
            statement = connect.createStatement();
            sql = "UPDATE Pojazd SET StatusKradziezy = "+ x + " WHERE VIN= " + "'" + VIN + "' ";
            statement.executeUpdate(sql);
            Date today = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formatedDate = dateFormat.format(today);

            if(status == true){
                sql = "INSERT INTO HistoriaPojazdu VALUES (6, "+ "'" + formatedDate + "'" + ", " + "'" + VIN + "' " + ")";
            }
            else{
                sql = "INSERT INTO HistoriaPojazdu VALUES (11, "+ "'" + formatedDate + "'" + ", " + "'" + VIN + "' " + ")";
            }
            statement.executeUpdate(sql);
            PoliceManagement.helper = "Pomyślnie zmieniono status kradzieży.";
        } catch (SQLException e) {
            e.printStackTrace();
            PoliceManagement.helper = "Wprowadzono nieprawidłowe dane!";
        }


        db.Disconnect();
    }

    public static void addNewEvent(String VIN, String nazwaZdarzenia){
        db.Connect();
        Connection connect = db.getConnect();
        int x=1;
        if(status==true) x = 1;
        else x = 0;
        try{
            statement = connect.createStatement();


            sql = "SELECT IDZdarzenia FROM Zdarzenie WHERE NazwaZdarzenia = " + "'" + nazwaZdarzenia +"'";
            result = statement.executeQuery(sql);
            result.next();
            int idzdarzenia = result.getInt(1);


            Date today = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formatedDate = dateFormat.format(today);

            sql = "INSERT INTO HistoriaPojazdu VALUES ("+ idzdarzenia +", "+ "'" + formatedDate + "'" + ", " + "'" + VIN + "' " + ")";

            statement.executeUpdate(sql);
            PoliceManagement.helper = "Pomyślnie dodano wydarzenie.";
        } catch (SQLException e) {
            e.printStackTrace();
            PoliceManagement.helper = "Wprowadzono nieprawidłowe dane!";
        }


        db.Disconnect();
    }


    public static void unregisterVehicle(String VIN){
        db.Connect();
        Connection connect = db.getConnect();

        try{
            statement = connect.createStatement();
            sql = "UPDATE Pojazd SET StatusRejestracji = "+ 0 + " WHERE VIN= " + "'" + VIN + "' ";
            statement.executeUpdate(sql);
            Date today = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formatedDate = dateFormat.format(today);


                sql = "INSERT INTO HistoriaPojazdu VALUES (9, "+ "'" + formatedDate + "'" + ", " + "'" + VIN + "' " + ")";

            statement.executeUpdate(sql);
            PoliceManagement.helper = "Pomyślnie wyrejestrowano pojazd.";
        } catch (SQLException e) {
            e.printStackTrace();
            PoliceManagement.helper = "Wprowadzono nieprawidłowy numer VIN!";
        }


        db.Disconnect();
    }

}
