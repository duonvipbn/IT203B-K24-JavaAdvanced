package Ss02;

interface UserActions {
    default void logActivity(String activity) {
        System.out.println("User log: " + activity);
    }
}

interface AdminActions {
    default void logActivity(String activity) {
        System.out.println("Admin log: " + activity);
    }
}

class SuperAdmin implements UserActions, AdminActions {

    public void logActivity(String activity) {
        UserActions.super.logActivity(activity);
        AdminActions.super.logActivity(activity);
    }
}

public class Bai05 {
    public static void main(String[] args) {

        SuperAdmin superadmin = new SuperAdmin();
        superadmin.logActivity("Login system");
    }
}
//diamond problem