/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class Hospital {
    
    private String nombre;
    private String direccion;
    private int numeroCamas;
    private List<Paciente> listaPacientes;
    private List<Empleado> listaEmpleados;

    public Hospital(String nombre, String direccion, int numeroCamas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroCamas = numeroCamas;
        this.listaPacientes = new ArrayList<>();
        this.listaEmpleados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getNumeroCamas() {
        return numeroCamas;
    }

    public List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
    
    public void contratarEmpleado(Empleado emp){
        this.listaEmpleados.add(emp);
    }
    
    public void ingresarPaciente(Paciente paciente){
        this.listaPacientes.add(paciente);
    }
}
