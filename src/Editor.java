
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.text.html.HTMLDocument.RunElement;

import javafx.application.Application;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Editor {
    private String textData;

    public Editor () {

    }

    public void newOption() {
        TiaEditor.textArea.clear();
        TiaEditor.textFile = null;
        TiaEditor.mainStage.setTitle("Untiltle*" + "- Tia Editor");

    }

    public void openOption() {
        TiaEditor.fChooser.setTitle("Open");
        TiaEditor.textFile = TiaEditor.fChooser.showOpenDialog(TiaEditor.mainStage); 
        TiaEditor.textArea.setText(readAfile(TiaEditor.textFile));
        TiaEditor.mainStage.setTitle(TiaEditor.textFile.getName() + "- Tia Editor");
    }

    public void saveOption() {
        writeAfile(TiaEditor.textFile);
    }

    public void saveAsOption() {
        TiaEditor.fChooser.setTitle("Save as");
        TiaEditor.textFile = TiaEditor.fChooser.showSaveDialog(TiaEditor.mainStage);

        writeAfile(TiaEditor.textFile); 
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

    public void alertToUser(AlertType alertType, String contentText) {
        TiaEditor.userAlert.setAlertType(alertType);
        TiaEditor.userAlert.setContentText(contentText);
        // TiaEditor.userAlert.setHeaderText();
        TiaEditor.userAlert.show();
    }

    public String getTextData() {
        return textData;
    }
}
