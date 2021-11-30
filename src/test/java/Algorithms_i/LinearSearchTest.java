package Algorithms_i;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearSearchTest {
    public int[] arr={1,9,2,5,1,0,2,0,0,2};
    @Test
    public void SearchTest()
    {
        assertEquals(2,new LinearSearch().find(2,arr));
        System.out.println("Done Successfully");
    }

}