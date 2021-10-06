package com.tppe.tdd.patex;
/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        Patex patex = new Patex();

        patex.start();
        patex.stop();
    }
}
