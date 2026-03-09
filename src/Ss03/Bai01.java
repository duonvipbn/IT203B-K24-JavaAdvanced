package Ss03;

import java.util.List;

record User(String username, String email, String status) {}

public class Bai01 {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User("a", "a@example.com", "ACTIVE"),
                new User("bb", "bb@example.com", "INACTIVE"),
                new User("v", "v@example.com", "ACTIVE")
        );

        users.forEach(user -> System.out.println(user));
    }
}