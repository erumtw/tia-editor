import java.io.File;

import javax.lang.model.util.ElementScanner14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TiaEditor extends Application {
    protected static File textFile;
    protected static Alert userAlert;
    Editor editor = new Editor();
    protected static TextArea textArea = new TextArea();

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");

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
                    editor.openOption();
                }
                else if ("Save".equals(addMenuItem.getText())) {
                    editor.saveOption();
                }
                else{
                    editor.saveAsOption();
                }
            });
        }

        menuBar.getMenus().add(fileMenu);
        VBox vBox = new VBox();

        vBox.getChildren().addAll(menuBar, textArea);
        
        Scene scene = new Scene(vBox);
        stage.setTitle("TiaEditor");
        stage.setScene(scene);
        stage.show();

    }
}
