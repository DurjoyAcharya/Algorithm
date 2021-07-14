package Algorithms_ii;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class) //Testing er jonno just ekhane main er poriborte Unit Testing use koresi
public class FloydWarshall_Test {
    @Test
        public void basicTest() {
            FloydWarshall fw = new FloydWarshall(5);
            double INF = Double.POSITIVE_INFINITY;
            double[][] expected ={ {0,   3,   INF,   7},
                    {8, 0,   2,   0},
                    {5, INF, 0,   1},
                    {2, INF, INF, 0} };

            fw.addEdge(1, 2, 3);
            fw.addEdge(1, 4, 7);
            fw.addEdge(2, 3, 2);
            fw.addEdge(3, 1, 5);
            fw.addEdge(3, 4, 1);
            fw.addEdge(2,1,8);
            fw.addEdge(4,1,2);

            double[][] result = fw.floydWarshall();

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    System.out.print(result[i][j]+"  ");
                }
                System.out.println();
            }
    }
}
