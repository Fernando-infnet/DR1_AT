package com.example;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.Size;

class ViaCepTest {

    MathLogger logger = (op, inputs) -> {};
    ViaCep math = new ViaCep(logger);

    // MultiplyByTwo valide que o resultado é sempre par.
    @Property(tries = 1000)
    void MultiplyByTwo(@ForAll int number) {
        int result = math.multiplyByTwo(number);
        assertEquals(0, result % 2);
    }

    // GenerateMultiplicationTable valide que todos os elementos são múltiplos do número original.
    @Property(tries = 1000)
        void GenerateMultiplicationTable(
            @ForAll int number,
            @ForAll @IntRange(min = 1, max = 10000) int limit) {

        Assume.that(number != 0);
        Assume.that(Math.abs((long) number * limit) <= Integer.MAX_VALUE);

        int[] table = math.generateMultiplicationTable(number, limit);

        for (int value : table) {
            assertEquals(0, value % number);
        }
    }

    // IsPrime valide que para qualquer número primo, não há divisores além de 1 e ele mesmo.
    @Property(tries = 1000)
    void IsPrime(
            @ForAll @IntRange(min = 2, max = 1_000_000) int n) {  

        Assume.that(math.isPrime(n));

        for (int i = 2; i * i <= n; i++) {  
            assertNotEquals(0, n % i);
        }
    }

    // CalculateAverage verifique se o resultado está sempre entre o menor e o maior valor do array.
    @Property
    void CalculateAverage(
            @ForAll @Size(min = 1, max = 50) int[] numbers) {

        double avg = math.calculateAverage(numbers);

        int min = Arrays.stream(numbers).min().orElseThrow();
        int max = Arrays.stream(numbers).max().orElseThrow();

        assertTrue(avg >= min && avg <= max);
    }
}
