package dao;

import database.DbConnection;
import gui.DistrictManagement;
import model.PojazdModel;
import utilities.PojazdNullException;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DistrictDAO {
    private static DbConnection db = new DbConnection();
    private static String sql;
    private static Statement statement;
    private static boolean status;
    private static ResultSet result;
    private static PojazdModel pojazd;

    public static boolean VehicleRegistry(String VIN, String serviceDate, String insuranceDate, boolean theftStatus
                                            , String registrationNumber, String produceDate, String power, String capacity
                                            , String fuelType, int brandID, int modelID, String insuranceNumber, int districtID
                                            , boolean registryStatus, String ownerPESEL) {
        db.Connect();
        Connection connect = db.getConnect();

        try {

            sql = "INSERT INTO Pojazd (VIN ,WaznoscPrzegladu ,WaznoscUbezpieczenia ,StatusKradziezy " +
                    ",NrRejestracyjny ,DataProdukcji ,Moc ,Pojemnosc ,RodzajPaliwa ,IDMarki ,IDModelu " +
                    ",NrPolisy ,IDOR ,StatusRejestracji) " +
                    "VALUES (?,? ,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement st = connect.prepareStatement(sql);
            st.setString(1, VIN);
            st.setString(2, serviceDate);
            st.setString(3, insuranceDate);
            st.setBoolean(4, theftStatus);
            st.setString(5, registrationNumber);
            st.setString(6, produceDate);
            st.setString(7, power);
            st.setString(8, capacity);
            st.setString(9, fuelType);
            st.setInt(10, brandID);
            st.setInt(11, modelID);
            st.setString(12, insuranceNumber);
            st.setInt(13, districtID);
            st.setBoolean(14, registryStatus);

            st.executeUpdate();

            sql = "INSERT INTO Pojazd_Wlasciciel (VIN, PESEL) VALUES (?,?)";
            st = connect.prepareStatement(sql);
            st.setString(1, VIN);
            st.setString(2, ownerPESEL);

            st.executeUpdate();


            DistrictManagement.helperDistrict = "Wykonano żądanie.";
            return true;


        } catch (SQLException e) {
            e.printStackTrace();
            DistrictManagement.helperDistrict = "Nieprawidłowe dane!";
            return false;
        }
    }


        public static boolean Deregistration(String VIN){
            db.Connect();
            Connection connect = db.getConnect();

            try {

                sql = "UPDATE Pojazd SET StatusRejestracji = 0 WHERE VIN = ?";
                PreparedStatement st = connect.prepareStatement(sql);
                st.setString(1,VIN);

                st.executeUpdate();

                sql = "INSERT INTO HistoriaPojazdu (IDZdarzenia, DataZdarzenia, VIN) VALUES (?,?,?)";
                st = connect.prepareStatement(sql);
                st.setInt(1,9);
                java.util.Date today = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                st.setString(2,dateFormat.format(today));
                st.setString(3,VIN);

                st.executeUpdate();

                DistrictManagement.helperDistrict = "Wykonano żądanie.";
                return true;


            } catch (SQLException e) {
                e.printStackTrace();
                DistrictManagement.helperDistrict = "Nieprawidłowy VIN!";
                return false;
            }
        }


        public static PojazdModel GetVehicleInfo(String VIN){

            db.Connect();
            Connection connect = db.getConnect();


            try {
                sql = "SELECT * FROM Pojazd WHERE VIN = ?";
                PreparedStatement st = connect.prepareStatement(sql);
                st.setString(1,VIN);

                result = st.executeQuery();

                result.next();

                PojazdModel vehicle = new PojazdModel(result.getString(1), result.getDate(2),result.getDate(3)
                ,result.getBoolean(4), result.getString(5), result.getDate(6),result.getString(7),
                        result.getString(8),result.getString(9), result.getInt(10), result.getInt(11),
                        result.getString(12), result.getInt(13), result.getBoolean(14));

                DistrictManagement.helperDistrict = "Wykonano żądanie.";
                return vehicle;
            } catch (SQLException e) {
                DistrictManagement.helperDistrict = "Nieprawidłowy VIN!";
                return new PojazdModel();
            }

        }

        public static boolean RegisterVehicle(String VIN, String registryNumber){
            db.Connect();
            Connection connect = db.getConnect();

            try {

                sql = "UPDATE Pojazd SET NrRejestracyjny = ?, StatusRejestracji = 1 WHERE VIN = ?";
                PreparedStatement st = connect.prepareStatement(sql);
                st.setString(1,registryNumber);
                st.setString(2,VIN);

                st.executeUpdate();

                sql = "INSERT INTO HistoriaPojazdu (IDZdarzenia, DataZdarzenia, VIN) VALUES (?,?,?)";
                st = connect.prepareStatement(sql);
                st.setInt(1,8);
                java.util.Date today = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                st.setString(2,dateFormat.format(today));
                st.setString(3,VIN);

                st.executeUpdate();

                DistrictManagement.helperDistrict = "Wykonano żądanie.";
                return true;


            } catch (SQLException e) {
                e.printStackTrace();
                DistrictManagement.helperDistrict = "Nieprawidłowe dane!";
                return false;
            }
        }


        public static boolean ChangeOwner(String VIN, String newOwnerPESEL){
            db.Connect();
            Connection connect = db.getConnect();

            try {
                sql = "SELECT PESEL_nowy FROM HistoriaZmianyWlasciciela WHERE VIN = ?";
                PreparedStatement st = connect.prepareStatement(sql);
                st.setString(1,VIN);
                result = st.executeQuery();
                result.next();

                String PESEL_nowyOld = result.getString(1);

                sql = "UPDATE HistoriaZmianyWlasciciela SET PESEL_nowy = ?, PESEL_stary = ?, Data = ? WHERE VIN = ?";
                st = connect.prepareStatement(sql);
                st.setString(1,newOwnerPESEL);
                st.setString(2,PESEL_nowyOld);
                java.util.Date today = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                st.setString(3,dateFormat.format(today));
                st.setString(4,VIN);


                st.executeUpdate();

                sql = "INSERT INTO HistoriaPojazdu (IDZdarzenia, DataZdarzenia, VIN) VALUES (?,?,?)";
                st = connect.prepareStatement(sql);
                st.setInt(1,10);

                st.setString(2,dateFormat.format(today));
                st.setString(3,VIN);

                st.executeUpdate();
                sql = "UPDATE Pojazd_Wlasciciel SET PESEL = ? WHERE VIN = ?";
                st = connect.prepareStatement(sql);
                st.setString(1,newOwnerPESEL);

                st.setString(2,VIN);

                st.executeUpdate();

                DistrictManagement.helperDistrict = "Wykonano żądanie.";
                return true;


            } catch (SQLException e) {
                e.printStackTrace();
                DistrictManagement.helperDistrict = "Nieprawidłowe dane!";
                return false;
            }
        }


}
