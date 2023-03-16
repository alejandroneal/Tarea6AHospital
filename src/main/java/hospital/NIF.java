/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

import java.time.LocalDate;

/**
 *
 * @author Alejandro
 */
public final class NIF {
    
    private long numero;
    private char letra;
    private LocalDate fechaCaducidad;

    public NIF(long numero, LocalDate fechaCaducidad) {
        this.numero = numero;
        this.letra = calcularLetra();
        this.fechaCaducidad = fechaCaducidad;
    }
    
    private char calcularLetra(){
        int resto = (int) (this.numero % 23);
        String conjuntoLetras = "TRWAGMYFPDXBNJZSQVHLCKE";
        return conjuntoLetras.charAt(resto);
    }
    
    public void renovar(LocalDate fechaSolicitudRenovacion){
        this.fechaCaducidad = fechaSolicitudRenovacion.plusYears(10);
    }

    @Override
    public String toString() {
        return "" + this.numero + this.letra;
    }

    public long getNumero() {
        return numero;
    }

    public char getLetra() {
        return letra;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }
}
