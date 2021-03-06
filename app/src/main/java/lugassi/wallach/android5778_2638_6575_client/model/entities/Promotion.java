package lugassi.wallach.android5778_2638_6575_client.model.entities;

public class Promotion {
    private int customerID;
    private int totalRentDays;
    private boolean isUsed;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getTotalRentDays() {
        return totalRentDays;
    }

    public void setTotalRentDays(int totalRentDays) {
        this.totalRentDays = totalRentDays;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    // method for promotion (discount/free days)
}
