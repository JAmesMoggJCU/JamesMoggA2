import java.util.ArrayList;

/**
 * Created by moggj_000 on 13/09/2016.
 */
public class Players {
    String Name;
    ArrayList<Card> PlayerHand;
    Boolean inorOut;

    Players(String in_Name){
        this.Name = in_Name;
        this.PlayerHand = new ArrayList<Card>();
        this.inorOut = true;
    }
    public String getPlayer(){
        String hand = "";

        for(Card i : PlayerHand){
            hand += i+ " ";
        }
    return (this.Name + " " + hand + " " + this.inorOut);
    }
}

