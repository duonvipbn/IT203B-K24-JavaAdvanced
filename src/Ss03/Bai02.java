package Ss03;

import java.util.List;

public class Bai02 {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User("a", "a@gmail.com", "ACTIVE"),
                new User("bb", "bb@gmail.com", "INACTIVE"),
                new User("v", "v@example.com", "ACTIVE")
        );

        users.stream()
                .filter(user -> user.email().endsWith("@gmail.com"))
                .forEach(user -> System.out.println(user.username()));
    }
}