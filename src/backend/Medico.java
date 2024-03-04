package backend;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Stack;

public class Medico implements Serializable {
    private String contrasena;
    private String nombre;
    private String apellido;
    private String cedula;
    private String fechaDeNacimiento;
    private LinkedList<Paciente> listaDePacientes;
    private Stack citas;

    public Medico(String nombre, String apellido, String fechaDeNacimiento, String contrasena, String cedula) {

        this. nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.contrasena = contrasena;
        this.cedula = cedula;
        this.listaDePacientes = new LinkedList();
        this.citas = new Stack<Cita>();
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

    public void enlistarPaciente(Paciente paciente) {
        listaDePacientes.add(paciente);
    }

    public String getCedula() {
        return cedula;
    }

    public LinkedList<Paciente> getListaDePacientes() {
        return listaDePacientes;
    }

    public void setListaDePacientes(LinkedList<Paciente> listaDePacientes) {
        this.listaDePacientes = listaDePacientes;
    }

    public void setCitaMedica(Cita citaMedica) {
        citas.push(citaMedica);
    }

    public Stack getCitas() {
        return citas;
    }

    public void setCitas(Stack<Cita> citas) {
        this.citas = citas;
    }

    public int getCantidadDeCitas() {
        return citas.size();
    }
}
