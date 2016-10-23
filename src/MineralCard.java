import com.dd.plist.NSArray;
import com.dd.plist.NSString;

/**
 * Created by moggj_000 on 13/09/2016.
 */
abstract class MineralCard extends Card {
    public String chemistry;
    public String classification;
    public String crystal_system;
    NSArray occurrence;
    public String hardness;
    public String specific_gravity;
    public String cleavage;
    public String crustal_abundance;
    public String economic_value;

    MineralCard(NSString in_name, NSString in_class1, NSString in_class2, NSString in_class3, NSArray in_class4, NSString in_class5, NSString in_class6, NSString in_class7, NSString in_class8, NSString in_class9) {
        super(in_name);
        this.chemistry = in_class1.toString();
        this.classification = in_class2.toString();
        this.crystal_system = in_class3.toString();
        this.occurrence = in_class4;
        this.hardness = in_class5.toString();
        this.specific_gravity = in_class6.toString();
        this.cleavage = in_class7.toString();
        this.crustal_abundance = in_class8.toString();
        this.economic_value = in_class9.toString();
    }
    @Override
    public String toString() {
        return ("\n" + "Name:  " + this.title + "   " + "Gravity:  " + this.specific_gravity + "    " + "Hardness:  " + this.hardness + "      " + "Crystal abundance:  " + this.crustal_abundance + "     " + "Economic Value:  " + this.economic_value);

    }
    public String getChemistry(){
        return chemistry;
    }
    public String getClassification() {
        return classification;
    }

    public String getCrystal_system() {
        return crystal_system;
    }

    public NSArray getOccurrence() {
        return occurrence;
    }

    public String getHardness() {
        return hardness;
    }

    public String getGravity() {
        return specific_gravity;
    }

    public String getCleavage() {
        return cleavage;
    }

    public String getCrustalAbundance() {
        return crustal_abundance;
    }

    public String getEconomic_value() {
        return economic_value;
    }

}