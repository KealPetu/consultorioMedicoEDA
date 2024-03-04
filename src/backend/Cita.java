package backend;

public class Cita {
    private final String razonDeCita;
    private final String fechaDeCita;
    private final int horaDeLaCita;

    public Cita(String razonDeCita, String fechaDeCita, int horaDeLaCita) {
        this.razonDeCita = razonDeCita;
        this.fechaDeCita = fechaDeCita;
        this.horaDeLaCita = horaDeLaCita;
    }

    public int getHoraDeLaCita() {
        return horaDeLaCita;
    }

    public String getRazonDeCita() {
        return razonDeCita;
    }

    public String getFechaDeCita() {
        return fechaDeCita;
    }
}
