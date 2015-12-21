package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    public static void main(String[] args){
        launch(args);
    }

    void showTab() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TabView.fxml"));
        Parent root = loader.load();
        tc = loader.getController();
        tc.setMain(this);
        tc.gohere("www.google.com");
        stage.setTitle("WebSite");
        stage.setScene(new Scene(root));
        stage.show();
    }
}