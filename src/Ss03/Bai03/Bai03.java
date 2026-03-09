package Ss03.Bai03;

public class Bai03 {

    public static void main(String[] args) {

        UserRepository repo = new UserRepository();

        var userOpt = repo.findUserByUsername("alice");

        String result = userOpt
                .map(user -> "Welcome " + user.username())
                .orElse("Guest login");

        System.out.println(result);
    }
}