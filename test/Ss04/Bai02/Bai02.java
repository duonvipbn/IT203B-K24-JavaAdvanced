package Ss04.Bai02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Bai02 {

    @Test
    void TC01_age18_valid() {

        UserService service = new UserService();

        boolean result = service.checkRegistrationAge(18);

        assertEquals(true, result);
    }

    @Test
    void TC02_age17_invalid() {

        UserService service = new UserService();

        boolean result = service.checkRegistrationAge(17);

        assertEquals(false, result);
    }

    @Test
    void TC03_negativeAge_exception() {

        UserService service = new UserService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.checkRegistrationAge(-1);
        });
    }
}
