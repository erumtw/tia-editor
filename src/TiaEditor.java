
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
    protected static Alert userAlert;
    protected static TextArea textArea = new TextArea();
    protected static FileChooser fChooser = new FileChooser();
    protected static String filePathString;
    protected static Stage mainStage;
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
                if ("New".equals(addMenuItem.getText())) {
                    editor.newOption();
                }
                else if ("Open".equals(addMenuItem.getText())) {
                    if (textFile == null) 
                        editor.openOption();
                    else 
                        editor.saveAsOption();
                }
                else if ("Save".equals(addMenuItem.getText())) {
                    if (textFile != null && textFile.exists())
                        editor.saveOption();
                    else 
                        editor.saveAsOption();
                }
                else{
                    editor.saveAsOption();
                }
            });
        }

        menuBar.getMenus().add(fileMenu);
        VBox vBox = new VBox();

        vBox.getChildren().addAll(menuBar, textArea);
        
        Scene scene = new Scene(vBox, 500, 500);
        mainStage.setTitle("TiaEditor");
        mainStage.setScene(scene);
        mainStage.show();

    }

    
}
