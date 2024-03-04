package backend;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Medico implements Serializable {
    private String contrasena;
    private String nombre;
    private String apellido;
    private String fechaDeNacimiento;
    private List listaDePacientes;
    private Stack citas;

    public Medico(String nombre, String apellido, String fechaDeNacimiento, String contrasena) {

        this. nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.contrasena = contrasena;
        this.listaDePacientes = new LinkedList();
        this.citas = new Stack<Citas>();

    }

    public String getNombre(){
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getContrasena() {
        return contrasena;
    }
}
