package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;


public class BrowserMain extends Application {
    tabController tc;
    Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage=stage;
        showTab();

    }

    private String webAddress;

    public static void main(String[] args){
        //Scanner scn = new Scanner(System.in);
        //webAddress=scn.nextLine();
        launch(args);
    }
    public String goHere(){
        return webAddress;
    }
    public void setAddress(String url) throws Exception {
        webAddress =url;
        showWeb();
    }

    void showTab() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TabView.fxml"));
        Parent root = loader.load();
        tc = loader.getController();
        tc.setMain(this);

        stage.setTitle("WebSite");
        stage.setScene(new Scene(root,750,500));
        stage.show();
    }

    void showWeb() throws Exception{
        stage.setTitle(goHere());
        stage.setScene(new Scene(new Browser(this),750,500, Color.web("#666970")));
        stage.show();
    }
}