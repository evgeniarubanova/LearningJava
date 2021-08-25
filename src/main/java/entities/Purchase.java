package entities;

public class Purchase {

    private String delivery;
    private int paymentAmount;
    private String purchaseStatus;
    private int userID;
    private int purchaseID;

    public Purchase(String delivery, int paymentAmount, String purchaseStatus, int userID) {
        this.delivery = delivery;
        this.paymentAmount = paymentAmount;
        this.purchaseStatus = purchaseStatus;
        this.userID = userID;
    }

    public Purchase(String delivery, int paymentAmount, String purchaseStatus, int userID, int purchaseID) {
        this.delivery = delivery;
        this.paymentAmount = paymentAmount;
        this.purchaseStatus = purchaseStatus;
        this.userID = userID;
        this.purchaseID = purchaseID;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(String purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPurchaseID() {
        return purchaseID;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "delivery='" + delivery + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", purchaseStatus='" + purchaseStatus + '\'' +
                ", userID=" + userID +
                '}';
    }
}
