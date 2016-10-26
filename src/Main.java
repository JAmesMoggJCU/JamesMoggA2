/**
 * Created by moggj_000 on 24/10/2016.
 */
import com.dd.plist.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
    static Game game;
    static Launcher _launcher;

    public static void main(String[] args) throws PropertyListFormatException, ParserConfigurationException, SAXException, ParseException, IOException {
        game = new Game();
        game.deckInstance = new Deck();
        game.playersArray = new ArrayList<>();
        game.centerCards = new ArrayList<>();
        game.winnerPile = new ArrayList<>();
        Collections.shuffle(game.deckInstance.deckArray);
        _launcher = new Launcher();

        _launcher.getGameInstance(game);
        StartScreen.getLauncher(_launcher);
        PlayerAmountUI.getLauncher(_launcher);
        PlayerNameUI.getLauncher(_launcher);
        ChangeCategoryUI.getLauncher(_launcher);
        startStartScreen();
    }
    public static void startStartScreen(){
        StartScreen startScreen = new StartScreen();
        startScreen.setSize(500, 500);
        startScreen.setVisible(true);
    }
}
