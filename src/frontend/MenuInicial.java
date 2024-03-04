package frontend;

import backend.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MenuInicial extends MenuParent{

    private Medico medicoActual;
    @FXML
    private Label mensajeDeBienvenida;
    @FXML
    private Button botonHome;
    @FXML
    private Button botonCalendario;
    @FXML
    private Button botonPacientes;
    @FXML
    private Button botonLogOut;
    @FXML
    private BorderPane borde;
    @FXML
    private FXMLLoader loader;
    public void setMedico(Medico medico) {
        this.medicoActual = medico;
        setMensajeDeBienvenida();
    }
    public Medico getMedicoActual() {
        return this.medicoActual;
    }

    private void setMensajeDeBienvenida() {
        mensajeDeBienvenida.setText("Bienvenid@ " + medicoActual.getApellido() + " " + medicoActual.getNombre());
    }

    @FXML
    public void logOut(ActionEvent event) throws IOException {
        irAMenuLogIn(event);
        medicoActual = null;
    }

    @FXML
    public void irAHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/SceneHome.fxml"));
        AnchorPane view = loader.load();
        borde.setCenter(view);

    }
    @FXML
    public void irAPacientes(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/ScenePacientes.fxml"));
        AnchorPane view = loader.load();
        ScenePacientes scenePacientes = loader.getController();
        scenePacientes.setMedico(medicoActual);
        borde.setCenter(view);
    }
    @FXML
    public void irAAgendar(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("/frontend/SceneAgendarCitas.fxml"));
        borde.setCenter(view);
    }
}
