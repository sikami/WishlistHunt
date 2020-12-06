package View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.awt.*;

public class View extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(theLayout());
        stage.setScene(scene);
        stage.show();
    }

    public GridPane theLayout() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        Label title = new Label("Wishlist Hunt");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        gridPane.add(title, 0, 0, 1, 1);
        gridPane.add(new Separator(), 0, 1, 3, 1);

        gridPane.add(new Label("Phone number:"), 0, 2, 1, 1);
        TextField phoneNumber = new TextField();
        gridPane.add(phoneNumber, 1, 2, 1, 1);

        Label webTitle = new Label("Website addresses:");
        webTitle.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        gridPane.add(webTitle, 0, 4, 1,1);
        gridPane.add(new Separator(), 0, 5, 3, 1);

        gridPane.add(new Label("Website 1:"), 0, 6, 1, 1);
        TextField website1 = new TextField();
        gridPane.add(website1, 1, 6, 1, 1);
        gridPane.add(new Label("Keyword to search:"), 2, 6,1, 1);
        TextField string1 = new TextField();
        gridPane.add(string1, 3,6,1,1);

        gridPane.add(new Label("Website 2:"), 0, 7, 1, 1);
        TextField website2 = new TextField();
        gridPane.add(website2, 1,7, 1, 1);
        gridPane.add(new Label("Keyword to search:"), 2, 7, 1, 1);
        TextField string2 = new TextField();
        gridPane.add(string2, 3, 7, 1, 1);



        return gridPane;
    }
}
