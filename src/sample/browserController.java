package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

/**
 * Created by Nasif Zaman on 09-Dec-15.
 */
public class browserController {
    @FXML
    private TextArea box;

    BrowserMain currentPage;

    public void setMain(BrowserMain currentPage){
        this.currentPage=currentPage;
    }

    private String url;
    @FXML
    public void GoNow() throws Exception {
        url=currentPage.goHere();
        if(!(url.isEmpty())){
            box.setText(url);
        }
    }

}
