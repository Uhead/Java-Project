package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.*;

/**
 * Created by Nasif Zaman on 22-Dec-15.
 */

class visitedPages implements Serializable{
    ListView<String> Pages;
}

public class webHistory {
    @FXML
    private Button back,go;
    private visitedPages pages = new visitedPages();
    @FXML
    ListView<String> logs;
    tabController tc;

    void setTc(tabController tc){
        this.tc=tc;
    }

    void newHistory(){
        pages.Pages=logs;
        try {
            FileOutputStream fos = new FileOutputStream("src/sample/History.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.reset();
            oos.writeObject(pages);
            oos.flush();
            oos.close();
        }
        catch(Exception e) {
            System.out.println("Exception during serialization: " + e);
            System.exit(0);
        }

    }

    void getHistory(){
        try {
            FileInputStream fis = new FileInputStream("src/sample/History.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            pages = (visitedPages)ois.readObject();
            logs=pages.Pages;
            ois.close();

        }
        catch(Exception e) {
            System.out.println("Exception during deserialization: " + e);
            System.exit(0);
        }
    }

    void goBack(){
        tc.currentPage.setPage(tc.url,tc.currentPage.scene);
    }

    void goHistory(){
        String url = logs.getSelectionModel().getSelectedItem();
        tc.currentPage.setPage(url,tc.currentPage.scene);
        tc.gohere(url);
    }

}
