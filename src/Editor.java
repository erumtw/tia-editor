import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;


public class Editor {
    private String textData;
    
    protected final String NEW = "NEW";
    protected final String OPEN = "OPEN";
    protected final String SAVE = "SAVE";
    protected final String SAVE_AS = "SAVE AS"; 

    public Editor () {

    }

    public void newOption() {
        TiaEditor.textArea.clear();
        TiaEditor.textFile = null;
        // TiaEditor.mainStage.setTitle("Untiltle*" + "- Tia Editor");

    }

    public void openOption() {
        TiaEditor.fChooser.setTitle("Open");
        File fileChoosed = TiaEditor.fChooser.showOpenDialog(TiaEditor.mainStage); 

        if (fileChoosed != null && fileChoosed.getName().contains(".txt")) {
            TiaEditor.textFile = fileChoosed;
            // TiaEditor.mainStage.setTitle(TiaEditor.textFile.getName() + "- Tia Editor");
        }
        else if (fileChoosed.getName().contains(".txt") == false){
            warnUser("Invalid File, Must be only txt files");
        }
        TiaEditor.textArea.setText(readAfile(TiaEditor.textFile));
        TiaEditor.mainStage.setTitle(TiaEditor.textFile.getName() + "- Tia Editor");
    }

    public void saveOption() {
        
        writeAfile(TiaEditor.textFile);
        readAfile(TiaEditor.textFile);
    }

    public void saveAsOption() {
        TiaEditor.fChooser.setTitle("Save as");
        TiaEditor.textFile = TiaEditor.fChooser.showSaveDialog(TiaEditor.mainStage);

        writeAfile(TiaEditor.textFile); 
        readAfile(TiaEditor.textFile);
    }

    public String readAfile(File file) {
        
        try {
            byte[] readText = Files.readAllBytes(Paths.get(file.getAbsolutePath())); 
            textData = new String(readText);
            return textData;

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return textData;
    }

    public void writeAfile(File file) {
        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(file))) {
            bWriter.write(TiaEditor.textArea.getText());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void alertForChanges(String anOption) {
        TiaEditor.userAlert.setAlertType(AlertType.CONFIRMATION);
        TiaEditor.userAlert.setContentText("Do you want to save for changes");
        Optional<ButtonType> result = TiaEditor.userAlert.showAndWait();

        if (result.get() == ButtonType.OK) {
            //save or save as
            if (TiaEditor.textFile != null)
                saveOption();
            else 
                saveAsOption();
        }
        else {
            switch (anOption) {
                case NEW:
                    newOption();
                    break;
                case OPEN:
                    openOption();
                    break;
                default:
                    break;
            }
        }
    }

    public void warnUser(String warnContent) {
        TiaEditor.userAlert.setAlertType(AlertType.WARNING);
        TiaEditor.userAlert.setContentText(warnContent);
        TiaEditor.userAlert.showAndWait();
    }

    public String getTextData() {
        return textData;
    }
}
