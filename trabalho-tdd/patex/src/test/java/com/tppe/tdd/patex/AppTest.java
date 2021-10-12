package com.tppe.tdd.patex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test()
    void testFileNotChosen() throws FileNotFoundException {
        /* Since Patex uses a dialog in which the user needs to choose the file,
        for this test to pass the user is required to hit the cancel button */
        assertThrows(FileNotFoundException.class, () ->
            this.patexapp.chooseFile()
        );
    }

    @Test()
    void testFileAlreadyChosen(){
        this.patexapp = new Patex("analysisTime.out");
        assertEquals("analysisTime.out", this.patexapp.chosenFile.getPath());
    }

    @Test()
    void testIfFileIsReadable(){
        this.patexapp = new Patex("analysisTime.out");
        assertEquals(true, this.patexapp.isChosenFileReadable());
    }
}
