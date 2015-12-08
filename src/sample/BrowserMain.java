package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;


public class BrowserMain extends Application {
    tabController tc;
    static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage=stage;
        showTab();

    }

    private static String webAddress;

    public static void main(String[] args){
        //Scanner scn = new Scanner(System.in);
        //webAddress=scn.nextLine();
        launch(args);
    }
    public static String goHere(){
        return webAddress;
    }
    public static void setAddress(String url) { webAddress =url; }

    void showTab() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TabView.fxml"));
        Parent root = loader.load();

        stage.setTitle("WebSite");
        stage.setScene(new Scene(root,750,500));
        stage.show();
    }

    static void showWeb() throws Exception{
        stage.setTitle(goHere());
        stage.setScene(new Scene(new Browser(),750,500, Color.web("#666970")));
        stage.show();
    }
}

