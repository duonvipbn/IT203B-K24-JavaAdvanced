package Ss03.Bai04;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record User(String username, String email, String status) {}

public class Bai04 {

    public static void main(String[] args) {

        List<User> users = List.of(
                new User("alice", "alice@gmail.com", "ACTIVE"),
                new User("bob", "bob@gmail.com", "ACTIVE"),
                new User("alice", "alice2@gmail.com", "INACTIVE"),
                new User("charlie", "charlie@gmail.com", "ACTIVE")
        );

        Map<String, User> uniqueUsers = users.stream()
                .collect(Collectors.toMap(
                        User::username,
                        user -> user,
                        (existing, replacement) -> existing
                ));

        uniqueUsers.values()
                .forEach(System.out::println);
    }
}