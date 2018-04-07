package gui;

import dao.OwnerDAO;
import java.io.IOException;
import java.util.Date;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.OwnerEventHistoryView;
import view.OwnerHistoryChangeView;
import view.OwnerView;

public class VehicleOwnerManagement {
    
    public static String helperOwner;
    private int flagOwner = 0;
    
    @FXML
    private Button sprawdzenieInformacjiNaTematPojazduOwner, sprawdzenieHistoriiPojazdu, zatwierdz2;
    
    @FXML
    private Text naglowekWlasciciel, wynik;
    
    @FXML
    private Label ownerVINLabel, ownerSecondLabel, ownerThirdLabel, ownerFourthLabel;
    
    @FXML
    private TextField ownerVINTextField, ownerSecondTextField, ownerThirdTextField, ownerFourthTextField;
    
    @FXML
    private HBox HBox6, HBox7, HBox8;
    
    @FXML
    private TableView<OwnerEventHistoryView> tableView;
    
    @FXML
    private TableColumn<OwnerEventHistoryView, String> nazwaZdarzenia, opisZdarzenia;
    
    @FXML
    private TableColumn<OwnerEventHistoryView, Date> dataZdarzenia;
    
    @FXML
    private TableView<OwnerHistoryChangeView> tableView2;
    
    @FXML
    private TableColumn<OwnerHistoryChangeView, String> PESEL_nowy, PESEL_stary;
    
    @FXML
    private TableColumn<OwnerHistoryChangeView, Date> date;
    
    @FXML
    protected void goBackToMenuPane(ActionEvent event) {
        switchScene("/fxml_files/MainMenu.fxml", event);
    }
    
    @FXML
    protected void vehicleOwnerButtons(ActionEvent event) throws Exception {
        if(event.getSource()==sprawdzenieInformacjiNaTematPojazduOwner) {
            flagOwner = 1;
            naglowekWlasciciel.setText("Sprawdź informacje o pojeździe");
            visibleOwner();
        } else if(event.getSource()==sprawdzenieHistoriiPojazdu) {
            flagOwner = 2;
            naglowekWlasciciel.setText("Sprawdź historię pojazdu");
            visibleOwner();
        } else if(event.getSource()==zatwierdz2) {
            OwnerView owner = OwnerDAO.getOwnerObject(ownerVINTextField.getText());
            tableView.getItems().clear();
            tableView2.getItems().clear();
            if(flagOwner==1) {                
                ownerSecondTextField.setText(String.valueOf(owner.isRegistrationStatus()));
                ownerThirdTextField.setText(String.valueOf(owner.isInsuranceStatus()));
                ownerFourthTextField.setText(String.valueOf(owner.isServiceStatus())); 
            } else if(flagOwner==2) {
                for(int i=0; i<owner.getEventHistory().size(); i++) {
                    //tableView.getItems().add(new OwnerEventHistoryView(owner.getEventHistory().get(i).getVIN(),
                    //        owner.getEventHistory().get(i).getNazwaZdarzenia(), owner.getEventHistory().get(i).getOpisZdarzenia(), 
                    //        owner.getEventHistory().get(i).getDataZdarzenia()));
                    tableView.getItems().add(owner.getEventHistory().get(i));
                }
                //VINo.setCellValueFactory(new PropertyValueFactory<>("VINo"));
                nazwaZdarzenia.setCellValueFactory(new PropertyValueFactory<>("nazwaZdarzenia"));
                opisZdarzenia.setCellValueFactory(new PropertyValueFactory<>("opisZdarzenia"));
                dataZdarzenia.setCellValueFactory(new PropertyValueFactory<>("dataZdarzenia"));
                for(int i=0; i<owner.getChangeHistory().size(); i++) {
                    //tableView2.getItems().add(new OwnerHistoryChangeView(owner.getChangeHistory().get(i).getVIN(),
                    //owner.getChangeHistory().get(i).getPESEL_nowy(), owner.getChangeHistory().get(i).getPESEL_stary(),
                    //owner.getChangeHistory().get(i).getDate()));
                    tableView2.getItems().add(owner.getChangeHistory().get(i));
                }
                //VIN.setCellValueFactory(new PropertyValueFactory<>("VIN"));
                PESEL_nowy.setCellValueFactory(new PropertyValueFactory<>("PESEL_nowy"));
                PESEL_stary.setCellValueFactory(new PropertyValueFactory<>("PESEL_stary"));
                date.setCellValueFactory(new PropertyValueFactory<>("date"));
            }
            wynik.setText(helperOwner);
        }
    }
    
    private void visibleOwner() {
        HBox6.setVisible(false);
        HBox7.setVisible(false);
        HBox8.setVisible(true);
        ownerVINLabel.setVisible(true);
        ownerVINTextField.setVisible(true);
        if(flagOwner==1) {
            ownerSecondLabel.setVisible(true);
            ownerSecondTextField.setEditable(false);
            ownerSecondTextField.setVisible(true); 
            ownerThirdLabel.setVisible(true);
            ownerThirdTextField.setEditable(false);
            ownerThirdTextField.setVisible(true); 
            ownerFourthLabel.setVisible(true);
            ownerFourthTextField.setEditable(false);
            ownerFourthTextField.setVisible(true);
        } else if(flagOwner==2) {
            tableView.setVisible(true);
            tableView2.setVisible(true);
        }
    }
    
    public void switchScene(String fxmlFile, ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(fxmlFile)); /* Exception */
        } catch (IOException ex) {
            Logger.getLogger(VehicleOwnerManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root, 1000, 666);
        stage.setScene(scene);
        stage.show();
    }
    
}