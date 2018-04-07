package gui;

import dao.PoliceDAO;
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
import view.PoliceView;

public class PoliceManagement {
    
    public static String helper; //police
    private int flagPolice = 0; //police
    
    @FXML
    private Button sprawdzenieInformacjiNaTematPojazdu, dodanieWydarzeniaDoHistoriiPojazdu, //police
            wyrejestrowaniePojazdu, zmianaStatusuKradziezy, zatwierdz; //police
    
    @FXML
    private Text operacja, naglowekPolicja; //police
    
    @FXML
    private Label policemanVINLabel, policemanSecondLabel, policemanThirdLabel, policemanFourthLabel; //police
    
    @FXML
    private TextField policemanVINTextField, policemanSecondTextField, 
            policemanThirdTextField, policemanFourthTextField; //police
    
    @FXML
    private HBox HBox1, HBox2, HBox3, HBox4, HBox5; //police
    
    @FXML
    protected void goBackToMenuPane(ActionEvent event) {
        switchScene("/fxml_files/MainMenu.fxml", event);
    }
    
    @FXML
    protected void policemanButtons(ActionEvent event) throws Exception {
        if(event.getSource()==sprawdzenieInformacjiNaTematPojazdu) {
            flagPolice = 4;
            naglowekPolicja.setText("Sprawdź informacje na temat pojazdu");
            visiblePolice();
        } else if(event.getSource()==dodanieWydarzeniaDoHistoriiPojazdu) {
            flagPolice = 3;
            naglowekPolicja.setText("Dodaj wydarzenie do historii pojazdu");
            visiblePolice();
        } else if(event.getSource()==wyrejestrowaniePojazdu) {
            flagPolice = 1;
            naglowekPolicja.setText("Wyrejestruj pojazd");
            visiblePolice();
        } else if(event.getSource()==zmianaStatusuKradziezy) {
            flagPolice = 2;
            naglowekPolicja.setText("Zmień status kradzieży pojazdu");
            visiblePolice();
        } else if(event.getSource()==zatwierdz) {
            if(flagPolice==1) {
                PoliceDAO.unregisterVehicle(policemanVINTextField.getText());
            } else if(flagPolice==2) {
                PoliceDAO.setTheftStatus(Boolean.valueOf(policemanSecondTextField.getText()), policemanVINTextField.getText());
            } else if(flagPolice==3) {
                PoliceDAO.addNewEvent(policemanVINTextField.getText(), policemanSecondTextField.getText());
            } else if(flagPolice==4) {
                PoliceView police = PoliceDAO.getPoliceObject(policemanVINTextField.getText());
                policemanSecondTextField.setText(String.valueOf(police.isServiceStatus()));
                policemanThirdTextField.setText(String.valueOf(police.isInsuranceStatus()));
                policemanFourthTextField.setText(String.valueOf(police.isTheftStatus()));          
            }
            operacja.setText(helper);
        }
    }
    
    private void visiblePolice() {
        HBox2.setVisible(false);
        HBox3.setVisible(false);
        HBox4.setVisible(false);
        HBox5.setVisible(false);
        policemanVINLabel.setVisible(true);
        policemanVINTextField.setVisible(true);
        HBox1.setVisible(true);
        operacja.setVisible(true);
        if(flagPolice==2) {
            policemanSecondLabel.setVisible(true);
            policemanSecondTextField.setVisible(true);
        } else if(flagPolice==3) {
            policemanSecondLabel.setText("Podaj nazwę zdarzenia:");
            policemanSecondLabel.setVisible(true);
            policemanSecondTextField.setVisible(true);
        } else if(flagPolice==4) {
            policemanSecondLabel.setText("Ważność przeglądu technicznego:");
            policemanSecondLabel.setVisible(true);
            policemanSecondTextField.setEditable(false);
            policemanSecondTextField.setVisible(true);
            policemanThirdLabel.setText("Ważność ubezpieczenia:");
            policemanThirdLabel.setVisible(true);
            policemanThirdTextField.setEditable(false);
            policemanThirdTextField.setVisible(true);
            policemanFourthLabel.setText("Status kradzieży:");
            policemanFourthLabel.setVisible(true);
            policemanFourthTextField.setEditable(false);
            policemanFourthTextField.setVisible(true);
        }
    }
    
    public void switchScene(String fxmlFile, ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(fxmlFile)); /* Exception */
        } catch (IOException ex) {
            Logger.getLogger(PoliceManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root, 1000, 666);
        stage.setScene(scene);
        stage.show();
    }
}
