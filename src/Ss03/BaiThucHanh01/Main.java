package Ss03.BaiThucHanh01;


import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserService service = new UserService();

        List<User> users = List.of(
                new User("U1","alice@gmail.com","123",true, LocalDate.now().minusMonths(30)),
                new User("U2","bob@gmail.com","123",false, LocalDate.now().minusMonths(10)),
                new User("U3","charlie@gmail.com","123",true, LocalDate.now().minusMonths(15)),
                new User("U4","david@gmail.com","123",true, LocalDate.now().minusMonths(5)),
                new User("U5","emma@gmail.com","123",false, LocalDate.now().minusMonths(40))
        );

        // Bước 2: lọc verified
        List<User> verifiedUsers = service.getVerifiedUsers(users);

        // Bước 3: chuyển sang PublicUser
        List<PublicUser> publicUsers = verifiedUsers.stream()
                .map(user -> {
                    long months = service.getMonths(user);
                    Tier tier = service.classifyTier(months);
                    return new PublicUser(user.getId(), user.getEmail(), tier);
                })
                .toList();

        // Bước 4: báo cáo
        String report = """
                ===== USER REPORT =====
                %s
                """.formatted(
                publicUsers.stream()
                        .map(p -> p.id() + " | " + p.email() + " | " + p.tier())
                        .reduce("", (a,b) -> a + b + "\n")
        );

        System.out.println(report);
    }
}