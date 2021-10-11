package com.tppe.tdd.patex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileNotFoundException;

/**
 * Unit test for simple App.
 */
class AppTest {

    private Patex patexapp;

    AppTest(){
        this.patexapp = new Patex();
    }

    @Test()
    void testFileChoosing() throws FileNotFoundException {
        this.patexapp.chooseFile();
        assertNotNull(this.patexapp.chosenFile);
    }
}
