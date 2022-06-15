import java.io.File;

import javafx.application.Application;
import javafx.scene.control.Alert.AlertType;

public class Editor {

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
    }

    public void saveOption() {
        // check if the file's from open option or already have a file as a same path
        // case true: then save the file
        // case false: involve saveAsOption
    }

    public void saveAsOption() {
        // save the file that can select the path by fileChooser
    }


}
