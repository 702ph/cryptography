package lab02_morse;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class MorseTest {

    //private static Morse instance;
    Morse morse = new Morse();

    @BeforeAll
    static void setup(){
        //instance = new Morse();
    }

    // get private method
    Method getPrivateMethod(String methodName, Class parameterClassType) throws NoSuchMethodException {
        Method method = Morse.class.getDeclaredMethod(methodName, parameterClassType);
        method.setAccessible(true);
        return method;
    }


    @org.junit.jupiter.api.Test
    void encode() {
    }


    @org.junit.jupiter.api.Test
    void decode() {
        assertEquals("AZ10", morse.decode(".-/--../-----"));
    }


    @org.junit.jupiter.api.Test
    void testGetAlphabet() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = getPrivateMethod("getAlphabet", String.class);
        assertEquals("A", method.invoke(morse, ".-"));
        assertEquals("Z", method.invoke(morse, "--.."));
        assertEquals("10", method.invoke(morse, "-----"));
    }


    @org.junit.jupiter.api.Test
    void testGetCode() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = getPrivateMethod("getCode", String.class);
        assertEquals(".-", method.invoke(morse, "A"));
        assertEquals("--..", method.invoke(morse, "Z"));
        assertEquals("-----", method.invoke(morse, "10"));
    }
}