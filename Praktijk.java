package Hoofstuk14;

import java.awt.*;
import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * Created by Romy Mae on 30-11-2016.
 */
public class Praktijk extends Applet {

    public String gameOver;
    public int numE = 23;
    public boolean turn = true;
    public int turnPlayer, turnComp;
    public Image image;
    public TextField inputHere;
    public Button input;
    public int inputNumber;

    public void init() {
        inputHere = new TextField("", 5);
        inputHere.addActionListener(new TurnListener());
        add(inputHere);
        input = new Button("End turn");
        input.addActionListener(new TurnListener());
        add(input);
        URL pad = Praktijk.class.getResource("Img/");
        image = getImage(pad, "spooky.jpg");
        setSize(800,800);
    }

    public void paint(Graphics g) {
        if (!turn) {
            turn = true;
            g.setColor(Color.BLACK);
            g.drawString("Choose an number between 1 and 3", 40, 80);
            if (inputNumber > 3) {
                g.setColor(Color.RED);
                g.drawString("ERROR Choose an number between 1 and 3", 45, 80);
                g.setColor(Color.BLACK);
            }
            if (inputNumber < 1) {
                g.setColor(Color.RED);
                g.drawString("Choose an number between 1 and 3", 40, 80);
                g.setColor(Color.BLACK);
            }
        }
        if (numE > 0) {
            int x = 50;
            int y = 100;

            for (int i = 0; i < numE; i++) {
                g.drawImage(image, x, y, 20, 20, this);
                x += 50;
                if (i % 4 == 3) {
                    x = 50;
                    y += 50;
                }
            }
            g.drawString("computer's last turn:  " + turnComp, 200, 70);
        } else {
            g.drawString(gameOver, 100, 100);
        }
    }


    private int compOptions() {
        int END = 0;

        double r;
        int r2;

        r = Math.random();
        r2 = (int) (r * 3 + 1);
        int c;

        c = numE % 4;

        if (c == 0) {
            END = 3;
        }

        if (c == 1) {
            END = r2;
        }

        if (c == 2) {
            END = 1;
        }

        if (c == 3) {
            END = 2;
        }
        return END;
    }

    public class TurnListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String inputGiven = inputHere.getText();
            inputNumber = Integer.parseInt(inputGiven);
            if (inputNumber < 4 && inputNumber > 0) {

                turnPlayer = inputNumber;
                numE -= turnPlayer;
                if (numE < 1) {
                    gameOver = "GAME OVER!";
                } else {

                    turnComp = compOptions();
                    numE -= turnComp;
                    if (numE < 0) {
                        gameOver = "YOU'VE WON!!";
                    }

                }
            } else {
                turn = false;
            }
            repaint();
        }
    }









}
