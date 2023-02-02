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
    private Simulation[] s;
    private int total_service_time;
    private int N;//Number Of Customer;
    private double avg_waiting_time;
    private double probability_wait;
    private double probability_of_idle_server;
    private double avg_service_time;
    private double avg_time_btn_arrival;
    private double avg_waiting_time_those_who_wait;
    private double Average_time_customer_spends_in_the_system;
    private static final java.util.Scanner sc=new java.util.Scanner(System.in);
    public SingleServerQueue()
    {
        s=new Simulation[200];//initialize with 200 rand
        for (int i = 0; i < s.length; i++) {
            s[i]=new Simulation();
        }
    }
    public void lunchSimulation()
    {
        System.out.println("Enter Number Of Customer: ");
        N=sc.nextInt();
        System.out.println("Enter Random Digit For Arrival Time For Every Customer: ");
        for (int i = 1; i < 2; i++) {
            System.out.println("Random Arrival[1]: - ");
            s[i].customer_no=1;
            s[i].rd_ar=0;
            s[i].iat=0;
        }
        for (int i = 2; i <= N; i++) {
            System.out.printf("  Random Arrival[%d] ",i);
            s[i].rd_ar= sc.nextInt();
            s[i].customer_no=i;
            if(s[i].rd_ar > 0 && s[i].rd_ar < 126)
                s[i].iat=1;
            else if(s[i].rd_ar > 125 && s[i].rd_ar < 251)
                s[i].iat=2;
            else if(s[i].rd_ar > 250 && s[i].rd_ar < 376)
                s[i].iat=3;
            else if(s[i].rd_ar > 375 && s[i].rd_ar < 501)
                s[i].iat=4;
            else if(s[i].rd_ar > 500 && s[i].rd_ar < 626)
                s[i].iat=5;
            else if(s[i].rd_ar > 625 && s[i].rd_ar < 751)
                s[i].iat=6;
            else if(s[i].rd_ar > 750 && s[i].rd_ar < 876)
                s[i].iat=7;
            else if(s[i].rd_ar > 875 && s[i].rd_ar < 1001)
                s[i].iat=8;
            else{
                System.out.printf(" Warning!! Please Enter Random Arrival. around 1-1000");
                return;
            }
        }
        ScheduleArrivalTime(s,N);
        System.out.println(" Enter random digit for service time for each customer: ");
        for(int i=1;i<2;i++)
            s[i].service_begin=0;
        for (int i = 1; i <=N; i++) {
            System.out.printf("  Random Service[%d] ",i);
            s[i].rd_se=sc.nextInt();
            if(s[i].rd_se > 0 && s[i].rd_se < 11)
                s[i].service_time=1;
            else if(s[i].rd_se > 10 && s[i].rd_se < 31)
                s[i].service_time=2;
            else if(s[i].rd_se > 30 && s[i].rd_se < 61)
                s[i].service_time=3;
            else if(s[i].rd_se > 60 && s[i].rd_se < 86)
                s[i].service_time=4;
            else if(s[i].rd_se > 85 && s[i].rd_se < 96)
                s[i].service_time=5;
            else if(s[i].rd_se > 95 && s[i].rd_se < 101)
                s[i].service_time=6;
            else{
                System.out.printf(" Warning!! Please Enter Random Service. Around 1-100");
                return;
            }
            total_service_time+=s[i].service_time;
        }


    }

    public static void main(String[] args) {
        //System.out.printf("arr[%d]",5);
    }

    @Override
    public void ScheduleArrivalTime(Simulation[] simulations, int n) {

    }

    @Override
    public void ScheduleServiceTime(Simulation[] simulations, int n) {

    }

    @Override
    public void CompletionOfService(Simulation[] simulations, int n) {

    }

    @Override
    public int WaitingAndIdleTime(Simulation[] simulations, int n) {
        return 0;
    }

    @Override
    public int SpendTime(Simulation[] simulations, int n) {
        return 0;
    }
}