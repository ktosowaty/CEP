package test.database;

import dao.DistrictDAO;
import model.PojazdModel;

public class DistrictTest {

    public static void main(String[] args) {
      /*          try {
            boolean x = DistrictDAO.VehicleRegistry("GSDADASD", "2017-01-01","2017-01-01"
                    ,false,"WZU123", "2017-01-01", "140", "2.0",
                    "DIESL", 1,1,"7349032814", 1, true, "92031212342");
       } catch (Exception e) {
            e.printStackTrace();
        }*/
//        x = DistrictDAO.Deregistration("GSDADASD");
//        System.out.println(" " + x);
//        try {
//            OwnerDAO.getOwnerObject("GF633F67GF2G387G", "");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        PojazdModel m = DistrictDAO.GetVehicleInfo("GF633F67GF2G387G");
//        System.out.println(m.getPojemnosc());

//        System.out.println(DistrictDAO.RegisterVehicle("GSDADASD", "WZUNOWY"));
        //System.out.println(DistrictDAO.ChangeOwner("EWQEWQEQWE2222", "96120604370"));
        System.out.println(DistrictDAO.ChangeOwner("BOLOTEST", "96120604370"));
    }
}
