package Ss02;

@FunctionalInterface
interface Authenticatable {

    String getPassword();

    default boolean isAuthenticated() {
        return getPassword() != null && !getPassword().isEmpty();
    }

    static String encrypt(String rawPassword) {
        return "A_" + rawPassword;
    }
}

public class Bai03 {
    public static void main(String[] args) {

        Authenticatable user = () -> "123456";

        System.out.println(user.isAuthenticated());
        System.out.println(Authenticatable.encrypt(user.getPassword()));
    }
}