package com.tppe.tdd.patex;

import org.junit.jupiter.api.Test;
import java.io.File;
import com.tppe.tdd.patex.Exceptions.EscritaNãoPermitidaException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OutputPathTest {
    
    private Patex patexapp;

    public OutputPathTest() {
        this.patexapp = new Patex();
        this.patexapp.delimiter = ";";
    }
        

    @Test()
    void testDirectoryWritePermission(){
        //Escolhendo um diretorio teste com a permissao de escrita negada 
        assertThrows(EscritaNãoPermitidaException.class,() -> patexapp.OutputPathChoose());    
    }

    @Test()
    void testFileExtension(){
        try{    
            patexapp.chosenFile =new File("../../../analysisMemory.out");
            patexapp.OutputPathChoose();
            File file =new File(patexapp.outputPath);
            assertTrue(file.getName().endsWith(".out"));
        }catch(Exception ex){ }

    }
    
    @Test()
    void testFileNameAnalysisMemoryTab(){
            try{
                patexapp.chosenFile =new File("../../../analysisMemory.out");
                patexapp.OutputPathChoose();
                assertEquals("analysisMemoryTab.out", patexapp.returnSelectedFileName() );
            }catch(Exception ex){}
    }
    @Test()
    void testFileNameAnalysisTimeTab(){
        try{    
            patexapp.chosenFile =new File("../../../analysisTime.out");
            patexapp.OutputPathChoose();
            assertEquals("analysisTimeTab.out", patexapp.returnSelectedFileName() );       
        }catch(Exception ex){}    
    }
}
