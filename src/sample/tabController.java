package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class tabController {
    @FXML
    private Button Go;
    @FXML
    private TextField omnibox;
    @FXML
    private Button newTab;
    public String url;

    @FXML
    void GoNow(ActionEvent event) throws Exception {
        url=omnibox.getText();
        if(!(url.isEmpty())){
            BrowserMain.setAddress(url);
            BrowserMain.showWeb();
        }
    }
}
