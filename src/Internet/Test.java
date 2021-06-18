package Internet;


class Card{
    private int rank;
    private int suits;
    public Card(int rank, int suits) {
        this.rank = rank;
        this.suits = suits;
    }
    @Override
    public String toString()
    {
        String[] str={"Clubs","Diamonds","Hearts","Spades"};
        String[] ranks={null,"Ace","2","3","4","5","6","7","8","9","10",
                "Jack","Queen","King"};
        String s=ranks[this.rank]+" Of "+str[this.suits];
        return s;
    }
}
public class Test {
    public static void main(String[] args) {
        Card ThreeOfCard=new Card(11,2);
        System.out.println(ThreeOfCard);
    }
}
