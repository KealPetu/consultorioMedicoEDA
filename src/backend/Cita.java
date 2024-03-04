package backend;

import java.io.Serializable;

public class Cita implements Serializable {
    private final String razonDeCita;

    public Cita(String razonDeCita) {
        this.razonDeCita = razonDeCita;
    }
    public String getRazonDeCita() {
        return razonDeCita;
    }

}
