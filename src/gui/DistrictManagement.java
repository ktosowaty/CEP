package gui;

import dao.DistrictDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.PojazdModel;

public class DistrictManagement {
    
    public static String helperDistrict;
    private int flagDistrict = 0;
    
    @FXML
    private Button sprawdzenieInformacjiNaTematPojazdu, rejestracjaPojazdu, wyrejestrowaniePojazdu,
            zmianaNumeruRejestracyjnegoPojazdu, zmianaWlascicielaPojazdu, zatwierdz;
    
    @FXML
    private Text naglowekUrzad, operacja;
    
    @FXML
    private HBox HBox1, HBox2, HBox3, HBox4, HBox5, HBox6;
    
    @FXML
    private Label districtVINLabel, secondLabel, thirdLabel, fourthLabel, fifthLabel, sixthLabel, seventhLabel,
            eighthLabel, ninthLabel, tenthLabel, eleventhLabel, twelfthLabel, thirteenthLabel, fourteenthLabel,
            fifteenthLabel;
    
    @FXML
    private TextField districtVINTextField, secondTextField, thirdTextField, fourthTextField, fifthTextField,
            sixthTextField, seventhTextField, eighthTextField, ninthTextField, tenthTextField, eleventhTextField,
            twelfthTextField, thirteenthTextField, fourteenthTextField, fifteenthTextField;
    
    @FXML
    protected void districtButtons(ActionEvent event) {
        if(event.getSource()==sprawdzenieInformacjiNaTematPojazdu) {
            flagDistrict = 1;
            naglowekUrzad.setText("Sprawdź informacje o pojeździe");
            visibleDistrict();
        } else if(event.getSource()==rejestracjaPojazdu) {
            flagDistrict = 2;
            naglowekUrzad.setText("Zarejestruj pojazd");
            visibleDistrict();
        } else if(event.getSource()==wyrejestrowaniePojazdu) {
            flagDistrict = 3;
            naglowekUrzad.setText("Wyrejestruj pojazd");
            visibleDistrict();
        } else if(event.getSource()==zmianaNumeruRejestracyjnegoPojazdu) {
            flagDistrict = 4;
            naglowekUrzad.setText("Zmień numer rejestracyjny pojazdu");
            visibleDistrict();
        } else if(event.getSource()==zmianaWlascicielaPojazdu) {
            flagDistrict = 5;
            naglowekUrzad.setText("Zmień właściciela pojazdu");
            visibleDistrict();
        } else if(event.getSource()==zatwierdz) {
            if(flagDistrict==1) {
                PojazdModel pojazd = DistrictDAO.GetVehicleInfo(districtVINTextField.getText());
                secondTextField.setText(pojazd.getWaznoscPrzegladu().toString());
                thirdTextField.setText(pojazd.getWaznoscUbezpieczenia().toString());
                fourthTextField.setText(String.valueOf(pojazd.isStatusKradziezy()));
                fifthTextField.setText(pojazd.getNrRejestracyjny());
                sixthTextField.setText(pojazd.getDataProdukcji().toString());
                seventhTextField.setText(pojazd.getMoc());
                eighthTextField.setText(pojazd.getPojemnosc());
                ninthTextField.setText(pojazd.getRodzajPaliwa());
                tenthTextField.setText(String.valueOf(pojazd.getIDMarki()));
                eleventhTextField.setText(String.valueOf(pojazd.getIDModelu()));
                twelfthTextField.setText(pojazd.getNrPolisy());
                thirteenthTextField.setText(String.valueOf(pojazd.getIDOR())); 
                fourteenthTextField.setText(String.valueOf(pojazd.isStatusRejestracji()));
            } else if(flagDistrict==2) {
                DistrictDAO.VehicleRegistry(districtVINTextField.getText(), secondTextField.getText(),
                thirdTextField.getText(), Boolean.parseBoolean(fourthTextField.getText()), fifthTextField.getText(),
                sixthTextField.getText(), seventhTextField.getText(), eighthTextField.getText(),
                ninthTextField.getText(), Integer.parseInt(tenthTextField.getText()),
                Integer.parseInt(eleventhTextField.getText()), twelfthTextField.getText(),
                Integer.parseInt(thirteenthTextField.getText()), Boolean.parseBoolean(fourteenthTextField.getText()),
                fifteenthTextField.getText());
            } else if(flagDistrict==3) {
                DistrictDAO.Deregistration(districtVINTextField.getText());
            } else if(flagDistrict==4) {
                DistrictDAO.RegisterVehicle(districtVINTextField.getText(), secondTextField.getText());
            } else if(flagDistrict==5) {
                DistrictDAO.ChangeOwner(districtVINTextField.getText(), secondTextField.getText());
            }
            operacja.setText(helperDistrict);
        }
    }
    
    private void visibleDistrict() {
        HBox1.setVisible(false);
        HBox2.setVisible(false);
        HBox3.setVisible(false);
        HBox4.setVisible(false);
        HBox5.setVisible(false);
        districtVINLabel.setVisible(true);
        districtVINTextField.setVisible(true);
        HBox6.setVisible(true);
        if(flagDistrict==4) {
            secondLabel.setText("Numer rejestracyjny:");
            secondLabel.setVisible(true);
            secondTextField.setVisible(true);
        } else if(flagDistrict==5) {
            secondLabel.setText("Pesel nowego właściciela:");
            secondLabel.setVisible(true);
            secondTextField.setVisible(true);
        } else if(flagDistrict==2 || flagDistrict==1) {
            secondLabel.setVisible(true);            
            thirdLabel.setVisible(true);
            fourthLabel.setVisible(true);
            fifthLabel.setVisible(true); 
            sixthLabel.setVisible(true); 
            seventhLabel.setVisible(true);
            eighthLabel.setVisible(true); 
            ninthLabel.setVisible(true); 
            tenthLabel.setVisible(true); 
            eleventhLabel.setVisible(true); 
            twelfthLabel.setVisible(true);
            thirteenthLabel.setVisible(true);
            fourteenthLabel.setVisible(true);
            secondTextField.setVisible(true);
            thirdTextField.setVisible(true);
            fourthTextField.setVisible(true);
            fifthTextField.setVisible(true);
            sixthTextField.setVisible(true);
            seventhTextField.setVisible(true);
            eighthTextField.setVisible(true); 
            ninthTextField.setVisible(true); 
            tenthTextField.setVisible(true); 
            eleventhTextField.setVisible(true);
            twelfthTextField.setVisible(true); 
            thirteenthTextField.setVisible(true); 
            fourteenthTextField.setVisible(true);
            if(flagDistrict==1) {
                secondTextField.setEditable(false);
                thirdTextField.setEditable(false);
                fourthTextField.setEditable(false);
                fifthTextField.setEditable(false);
                sixthTextField.setEditable(false);
                seventhTextField.setEditable(false);
                eighthTextField.setEditable(false); 
                ninthTextField.setEditable(false);
                tenthTextField.setEditable(false);
                eleventhTextField.setEditable(false);
                twelfthTextField.setEditable(false); 
                thirteenthTextField.setEditable(false); 
                fourteenthTextField.setEditable(false);
            } else {
                fifteenthLabel.setVisible(true);
                fifteenthTextField.setVisible(true);
            }
        }
    }
    
    @FXML
    protected void goBackToMenuPane(ActionEvent event) {
        switchScene("/fxml_files/MainMenu.fxml", event);
    }
    
    public void switchScene(String fxmlFile, ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(fxmlFile)); /* Exception */
        } catch (IOException ex) {
            Logger.getLogger(DistrictManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root, 1000, 666);
        stage.setScene(scene);
        stage.show();
    }
}
