package com.tppe.tdd.patex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class OutputFormatTest extends AppTest {
    OutputFormatTest(){
        super();
    }

    @Test()
    void testOutputFormatChoosing() throws Exception{
        assertEquals(true, this.patexapp.choseOutputFormat());
    }

    @Test()
    void testWrongOutputFormatChoosing() throws Exception {
        /* Since the method being tested needs user interaction, for this test
        to pass you need to hit the cancel or the 'x' button */
        assertThrows(Exception.class, () -> this.patexapp.choseOutputFormat());
    }
}
