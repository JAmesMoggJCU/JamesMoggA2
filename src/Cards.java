/**
 * Created by moggj_000 on 30/08/2016.
 */
import com.dd.plist.NSString;
import com.dd.plist.NSArray;

import java.awt.*;

abstract class Card{
    String title;
    String fileName;

    Card() {

    }

    Card(NSString in_name, NSString inFileName){

        this.title = in_name.toString();
        this.fileName = inFileName.toString();
    }

    abstract String getChemistry();

    abstract String getClassification();

    abstract String getCrystal_system();

    abstract NSArray getOccurrence();

    abstract String getHardness();

    abstract String getGravity();

    abstract String getCleavage();

    abstract String getCrustal_Abundance();

    abstract String getEconomic_value();

    abstract String getDescription();


    public String toString() {
        return ("\n" + "Card name: " + this.title + "\n Hardness: " + getHardness() + "\n Specific Gravity: " + getGravity() + "\n");
    }



}
