package Ss03.BaiThucHanh01;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class UserService {

    public List<User> getVerifiedUsers(List<User> users) {
        return users.stream()
                .filter(User::isVerified)
                .toList();
    }

    public Tier classifyTier(long months) {

        return switch ((int) months) {
            case 25,26,27,28,29,30 -> new Gold();
            case 13,14,15,16,17,18,19,20,21,22,23,24 -> new Silver();
            default -> new Bronze();
        };
    }
    public long getMonths(User user) {
        return ChronoUnit.MONTHS.between(user.getCreatedAt(), LocalDate.now());
    }
}