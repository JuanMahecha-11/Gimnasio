package com.example.demo.controlador;

import com.example.demo.modelo.Miembro;
import com.example.demo.modelo.MiembroEstudiante;
import com.example.demo.modelo.MiembroPremium;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GimnasioController {

    private final List<Miembro> miembros;
    private final Map<String, String> horarios;

    public GimnasioController() {
        miembros = new ArrayList<>();
        miembros.add(new Miembro("Carlos", 30));
        miembros.add(new MiembroPremium("Ana", 25, "Entrenador Luis"));
        miembros.add(new MiembroEstudiante("Mateo", 20, "Universidad Nacional"));
        miembros.add(new MiembroPremium("Laura", 28, "Entrenadora Sara"));

        horarios = new LinkedHashMap<>();
        horarios.put("yoga", "Lunes y miércoles, 7:00 a. m.");
        horarios.put("spinning", "Martes y jueves, 6:00 p. m.");
        horarios.put("crossfit", "Lunes, miércoles y viernes, 5:00 p. m.");
    }

    @GetMapping("/miembros")
    public List<Miembro> obtenerMiembros() {
        return miembros;
    }

    @GetMapping("/miembros/buscar/{nombre}")
    public String buscarMiembro(@PathVariable String nombre) {
        return miembros.stream()
                .filter(miembro -> miembro.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .map(miembro -> miembro.descripcion()
                        + " - cuota mensual: $" + miembro.cuotaMensual())
                .orElse("No se encontró al miembro " + nombre + ".");
    }

    @GetMapping("/miembros/cuota/{minima}")
    public List<Miembro> buscarPorCuota(@PathVariable double minima) {
        return miembros.stream()
                .filter(miembro -> miembro.cuotaMensual() >= minima)
                .toList();
    }

    @GetMapping("/clases/{nombre}")
    public String consultarHorario(@PathVariable String nombre) {
        return horarios.entrySet().stream()
                .filter(entrada -> entrada.getKey().equalsIgnoreCase(nombre))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse("Clase no disponible");
    }
}
