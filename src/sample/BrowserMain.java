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
    Scene scene;
    webHistory hc;


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
        this.scene=new Scene(root);
        setPage(tc.url,scene);
    }

    void setPage(String url,Scene scene){
        stage.setTitle(url);
        stage.setScene(scene);
        stage.show();
    }

    void getHistory() throws IOException {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("History.fxml"));
            Parent root = loader.load();
            hc = loader.getController();
            hc.setTc(tc);
            setPage("History",new Scene(root));
        }catch (Exception e){
            System.out.println(e);
        }
    }
}