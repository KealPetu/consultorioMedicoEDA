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

public class MenuRegistro {
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellido;
    @FXML
    private TextField cedula;
    @FXML
    private DatePicker fechaDeNacimiento;
    @FXML
    private PasswordField contrasena,
            contrasenaRepetida;
    @FXML
    private Hyperlink enlaceDeRegreso;
    @FXML
    private Button botonDeRegistro;
    @FXML
    private Label errorUsuarioExistente,
            errorContrasenaNoCoincide;
    private File file = new File("listaDeMedicos");

    @FXML
    public void registrarNuevoMedico(ActionEvent event) throws IOException {

        if (contrasenasNoSonIguales()) return;

        try{

            ListaDeMedicos medicos = getListaDeMedicos();
            if (yaExisteMedico(medicos)) return;
            escribirEnElArchivo(medicos);

        }catch (FileNotFoundException e) {

            crearArchivo();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void regresarAMenuLogIn(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../frontend/MenuLogIn.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private boolean contrasenasNoSonIguales() {
        if (!contrasena.getText().equals(contrasenaRepetida.getText())){
            showPswrdErrorLabel();
            return true;
        }
        return false;
    }

    private void crearArchivo() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutputStream);
        ListaDeMedicos medicos = new ListaDeMedicos();
        medicos.put(cedula.getText(), new Medico(nombre.getText(), apellido.getText(), fechaDeNacimiento.getAccessibleText(), contrasena.getText()));
        objectOutput.writeObject(medicos);
        objectOutput.close();
        fileOutputStream.close();
    }

    private void escribirEnElArchivo(ListaDeMedicos medicos) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutputStream);
        medicos.put(cedula.getText(), new Medico(nombre.getText(), apellido.getText(), fechaDeNacimiento.getAccessibleText(), contrasena.getText()));
        objectOutput.writeObject(medicos);
        objectOutput.close();
        fileOutputStream.close();
    }

    private boolean yaExisteMedico(ListaDeMedicos medicos) {
        if (medicos.containsKey(cedula.getText())){
            showUserErrorLabel();
            return true;
        }
        return false;
    }

    private ListaDeMedicos getListaDeMedicos() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        ListaDeMedicos medicos = (ListaDeMedicos) objectIn.readObject();
        return medicos;
    }

    private void showPswrdErrorLabel() {
        errorContrasenaNoCoincide.setOpacity(1);
        errorUsuarioExistente.setOpacity(0);

    }

    private void showUserErrorLabel() {
        errorUsuarioExistente.setOpacity(1);
        errorContrasenaNoCoincide.setOpacity(0);

    }
}
