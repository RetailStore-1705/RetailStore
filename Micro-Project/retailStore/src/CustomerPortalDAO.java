public interface CustomerPortalDAO {
    public void checkInventory();
    // public void checkEmployeeDetails();
    public void buyItems(Customer cust,Integer transID, String productName, Integer quantity);
    public void OrderItemsByPrice();
    // public void generateReceipt(Customer cust,Integer transID);
    // public void maxSoldProduct();
    public void getCustomer(Integer custID);
}
