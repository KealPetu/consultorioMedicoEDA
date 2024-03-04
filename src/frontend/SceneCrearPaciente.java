package frontend;

import backend.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;


public class SceneCrearPaciente {
    @FXML
    private TextField campoNombre;
    @FXML
    private TextField campoApellido;
    @FXML
    private TextField campoCedula;
    @FXML
    private TextField campoAltura;
    @FXML
    private TextField campoPeso;
    @FXML
    private DatePicker fechaDeNacimiento;
    @FXML
    private Button RegistrarPaciente;
    @FXML
    private ChoiceBox eleccionDeSexo;
    private Medico medico;

    public void registrarPaciente(ActionEvent event) throws IOException {
        cambiarAScenePacientes(event);
    }

    private void cambiarAScenePacientes(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Scene scene = source.getScene();
        BorderPane borderPane = (BorderPane) scene.getRoot();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/ScenePacientes.fxml"));
        AnchorPane nuevoAnchorPane = loader.load();
        ScenePacientes scenePacientes = loader.getController();
        scenePacientes.setMedico(medico);
        borderPane.setCenter(nuevoAnchorPane);
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
