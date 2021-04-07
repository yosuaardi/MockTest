package org.mockExample;

import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class CarMockTest {
    private Car myCar = mock(Car.class);

    @Test
    public void testIfCarMyCarIsCar(){
        assertTrue(myCar instanceof Car);
    }
}
