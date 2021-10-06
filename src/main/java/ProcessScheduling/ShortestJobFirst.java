package ProcessScheduling;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Name: Durjoy Acharya
 * Id: 1925102002
 * Batch: 51th
 * Email: da-durjoy@outlook.com
 * Department Of Computer Science & Engineering
 * City University
 */

//AT---Arrival Time
//BT---Burst Time
//WT---Waiting Time
//TAT---TurnAround Time
//---Arrival Time

public class ShortestJobFirst {
    private static final Scanner sc=new Scanner(System.in);
    private  double avg_turnaround_time;
    private  double total_turnaround_time;
    private  double total_idle_time;
    private double avg_waiting_time;
    private double total_waiting_time;
    private double avg_response_time;
    private double cpu_util;
    private double total_response_time;
//    public int[] isCompleted=new int[20];
    public void Start_SJF_Operation() {
//        System.out.println(Arrays.toString(isCompleted));
        System.out.println("Enter Number Of Processes: ");
        int n = sc.nextInt();
        Processes[] pro = new Processes[n];
        boolean[] isCompleted=new boolean[n];
        System.out.println("Please First Enter PID then Arrival Time and then Burst Time");
        for (int i = 0; i < pro.length; i++) {
            pro[i] = new Processes();
            pro[i].Pid = sc.next();
            pro[i].arrival_time = sc.nextInt();
            pro[i].burst_time = sc.nextInt();
        }
        sc.close();
        int current_time = 0;
        int completed = 0;
        int prev = 0;
        while (completed!=n)
        {
            int idx=-1;
            int max=Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if(pro[i].arrival_time<=current_time && !isCompleted[i])
                {
                    if (pro[i].burst_time<max)
                    {
                        max=pro[i].burst_time;
                        idx=i;
                    }
                    if(pro[i].burst_time==max)
                    {
                        if (pro[i].arrival_time<pro[idx].arrival_time)
                        {
                            max=pro[i].burst_time;
                            idx=i;
                        }
                    }
                }
            }
            if (idx!=-1)
            {
                pro[idx].start_time=current_time;
                pro[idx].completion_time=pro[idx].start_time+pro[idx].burst_time;
                pro[idx].turnaround_time=pro[idx].completion_time-pro[idx].arrival_time;
                pro[idx].waiting_time=pro[idx].turnaround_time-pro[idx].burst_time;
                pro[idx].response_time=pro[idx].start_time-pro[idx].arrival_time;


                total_waiting_time+=pro[idx].waiting_time;
                total_response_time+=pro[idx].response_time;
                total_turnaround_time+=pro[idx].turnaround_time;
                total_idle_time+=pro[idx].start_time-prev;


                isCompleted[idx]=true;
                completed++;
                current_time=pro[idx].completion_time;
                prev=current_time;
            }else current_time++;
        }
        int min_arrival_time=Integer.MAX_VALUE;
        int max_completion_time=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min_arrival_time=Integer.min(min_arrival_time,pro[i].arrival_time);
            max_completion_time=Integer.max(max_completion_time,pro[i].completion_time);
        }
        avg_turnaround_time=total_turnaround_time/n;
        avg_waiting_time=total_waiting_time/n;
        avg_response_time=total_response_time/n;
        cpu_util=((max_completion_time-total_idle_time)/max_completion_time)*100;

        System.out.println("::::After Analysis of SJF Scheduling Algorithm::::");
        Arrays.stream(pro).forEach(e->{
            System.out.println("|  PQ: "+e.Pid+"  |  AT:"+e.arrival_time
            +"  |  BT: "+ e.burst_time+"  |  WT: "+e.waiting_time+" | RT: "+e.response_time+"  |  TAT: "+
                    e.turnaround_time+" |");
        });
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Average Turnaround Time: "+avg_turnaround_time+"m/s");
        System.out.println("Average Waiting Time: "+avg_waiting_time+"m/s");
        System.out.println("Average Response Time: "+avg_response_time+"m/s");
        System.out.println("CPU Utilization: "+String.format("%.2f",cpu_util)+"%");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::");
    }
    public static void main(String[] args) {
        new ShortestJobFirst().Start_SJF_Operation();
    }
}
