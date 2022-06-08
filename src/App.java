import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // TODO Auto-generated method stub
        MenuBar menuBar = new MenuBar();
        Menu file = new Menu("File");
        String[] fileOption = {
            "New",
            "Open",
            "Save",
            "Exit"
        };

        for (String string : fileOption) {
            MenuItem addMenuItem = new MenuItem(string);
            file.getItems().add(addMenuItem);
        }

        menuBar.getMenus().add(file);
        TextArea textArea = new TextArea();
        VBox vBox = new VBox();

        vBox.getChildren().addAll(menuBar, textArea);

        Scene scene = new Scene(vBox);
        stage.setTitle("TiaEditor");
        stage.setScene(scene);
        stage.show();

    }
}
