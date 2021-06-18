package Internet;


class Card{
    private int rank;
    private int suits;
    public Card(int rank, int suits) {
        this.rank = rank;
        this.suits = suits;
    }
    public int CompareTo(Card that)
    {
        if (this.suits< that.suits)
            return -1;
        if (this.suits> that.suits)
            return 1;
        if (this.rank<that.rank)
            return -1;
        if (this.rank>that.rank)
            return 1;
        return 0;
    }
    public int getRank() {
        return this.rank;
    }
    public int getSuits() {
        return this.suits;
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
    public static void CasinoWar(Card[] cards)
    {
        for (int i = 0; i < cards.length; i++) {
            System.out.println(cards[i]);
        }
    }
    public static int Search(Card[] cards, String target)
    {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].equals(target))
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Card[] cards=new Card[52];
        int index=0;
        for (int i = 0; i <=3; i++) {
            for (int j = 1; j <=13; j++) {
                cards[index]=new Card(j,i);
                index++;
            }
        }
        CasinoWar(cards);
    }
}
