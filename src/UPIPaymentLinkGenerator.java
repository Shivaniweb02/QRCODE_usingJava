public class UPIPaymentLinkGenerator {
    public static String payment(String rs) {
        // Replace these values with your actual UPI details
        String upiId = "hi@upi"; //your UPI ID
        String name = "Recipient Name";
//        String amount = "10.00";
        String note = "Payment for goods/services";

        // Generate the UPI payment link
        String upiPaymentLink = generateUpiPaymentLink(upiId, name, rs, note);

        // Display the generated link
//        System.out.println("UPI Payment Link: " + upiPaymentLink);
        return upiPaymentLink;
    }

    private static String generateUpiPaymentLink(String upiId, String name, String amount, String note) {
        // UPI payment link format
        // upi://pay?pa=<upi_id>&pn=<name>&mc=<merchant_code>&tid=<transaction_id>&tr=<transaction_ref_id>&tn=<transaction_note>&am=<transaction_amount>&cu=<currency_code>&url=<url>
        String upiLinkFormat = "upi://pay?pa=%s&pn=%s&mc=&tid=&tr=&tn=%s&am=%s&cu=INR&url=";

        // Encode values for URL
        upiId = java.net.URLEncoder.encode(upiId);
        name = java.net.URLEncoder.encode(name);
        note = java.net.URLEncoder.encode(note);
        amount = java.net.URLEncoder.encode(amount);

        // Create the UPI payment link
        return String.format(upiLinkFormat, upiId, name, note, amount);
    }
}
