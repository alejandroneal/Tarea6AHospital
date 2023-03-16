/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

/**
 *
 * @author Alejandro
 */
public class Medico extends Empleado implements Nada{
    
    private String especialidad;

    public Medico(String especialidad, String numeroSeguridadSocial, double salario, String nombre, String apellidos, NIF nif) {
        super(numeroSeguridadSocial, salario, nombre, apellidos, nif);
        this.especialidad = especialidad;
    }

    @Override
    public double calcularIRPF() {
        if (this.especialidad.equalsIgnoreCase("cirugía")) {
            return getSalario() * 0.25;
        } else {
            return getSalario() * 0.235;
        }
    }
    
    public void tratar(Paciente paciente, String medicina){
        System.out.println("El médico " + getNombre() + " trata a " + paciente.getNombre() 
                + " con la medicina: " + medicina);
    }

    @Override
    public void nada() {
        System.out.println("El médico " + getNombre() + " sabe nadar");
    }

    @Override
    public String toString() {
        return "Medico{nombre=" + getNombre() + ", apellidos=" + getApellidos() + ", nif=" + getNif() + ", numero de la seguridad social" + getNumeroSeguridadSocial() 
                + "especialidad=" + especialidad + '}';
    }
}
