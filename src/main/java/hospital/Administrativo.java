/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

/**
 *
 * @author Alejandro
 */
public class Administrativo extends Empleado {
    
    private Grupo grupo;

    public Administrativo(Grupo grupo, String numeroSeguridadSocial, double salario, String nombre, String apellidos, NIF nif) {
        super(numeroSeguridadSocial, salario, nombre, apellidos, nif);
        this.grupo = grupo;
    }

    @Override
    public double calcularIRPF() {
        return getSalario() * this.grupo.getIrpf();
    }
    
    public void registrarDocumento(String nombreDocumento){
        System.out.println("El administrador " + getNombre() + " " + getApellidos() + " ha registrado el documento "
                + nombreDocumento + " con el código " + nombreDocumento.hashCode());
    }

    @Override
    public String toString() {
        return "Administrativo{nombre=" + getNombre() + ", apellidos=" + getApellidos() + ", nif=" + getNif() + ", numero de la seguridad social=" + getNumeroSeguridadSocial() 
                + "grupo=" + grupo + '}';
    }
}
