import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ElectronicStoreView extends Pane{
    private ListView<String> popularitems, storestock, currentcart;
    private TextField nosales, revenue, valuesales;
    private ElectronicStoreButtonPane buttonpane;

    public ElectronicStoreButtonPane getButtonPane() { return buttonpane; }

    public ElectronicStoreView() {

        Label summary = new Label("Store Summary:");
        summary.relocate(50,20);

        Label stock = new Label("Store Stock:");
        stock.relocate(285,20);

        Label current = new Label("Current Cart:");
        current.relocate(600,20);

        Label pop = new Label("Most Popular Items:");
        pop.relocate(35,160);

        Label lnosales = new Label("# Sales:");
        lnosales.relocate(27,45);

        Label lrevenue = new Label("Revenue:");
        lrevenue.relocate(20,85);

        Label lvaluesales = new Label("$ / Sale:");
        lvaluesales.relocate(27,125);

        nosales = new TextField("0");
        nosales.relocate(75,40);
        nosales.setPrefSize(90,30);
        nosales.setEditable(false);

        revenue = new TextField("0.00");
        revenue.relocate(75,80);
        revenue.setPrefSize(90,30);
        revenue.setEditable(false);

        valuesales = new TextField("N/A");
        valuesales.relocate(75,120);
        valuesales.setPrefSize(90,30);
        valuesales.setEditable(false);

        popularitems = new ListView<String>();
        popularitems.relocate(20,180);
        popularitems.setPrefSize(140,140);

        storestock = new ListView<String>();
        storestock.relocate(180,40);
        storestock.setPrefSize(290,280);

        currentcart = new ListView<String>();
        currentcart.relocate(490,40);
        currentcart.setPrefSize(290,280);

        buttonpane = new ElectronicStoreButtonPane();
        buttonpane.relocate(40,340);
        buttonpane.setPrefSize(720,40);

        getChildren().addAll(summary, stock, current, pop, lnosales, lrevenue, lvaluesales, nosales, revenue, valuesales, popularitems, storestock, currentcart, buttonpane);

        setPrefSize(800,400);
    }

    public void update(ElectronicStore model) {

        int selection1 = storestock.getSelectionModel().getSelectedIndex();
        if (selection1 == -1) {
            buttonpane.getAddbutton().setDisable(true);
        } else {
            buttonpane.getAddbutton().setDisable(false);
        }

        int selection2 = currentcart.getSelectionModel().getSelectedIndex();
        if (selection2 == -1) {
            buttonpane.getRemovebutton().setDisable(true);
        } else {
            buttonpane.getRemovebutton().setDisable(false);
        }

        if (currentcart.getItems().isEmpty()) {
            buttonpane.getCompletebutton().setDisable(true);
        } else {
            buttonpane.getCompletebutton().setDisable(false);
        }

        Product[] stocklist = model.getProducts();
        ArrayList<String> cstocklist = new ArrayList<>();

        for (int i=0; i<stocklist.length; i++) {
            if (stocklist[i] != null) {
                cstocklist.add(stocklist[i].toString());
            }
        }

        storestock.setItems(FXCollections.observableArrayList(cstocklist));

    }

    public ListView<String> getStorestock() { return storestock; }

}
