package ProcessScheduling;


import org.junit.Test;
import java.util.Arrays;
import java.util.Scanner;

public class FCFSTemp {
    private static final Scanner sc=new Scanner(System.in);
    private static int Total_Turnaround_Time;
    private static int Total_Waiting_Time;
    private static int Total_Response_Time;
    private static int Total_Idle_Time;
    @Test
    public void Start_FCFS_Operation()
    {
        System.out.println("Enter Number Of Processes: ");
        int n= sc.nextInt();
        Processes[] pro=new Processes[n];
        System.out.println("Bro 😎 First Enter PID then Arrival Time and then Burst Time");
        for (int i = 0; i < pro.length; i++) {
            pro[i]=new Processes();
            pro[i].Pid=sc.nextInt();
            pro[i].arrival_time=sc.nextInt();
            pro[i].burst_time=sc.nextInt();
        }
        sc.close();
        //List<Processes> list=Arrays.stream(pro).sorted().collect(Collectors.toList());
        Arrays.sort(pro);

        for (int i = 0; i < pro.length; i++) {
         pro[i].start_time=(i==0)?pro[i].arrival_time:Integer.max(pro[i-1].completion_time,pro[i].arrival_time);
         pro[i].completion_time=pro[i].start_time+pro[i].burst_time;
         pro[i].turnaround_time = pro[i].completion_time - pro[i].arrival_time;
         pro[i].waiting_time=pro[i].turnaround_time-pro[i].burst_time;
         pro[i].response_time=pro[i].start_time-pro[i].arrival_time;
         Total_Turnaround_Time+=pro[i].turnaround_time;
         Total_Response_Time+=pro[i].response_time;
         Total_Waiting_Time+=pro[i].waiting_time;
         Total_Idle_Time+=(i==0)?(pro[i].arrival_time):(pro[i].start_time-pro[i].completion_time);
        }
        Arrays.stream(pro).forEach(e->{
            System.out.print(e.completion_time+" ");
        });
    }
}
class Processes implements Comparable<Processes>{
    public int Pid;
    public int arrival_time;
    public int burst_time;
    public int start_time;
    public int completion_time;
    public int turnaround_time;
    public int waiting_time;
    public int response_time;

    @Override
    public int compareTo(Processes o) {
        return this.arrival_time-o.arrival_time;
    }
}
