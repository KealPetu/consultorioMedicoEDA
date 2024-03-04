package frontend;

import backend.ListaDeMedicos;
import backend.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MenuInicial extends MenuParent{
    private Medico medicoActual;
    private ListaDeMedicos medicos;
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
    public void setMedicoyLista(Medico medico, ListaDeMedicos medicos) {
        this.medicoActual = medico;
        this.medicos = medicos;
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
        medicos.put(medicoActual.getCedula(), medicoActual);
        //escribirEnElArchivo(); //TODO: verificar error de escritura de archivo
        irAMenuLogIn(event);
        medicoActual = null;
    }

    public void escribirEnElArchivo() throws IOException {
        File newFile = new File("test.txt");
        ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(newFile));
        objOut.writeObject(medicos);
        objOut.close();

    }

    @FXML
    public void irAHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/SceneHome.fxml"));
        AnchorPane view = loader.load();
        SceneHome sceneHome = loader.getController();
        sceneHome.initialize(medicoActual, medicos);
        borde.setCenter(view);

    }
    @FXML
    public void irAPacientes(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/ScenePacientes.fxml"));
        AnchorPane view = loader.load();
        ScenePacientes scenePacientes = loader.getController();
        scenePacientes.initialize(medicoActual, medicos);
        borde.setCenter(view);
    }
    @FXML
    public void irAAgendar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/SceneAgendarCitas.fxml"));
        AnchorPane view = loader.load();
        SceneAgendarCitas sceneAgendarCitas = loader.getController();
        sceneAgendarCitas.initialize(medicoActual, medicos);
        borde.setCenter(view);
    }
}
