package com.example.demo.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Miembro {

    private String nombre;
    private int edad;

    public Miembro(String nombre, int edad) {
        this.nombre = nombre;
        setEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad debe ser mayor que 0.");
        }
        this.edad = edad;
    }

    public double cuotaMensual() {
        return 50000.0;
    }

    // Permite que Jackson incluya en el JSON la cuota calculada del subtipo.
    @JsonProperty("cuotaMensual")
    public double getCuotaMensual() {
        return cuotaMensual();
    }

    public String descripcion() {
        return nombre + " (" + edad + " años)";
    }
}
