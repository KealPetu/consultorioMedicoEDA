package frontend;

import backend.ListaDeMedicos;
import backend.Medico;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;

public class MenuLogIn {
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private TextField cedula;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private Hyperlink signUpLink;
    @FXML
    private Label errorMsg;

    public void compararEntradaConLista(ActionEvent event) throws IOException {

        ListaDeMedicos medicos = null;

        try{

            medicos = getListaDeMedicos();

        } catch (FileNotFoundException e){

            cambiarMenuSignUp();
            return;

        } catch (IOException e){

            throw new IOException(e);

        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);

        }

        if (!medicos.containsKey(cedula.getText())){

            cambiarMenuSignUp();
            return;

        }
        if (!medicos.get(cedula.getText()).getContrasena().equals(password.getText())){

            showErrorLabel();
            return;

        }

        logIn(medicos.get(cedula.getText()));
    }

    private static ListaDeMedicos getListaDeMedicos() throws IOException, ClassNotFoundException {
        ListaDeMedicos medicos;
        FileInputStream fileIn = new FileInputStream("listaDeMedicos");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        medicos = (ListaDeMedicos) objectIn.readObject();
        return medicos;
    }

    @FXML
    private void cambiarMenuSignUp(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../frontend/MenuRegistro.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private void cambiarMenuSignUp() throws IOException {
        root = FXMLLoader.load(getClass().getResource("../frontend/MenuRegistro.fxml"));
        stage = (Stage)loginButton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void showErrorLabel() {
        errorMsg.setOpacity(1);
    }

    private void logIn(Medico medico) {

    }

}
