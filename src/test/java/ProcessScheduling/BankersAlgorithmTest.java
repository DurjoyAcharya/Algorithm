package ProcessScheduling;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankersAlgorithmTest {
    @Test
    public void test() {
        int[] available = {3, 3, 2};
        int[][] max = {
                {7, 5, 3}, {3, 2, 2}, {9, 0, 2}, {4, 2, 2}, {5, 3, 3}
        };
        int[][] allocation = {
                {0, 1, 0}, {2, 0, 0}, {3, 0, 2}, {2, 1, 1}, {0, 0, 2}
        };
        int[][] need = {
                {7, 4, 3}, {1, 2, 2}, {6, 0, 0}, {4, 1, 1}, {5, 3, 1}
        };
        BankersAlgorithm banker = new BankersAlgorithm(available, max, allocation, need);
        System.out.println(banker);

        System.out.println("Security analysis: ");
        System.out.println("Is there a security sequence? " + banker.hasSecureSequence());
        System.out.println();

//        System.out.println("P1 request resource：Request1(1,0,2)");
//        int[] request1 = {1, 0, 2};
//        System.out.println("There is a security sequence？ " + banker.processRequest(1, request1));
//        System.out.println();
//
//        System.out.println("P4 request resources：Request4(3,3,0)");
//        int[] request4 = {3, 3, 0};
//        System.out.println("Is there a security sequence? " + banker.processRequest(4, request4));
//        System.out.println();
//
//        System.out.println("P0 request resource: Request0(0,2,0)");
//        int[] request0 = {0, 2, 0};
//        System.out.println("Is there a security sequence? " + banker.processRequest(0, request0));
//        System.out.println();
    }
}