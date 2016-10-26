import com.dd.plist.NSString;

/**
 * Created by moggj_000 on 13/09/2016.
 */
abstract class TrumpCard extends Card {
    public String subtitle;

    TrumpCard(NSString in_name, NSString inFileName, NSString description) {
        super(in_name, inFileName);
        this.subtitle = description.toString();

    }

    @Override
    /*public String toString() {
        return ("\n" + "This Trump Card is\n " + this.title + "\n its description is\n " + this.subtitle);
    }*/
    public String getDescription() {
        return subtitle;
    }

    abstract String getSpecific_gravity();

    abstract String getCrustal_Abundance();

    abstract String getEconomic_value();
}
