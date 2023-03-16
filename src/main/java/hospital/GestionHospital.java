/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author Alejandro
 */
public class GestionHospital {

    public static void main(String[] args) {

        //Creo un hospital
        Hospital hospital = new Hospital("Centro de Salud", "Calle nosecuantos nº 3", 250);
        //Creo un objeto de clase GestionHospital para poder crear diferentes pacientes y empleados
        GestionHospital gh = new GestionHospital(hospital);
        //Creo 5 pacientes
        Paciente p1 = gh.crearPaciente("1", "Paciente1", "ApellidosPaciente1",
                new NIF(78945612, LocalDate.of(2024, 3, 19)));
        Paciente p2 = gh.crearPaciente("2", "Paciente2", "ApellidosPaciente2",
                new NIF(54681237, LocalDate.of(2027, 8, 5)));
        Paciente p3 = gh.crearPaciente("3", "Paciente3", "ApellidosPaciente3",
                new NIF(84753465, LocalDate.of(2027, 1, 22)));
        Paciente p4 = gh.crearPaciente("4", "Paciente4", "ApellidosPaciente4",
                new NIF(78513698, LocalDate.of(2023, 11, 19)));
        Paciente p5 = gh.crearPaciente("5", "Paciente5", "ApellidosPaciente5",
                new NIF(34622825, LocalDate.of(2025, 7, 11)));

        //Creo 2 medicos
        Empleado m1 = gh.crearMedico("cirugía", "1", 2300,
                "Médico1", "ApellidosMédico1", new NIF(69695874,
                        LocalDate.of(2025, 8, 22)));
        Empleado m2 = gh.crearMedico("pediatría", "2", 1700,
                "Médico2", "ApellidosMédico2", new NIF(47457521,
                        LocalDate.of(2026, 10, 13)));

        //Creo 3 administrativos
        Empleado a1 = gh.crearAdministrativo(Grupo.C, "3", 1500,
                "Administrativo1", "ApellidosAdministrativo1",
                new NIF(75753528, LocalDate.of(2023, 4, 4)));
        Empleado a2 = gh.crearAdministrativo(Grupo.C, "4", 1475,
                "Administrativo2", "ApellidosAdministrativo2",
                new NIF(85876253, LocalDate.of(2027, 1, 25)));
        Empleado a3 = gh.crearAdministrativo(Grupo.C, "3", 1650,
                "Administrativo3", "ApellidosAdministrativo3",
                new NIF(45414795, LocalDate.of(2024, 9, 15)));

        //Contrato a los 5 empleados en el hospital
        hospital.contratarEmpleado(m1);
        hospital.contratarEmpleado(m2);
        hospital.contratarEmpleado(a1);
        hospital.contratarEmpleado(a2);
        hospital.contratarEmpleado(a3);
        System.out.println("Todos los empleados contratados");
        for (Empleado empleado : hospital.getListaEmpleados()) {
            System.out.println(empleado);
        }

        //Ingreso a los 5 pacientes
        hospital.ingresarPaciente(p1);
        hospital.ingresarPaciente(p2);
        hospital.ingresarPaciente(p3);
        hospital.ingresarPaciente(p4);
        hospital.ingresarPaciente(p5);
        System.out.println("\nTodos los pacientes ingresados");
        for (Paciente paciente : hospital.getListaPacientes()) {
            System.out.println(paciente);
        }

        //Hago que un médico aleatorio trate a un paciente aleatorio 
        System.out.println("");
        Random random = new Random();
        do {
            Empleado aux = hospital.getListaEmpleados()
                    .get(random.nextInt(0, hospital.getListaEmpleados().size()));
            if (aux instanceof Medico) {
                ((Medico) aux).tratar(hospital.getListaPacientes()
                        .get(random.nextInt(0, hospital.getListaPacientes().size())), "Pancetamol");
                break;
            }
        } while (true);

        for (Empleado empleado : hospital.getListaEmpleados()) {
            System.out.println("\nEl empleado:");
            System.out.println(empleado);
            System.out.println("Paga de IRPF: " + empleado.calcularIRPF());
        }

        System.out.println("\nRenovar el NIF a un paciente");
        System.out.println(hospital.getListaPacientes().get(0));
        System.out.println("Cuyo NIF caduca el " + hospital.getListaPacientes().get(0).getNif().getFechaCaducidad());
        //Renovamos su nif con su método que hereda de la clase Persona
        hospital.getListaPacientes().get(0).renovarNIF(LocalDate.now());
        System.out.println("Ahora su NIF caduca el " + hospital.getListaPacientes().get(0).getNif().getFechaCaducidad());
    }

    private Hospital hospital;

    public GestionHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Paciente crearPaciente(String numeroHistoria, String nombre, String apellidos, NIF nif) {
        return new Paciente(numeroHistoria, nombre, apellidos, nif);
    }

    public Medico crearMedico(String especialidad, String numeroSeguridadSocial, double salario, String nombre, String apellidos, NIF nif) {
        return new Medico(especialidad, numeroSeguridadSocial, salario, nombre, apellidos, nif);
    }

    public Administrativo crearAdministrativo(Grupo grupo, String numeroSeguridadSocial, double salario, String nombre, String apellidos, NIF nif) {
        return new Administrativo(grupo, numeroSeguridadSocial, salario, nombre, apellidos, nif);
    }
}
