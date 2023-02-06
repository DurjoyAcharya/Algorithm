class Simulation{
   public int customer_no;
   public int rd_ar;//random digit arrengment
   public int iat;//Interval arrival time (Min);
   public int arr_time;
   public int rd_se;
   public int service_begin;
   public int service_time;
   public int time_ser_end;
   public int waiting_time;
   public int idle_time;
   public int spend;

}

interface SimulationFunction<T>{
    void ScheduleArrivalTime(T[] simulations,int n);
    void ScheduleServiceTime(T[] simulations,int n);
    void CompletionOfService(T[] simulations,int n);
    int WaitingAndIdleTime(T[] simulations,int n);
    int SpendTime(T[] simulations,int n);//Schedule spend time
}

public class SingleServerQueue implements SimulationFunction<Simulation>{
    private Simulation[] simulations;
    private int total_service_time;
    public int total_idle_time=0;
    public int total_waiting_time=0;
    public int wait_count=0;
    private int N;//Number Of Customer;
    private double avg_waiting_time;
    private double probability_wait;
    private double probability_of_idle_server;
    private double avg_service_time;
    private double avg_time_btn_arrival;
    private double avg_waiting_time_those_who_wait;
    private double average_time_customer_spends_in_the_system;
    private static final java.util.Scanner sc=new java.util.Scanner(System.in);
    public SingleServerQueue()
    {
        simulations=new Simulation[200];//initialize with 200 rand
        for (int i = 0; i < simulations.length; i++) {
            simulations[i]=new Simulation();
        }
    }
    public void lunchSimulation()
    {
        System.out.println("Enter Number Of Customer: ");
        N=sc.nextInt();
        System.out.println("Enter Random Digit For Arrival Time For Every Customer: ");
        for (int i = 1; i < 2; i++) {
            System.out.println("  Random Arrival[1]: - ");
            simulations[i].customer_no=1;
            simulations[i].rd_ar=0;
            simulations[i].iat=0;
        }
        for (int i = 2; i <= N; i++) {
            System.out.printf("  Random Arrival[%d] ",i);
            simulations[i].rd_ar= sc.nextInt();
            simulations[i].customer_no=i;
            if(simulations[i].rd_ar > 0 && simulations[i].rd_ar < 126)
                simulations[i].iat=1;
            else if(simulations[i].rd_ar > 125 && simulations[i].rd_ar < 251)
                simulations[i].iat=2;
            else if(simulations[i].rd_ar > 250 && simulations[i].rd_ar < 376)
                simulations[i].iat=3;
            else if(simulations[i].rd_ar > 375 && simulations[i].rd_ar < 501)
                simulations[i].iat=4;
            else if(simulations[i].rd_ar > 500 && simulations[i].rd_ar < 626)
                simulations[i].iat=5;
            else if(simulations[i].rd_ar > 625 && simulations[i].rd_ar < 751)
                simulations[i].iat=6;
            else if(simulations[i].rd_ar > 750 && simulations[i].rd_ar < 876)
                simulations[i].iat=7;
            else if(simulations[i].rd_ar > 875 && simulations[i].rd_ar < 1001)
                simulations[i].iat=8;
            else{
                System.out.printf(" Warning!! Please Enter Random Arrival. around 1-1000");
                return;
            }
        }
        ScheduleArrivalTime(simulations,N);
        System.out.println("Enter random digit for service time for each customer: ");
        for(int i=1;i<2;i++)
            simulations[i].service_begin=0;
        for (int i = 1; i <=N; i++) {
            System.out.printf("  Random Service[%d] ",i);
            simulations[i].rd_se=sc.nextInt();
            if(simulations[i].rd_se > 0 && simulations[i].rd_se < 11)
                simulations[i].service_time=1;
            else if(simulations[i].rd_se > 10 && simulations[i].rd_se < 31)
                simulations[i].service_time=2;
            else if(simulations[i].rd_se > 30 && simulations[i].rd_se < 61)
                simulations[i].service_time=3;
            else if(simulations[i].rd_se > 60 && simulations[i].rd_se < 86)
                simulations[i].service_time=4;
            else if(simulations[i].rd_se > 85 && simulations[i].rd_se < 96)
                simulations[i].service_time=5;
            else if(simulations[i].rd_se > 95 && simulations[i].rd_se < 101)
                simulations[i].service_time=6;
            else{
                System.out.printf(" Warning!! Please Enter Random Service. Around 1-100");
                return;
            }
            total_service_time+=simulations[i].service_time;

        }
        //Play With ScheduleServiceTime & CompletionOfService
        ScheduleServiceTime(simulations,N);
        CompletionOfService(simulations,N);
        ScheduleServiceTime(simulations,N);
        CompletionOfService(simulations,N);
        //After play with ScheduleServiceTime & CompletionOfService then WaitingAndIdle
        WaitingAndIdleTime(simulations,N);
        int tst=SpendTime(simulations,N);//total spend time
        System.out.printf("\n   -----------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("\n   -----------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("\n   | Customer  | Random. For | Inter_arrival | Arrival |Random for   | Service | T.Service | T.Service |  Waiting | Server  | Spend in |\n");
        //waiting for implementation
        System.out.printf("    | No.     |Arrival. Time| Time          | Time    |Service.Time | Time     |  Begin    |    End    |  in Queue| Idle.T |  System  |");
        System.out.printf("\n   ----------------------------------------------------------------------------------------------------------------------------------\n");
        for (int i = 1; i <=N; i++) {
            System.out.println(simulations[i].customer_no+"     "+simulations[i].rd_ar+"     "+simulations[i].iat+"     "+
                    simulations[i].arr_time+"   "+simulations[i].rd_se+"    "+simulations[i].service_time+"     "+
                    simulations[i].service_begin+"      "+simulations[i].time_ser_end+"     "+simulations[i].waiting_time+
                    "       "+simulations[i].idle_time+"       "+simulations[i].spend);
            if (i!=N)
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
            else
                System.out.println("\"   -----------------------------------------------------------====-----------------------------====--------====------====--\\n\"");
        }
        System.out.println("\t\t\t\t\t\t\t   "+total_service_time+" \t\t\t\t   "+total_waiting_time+"   \t"+total_idle_time+"   \t"+tst );
        avg_waiting_time = (double) total_waiting_time/(double)N;
        probability_wait = (double) wait_count/(double)N;
        probability_of_idle_server = (double) total_idle_time/(float)simulations[N].time_ser_end;
        avg_service_time = (double) total_service_time/(double) N;
        avg_time_btn_arrival = (double) simulations[N].arr_time/(double)(N-1);
        avg_waiting_time_those_who_wait = (float)total_waiting_time/(float)wait_count;
        average_time_customer_spends_in_the_system = (float)tst/(float)N;

        System.out.println(" Average waiting time = "+avg_waiting_time);
        System.out.println(" Probability(wait) = "+probability_wait);
        System.out.println(" Probability of idle server = "+probability_of_idle_server);
        System.out.println(" Average service time = "+avg_service_time);
        System.out.println(" Average time between arrival = "+avg_time_btn_arrival);
        System.out.println(" Average waiting time of those who wait =  "+avg_waiting_time_those_who_wait);
        System.out.println(" Average time customer spends in the system = "+average_time_customer_spends_in_the_system);
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        //waiting for lunchSimulation
        new SingleServerQueue().lunchSimulation();
    }

    @Override
    public void ScheduleArrivalTime(Simulation[] simulations, int n) {
        for( int i=2; i<=n; i++)
            simulations[i].arr_time=simulations[i-1].arr_time+simulations[i].iat;
    }

    @Override
    public void ScheduleServiceTime(Simulation[] simulations, int n) {
        for(int i=2; i<=n; i++){
            if(simulations[i].arr_time > simulations[i-1].time_ser_end){
                simulations[i].service_begin=simulations[i].arr_time;
            }
            else{
                simulations[i].service_begin=simulations[i-1].time_ser_end;
            }
        }
    }

    @Override
    public void CompletionOfService(Simulation[] simulations, int n) {
        for( int i=1; i<=n; i++)
            simulations[i].time_ser_end=simulations[i].service_begin+simulations[i].service_time;
    }

    @Override
    public int WaitingAndIdleTime(Simulation[] simulations, int n) {
        simulations[1].waiting_time=0;
        simulations[1].idle_time=0;
        for( int i=2; i<=n; i++){
            if(simulations[i].arr_time > simulations[i-1].time_ser_end){
                simulations[i].idle_time=simulations[i].arr_time-simulations[i-1].time_ser_end;
                total_idle_time+=simulations[i].idle_time;
                simulations[i].waiting_time=0;
            }
            else{
                simulations[i].waiting_time=simulations[i-1].time_ser_end-simulations[i].arr_time;
                total_waiting_time+=simulations[i].waiting_time;
                simulations[i].idle_time=0;
            }
            if(simulations[i].waiting_time!=0)
                wait_count+=1;
        }
        return total_idle_time;//confussioning
    }

    @Override
    public int SpendTime(Simulation[] simulations, int n) {
        int total_spend_time=0;
        for(int i=1;i<=n;i++)
        {
            simulations[i].spend = simulations[i].service_time+simulations[i].waiting_time;
            total_spend_time+=simulations[i].spend;

        }
        return total_spend_time;
    }
}