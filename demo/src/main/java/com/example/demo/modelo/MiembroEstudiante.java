package com.example.demo.modelo;

public class MiembroEstudiante extends Miembro {

    private String universidad;

    public MiembroEstudiante(String nombre, int edad, String universidad) {
        super(nombre, edad);
        this.universidad = universidad;
    }

    public String getUniversidad() {
        return universidad;
    }

    @Override
    public double cuotaMensual() {
        return super.cuotaMensual() - 15000.0;
    }
}
