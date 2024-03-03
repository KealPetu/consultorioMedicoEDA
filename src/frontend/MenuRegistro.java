package frontend;

import backend.ListaDeMedicos;
import backend.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;

public class MenuRegistro {
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

    @FXML
    public void registrarNuevoMedico(ActionEvent event) throws IOException {
        if (!contrasena.getText().equals(contrasenaRepetida.getText())){
            showPswrdErrorLabel();
            return;
        }

        ListaDeMedicos medicos = null;
        File file = new File("listaDeMedicos");
        try{

            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            medicos = (ListaDeMedicos) objectIn.readObject();

            if (medicos.containsKey(cedula.getText())){
                showUserErrorLabel();
                return;
            }

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutputStream);
            medicos.put(cedula.getText(), new Medico(nombre.getText(), apellido.getText(), fechaDeNacimiento.getAccessibleText(), contrasena.getText()));
            objectOutput.writeObject(medicos);
            objectOutput.close();
            fileOutputStream.close();

        }catch (FileNotFoundException e) {

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutputStream);
            medicos = new ListaDeMedicos();
            medicos.put(cedula.getText(), new Medico(nombre.getText(), apellido.getText(), fechaDeNacimiento.getAccessibleText(), contrasena.getText()));
            objectOutput.writeObject(medicos);
            objectOutput.close();
            fileOutputStream.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
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
