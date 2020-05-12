package ui.constants;

public class CheckoutConstants {
    public static final String SUCCESS_ORDER_MESSAGE = "Your order on My Store is complete.";

    private static String TOTAL_PRICE = "";

    public static String getTotalPrice() {
        return TOTAL_PRICE;
    }

    public static void setTotalPrice(String totalPrice) {
        TOTAL_PRICE = totalPrice;
    }
}
