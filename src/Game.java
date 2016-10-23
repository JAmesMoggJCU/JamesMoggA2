/**
 * Created by moggj_000 on 13/09/2016.
 */
import com.dd.plist.*;

import javax.xml.parsers.*;
import org.xml.sax.*;

import java.text.ParseException;
import java.io.*;
import java.util.*;
import java.util.Collections;
public class Game {
    static String roundType;
    static int outCounter;
    static Integer handCardValue;
    static Integer PileCardValue;
    static int playerAmmount;
    static String playerStringInputName;

    Game() {
        this.roundType = " ";
        this.outCounter = 0;
        this.handCardValue = null;
        this.PileCardValue = null;
        this.playerAmmount = 0;
        this.playerStringInputName = " ";
    }

    static Deck deckInstance;
    static ArrayList<Players> playersArray;
    static ArrayList<Card> centerCards;
    static ArrayList<Players> winnerPile;

    /*public static void main(String[] args) throws ParserConfigurationException, ParseException, SAXException, PropertyListFormatException, IOException {
        deckInstance = new Deck();
        centerCards = new ArrayList<>();
        playersArray = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        Integer playersArrayIndex = 0;
        ArrayList<Players> winnerPile = new ArrayList<>();


        //System.out.println(deckInstance.deckArray.get(0).toString()); //testing if everything prints with deck
        //deckInstance.print();
        // asks for how many players there are in the game
        do {

            System.out.println("Enter the number of players:   ");
            playersArrayIndex = input.nextInt();
            Collections.shuffle(Game.deckInstance.deckArray);
        } while (playersArrayIndex > 5 || playersArrayIndex < 3);
        input.nextLine();
        for (int x = 0; x < playersArrayIndex; x = x + 1) {
            String playerName;
            System.out.println("Enter players name:   "); // enters in players names
            playerName = input.nextLine();
            Players nextPlayer = new Players(playerName);
            while (nextPlayer.PlayerHand.size() < 8) {
                nextPlayer.PlayerHand.add(deckInstance.deckArray.remove(0));
            }
            playersArray.add(nextPlayer);
            System.out.println(nextPlayer.getPlayer());
        }
        // begins the round asking for first player to choose the type of round
        Play.roundType = chooseType(Play.roundType);
        String gameOption;
        System.out.println("The type of round is:    " + Play.roundType);
        while (playersArray.size() > 1) {
            for (int i = 0; i < playersArray.size(); i++) {
                if (playersArray.get(i).inorOut) {
                    do {
                        System.out.println("\n" + "Enter an option for player:   " + playersArray.get(i).Name + " \n play \n pass");//asks player to play or pass
                        gameOption = input.nextLine().toLowerCase();
                        if (gameOption.equals("play")) {
                            CardsPile();
                            System.out.println("The type for the round is:   " + Play.roundType + "\n");// displays the round category
                            System.out.println(playersArray.get(i).getPlayer());
                            Play.roundType = cardCompare(playersArray.get(i), Play.roundType, i, playersArrayIndex);
                            if (playersArray.get(i).PlayerHand.size() == 0) {
                                System.out.println("Congratulations " + playersArray.get(i).getPlayer() + " for emptying your hand \n");//when players have emptied there hand they get removed from playersArray and added to winnerpile
                                winnerPile.add(playersArray.get(i));
                                playersArray.remove(i);
                            }

                        } else if (gameOption.equals("pass")) {//that if a player passes they will draw a card to PlayerHand
                            drawCard(playersArray.get(i));
                            System.out.println(playersArray.get(i).getPlayer());
                            playersArray.get(i).inorOut = Boolean.FALSE;
                            Play.outCounter++;
                            nextRound(playersArrayIndex);

                        }
                    } while (!gameOption.equals("play") && !gameOption.equals("pass"));
                }
            }
        }
    }
    // will show when a new category has to be chosen by the first player
    static void nextRound(int playerAmountPlace) {
        playerAmountPlace--;
        if (Play.outCounter == playerAmountPlace) {
            System.out.println("\n" + "-----------------------------------\n The current round has ended \n the new round will start now \n ----------------------------------- \n");
            for (int i = 0; i < playersArray.size(); i++) {
                playersArray.get(i).inorOut = Boolean.TRUE;
            }
            Play.roundType = chooseType(Play.roundType);
            Play.outCounter = 0;
        }

    }
*/
    // runs the player choosing what category the round will be in
    static String chooseType(String TypeHolder) {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Enter the category to play: \n hardness \n specific gravity \n cleavage \n crustal abundance \n economic value   ");
            TypeHolder = input.nextLine().toLowerCase();
        }
        while (!TypeHolder.equals("hardness") && !TypeHolder.equals("specific gravity") && !TypeHolder.equals("cleavage") && !TypeHolder.equals("crustal abundance") && !TypeHolder.equals("economic value"));
        return TypeHolder;
    }

    // holds the vlaues of the hardness category from string to integer
    static int getHardness(String hardness) {
        int HardnessValue = 0;
        switch (hardness) {
            case "1":
                return 1;
            case "1 - 1.5":
                return 2;
            case "1.5 - 2.5":
                return 3;
            case "1 - 2":
                return 4;
            case "2":
                return 5;
            case "2.5":
                return 6;
            case "2 - 3":
                return 7;
            case "2.5 - 3":
                return 8;
            case "3":
                return 9;
            case "2.5 -3.5":
                return 10;
            case "3 - 3.5":
                return 11;
            case "3.5 - 4":
                return 12;
            case "4":
                return 13;
            case "3.5 - 4.5":
                return 14;
            case "4 - 4.5":
                return 15;
            case "5":
                return 16;
            case "5 - 5.5":
                return 17;
            case "5.5":
                return 18;
            case "5.5 - 6":
                return 19;
            case "5 - 6":
                return 20;
            case "6":
                return 21;
            case "5.5 - 6.5":
                return 22;
            case "6 - 6.5":
                return 23;
            case "6 - 7":
                return 24;
            case "6.5 - 7":
                return 25;
            case "5.5 - 7":
                return 26;
            case "7":
                return 27;
            case "7 - 7.5":
                return 28;
            case "6.5 - 7.5":
                return 29;
            case "6 - 7.5":
                return 30;
            case "7.5":
                return 31;
            case "7.5 - 8":
                return 32;
            case "8":
                return 33;
            case "9":
                return 34;
            case "10":
                return 35;
        }
        return HardnessValue;
    }

    // holds the Gravity values from String to integer
    public static int getGravity(String Gravity) {
        int GravityValue = 0;
        switch (Gravity) {
            case "2.2":
                return 1;
            case "2.3":
                return 2;
            case "2.4":
                return 3;
            case "2.5 - 2.6":
                return 4;
            case "2.6":
                return 5;
            case "2.65":
                return 6;
            case "2.6 - 2.7":
                return 7;
            case "2.7":
                return 8;
            case "2.6 - 2.8":
                return 9;
            case "2.6 - 2.9":
                return 10;
            case "2.8 - 2.9":
                return 11;
            case "2.9":
                return 12;
            case "3.0":
                return 13;
            case "3.15":
                return 14;
            case "3.1 - 3.2":
                return 15;
            case "3.0 - 3.2":
                return 16;
            case "3.2":
                return 17;
            case "3.25":
                return 18;
            case "2.6 - 3.3":
                return 19;
            case "2.7 - 3.3":
                return 20;
            case "3.0 - 3.5":
                return 21;
            case "3.5":
                return 22;
            case "3.2 - 3.5":
                return 23;
            case "3.2 - 3.6":
                return 24;
            case "3.4 - 3.6":
                return 25;
            case "3.5 - 3.6":
                return 26;
            case "3.5 - 3.7":
                return 27;
            case "3.7 - 3.8":
                return 28;
            case "3.2 - 3.9":
                return 29;
            case "4.0":
                return 30;
            case "3.9 - 4.1":
                return 31;
            case "3.5 - 4.3":
                return 32;
            case "4.1 - 4.3":
                return 33;
            case "4.3":
                return 34;
            case "3.2 - 4.4":
                return 35;
            case "4.5":
                return 36;
            case "4.6":
                return 37;
            case "4.6 - 4.7":
                return 38;
            case "4.7":
                return 39;
            case "4.7 - 4.8":
                return 40;
            case "5.0":
                return 41;
            case "4.5 -5.1":
                return 42;
            case "5.2":
                return 43;
            case "5.0 - 5.3":
                return 44;
            case "5.3":
                return 45;
            case "6.9 - 7.1":
                return 46;
            case "7.5 - 7.6":
                return 47;
            case "19.3":
                return 48;
        }
        return GravityValue;
    }

    // holds the Cleavage vlaues from String to Integer
    public static int getCleavage(String Cleavage) {
        int CleavageValue = 0;
        switch (Cleavage) {
            case "none":
                return 1;
            case "poor/none":
                return 2;
            case "1 poor":
                return 3;
            case "2 poor":
                return 4;
            case "1 good":
                return 5;
            case "1 good, 1 poor":
                return 6;
            case "2 good":
                return 7;
            case "3 good":
                return 8;
            case "1 perfect":
                return 9;
            case "1 perfect, 1 good":
                return 10;
            case "1 perfect, 2 good":
                return 11;
            case "2 perfect, 1 good":
                return 12;
            case "3 perfect":
                return 13;
            case "4 perfect":
                return 14;
            case "6 perfect":
                return 15;
        }
        return CleavageValue;
    }

    // holds the CrustalAbundance vlaues from String to Integer
    public static int getCrustalAbundance(String Crustal) {
        int CrustalAbundanceValue = 0;
        switch (Crustal) {
            case "ultratrace":
                return 1;
            case "trace":
                return 2;
            case "low":
                return 3;
            case "moderate":
                return 4;
            case "high":
                return 5;
            case "very high":
                return 5;

        }
        return CrustalAbundanceValue;
    }

    // holds the Economic vlaues from String to Integer
    public static int getEconomicValue(String Economic) {
        int EconomicValueValue = 0;
        switch (Economic) {
            case "trivial":
                return 1;
            case "low":
                return 2;
            case "moderate":
                return 3;
            case "high":
                return 4;
            case "very high":
                return 5;
            case "I'm rich!":
                return 6;
        }
        return EconomicValueValue;
    }

    static void CardsPile() {
        System.out.println("<Center Card Pile \n " + centerCards.toString());
    }

    static void drawCard(Players playerPlace) {
        playerPlace.PlayerHand.add(deckInstance.deckArray.get(0));
        deckInstance.deckArray.remove(0);
    }

    //resets the round fro all players when a trump card is played
    static void trumpPlayerReset() {
        System.out.println("A trump card has been played everyone is back in the round now");
        for (int i = 0; i < playersArray.size(); i++) {
            playersArray.get(i).inorOut = Boolean.TRUE;
        }
        Play.outCounter = 0;
    }

    /*
    // compares the cards values to determine if a card is larger category than the other
    static String cardCompare(Players playerPlace, String cardCompareType, int playerIndex, Integer playersArrayIndex) {
        Integer handCardValue = null;
        Integer CardPileValue = null;
        int cardHandIndex = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("type the number of the card you wish to place:    ");
        centerCards.add(playerPlace.PlayerHand.get(cardHandIndex));
        playersArray.remove(playerPlace.PlayerHand.remove(cardHandIndex));
        cardHandIndex = input.nextInt();
        switch (cardCompareType) {
            case "hardness":
                try {
                    handCardValue = getHardness(playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).getHardness());
                } catch (NullPointerException a) {
                    System.out.println("you have played " + playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).title);
                    centerCards.add(playerPlace.PlayerHand.get(cardHandIndex));
                    System.out.println(playerPlace.PlayerHand.remove(cardHandIndex));
                    if (playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).title.equals("The Geologist")) {
                        cardCompareType = chooseType(cardCompareType).toLowerCase();
                        trumpPlayerReset();
                        handCardValue = 10;
                        break;
                    } else if (playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).title.equals("The Geophysicist") && playersArray.get(playerIndex).PlayerHand.toString().contains("Magnetite")) {
                        System.out.println("You have Magnetite in your hand! ");
                        while (playersArray.get(playerIndex).PlayerHand.size() != 0) {
                            playersArray.get(playerIndex).PlayerHand.remove(0);
                        }
                        trumpPlayerReset();
                        break;
                    }
                    else {
                        cardCompareType = playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).getDescription().toLowerCase();
                        trumpPlayerReset();
                        handCardValue = 10;
                        break;
                    }
                }
                try {
                    CardPileValue = getHardness(centerCards.get(0).getHardness());

                } catch (IndexOutOfBoundsException b) {
                    System.out.println("there was no card on the pile you. may place your card");
                    CardPileValue = -1;
                }

                if (handCardValue > CardPileValue) {
                    System.out.println("the card has a higher value");
                } else System.out.println("the cards value was not higher! Try again");
                break;

            case "Gravity":
                try {
                handCardValue = getGravity(playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).getGravity());
                } catch (NullPointerException a) {
                    System.out.println("you have played " + playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).title);
                    centerCards.add(playerPlace.PlayerHand.get(cardHandIndex));
                    System.out.println(playerPlace.PlayerHand.remove(cardHandIndex));
                    if (playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).title.equals("The Geologist")) {
                        cardCompareType = chooseType(cardCompareType).toLowerCase();
                        trumpPlayerReset();
                        handCardValue = 10;
                        break;
                    } else if (playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).title.equals("The Geophysicist") && playersArray.get(playerIndex).PlayerHand.toString().contains("Magnetite")) {
                        System.out.println("You have Magnetite in your hand! ");
                        while (playersArray.get(playerIndex).PlayerHand.size() != 0) {
                            playersArray.get(playerIndex).PlayerHand.remove(0);
                        }
                        trumpPlayerReset();
                        break;
                    }
                    else {
                        cardCompareType = playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).getDescription().toLowerCase();
                        trumpPlayerReset();
                        handCardValue = 10;
                        break;
                    }
                }
                try {
                    CardPileValue = getGravity(centerCards.get(0).getGravity());

                } catch (IndexOutOfBoundsException b) {
                    System.out.println("there was no card on the pile you. may place your card");
                    CardPileValue = -1;
                }

                if (handCardValue > CardPileValue) {
                    System.out.println("the card has a higher value");
                    centerCards.add(playerPlace.PlayerHand.get(cardHandIndex));
                    System.out.println(playerPlace.PlayerHand.remove(cardHandIndex) + " was removed from hand");
                } else System.out.println("the cards value was not higher! Try again");
                break;
            case "Cleavage":
                try {
                    handCardValue = getCleavage(playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).getCleavage());
                } catch (NullPointerException a) {
                    System.out.println("you have played " + playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).title);
                    centerCards.add(playerPlace.PlayerHand.get(cardHandIndex));
                    System.out.println(playerPlace.PlayerHand.remove(cardHandIndex));
                    if (playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).title.equals("The Geologist")) {
                        cardCompareType = chooseType(cardCompareType).toLowerCase();
                        trumpPlayerReset();
                        handCardValue = 10;
                        break;
                    } else if (playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).title.equals("The Geophysicist") && playersArray.get(playerIndex).PlayerHand.toString().contains("Magnetite")) {
                        System.out.println("You have Magnetite in your hand! ");
                        while (playersArray.get(playerIndex).PlayerHand.size() != 0) {
                            playersArray.get(playerIndex).PlayerHand.remove(0);
                        }
                        trumpPlayerReset();
                        break;
                    }
                    else {
                        cardCompareType = playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).getDescription().toLowerCase();
                        trumpPlayerReset();
                        handCardValue = 10;
                        break;
                    }
                }
                try {
                    CardPileValue = getCleavage(centerCards.get(0).getCleavage());

                } catch (IndexOutOfBoundsException b) {
                    System.out.println("there was no card on the pile you. may place your card");
                    CardPileValue = -1;
                }

                if (handCardValue > CardPileValue) {
                    System.out.println("the card has a higher value");
                    centerCards.add(playerPlace.PlayerHand.get(cardHandIndex));
                    System.out.println(playerPlace.PlayerHand.remove(cardHandIndex) + " was removed from hand");
                } else System.out.println("the cards value was not higher! Try again");
                break;
            case "Crustal Abundance":
                try {
                    handCardValue = getCrustalAbundance(playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).getCrustalAbundance());
                } catch (NullPointerException a) {
                    System.out.println("you have played " + playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).title);
                    centerCards.add(playerPlace.PlayerHand.get(cardHandIndex));
                    System.out.println(playerPlace.PlayerHand.remove(cardHandIndex));
                    if (playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).title.equals("The Geologist")) {
                        cardCompareType = chooseType(cardCompareType).toLowerCase();
                        trumpPlayerReset();
                        handCardValue = 10;
                        break;
                    } else if (playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).title.equals("The Geophysicist") && playersArray.get(playerIndex).PlayerHand.toString().contains("Magnetite")) {
                        System.out.println("You have Magnetite in your hand! ");
                        while (playersArray.get(playerIndex).PlayerHand.size() != 0) {
                            playersArray.get(playerIndex).PlayerHand.remove(0);
                        }
                        trumpPlayerReset();
                        break;
                    }
                    else {
                        cardCompareType = playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).getDescription().toLowerCase();
                        trumpPlayerReset();
                        handCardValue = 10;
                        break;
                    }
                }
                try {
                    CardPileValue = getCrustalAbundance(centerCards.get(0).getCrustalAbundance());

                } catch (IndexOutOfBoundsException b) {
                    System.out.println("there was no card on the pile you. may place your card");
                    CardPileValue = -1;
                }

                if (handCardValue > CardPileValue) {
                    System.out.println("the card has a higher value");
                    centerCards.add(playerPlace.PlayerHand.get(cardHandIndex));
                    System.out.println(playerPlace.PlayerHand.remove(cardHandIndex) + " was removed from hand");
                } else System.out.println("the cards value was not higher! Try again");
                break;
            case "Economic Abundance":
                try {
                    handCardValue = getEconomicValue(playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).getEconomicvalue());
                } catch (NullPointerException a) {
                    System.out.println("you have played " + playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).title);
                    centerCards.add(playerPlace.PlayerHand.get(cardHandIndex));
                    System.out.println(playerPlace.PlayerHand.remove(cardHandIndex));
                    if (playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).title.equals("The Geologist")) {
                        cardCompareType = chooseType(cardCompareType).toLowerCase();
                        trumpPlayerReset();
                        handCardValue = 10;
                        break;
                    } else if (playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).title.equals("The Geophysicist") && playersArray.get(playerIndex).PlayerHand.toString().contains("Magnetite")) {
                        System.out.println("You have Magnetite in your hand! ");
                        while (playersArray.get(playerIndex).PlayerHand.size() != 0) {
                            playersArray.get(playerIndex).PlayerHand.remove(0);
                        }
                        trumpPlayerReset();
                        break;
                    }
                    else {
                        cardCompareType = playersArray.get(playerIndex).PlayerHand.get(cardHandIndex).getDescription().toLowerCase();
                        trumpPlayerReset();
                        handCardValue = 10;
                        break;
                    }
                }
                try {
                    CardPileValue = getEconomicValue(centerCards.get(0).getEconomicvalue());

                } catch (IndexOutOfBoundsException b) {
                    System.out.println("there was no card on the pile you. may place your card");
                    CardPileValue = -1;
                }

                if (handCardValue > CardPileValue) {
                    System.out.println("the card has a higher value");
                    centerCards.add(playerPlace.PlayerHand.get(cardHandIndex));
                    System.out.println(playerPlace.PlayerHand.remove(cardHandIndex) + " was removed from hand");
                } else System.out.println("the cards value was not higher! Try again");
                break;
        }
        return cardCompareType;
    }
*/
}
