package Algorithms_i;
//Trie Data Structure

class Fork
{
    private Fork links[]=new Fork[26];
    public boolean flag=false;

    public boolean containKey(char c)
    {
        return links[c-'a']!=null;
    }
    public Fork getFork(char c)
    {
        return links[c-'a'];
    }
    public void Put(char c,Fork fork)
    {
        links[c-'a']=fork;
    }
    public void setEnd()
    {
        flag=true;
    }
    public boolean isEnd()
    {
        return flag;
    }
}

public class Trie {
    private Fork fork;
    public Trie() {
        fork=new Fork();
    }

    public static void Insert()
    {

    }
    public static void main(String[] args) {

    }
}
