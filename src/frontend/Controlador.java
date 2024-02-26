package frontend;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controlador {
    @FXML
    private TextField textField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button button;
    @FXML
    private Hyperlink hyperlink;

    public void print(ActionEvent event){
        String user = textField.getText();
        System.out.print(user);
    }

}
