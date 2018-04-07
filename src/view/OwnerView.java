package view;

import java.util.LinkedList;
import java.util.List;

public class OwnerView {
    private List<OwnerEventHistoryView> eventHistory = new LinkedList<OwnerEventHistoryView>();
    private List<OwnerHistoryChangeView> changeHistory = new LinkedList<OwnerHistoryChangeView>();

    private boolean serviceStatus;
    private boolean registrationStatus;
    private boolean insuranceStatus;



    public List<OwnerEventHistoryView> getEventHistory() {
        return eventHistory;
    }

    public void addToEventHistory(OwnerEventHistoryView h){
        eventHistory.add(h);
    }

    public List<OwnerHistoryChangeView> getChangeHistory() {
        return changeHistory;
    }

    public void addToChangeHistory(OwnerHistoryChangeView h){
        changeHistory.add(h);
    }


    public boolean isServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(boolean serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public boolean isRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(boolean registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public boolean isInsuranceStatus() {
        return insuranceStatus;
    }

    public void setInsuranceStatus(boolean insuranceStatus) {
        this.insuranceStatus = insuranceStatus;
    }
}
