package Ss02;

import java.util.*;
import java.util.function.*;

interface IUserAccount {

    String getRole();

    default boolean checkAccess() {
        if (getRole().equals("ADMIN")) {
            return true;
        }
        return false;
    }

    static boolean isStandardLength(String username) {
        return username != null && username.length() > 5;
    }
}

class UserBaiThucHanh01 implements IUserAccount {

    private String username;
    private String email;
    private String role;
    private String status;

    public UserBaiThucHanh01() {
    }

    public UserBaiThucHanh01(String username, String email, String role, String status) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getStatus() {
        return status;
    }

    public String toString() {
        return "User{username='" + username + "', email='" + email + "', role='" + role + "', status='" + status + "'}";
    }
}

class UserManagement {

    Supplier<UserBaiThucHanh01> createUser = UserBaiThucHanh01::new;

    Predicate<UserBaiThucHanh01> checkActive = u -> u.getStatus().equals("ACTIVE");

    Function<UserBaiThucHanh01, String> getEmail = UserBaiThucHanh01::getEmail;
}

public class BaiThucHanh01 {

    public static void main(String[] args) {

        UserManagement um = new UserManagement();

        UserBaiThucHanh01 u = um.createUser.get();

        UserBaiThucHanh01 user1 = new UserBaiThucHanh01("duong123", "duong@gmail.com", "ADMIN", "ACTIVE");

        System.out.println(IUserAccount.isStandardLength(user1.getUsername()));

        System.out.println(um.getEmail.apply(user1));

        List<UserBaiThucHanh01> users = new ArrayList<>();

        users.add(user1);
        users.add(new UserBaiThucHanh01("nam234", "nam@gmail.com", "USER", "ACTIVE"));
        users.add(new UserBaiThucHanh01("linh345", "linh@gmail.com", "USER", "INACTIVE"));
        users.add(new UserBaiThucHanh01("anh456", "anh@gmail.com", "ADMIN", "ACTIVE"));

        users.forEach(System.out::println);
    }
}