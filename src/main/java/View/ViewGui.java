package View;

import DataScraper.DataScraper;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ViewGui extends Application {
    Logger LOGGER = Logger.getLogger(ViewGui.class.getName());
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
    private String urlOneAddress;
    private String urlTwoAddress;
    private String urlThreeAddress;
    private String keywordOneName;
    private String keywordTwoName;
    private String keywordThreename;
    private boolean isExist;
    private List<ShopToSearch> shops;
    private ToggleGroup toogleGroup1;
    private ToggleGroup toogleGroup2;
    private ToggleGroup toogleGroup3;
    private boolean exist1, exist2, exist3;

    public ViewGui() {
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
        this.urlOneAddress = "";
        this.urlTwoAddress = "";
        this.urlThreeAddress = "";
        this.keywordOneName = "";
        this.keywordTwoName = "";
        this.keywordThreename = "";
        this.shops = new ArrayList<>();
        this.toogleGroup1 = new ToggleGroup();
        this.toogleGroup2 = new ToggleGroup();
        this.toogleGroup3 = new ToggleGroup();
        this.exist1 = false;
        this.exist2 = false;
        this.exist3 = false;
    }

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(theLayout());
        tryButton();
        stage.setScene(scene);
        stage.show();

    }

    public void printShops() {
        shops.stream().forEach(obj -> System.out.println(obj));
    }

    public List<ShopToSearch> getShops() {
        return shops;
    }

    private void setPhone(TextField phone) {
        this.phone = phone;
    }

    private void setUrl1(TextField url1) {
        this.url1 = url1;
    }

    private void setUrl2(TextField url2) {
        this.url2 = url2;
    }

    private void setUrl3(TextField url3) {
        this.url3 = url3;
    }

    private void setKeyword1(TextField keyword1) {
        this.keyword1 = keyword1;
    }

    private void setKeyword2(TextField keyword2) {
        this.keyword2 = keyword2;
    }

    private void setKeyword3(TextField keyword3) {
        this.keyword3 = keyword3;
    }

    private void setRun(Button run) {
        this.run = run;
    }

    private void setStop(Button stop) {
        this.stop = stop;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }


    private boolean getExistTrueFalse(ToggleGroup toggleGroup) {

        try {
            RadioButton selected = (RadioButton) toggleGroup.getSelectedToggle();
            if(selected.isSelected()) {
                String value = selected.getText();
                if (value.equals("exist")) {
                    return true;
                }
                return false;
            }
        } catch (NullPointerException e) {
            LOGGER.info("Radio Button is not selected");
        }

        return false;
    }

    private void getData() {
        shops.clear();

        this.phoneNumber = this.phone.getText();
        this.urlOneAddress = this.url1.getText();
        this.urlTwoAddress = this.url2.getText();
        this.urlThreeAddress = this.url3.getText();
        this.keywordOneName = this.keyword1.getText();
        this.keywordTwoName = this.keyword2.getText();
        this.keywordThreename = this.keyword3.getText();
        this.exist1 = getExistTrueFalse(toogleGroup1);
        this.exist2 = getExistTrueFalse(toogleGroup2);
        this.exist3 = getExistTrueFalse(toogleGroup3);

        if (!this.urlOneAddress.isEmpty() && !this.keywordOneName.isEmpty()) {
            shops.add(new ShopToSearch(this.phoneNumber, this.urlOneAddress, this.keywordOneName, this.exist1));
        }

        if (!this.urlTwoAddress.isEmpty() && !this.keywordTwoName.isEmpty()) {
            shops.add(new ShopToSearch(this.phoneNumber, this.urlTwoAddress, this.keywordTwoName, this.exist2));
        }

        if (!this.urlThreeAddress.isEmpty() && !this.keywordThreename.isEmpty()) {
            shops.add(new ShopToSearch(this.phoneNumber, this.urlThreeAddress, this.keywordThreename, this.exist3));
        }

    }

    private void fieldsStatOnRun() {
        this.run.setDisable(true);
        this.stop.setDisable(false);
        this.url1.setDisable(true);
        this.url2.setDisable(true);
        this.url3.setDisable(true);
        this.keyword1.setDisable(true);
        this.keyword2.setDisable(true);
        this.keyword3.setDisable(true);
        this.phone.setDisable(true);
    }

    private void fieldsStatOnStop() {
        this.run.setDisable(false);
        this.stop.setDisable(true);
        this.url1.clear();
        this.url1.setDisable(false);
        this.url2.setDisable(false);
        this.url2.clear();
        this.url3.setDisable(false);
        this.url3.clear();
        this.keyword1.setDisable(false);
        this.keyword1.clear();
        this.keyword2.setDisable(false);
        this.keyword2.clear();
        this.keyword3.setDisable(false);
        this.keyword3.clear();
        this.phone.clear();
        this.phone.setDisable(false);
        try {
            this.toogleGroup1.getSelectedToggle().setSelected(false);
            this.toogleGroup2.getSelectedToggle().setSelected(false);
            this.toogleGroup3.getSelectedToggle().setSelected(false);
            this.exist1 = false;
            this.exist2 = false;
            this.exist3 = false;
        } catch (NullPointerException e) {
            LOGGER.info("One or more toggle groups are not selected.");
        }

    }

    //make methods to retrieve string for phone number, url address, keywords
    public void tryButton() {
        //add button listener
         //if pressed then all required data are saved

        this.run.setOnMouseClicked(button -> {
            try {
                getData();
                fieldsStatOnRun();
                DataScraper dataScraper = new DataScraper(shops);
                // on DataScraper class, fixing DataScraper class so it can scrape only 1 shoptosearch instead of of list
//                if (shops.size() == 1) {
//                    if (dataScraper.scrapeKeyword())
//                }
                System.out.println(shops);
                //To be continue
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        this.stop.setOnMouseClicked(button -> {
            fieldsStatOnStop();
        });
    }

//    public boolean buttonSelected(ToggleGroup toggleGroup) {
//       RadioButton radioButton1 = (RadioButton) toggleGroup.getSelectedToggle();
//       if (radioButton1.getText().equals("exist")) {
//           setExist(true);
//       } else {
//           setExist(false);
//       }
//       return this.isExist;
//    }


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
        RadioButton exist1 = new RadioButton("exist");
        RadioButton noExist1 = new RadioButton("not exist");
        exist1.setToggleGroup(toogleGroup1);
        noExist1.setToggleGroup(toogleGroup1);
        gridPane.add(website1, 1, 6, 1, 1);
        gridPane.add(exist1, 4,6,1,1);
        gridPane.add(noExist1,5,6,1,1);
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
        RadioButton exist2 = new RadioButton("exist");
        RadioButton noExist2 = new RadioButton("not exist");
        exist2.setToggleGroup(toogleGroup2);
        noExist2.setToggleGroup(toogleGroup2);
        gridPane.add(exist2, 4, 7, 1, 1);
        gridPane.add(noExist2, 5, 7, 1, 1);

        gridPane.add(new Label("Website 3:"), 0, 8, 1, 1);
        TextField website3 = new TextField();
        setUrl3(website3);
        gridPane.add(website3, 1, 8, 1, 1);
        gridPane.add(new Label("Keyword to search:"), 2, 8, 1, 1);
        TextField string3 = new TextField();
        setKeyword3(string3);
        gridPane.add(string3, 3, 8, 1, 1);
        RadioButton exist3 = new RadioButton("exist");
        RadioButton noExist3 = new RadioButton("not exist");
        exist3.setToggleGroup(toogleGroup3);
        noExist3.setToggleGroup(toogleGroup3);
        gridPane.add(exist3, 4, 8, 1, 1);
        gridPane.add(noExist3, 5, 8, 1, 1);
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
