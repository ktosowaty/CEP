package test.database;

import dao.PoliceDAO;

public class PoliceTest {
    public static void main(String[] args) {
//        try {
//            PoliceDAO.getPoliceObject("GF633F67GF2G387G");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


            //PoliceDAO.setTheftStatus(false, "GF633F67GF2G387G");
            //pesele: 92031212342, 96120604370
            //polisy: 7349032814, 6435438032
        //PoliceDAO.setTheftStatus(true, "EWQEWQEQWE2222");
        PoliceDAO.addNewEvent("EWQEWQEQWE2222", "Wypadek");
    }
}
