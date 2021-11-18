package bean;

import exeption.NonPositiveArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BynTest {
    @Test
    public void testSub() {
        Byn syllable1 = new Byn(150);
        Byn syllable2 = new Byn(50);
        Byn actual = syllable1.sub(syllable2);
        Byn expected = new Byn(100);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubException() {
        Byn syllable1 = new Byn(150);
        Byn syllable2 = new Byn(200);
        Exception exception = assertThrows(NonPositiveArgumentException.class,() -> syllable1.sub(syllable2));
        String expectedMessage = "non positive value -50";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testAdd() {
        Byn syllable1 = new Byn(150);
        Byn syllable2 = new Byn(50);
        Byn actual = syllable1.add(syllable2);
        Byn expected = new Byn(200);
        assertEquals(expected, actual);
    }

    @Test
    public void testMul() {
        Byn syllable1 = new Byn(150);
        double syllable2 = 10;
        Byn actual = syllable1.mul(syllable2);
        Byn expected = new Byn(1500);
        assertEquals(expected, actual);
    }

    @Test
    public void testMulException() {
        Byn syllable1 = new Byn(150);
        double syllable2 = -10.8;
        Exception exception = assertThrows(NonPositiveArgumentException.class,() -> syllable1.mul(syllable2));
        String expectedMessage = "non positive value -10";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}