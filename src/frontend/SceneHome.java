package frontend;

import backend.Cita;
import backend.ListaDeMedicos;
import backend.Medico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
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
    private Stack<Cita> stackTemporal = new Stack<>();
    private ObservableList<Cita> citas = FXCollections.observableArrayList();

    @FXML
    public void initialize(Medico medicoActual, ListaDeMedicos medicos){

        this.medico = medicoActual;
        this.medicos = medicos;
        LocalDate fechaDeHoy = LocalDate.now();
        fechaDeCita.setValue(fechaDeHoy);
        int dia = fechaDeHoy.getDayOfMonth();
        int mes = fechaDeHoy.getMonthValue();
        int año = fechaDeHoy.getYear() - 2024;

        this.stackTemporal = medico.getCitasDeHoy(dia, mes, año);

        try {
            while (!stackTemporal.isEmpty()){
                citas.add(stackTemporal.pop());
            }
        } catch (NullPointerException e) {
        }

        celdaHoraDeCita.setCellValueFactory(new PropertyValueFactory<Cita, Integer>("horaDeLaCita"));
        //celdaNombrePaciente.setCellValueFactory(new PropertyValueFactory<Paciente, String>("nombre"));
        celdaRazonDeCita.setCellValueFactory(new PropertyValueFactory<Cita, String>("razonDeCita"));

        tablaCitas.setItems(citas);
    }

    @FXML
    public void updateObservableList(ActionEvent event){
        LocalDate fechaDeDia;
        fechaDeDia = fechaDeCita.getValue();
        int dia = fechaDeDia.getDayOfMonth();
        int mes = fechaDeDia.getMonthValue();
        int año = fechaDeDia.getYear() - 2024;

        this.stackTemporal = medico.getCitasDeHoy(dia, mes, año);

        try {
            while (!stackTemporal.isEmpty()){
                citas.add(stackTemporal.pop());
            }
        } catch (NullPointerException e) {
        }

        celdaHoraDeCita.setCellValueFactory(new PropertyValueFactory<Cita, Integer>("horaDeLaCita"));
        //celdaNombrePaciente.setCellValueFactory(new PropertyValueFactory<Paciente, String>("nombre"));
        celdaRazonDeCita.setCellValueFactory(new PropertyValueFactory<Cita, String>("razonDeCita"));

        tablaCitas.setItems(citas);
    }
}
