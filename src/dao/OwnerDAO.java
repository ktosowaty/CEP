package dao;

import database.DbConnection;
import gui.VehicleOwnerManagement;
import model.PojazdModel;
import utilities.PojazdNullException;
import view.OwnerEventHistoryView;
import view.OwnerHistoryChangeView;
import view.OwnerView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class OwnerDAO {
    private static DbConnection db = new DbConnection();
    private static String sql;
    private static Statement statement;
    private static boolean status;
    private static ResultSet result;
    private static PojazdModel pojazd;

    /**
     * Podając VIN dana statyczna meteoda zwraca status rejestracji(true/false)
     */
    public static OwnerView getOwnerObject(String VIN) throws Exception {
        db.Connect();
        Connection connect = db.getConnect();
        OwnerView owner = new OwnerView();

        try{
            statement = connect.createStatement();
            sql = "SELECT * FROM Pojazd WHERE VIN=" + "'" + VIN + "' ";

            result = statement.executeQuery(sql);
            result.next();

            owner.setRegistrationStatus(result.getBoolean("StatusRejestracji"));

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date today = new Date();
            Date insurance = result.getDate("WaznoscUbezpieczenia");
            owner.setInsuranceStatus(today.before(insurance));

            Date service = result.getDate("WaznoscPrzegladu");
            owner.setServiceStatus(today.before(service));

            sql = "SELECT * FROM HistoriaPojazdu as h LEFT JOIN Zdarzenie as z ON h.IDZdarzenia=z.IDZdarzenia WHERE VIN = "+ "'" + VIN + "' ";
            result = statement.executeQuery(sql);

            while (result.next()){
                owner.addToEventHistory(new OwnerEventHistoryView(VIN,result.getString("NazwaZdarzenia"),result.getString("OpisZdarzenia"), result.getDate("DataZdarzenia")));
            }

            sql = "SELECT * FROM HistoriaZmianyWlasciciela WHERE VIN = "+ "'" + VIN + "' ";
            result = statement.executeQuery(sql);

            while(result.next()){
                owner.addToChangeHistory(new OwnerHistoryChangeView(VIN, result.getString("PESEL_nowy"), result.getString("PESEL_stary"), result.getDate("Data")));
            }
            
            VehicleOwnerManagement.helperOwner = "Wyszukiwanie zakończone sukcesem.";
        } catch (SQLException e) {
            e.printStackTrace();
            VehicleOwnerManagement.helperOwner = "Wprowadzono nieprawidłowy numer VIN!";
        }
        db.Disconnect();
        return owner;
    }

    public static boolean GetInsuranceStatus(String VIN) throws PojazdNullException{
        db.Connect();


        Connection connect = db.getConnect();

        try {
            statement = connect.createStatement();
            sql = "SELECT * FROM Pojazd as p WHERE VIN = '" + VIN + "'";
            result = statement.executeQuery(sql);
            result.next();
            status = result.getBoolean("StatusRejestracji");
        } catch (SQLException e) {
            throw new PojazdNullException("Pojazd nie istnieje");
        }


        db.Disconnect();
        return status;
    }
}
