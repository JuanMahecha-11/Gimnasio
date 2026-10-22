package com.example.demo.modelo;

public class MiembroPremium extends Miembro {

    private String entrenadorPersonal;

    public MiembroPremium(String nombre, int edad, String entrenadorPersonal) {
        super(nombre, edad);
        this.entrenadorPersonal = entrenadorPersonal;
    }

    public String getEntrenadorPersonal() {
        return entrenadorPersonal;
    }

    @Override
    public double cuotaMensual() {
        return super.cuotaMensual() + 30000.0;
    }
}
