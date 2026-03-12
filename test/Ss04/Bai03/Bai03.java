package Ss04.Bai03;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Bai03 {

    UserProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new UserProcessor();
    }

    @Test
    void testValidEmail() {

        String result = processor.processEmail("user@gmail.com");

        assertEquals("user@gmail.com", result);
    }

    @Test
    void testEmailMissingAtSymbol() {

        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail("usergmail.com");
        });
    }

    @Test
    void testEmailMissingDomain() {

        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail("user@");
        });
    }

    @Test
    void testEmailNormalizationToLowerCase() {

        String result = processor.processEmail("Example@Gmail.com");

        assertEquals("example@gmail.com", result);
    }
}