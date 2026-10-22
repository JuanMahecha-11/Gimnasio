package com.example.demo;

import com.example.demo.modelo.Miembro;
import com.example.demo.modelo.MiembroEstudiante;
import com.example.demo.modelo.MiembroPremium;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiembroTest {

    @Test
    void cuotasCambianSegunElTipoDeMiembro() {
        assertEquals(50000.0, new Miembro("Carlos", 30).cuotaMensual());
        assertEquals(80000.0, new MiembroPremium("Ana", 25, "Luis").cuotaMensual());
        assertEquals(35000.0, new MiembroEstudiante("Mateo", 20, "Universidad").cuotaMensual());
    }

    @Test
    void edadDebeSerMayorQueCero() {
        Miembro miembro = new Miembro("Carlos", 30);
        assertThrows(IllegalArgumentException.class, () -> miembro.setEdad(0));
        assertThrows(IllegalArgumentException.class, () -> miembro.setEdad(-2));
    }

    @Test
    void descripcionRespetaElFormatoSolicitado() {
        assertEquals("Carlos (30 años)", new Miembro("Carlos", 30).descripcion());
    }
}
