package frontend;

import backend.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class ScenePacientes {

    @FXML
    private Button botonCrearPaciente;
    private Medico medico;


    @FXML
    public void irAEscenaCrearPaciente(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Scene scene = source.getScene();
        BorderPane borderPane = (BorderPane) scene.getRoot();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/SceneCrearPaciente.fxml"));
        AnchorPane nuevoAnchorPane = loader.load();
        SceneCrearPaciente sceneCrearPaciente = loader.getController();
        sceneCrearPaciente.setMedico(medico);
        borderPane.setCenter(nuevoAnchorPane);
    }

    public void setMedico(Medico medicoActual) {
        this.medico = medicoActual;
    }
}
