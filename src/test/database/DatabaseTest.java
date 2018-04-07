package test.database;

import dao.OwnerDAO;
import database.DbConnection;
import utilities.PojazdNullException;

public class DatabaseTest {

    private static DbConnection dbConnection;

    public static void main(String[] args) {
        try {
            System.out.println(OwnerDAO.GetInsuranceStatus("EWQEWQEQWE2222"));
        } catch (PojazdNullException e) {
            e.printStackTrace();
        }
    }
}
