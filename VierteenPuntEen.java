package Hoofstuk14;

import java.applet.Applet;
import java.awt.*;
import java.util.Random;

/**
 * Created by Romy Mae on 22-11-2016.
 */
public class VierteenPuntEen extends Applet{
    private String[] kleuren = {"Ruiten ", "Harten ", "Schoppen ", "Klaveren "};
    private String[] kaarten = {"tien", "twee", "drie", "vier", "vijf", "zes", "zeven", "acht", "negen", "boer", "vrouw", "heer", "aas"};
    private String[] deck = new String[52];
    private String[] speler = new String[13];
    private double r;
    private int worp;

    public void init() {
        randomniser();
    }

    public void randomniser() {
        r = Math.random();
        worp = (int) (r * 6 + 1);
    }

    public void paint(Graphics g) {
        deckMaken();
        deelKaart();
        g.drawString("" + deelEnkeleKaart(), 100, 100);
    }

    public void deckMaken() {
        int index = 0;
        for (int i = 0; i < kleuren.length; i++) {
            String kleur = kleuren[i];
            for (int j = 0; j < kaarten.length; j++) {
                String kaart = kaarten[j];
                deck[index] = kleur + kaart;
                index++;
            }
        }
        for (int k = 0; k < 13; k++) {
            speler[k] = deelKaart();
        }
    }

    private String deelKaart() {
        int random = new Random().nextInt(deck.length);
        String kaart = deck[random];
        String[] hulpLijst = new String[deck.length - 1];
        int hulpindex = 0;
        for (int i = 0; i < deck.length; i++) {
            if (i != random) {
                hulpLijst[hulpindex] = deck[i];
                hulpindex++;
            }
        }
        deck = hulpLijst;
        return kaart;
    }

    public String deelEnkeleKaart() {
        return speler[new Random().nextInt(worp)];
    }
}
