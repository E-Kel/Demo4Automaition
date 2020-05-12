package ui.constants;

public class CheckoutConstants {
    private static String TOTAL_PRICE = "";
    public static final String SUCCESS_ORDER_MESSAGE = "Your order on My Store is complete.";

    public static void setTotalPrice(String totalPrice) {
        TOTAL_PRICE = totalPrice;
    }

    public static String getTotalPrice() {
        return TOTAL_PRICE;
    }
}
