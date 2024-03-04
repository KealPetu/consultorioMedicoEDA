package frontend;

import backend.Cita;
import backend.ListaDeMedicos;
import backend.Medico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Stack;

public class SceneHome {

    @FXML
    private TableView<Cita> tablaCitas;
    @FXML
    private TableColumn<Cita, Integer> celdaHoraDeCita;
    @FXML
    private TableColumn<Cita, String> celdaNombrePaciente;
    @FXML
    private TableColumn<Cita, String> celdaRazonDeCita;
    @FXML
    private DatePicker fechaDeCita;
    private Medico medico;
    private ListaDeMedicos medicos;
    private Stack<Cita> stackTemporal = new Stack<Cita>();
    private ObservableList<Cita> citas = FXCollections.observableArrayList();

    @FXML
    public void initialize(Medico medicoActual, ListaDeMedicos medicos){

        this.medico = medicoActual;
        this.medicos = medicos;
        this.stackTemporal = medico.getCitas();

        while (!stackTemporal.isEmpty()){
            citas.add(stackTemporal.pop());
        }

        celdaHoraDeCita.setCellValueFactory(new PropertyValueFactory<Cita, Integer>("horaDeLaCita"));
        //celdaNombrePaciente.setCellValueFactory(new PropertyValueFactory<Paciente, String>("nombre"));
        celdaRazonDeCita.setCellValueFactory(new PropertyValueFactory<Cita, String>("razonDeCita"));

        tablaCitas.setItems(citas);
    }
}
