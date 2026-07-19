
public final class IntegrityStatement {
    public static String signature() {
        String signature = "Lynn kendler 207489519"; // <- Fill in your name and ID here! For example: "Israel Israeli (123456789)"
        
        if (signature.length() == 0) {
            throw new UnsupportedOperationException("You should sign here");
        }
        
        return signature;
    }
}
