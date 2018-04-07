package test.database;

import dao.DistrictDAO;
import dao.OwnerDAO;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class OwnerTest {
    //VIN ='EWQEWQEQWE2222' AND NrRejestracyjny='WGRCH56'

    public static void main(String[] args) throws ParseException {

        boolean x;
//        try {
//            x = DistrictDAO.VehicleRegistry("GSDADASD", "2017-01-01","2017-01-01"
//                    ,false,"WZU123", "2017-01-01", "140", "2.0",
//                    "DIESL", 1,1,"7349032814", 1, true, "92031212342");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        x = DistrictDAO.Deregistration("GSDADASD");
        System.out.println(" " + x);
    }
}
