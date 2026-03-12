package Ss04.Bai04;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Bai04 {

    PasswordService service = new PasswordService();

    @Test
    void testPasswordStrengthLevels() {

        assertAll(

                () -> assertEquals("Manh",
                        service.evaluatePasswordStrength("Abc123!@")),

                () -> assertEquals("Trung binh",
                        service.evaluatePasswordStrength("abc123!@")),

                () -> assertEquals("Trung binh",
                        service.evaluatePasswordStrength("ABC123!@")),

                () -> assertEquals("Trung binh",
                        service.evaluatePasswordStrength("Abcdef!@")),

                () -> assertEquals("Trung binh",
                        service.evaluatePasswordStrength("Abc12345")),

                () -> assertEquals("Yeu",
                        service.evaluatePasswordStrength("Ab1!")),

                () -> assertEquals("Yeu",
                        service.evaluatePasswordStrength("password")),

                () -> assertEquals("Yeu",
                        service.evaluatePasswordStrength("ABC12345"))
        );
    }
}