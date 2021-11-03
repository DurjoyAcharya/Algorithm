package ProcessScheduling;


public class BankersAlgorithm {
    private int[] available;      // 可利用资源
    private int[][] max;          // 最大需求
    private int[][] allocation;   // 分配
    private int[][] need;         // 需求
    public BankersAlgorithm(int[] available, int[][] max, int[][] allocation, int[][] need) {
        this.available = available;
        this.max = max;
        this.allocation = allocation;
        this.need = need;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Available resources：" + format(available) + "\n" +
                String.format("%-7s%-12s%-11s%-1s",
                        "process", "Max Need", "Allocation", "need") + "\n");
        for (int i = 0; i < max.length; i++) {
            builder.append(String.format("%-8s%-13s%-12s%-10s", "P" + i,
                    format(max[i]), format(allocation[i]), format(need[i]))).append("\n");
        }
        return builder.toString();
    }

    boolean processRequest(int i, int[] request) {
        for (int j = 0; j < request.length; j++) {
            if (request[j] > need[i][j]) {
                System.out.println("Request" + i + " > Need" + i);
                return false;
            }
            if (request[j] > available[j]) {
                System.out.println("Request" + i + " > Available" + i);
                return false;
            }
        }

        // 假设能分配成功，先分配资源
        for (int j = 0; j < request.length; j++) {
            available[j] -= request[j];
            allocation[i][j] += request[j];
            need[i][j] -= request[j];
        }

        if (hasSecureSequence()) return true;
        System.out.println("Available resources:" + format(available) + "\n" +
                String.format("%-8s%-12s%-11s", "process", "Allocation", "need"));

        for (int j = 0; j < max.length; j++)
            System.out.println(String.format("%-8s%-13s%-12s", "P" + i,
                    format(allocation[i]), format(need[i])));
        for (int j = 0; j < request.length; j++) {
            available[j] += request[j];
            allocation[i][j] -= request[j];
            need[i][j] += request[j];
        }
        return false;
    }

    boolean hasSecureSequence() {
        StringBuilder builder = new StringBuilder(String.format("%-11s%-12s%-11s%-15s%-20s%-11s",
                "process", "Work", "Need", "Allocation", "Work + Allocation", "Finish") + "\n");
        int[] work = new int[available.length];

        System.arraycopy(available, 0, work, 0, work.length);

        boolean[] finish = new boolean[max.length];

        for (int i = 0, t = 0; t < max.length; i = (i + 1) % max.length) {
            if (!finish[i] && allEnough(i, work)) {
                builder.append(String.format("%-11s%-12s%-13s%-19s",
                        "P" + i, format(work), format(need[i]), format(allocation[i])));

                // 回收资源
                for (int j = 0; j < work.length; j++) {
                    work[j] += allocation[i][j];
                }
                finish[i] = true;
                builder.append(String.format("%-16s%-1s", format(work), finish[i]) ).append("\n");
                if (allTrue(finish)) {
                    System.out.print(builder);
                    return true;
                }
            }
            if (i == max.length - 1) t++;
        }
        return false;
    }
    private boolean allEnough(int i, int[] work) {
        for (int j = 0; j < work.length; j++)
            if (need[i][j] > work[j])
                return false;
        return true;
    }
    private boolean allTrue(boolean[] bool) {
        for (boolean b : bool)
            if (! b) return false;
        return true;
    }
    private static String format(int[] a) {
        StringBuilder str = new StringBuilder("(");
        for (int j = 0; j < a.length; j++) {
            str.append(a[j]);
            if (j < a.length - 1) str.append(",");
        }
        str.append(")");
        return str.toString();
    }
}
