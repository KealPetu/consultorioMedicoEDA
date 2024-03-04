package frontend;

import backend.ListaDeMedicos;
import backend.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;

public class MenuRegistro extends MenuParent{
    @FXML
    private TextField campoDeNombre;
    @FXML
    private TextField campoDeApellido;
    @FXML
    private TextField campoDeCedula;
    @FXML
    private DatePicker fechaDeNacimiento;
    @FXML
    private PasswordField campoDeContrasena;
    @FXML
    private PasswordField campoDeContrasenaRepetida;
    @FXML
    private Hyperlink enlaceDeRegreso;
    @FXML
    private Button botonDeRegistro;
    @FXML
    private Label errorUsuarioExistente;
    @FXML
    private Label errorContrasenaNoCoincide;
    @FXML
    private Label usuarioCreado;
    @FXML
    private Label contrasenaPequena;
    @FXML
    private Label cedulaNoValida;
    private File file = new File("listaDeMedicos.txt");

    @FXML
    public void registrarNuevoMedico(ActionEvent event) throws IOException {

        if (contrasenasNoSonIguales()) return;
        if (contrasenaMenosDeOchoChar())return;
        if (cedulaNoEsValida())return;

        try{

            ListaDeMedicos medicos = getListaDeMedicos();
            if (yaExisteMedico(medicos)) return;
            escribirEnElArchivo(medicos);
            showUserCreatedLabel();

        }catch (FileNotFoundException e) {

            crearArchivo();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean cedulaNoEsValida() {
        if (!campoDeCedula.getText().matches("[0-9]+")||campoDeCedula.getText().length() != 10){
            cedulaNoValida.setOpacity(1);
            return true;
        }
        cedulaNoValida.setOpacity(0);
        return false;
    }

    private boolean contrasenaMenosDeOchoChar() {
        if (campoDeContrasena.getText().length() < 8) {
            contrasenaPequena.setOpacity(1);
            return true;
        }
        contrasenaPequena.setOpacity(0);
        return false;
    }

    private void showUserCreatedLabel() {
        usuarioCreado.setOpacity(1);
    }
    private void doNotShowUserCreatedLabel() {
        usuarioCreado.setOpacity(0);
    }

    private boolean contrasenasNoSonIguales() {
        if (!campoDeContrasena.getText().equals(campoDeContrasenaRepetida.getText())){
            errorContrasenaNoCoincide.setOpacity(1);
            doNotShowUserCreatedLabel();
            return true;
        }
        errorContrasenaNoCoincide.setOpacity(0);
        return false;
    }

    private void crearArchivo() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutputStream);
        ListaDeMedicos medicos = new ListaDeMedicos();
        medicos.put(campoDeCedula.getText(), new Medico(campoDeNombre.getText(), campoDeApellido.getText(), fechaDeNacimiento.getPromptText(), campoDeContrasena.getText(), campoDeCedula.getText()));
        objectOutput.writeObject(medicos);
        objectOutput.close();
        fileOutputStream.close();
    }

    private void escribirEnElArchivo(ListaDeMedicos medicos) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutputStream);
        medicos.put(campoDeCedula.getText(), new Medico(campoDeNombre.getText(), campoDeApellido.getText(), fechaDeNacimiento.getPromptText(), campoDeContrasena.getText(), campoDeCedula.getText()));
        objectOutput.writeObject(medicos);
        objectOutput.close();
        fileOutputStream.close();
    }

    private boolean yaExisteMedico(ListaDeMedicos medicos) {
        if (medicos.existeMedicoConCedula(campoDeContrasena.getText())){
            showUserErrorLabel();
            doNotShowUserCreatedLabel();
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

    private void showUserErrorLabel() {
        errorUsuarioExistente.setOpacity(1);
        errorContrasenaNoCoincide.setOpacity(0);
        usuarioCreado.setOpacity(0);
        contrasenaPequena.setOpacity(0);
    }
}
