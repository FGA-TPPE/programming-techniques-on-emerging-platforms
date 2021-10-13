package com.tppe.tdd.patex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.tppe.tdd.patex.Exceptions.DelimitadorInvalidoException;

public class DelimiterTest {
    
    private Patex patexapp;

    public DelimiterTest() {
        this.patexapp = new Patex();
    }
    
    @Test()
    void testDelimiterChoosing(){
        try{    
            this.patexapp.chooseDelimiter();
            assertEquals(";",patexapp.delimiter);
        }catch(Exception e){}    
    }

    @Test()
    void testDelimiterChoosing2(){
        try{this.patexapp.chooseDelimiter();
            assertEquals(",",patexapp.delimiter);
        }catch(Exception e) {}   
    }
    
    @Test()
    void testDelimiterString(){    
        assertThrows(DelimitadorInvalidoException.class, () ->
            this.patexapp.chooseDelimiter()
        );
    }

    @Test()
    void testDelimiterEscape(){    
        try{this.patexapp.chooseDelimiter();
            assertEquals("/n",patexapp.delimiter);
        }catch(Exception e) {}  
    
    }

}
