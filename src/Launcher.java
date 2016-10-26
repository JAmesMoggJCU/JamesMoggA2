/**
 * Created by moggj_000 on 24/10/2016.
 */
public class Launcher {
    static Game instance;
    static int length = 200;
    static int height = 300;
    //connects the launcher to the game class through a  instnace
    public static void getGameInstance(Game gameInstance) {
        instance = gameInstance;
    }

    //holds the size and visibilty of the frame
    public static void startChangeCategory() {
        ChangeCategoryUI changeCategoryUI = new ChangeCategoryUI(instance);
        changeCategoryUI.setSize(length, height);
        changeCategoryUI.setVisible(true);
    }
    //holds the size and visibilty of the frame
    public static void startPlayerAmount() {
        PlayerAmountUI playerAmountUI = new PlayerAmountUI(instance);
        playerAmountUI.setSize(length, height);
        playerAmountUI.setVisible(true);
    }
    //holds the size and visibilty of the frame
    public static void startPlayerName() {
        PlayerNameUI playerNameUI = new PlayerNameUI(instance);
        playerNameUI.setSize(length, height);
        playerNameUI.setVisible(true);
    }
    //holds the size and visibilty of the frame
    public static void startMineralTrump() {
        MineralTrumpUI mineralTrumpUI = new MineralTrumpUI(instance);
        mineralTrumpUI.setSize(1000, 700);
        mineralTrumpUI.setVisible(true);
    }
}
