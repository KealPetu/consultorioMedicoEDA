package backend;

import java.io.Serializable;

public class Paciente implements Serializable {
    private String nombre;
    private String apellido;
    private String cedula;
    private String fechaDeNacimiento;
    private double peso;
    private double altura;
    private Sexo sexo;
    public Paciente(String nombre, String apellido, String cedula, String fechaDeNacimiento, double peso, double altura) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.peso = peso;
        this.altura = altura;
    }

    public String getApellido() {
        return apellido;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public String getCedula() {
        return cedula;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
