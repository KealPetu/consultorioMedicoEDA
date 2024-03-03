package backend;

import java.io.Serializable;

public class Medico implements Serializable {
    private String cedula;
    private String contrasena;
    private String nombre;
    private String apellido;
    private String fechaDeNacimiento;

    public Medico(String nombre, String apellido, String fechaDeNacimiento, String contrasena) {
        this. nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.contrasena = contrasena;
    }

    public String getCedula() {
        return cedula;
    }

    public String getContrasena() {
        return contrasena;
    }
}
