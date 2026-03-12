package Ss04.BaiTapTongHop01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestUserService {

    UserService userService;

    @BeforeEach
    public void initData(){
        userService = new UserService();
        userService.addUser(new User(1, "b", "b@gmail.com"));
    }

    @Test
    public void testFeatureAdd() {
        userService.addUser(new User(
                2,
                "a",
                "a@gmail.com"
        ));

        assertEquals(2, userService.users.size());
    }

    @Test
    @DisplayName("Kiểm tra có ngoại lệ hay không")
    public void testThrowsException(){

        assertThrows(IllegalArgumentException.class, () -> {
            userService.addUser(
                    new User(
                            3,
                            "     ",
                            "null@gmail.com"
                    )
            );
        });
    }
}