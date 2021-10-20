package com.tppe.tdd.patex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileNotFoundException;


class ChooseFileTest {

    protected Patex patexapp;

    ChooseFileTest(){
        this.patexapp = new Patex();
    }

    @Test()
    void testFileChoosing() throws FileNotFoundException {
        this.patexapp.chosenFile = new File("../analysisMemory.out");
        this.patexapp.chooseFile();
        assertNotNull(this.patexapp.chosenFile);
    }

    @Test()
    void testFileNotChosen() throws FileNotFoundException {
        this.patexapp.chosenFile = new File("../dontExist.txt");
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
        this.patexapp = new Patex("../analysisTime.out");
        assertEquals(true, this.patexapp.isChosenFileReadable());
    }
}
