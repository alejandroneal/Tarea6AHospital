/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

import java.util.Random;

/**
 *
 * @author Alejandro
 */
public class Paciente extends Persona implements Nada{
    
    private String numeroHistoria;

    public Paciente(String numeroHistoria, String nombre, String apellidos, NIF nif) {
        super(nombre, apellidos, nif);
        this.numeroHistoria = numeroHistoria;
    }
    
    public void tomarMedicina(String medicina){
        Random random = new Random();
        
        if (random.nextInt(0, 2) == 0) {
            System.out.println("El paciente " + getNombre() + " se ha curado");
        } else {
            System.out.println("El paciente " + getNombre() + " no se ha curado");
        }
    }

    @Override
    public void nada() {
        System.out.println("El paciente " + getNombre() + " sabe nadar");
    }

    @Override
    public String toString() {
        return "Paciente{nombre=" + getNombre() + ", apellidos=" + getApellidos() + ", nif=" + getNif() + ", numeroHistoria=" + numeroHistoria + '}';
    }
}
