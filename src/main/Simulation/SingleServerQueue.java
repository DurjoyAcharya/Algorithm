class Simulation{
   public int customer_no;
   public int rd_ar;//random arrival time
   public int intr_arr_time;
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




    }

    public static void main(String[] args) {

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