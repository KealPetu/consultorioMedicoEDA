package frontend;

import backend.Cita;
import backend.ListaDeMedicos;
import backend.Medico;
import backend.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SceneAgendarCitas {

    @FXML
    private Button botonAgendarCita;
    @FXML
    private DatePicker seleccionadorDeFecha;
    @FXML
    private TableView<Paciente> tablaPacientes;
    @FXML
    private TableColumn<Paciente, String> celdaApellidoPaciente;
    @FXML
    private TableColumn<Paciente, String> celdaNombrePaciente;
    @FXML
    private TableColumn<Paciente, String> celdaCedulaPaciente;
    @FXML
    private TextField campoDeRazonDeCitaMedica;
    private Medico medico;
    private ListaDeMedicos medicos;
    private ObservableList<Paciente> pacientes = FXCollections.observableArrayList();

    @FXML
    public void initialize(Medico medicoActual, ListaDeMedicos medicos) {
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

    @FXML
    public void agendarCita(ActionEvent event){
        LocalDate fecha = seleccionadorDeFecha.getValue();

        if (fecha != null) {
            DateTimeFormatter formateador = DateTimeFormatter.ofPattern("d/M/yyyy");
            String fechaFormateada = fecha.format(formateador);

            int dia = fecha.getDayOfMonth();
            int mes = fecha.getMonthValue();
            int año = fecha.getYear()-2024;

            medico.agregarCita(new Cita(campoDeRazonDeCitaMedica.getText()), dia, mes, año);
        } else {
            System.out.println("Por favor, selecciona una fecha antes de agendar la cita.");
        }
    }
}
