package project.inf.pkg151;

import static java.lang.Thread.sleep;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import project.inf.pkg151.Fork;

class Philosopher extends Thread {

    private String firstForkText;
    private String secondForkText;

    private Fork firstFork;
    private Fork secondFork;

    private JLabel E1, E2, E3, I, S;

    public Philosopher(Fork izq, Fork der, String init, JLabel E1, JLabel E2, JLabel E3, JLabel I, JLabel S) {

        if (init.equals("left")) {
            firstFork = izq;
            secondFork = der;
            firstForkText = "left";
            secondForkText = "right";
        }

        if (init.equals("right")) {
            firstFork = der;
            secondFork = izq;
            firstForkText = "right";
            secondForkText = "left";
        }


        this.E1 = E1;
        this.E2 = E2;
        this.E3 = E3;
        this.I = I;
        this.S = S;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {

            this.showMessage("sleeping");
            S.setIcon(new ImageIcon(getClass().getResource("/Images/red.JPG")));
            I.setIcon(new ImageIcon(getClass().getResource("/Images/sleep.gif")));
            this.getSleep(3000);

            this.showMessage("thinking");
            S.setIcon(new ImageIcon(getClass().getResource("/Images/red.JPG")));
            I.setIcon(new ImageIcon(getClass().getResource("/Images/think.gif")));
            this.getSleep(3000);

            E3.setText("waiting");
            S.setIcon(new ImageIcon(getClass().getResource("/Images/yellow.JPG")));
            I.setIcon(new ImageIcon(getClass().getResource("/Images/wait.gif")));
            this.getSleep(3000);

            this.showMessage(this.firstForkText + " fork OK");
            firstFork.decrease();
            this.getSleep(2000);

            this.showMessage(this.secondForkText + " fork OK");
            secondFork.decrease();
            this.getSleep(2000);

            this.showMessage("eating");
            S.setIcon(new ImageIcon(getClass().getResource("/Images/green.JPG")));
            I.setIcon(new ImageIcon(getClass().getResource("/Images/eat.gif")));
            this.getSleep(4000);

            this.showMessage(this.firstForkText + " fork LEFT");
            firstFork.increase();
            this.getSleep(1000);

            this.showMessage(this.secondForkText + " fork LEFT");
            secondFork.increase();
            this.getSleep(1000);

        }
        
        this.showMessage("sleeping");
        S.setIcon(new ImageIcon(getClass().getResource("/Images/red.JPG")));
        I.setIcon(new ImageIcon(getClass().getResource("/Images/sleep.gif")));
        
    }

    public void showMessage(String x) {
        String aux1 = E3.getText();
        String aux2 = E2.getText();

        E3.setText(x);
        E2.setText(aux1);
        E1.setText(aux2);

    }

    public void getSleep(Integer time) {
        try {
            sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}