package gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuManagement {
    
    @FXML
    protected void goToVehicleOwnerPane(ActionEvent event) {
        switchScene("/fxml_files/VehicleOwner.fxml", event);
    }
    
    @FXML
    protected void goToPolicemanPane(ActionEvent event) {
        switchScene("/fxml_files/Policeman.fxml", event);
    }
    
    @FXML
    protected void goToDistrictPane(ActionEvent event) {
        switchScene("/fxml_files/District.fxml", event);
    }
    
    public void switchScene(String fxmlFile, ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(fxmlFile)); /* Exception */
        } catch (IOException ex) {
            Logger.getLogger(MainMenuManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root, 1000, 666);
        stage.setScene(scene);
        stage.show();
    }
}
