package frontend;

import backend.ListaDeMedicos;
import backend.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MenuLogIn extends MenuParent{


    @FXML
    private TextField cedula;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private Button signUpButton;
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

    private void cambiarMenuSignUp() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/frontend/MenuRegistro.fxml"));
        stage = (Stage)loginButton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void showErrorLabel() {
        errorMsg.setOpacity(1);
    }

    @FXML
    private void doNotShowErrorLabel(ActionEvent event) {
        errorMsg.setOpacity(0);
    }
    private void doNotShowErrorLabel() {
        errorMsg.setOpacity(0);
    }

    private void logIn(Medico medico) throws IOException {
        irAMenuInicial(medico);
    }

    private void irAMenuInicial(Medico medico) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/MenuInicial.fxml"));
        root = loader.load();
        MenuInicial menuInicial = loader.getController();
        menuInicial.setMedico(medico);
        stage = (Stage)loginButton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
