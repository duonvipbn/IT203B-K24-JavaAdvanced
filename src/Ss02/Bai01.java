package Ss02;

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;

class User {
    private String username;
    private final String role;

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String toString() {
        return "User{username='" + username + "', role='" + role + "'}";
    }
}

public class Bai01 {
    public static void main(String[] args) {

        Predicate<User> isAdmin = user -> user.getRole().equalsIgnoreCase("ADMIN");

        User user1 = new User("duong", "ADMIN");
        System.out.println(isAdmin.test(user1));

        Function<User, String> getUsername = user -> user.getUsername();
        System.out.println(getUsername.apply(user1));

        Consumer<User> printUser = user -> System.out.println(user);
        printUser.accept(user1);

        Supplier<User> createDefaultUser = () -> new User("defaultUser", "USER");
        User user2 = createDefaultUser.get();

        System.out.println(user2);
    }
}