package project.inf.pkg151;

import static java.lang.Thread.sleep;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Fork {
    private int valor = 1;

    public Fork() {
        valor = 1;
    }

    synchronized void decrease() {
        while (valor <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        valor--;
    }

    synchronized void increase() {
        valor++;
        notify();
    }

    public int Valor() {
        return valor;
    }
}