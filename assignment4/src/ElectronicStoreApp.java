import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;


public class ElectronicStoreApp extends Application{

    private ElectronicStore model;
    private ElectronicStoreView view;

    public ElectronicStoreApp() { this.model = ElectronicStore.createStore(); }

    //this is where I begin step 2

    public void start(Stage stage) {
        Pane pane = new Pane();

        view = new ElectronicStoreView();
        view.update(model);
        pane.getChildren().add(view);

        stage.setTitle("Electronic Store Application - " + model.getName());
        stage.setResizable(false);
        stage.setScene(new Scene(pane));
        stage.show();

        view.getStorestock().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                // Your logic for handling the click event goes here
                // For example, you can call view.update(model) to update the view
                view.update(model);
            }
        });

    }

}
