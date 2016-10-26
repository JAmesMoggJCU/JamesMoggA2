/**
 * Created by moggj_000 on 24/10/2016.
 */
import com.dd.plist.*;
import org.xml.sax.SAXException;

import java.awt.Color;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
    // links game
    static Game game;
    //links the launcher contorl
    static Launcher _launcher;

    public static void main(String[] args) throws PropertyListFormatException, ParserConfigurationException, SAXException, ParseException, IOException {
        game = new Game();
        game.deckInstance = new Deck();
        game.playersArray = new ArrayList<>();
        game.centerCards = new ArrayList<>();
        game.winnerPile = new ArrayList<>();
        Collections.shuffle(game.deckInstance.deckArray);
        _launcher = new Launcher();
        //runs the launcher code in wat order is below while being linked to the game class
        _launcher.getGameInstance(game);
        StartScreen.getLauncher(_launcher);
        PlayerAmountUI.getLauncher(_launcher);
        PlayerNameUI.getLauncher(_launcher);
        ChangeCategoryUI.getLauncher(_launcher);
        startStartScreen();
    }
    //holds and runs the beginning frame that is then linked to the next grouping
    public static void startStartScreen(){
        StartScreen startScreen = new StartScreen();
        startScreen.setSize(300, 300);
        startScreen.setVisible(true);
    }
}
