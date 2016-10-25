/**
 * Created by moggj_000 on 24/10/2016.
 */
public class Launcher {
    static Game instance;
    static int length = 500;
    static int height = 500;

    public static void getGameInstance(Game gameInstance) {
        instance = gameInstance;
    }

    public static void startChangeCategory() {
        ChangeCategoryUI changeCategoryUI = new ChangeCategoryUI(instance);
        changeCategoryUI.setSize(length, height);
        changeCategoryUI.setVisible(true);
    }

    public static void startPlayerAmount() {
        PlayerAmountUI playerAmountUI = new PlayerAmountUI(instance);
        playerAmountUI.setSize(length, height);
        playerAmountUI.setVisible(true);
    }

    public static void startPlayerName() {
        PlayerNameUI playerNameUI = new PlayerNameUI(instance);
        playerNameUI.setSize(length, height);
        playerNameUI.setVisible(true);
    }

    public static void startMineralTrump() {
        MineralTrumpUI mineralTrumpUI = new MineralTrumpUI(instance);
        mineralTrumpUI.setSize(length, height);
        mineralTrumpUI.setVisible(true);
    }
}
