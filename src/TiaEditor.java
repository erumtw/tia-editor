
import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class TiaEditor extends Application {
    protected Editor editor = new Editor();
    protected static File textFile;
    protected static Alert userAlert = new Alert(AlertType.NONE);
    protected static TextArea textArea = new TextArea();
    protected static FileChooser fChooser = new FileChooser();
    protected static String filePathString;
    protected static Stage mainStage;
    private double initialHeight = 500;
    private double initialWidth = 700;
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) throws Exception {
        
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        
        fChooser.setInitialFileName(".txt");
        String[] fileOption = {
            "New",
            "Open",
            "Save",
            "Save As"
        };
        
        for (String string : fileOption) {
            MenuItem addMenuItem = new MenuItem(string);
            fileMenu.getItems().add(addMenuItem);
            addMenuItem.setOnAction(e-> {
                if ("New".equals(addMenuItem.getText())) { // set action for New Option
                    if ("".equals(textArea.getText())) {
                        editor.newOption();
                    }
                    else {
                        if (textFile.exists()) {
                            if (textArea.getText().equals(editor.getTextData())) {
                                editor.newOption();
                            }
                            else {
                                //ask for save
                                editor.alertToUser(AlertType.CONFIRMATION, "Do you want to save changes");
                            }
                        }
                        else {
                            //ask for save
                            editor.alertToUser(AlertType.CONFIRMATION, "Do you want to save changes");
                        }
                    }
                }
                else if ("Open".equals(addMenuItem.getText())) { // set action for Open option
                    if ("".equals(textArea.getText())){
                        editor.openOption();
                    }
                    else {
                        if (textFile.exists()) {
                            if (textArea.getText().equals(editor.getTextData())) {
                                editor.openOption();
                            }
                            else {
                                //ask for save
                                editor.alertToUser(AlertType.CONFIRMATION, "Do you want to save changes");
                            }
                        }
                        else {
                            //ask for save
                            editor.alertToUser(AlertType.CONFIRMATION, "Do you want to save changes");
                        }
                    }
                    
                }
                else if ("Save".equals(addMenuItem.getText())) { // set action for Save option
                    if (textFile.exists())
                        editor.saveOption();
                    else 
                        editor.saveAsOption();
                }
                else{ // set action for Save as option
                    editor.saveAsOption();
                }
            });
        }
        

        textArea.setMinHeight(initialHeight);
        textArea.setMinWidth(initialWidth);

        menuBar.getMenus().add(fileMenu);
        
        VBox vBox = new VBox();
        vBox.getChildren().addAll(menuBar, textArea);
        
        Scene scene = new Scene(vBox);
        mainStage.setTitle("TiaEditor");
        mainStage.setScene(scene);
        mainStage.show();

        vBox.widthProperty().addListener(ov -> {
            textArea.setMinWidth(vBox.getWidth());
        });
        
        vBox.heightProperty().addListener(ov -> {
            textArea.setMinHeight(vBox.getHeight() - menuBar.getHeight()); 
        });
    }

    
}
