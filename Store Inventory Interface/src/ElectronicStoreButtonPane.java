import javafx.scene.layout.Pane;
import javafx.scene.control.Button;

public class ElectronicStoreButtonPane extends Pane {
    private Button resetbutton, addbutton, removebutton, completebutton;

    public Button getResetbutton() { return resetbutton; }
    public Button getAddbutton() { return addbutton; }
    public Button getRemovebutton() { return removebutton; }
    public Button getCompletebutton() { return completebutton; }

    public ElectronicStoreButtonPane() {
        Pane buttonpane = new Pane();

        resetbutton = new Button("Reset Store");
        resetbutton.setStyle("-fx-font: 12 arial; -fx-base: rgb(220,220,220); -fx-text-fill: rgb(0,0,0);");
        resetbutton.relocate(0,0);
        resetbutton.setPrefSize(100,40);

        addbutton = new Button("Add to Cart");
        addbutton.setStyle("-fx-font: 12 arial; -fx-base: rgb(220,220,220); -fx-text-fill: rgb(0,0,0);");
        addbutton.relocate(230,0);
        addbutton.setPrefSize(100,40);

        removebutton = new Button("Remove from Cart");
        removebutton.setStyle("-fx-font: 12 arial; -fx-base: rgb(220,220,220); -fx-text-fill: rgb(0,0,0);");
        removebutton.relocate(477,0);
        removebutton.setPrefSize(120,40);

        completebutton = new Button("Complete Sale");
        completebutton.setStyle("-fx-font: 12 arial; -fx-base: rgb(220,220,220); -fx-text-fill: rgb(0,0,0);");
        completebutton.relocate(597,0);
        completebutton.setPrefSize(120,40);

        buttonpane.getChildren().addAll(resetbutton, addbutton, removebutton, completebutton);

        getChildren().addAll(buttonpane);
    }
}
