package View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class View extends Application {

    private GridPane gridPane;
    private TextField phone;
    private TextField url1;
    private TextField url2;
    private TextField url3;
    private TextField keyword1;
    private TextField keyword2;
    private TextField keyword3;
    private Button run;
    private Button stop;
    private String phoneNumber;

    public View() {
        this.gridPane = theLayout();
        this.phone = null;
        this.url1 = null;
        this.url2 = null;
        this.url3 = null;
        this.keyword1 = null;
        this.keyword2 = null;
        this.keyword3 = null;
        this.run = null;
        this.stop = null;
        this.phoneNumber = "";


    }

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(theLayout());
        tryButton();
        stage.setScene(scene);
        stage.show();
    }

    private GridPane getGridPane() {
        return gridPane;
    }

    private void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    private TextField getPhone() {
        return phone;
    }

    private void setPhone(TextField phone) {
        this.phone = phone;
    }

    private TextField getUrl1() {
        return url1;
    }

    private void setUrl1(TextField url1) {
        this.url1 = url1;
    }

    private TextField getUrl2() {
        return url2;
    }

    private void setUrl2(TextField url2) {
        this.url2 = url2;
    }

    private TextField getUrl3() {
        return url3;
    }

    private void setUrl3(TextField url3) {
        this.url3 = url3;
    }

    private TextField getKeyword1() {
        return keyword1;
    }

    private void setKeyword1(TextField keyword1) {
        this.keyword1 = keyword1;
    }

    private TextField getKeyword2() {
        return keyword2;
    }

    private void setKeyword2(TextField keyword2) {
        this.keyword2 = keyword2;
    }

    private TextField getKeyword3() {
        return keyword3;
    }

    private void setKeyword3(TextField keyword3) {
        this.keyword3 = keyword3;
    }

    private Button getRun() {
        return run;
    }

    private void setRun(Button run) {
        this.run = run;
    }

    private Button getStop() {
        return stop;
    }

    private void setStop(Button stop) {
        this.stop = stop;
    }

    //make methods to retrieve string for phone number, url address, keywords
    public void tryButton() {
        //add button listener
         //if pressed then all required data are saved

        this.run.setOnMouseClicked(button -> {
            this.run.setDisable(true);
            this.stop.setDisable(false);
        });


    }

    private GridPane theLayout() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        Label title = new Label("Wishlist Hunt");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        gridPane.add(title, 0, 0, 1, 1);
        gridPane.add(new Separator(), 0, 1, 4, 1);

        gridPane.add(new Label("Phone number:"), 0, 2, 1, 1);
        TextField phoneNumber = new TextField();
        setPhone(phoneNumber);
        gridPane.add(phoneNumber, 1, 2, 1, 1);

        Label webTitle = new Label("Website addresses:");
        webTitle.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        gridPane.add(webTitle, 0, 4, 1,1);
        gridPane.add(new Separator(), 0, 5, 4, 1);

        gridPane.add(new Label("Website 1:"), 0, 6, 1, 1);
        TextField website1 = new TextField();
        gridPane.add(website1, 1, 6, 1, 1);
        setUrl1(website1);
        gridPane.add(new Label("Keyword to search:"), 2, 6,1, 1);
        TextField string1 = new TextField();
        setKeyword1(string1);
        gridPane.add(string1, 3,6,1,1);
        gridPane.add(new Label("Website 2:"), 0, 7, 1, 1);
        TextField website2 = new TextField();
        setUrl2(website2);
        gridPane.add(website2, 1,7, 1, 1);
        gridPane.add(new Label("Keyword to search:"), 2, 7, 1, 1);
        TextField string2 = new TextField();
        setKeyword2(string2);
        gridPane.add(string2, 3, 7, 1, 1);

        gridPane.add(new Label("Website 3:"), 0, 8, 1, 1);
        TextField website3 = new TextField();
        setUrl3(website3);
        gridPane.add(website3, 1, 8, 1, 1);
        gridPane.add(new Label("Keyword to search:"), 2, 8, 1, 1);
        TextField string3 = new TextField();
        setKeyword3(string3);
        gridPane.add(string3, 3, 8, 1, 1);
        gridPane.add(new Separator(), 0, 9,4,1);

        FlowPane flowPane = new FlowPane(Orientation.HORIZONTAL, 10, 10);
        flowPane.setAlignment(Pos.CENTER_RIGHT);
        Button buttonRun = new Button("Run");
        Button buttonStop = new Button("Stop");
        buttonStop.setDisable(true);
        setRun(buttonRun);
        setStop(buttonStop);
        flowPane.getChildren().addAll(buttonRun, buttonStop);

        gridPane.add(flowPane, 0, 10, 4, 1);
        return gridPane;
    }
}
