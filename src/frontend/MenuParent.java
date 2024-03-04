package frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuParent {
    protected Parent root;
    protected Scene scene;
    protected Stage stage;

    @FXML
    protected void irAMenuLogIn(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/frontend/MenuLogIn.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void irAMenuSignUp(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/frontend/MenuRegistro.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
