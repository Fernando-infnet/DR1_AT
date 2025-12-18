package com.example;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CaesarTest {
    Caesar caesar = new Caesar();

    @Test
    void caesarEncryptTest() {
        // given
        String textToEncrypt = "Encrypt this text";
        // when
        String cipherText = caesar.encode(textToEncrypt, 5);
        // then
        assertEquals("Jshwduy ymnx yjcy", cipherText);
    }

    @Test
    void caesarDecryptTest() {
        // given
        String encryptedText = "Jshwduy ymnx yjcy";
        // when
        String cipherText = caesar.decode(encryptedText, 5);
        // then
        assertEquals("Encrypt this text", cipherText);
    }

    @Test
    void caesarBruteForce() {
        // given
        String encryptedText = "Jshwduy ymnx yjcy";
        // when
        String[] allPossibleAnswers = caesar.bruteforce(encryptedText);
        assertEquals(27, allPossibleAnswers.length);
        assertEquals("Encrypt this text", allPossibleAnswers[5]);
    }

    // Testes adicionais para cobrir ramificações

    @Test
    void encodeEmptyString() {
        assertEquals("", caesar.encode("", 5));  // Cobertura para string vazia
    }

    @Test
    void encodeNonLetters() {
        String input = "123 !@#";
        assertEquals(input, caesar.encode(input, 10)); // Apenas caracteres não alfabéticos
    }

    @Test
    void encodeShiftZero() {
        String input = "AbC xYz";
        assertEquals(input, caesar.encode(input, 0)); 
    }

    @Test
    void encodeLargeShift() {
        String input = "A";
        assertEquals("B", caesar.encode(input, 27));  // 27 % 26 = 1
    }

    @Test
    void encodeNegativeShift() {
        String input = "A";
        // -1 % 26 = 25
        assertEquals("Z", caesar.encode(input, -1)); 
    }

    @Test
    void decodeWrapAround() {
        String input = "A";
        assertEquals("V", caesar.decode(input, 5));  // Cobre wrap-around no decode
    }

    @Test
    void bruteforceNonLetters() {
        String input = "123";
        String[] expected = new String[27];
        for (int i = 0; i < 27; i++) {
            expected[i] = "123";  // Apenas else branch
        }
        assertArrayEquals(expected, caesar.bruteforce(input));
    }
}