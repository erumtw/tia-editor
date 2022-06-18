
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Editor {
    String textData;

    public Editor () {

    }

    public void newOption() {
        if ("".equals(TiaEditor.textArea.getText())) // if text area's empty then clear 
            TiaEditor.textArea.clear();
        // else // in case text area's not empty then
             //check if saved or nah? by text file == text area ? 
             //case true: clear the text area
             //case false: warning to save first 
    }

    public void openOption() {
        // if ("".equals(TiaEditor.textArea.getText()))
            //open it 
    //    else // in case text area's not empty then
               // check if saved or nah? by text file == text area ? 
               // case true: Open the text file  
               // case false: warning to save first
        TiaEditor.fChooser.setTitle("Open");
        TiaEditor.textFile = TiaEditor.fChooser.showOpenDialog(TiaEditor.mainStage); 
        
        if (TiaEditor.textFile != null) {

            try {
                byte[] readText = Files.readAllBytes(Paths.get(TiaEditor.textFile.getAbsolutePath())); 
                textData = new String(readText);
                TiaEditor.textArea.setText(textData);

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } 
            
        else    
            TiaEditor.textArea.setText("unselected");
    }

    public void saveOption() {
        // check if the file's from open option or already have a file as a same path
        // case true: then save the file
        // case false: involve saveAsOption
            try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(TiaEditor.textFile))) {
                bWriter.write(TiaEditor.textArea.getText());
    
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        
        
    }

    public void saveAsOption() {
        // save the file that can select the path by fileChooser
        TiaEditor.fChooser.setTitle("Save as");
        TiaEditor.textFile = TiaEditor.fChooser.showSaveDialog(TiaEditor.mainStage);

        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(TiaEditor.textFile))) {
            bWriter.write(TiaEditor.textArea.getText());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


}
