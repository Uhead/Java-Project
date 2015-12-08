package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class tabController {
    @FXML
    private Button Go;
    @FXML
    private TextField omniBox;
    @FXML
    private Button newTab;

    BrowserMain currentPage;
    public String url;

    public void setMain(BrowserMain currentPage){
        this.currentPage=currentPage;
    }

    @FXML
    void GoNow(ActionEvent event) throws Exception {
        url=omniBox.getText();
        if(!(url.isEmpty())){
            currentPage.setAddress(url);
        }
    }
}
