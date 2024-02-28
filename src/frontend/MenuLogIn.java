package frontend;

import backend.Medico;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MenuLogIn {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private Hyperlink signUpLink;

    private Medico medico;

    public void compareInputWithList(ActionEvent event){

    }

    private void showErrorScreen() {

    }

    private void logIn() {

    }

    public void signUp(ActionEvent event){

    }

}
