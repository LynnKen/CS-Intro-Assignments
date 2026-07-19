
public final class IntegrityStatement {
    public static String signature() {
        String sign = "Lynn Kedndler 207489519"; // <- Fill in your name and ID here! For example: "Israel Israeli (123456789)"
        if (sign.length() == 0) {
            throw new UnsupportedOperationException("You didn't sign the integrity statement!");
        }
        return sign;
    }
}
