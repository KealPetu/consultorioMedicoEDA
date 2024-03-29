package frontend;

import backend.ListaDeMedicos;
import backend.Medico;
import backend.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class ScenePacientes{

    @FXML
    private Button botonCrearPaciente;
    @FXML
    private TableView<Paciente> tablaPacientes;
    @FXML
    private TableColumn<Paciente, String> celdaApellidoPaciente;
    @FXML
    private TableColumn<Paciente, String> celdaNombrePaciente;
    @FXML
    private TableColumn<Paciente, String> celdaCedulaPaciente;
    private Medico medico;
    private ListaDeMedicos medicos;
    private ObservableList<Paciente> pacientes = FXCollections.observableArrayList();
    @FXML
    public void irAEscenaCrearPaciente(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Scene scene = source.getScene();
        BorderPane borderPane = (BorderPane) scene.getRoot();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/SceneCrearPaciente.fxml"));
        AnchorPane nuevoAnchorPane = loader.load();
        SceneCrearPaciente sceneCrearPaciente = loader.getController();
        sceneCrearPaciente.setMedicoyLista(medico, medicos);
        borderPane.setCenter(nuevoAnchorPane);
    }

    @FXML
    public void initialize(Medico medicoActual, ListaDeMedicos medicos){
        this.medico = medicoActual;
        this.medicos = medicos;

        for (Paciente paciente : medico.getListaDePacientes()){
            pacientes.add(paciente);
        }
        celdaApellidoPaciente.setCellValueFactory(new PropertyValueFactory<Paciente, String>("apellido"));
        celdaNombrePaciente.setCellValueFactory(new PropertyValueFactory<Paciente, String>("nombre"));
        celdaCedulaPaciente.setCellValueFactory(new PropertyValueFactory<Paciente, String>("cedula"));

        tablaPacientes.setItems(pacientes);
    }
}
