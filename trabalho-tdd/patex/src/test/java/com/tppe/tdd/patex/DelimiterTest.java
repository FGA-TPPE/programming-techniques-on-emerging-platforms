package com.tppe.tdd.patex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.tppe.tdd.patex.Exceptions.DelimitadorInvalidoException;

public class DelimiterTest extends ChooseFileTest {

    public DelimiterTest() {
        super();
    }

    @Test()
    void testDelimiterChoosing(){
        try{
            this.patexapp.delimiter = ";";
            this.patexapp.chooseDelimiter();
            assertEquals(";",patexapp.delimiter);
        }catch(Exception e){}
    }

    @Test()
    void testDelimiterChoosing2(){
        try{
            this.patexapp.delimiter = ",";
            this.patexapp.chooseDelimiter();
            assertEquals(",",patexapp.delimiter);
        }catch(Exception e) {}
    }

    @Test()
    void testDelimiterString(){
        this.patexapp.delimiter = "nn";
        assertThrows(DelimitadorInvalidoException.class, () ->
            this.patexapp.chooseDelimiter()
        );
    }

    @Test()
    void testDelimiterEscape(){
        try{
            this.patexapp.delimiter = "\\n";
            this.patexapp.chooseDelimiter();
            assertEquals("\\n", this.patexapp.delimiter);
        }catch(Exception e) {}

    }

}
