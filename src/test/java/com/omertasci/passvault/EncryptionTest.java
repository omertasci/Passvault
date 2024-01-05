package com.omertasci.passvault;

import com.omertasci.passvault.util.EncryptionUtil;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EncryptionTest {

    final String originalText = "Hello, this is a secret message.";
    static String expectedText;


    @Test
    @Order(1)
    void test_encryptAES256() {

        String secretKey = "MySecretKey";
        String salt = "MySalt";

        String encryptedString = EncryptionUtil.encrypt(originalText, secretKey, salt);
        expectedText = encryptedString;

        System.out.println(encryptedString);
        assertNotNull(expectedText);
    }

    @Test
    @Order(2)
    void test_decryptAES256() {

        String secretKey = "MySecretKey";
        String salt = "MySalt";

        String decryptedString = EncryptionUtil.decrypt(expectedText, secretKey, salt);

        System.out.println(decryptedString);
        assertEquals(originalText, decryptedString);

    }
}
