/**
 * Created by moggj_000 on 30/08/2016.
 */
import com.dd.plist.NSString;
import com.dd.plist.NSArray;

abstract class Card{
    String title;

    Card(NSString in_name) {
        this.title = in_name.toString();
    }

    abstract String getChemistry();

    abstract String getClassification();

    abstract String getCrystal_system();

    abstract NSArray getOccurrence();

    abstract String getHardness();

    abstract String getGravity();

    abstract String getCleavage();

    abstract String getCrustalAbundance();

    abstract String getEconomicvalue();

    abstract String getDescription();


    public String toString() {
        return ("\n" + "Card name: " + this.title + "\n Hardness: " + getHardness() + "\n Specific Gravity: " + getGravity() + "\n");
    }



}
