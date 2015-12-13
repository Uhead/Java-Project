package sample;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

class Browser extends Region {

    WebView browser = new WebView();
    WebEngine webEngine = browser.getEngine();



    public Browser(BrowserMain currentPage) {
        //System.out.println(currentPage.goHere());
        webEngine.load("http://" + currentPage.goHere());
        getChildren().add(browser);
        System.out.println(webEngine.getLocation());
    }

    @Override
    protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(browser,0,0,w,h,0, HPos.CENTER, VPos.CENTER);
    }

    @Override
    protected double computePrefWidth(double height) {
        return 750;
    }

    @Override
    protected double computePrefHeight(double width) {
        return 500;
    }

}