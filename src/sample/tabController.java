package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.util.StringTokenizer;

public class tabController{
    @FXML
    private Button Go,Search,newTab;
    @FXML
    private MenuButton Menu;
    @FXML
    private TextField omniBox,Google;
    @FXML
    private MenuItem History,Bookmarks,Settings;
    BrowserMain currentPage;


    private Browser browser;

     /*public Controller(){
         browser =new Browser(currentPage);
         browser.webEngine.load("www.google.com");
         //browser.getChildren().addAll(omniBox,Google,Go,Search,newTab,Menu);
     }
     */

    public String url="www.google.com";
    public StringTokenizer surl;


    public void setMain(BrowserMain main){ currentPage=main;}
    @FXML
    void GoNow(ActionEvent event) throws Exception {
        url = omniBox.getText();
        if (!(url.isEmpty())) {
            currentPage.setAddress(url);
        }
    }
    @FXML
    void GoHistory(ActionEvent event) throws Exception {
        System.out.println("History!!");
    }
    @FXML
    void GoBookmarks(ActionEvent event) throws Exception {
        System.out.println("Bookmarks!!");
    }
    @FXML
    void GoGoogle(ActionEvent event) throws Exception {
        surl = new StringTokenizer(Google.getText());
        StringBuffer surl1=new StringBuffer("www.google.com/search?q=");
        int f=0;
        while(surl.hasMoreTokens()){
            if(f!=0){
                surl1.append('+');
            }
            surl1.append(surl.nextToken());
            f++;
        }
        surl1.append("&ie=utf-8&oe=utf-8");
        url= String.valueOf(surl1);
        if (!(url.isEmpty())) {
            currentPage.setAddress(url);
        }
    }
    @FXML
    void GoSettings(ActionEvent event) throws Exception {
        System.out.println("Settings!!");
    }
    @FXML
    void GoTab(ActionEvent event) throws Exception {
        System.out.println("Tab!!");
    }
}
