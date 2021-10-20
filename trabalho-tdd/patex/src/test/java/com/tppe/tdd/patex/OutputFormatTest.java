package com.tppe.tdd.patex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class OutputFormatTest extends ChooseFileTest {
    OutputFormatTest(){
        super();
    }

    @Test()
    void testOutputFormatChoosing() throws Exception{
        this.patexapp.userOutputFormatChoice = "Lines";
        assertEquals(true, this.patexapp.choseOutputFormat());
    }

    @Test()
    void testOutputFormatChoosing_2() throws Exception {
        this.patexapp.userOutputFormatChoice = "Columns";
        assertEquals(true, this.patexapp.choseOutputFormat());
    }

    @Test()
    void testWrongOutputFormatChoosing() throws Exception {
        assertThrows(Exception.class, () -> {
            this.patexapp.userOutputFormatChoice = "invalid output choice";
            this.patexapp.choseOutputFormat();
        });
    }
}
