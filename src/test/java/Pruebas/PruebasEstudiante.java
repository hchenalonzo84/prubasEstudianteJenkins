/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Pruebas;

import com.mycompany.estudiante.Estudiante;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author rapaz
 */
public class PruebasEstudiante {
    
    // Campo usado por todos los tests
    public Estudiante estudiante;
 
    
    @BeforeEach
    public void setUp() {
    estudiante = new Estudiante("Ana"); 
    }
    @Test
    public void testAgregarNotaValida() {
        // Agregar una nota válida y verificar el promedio
        estudiante.agregarNota(80);
        assertEquals(80.0, estudiante.calcularPromedio(), 0.0001);
    }

    @Test
    public void testAgregarNotaInvalida() {
        // Notas fuera de 0..100 deben lanzar IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> estudiante.agregarNota(-1));
        assertThrows(IllegalArgumentException.class, () -> estudiante.agregarNota(101));
    }

    @Test
    public void testCalcularPromedio() {
        // Promedio de 80, 60, 70 es 70
        estudiante.agregarNota(80);
        estudiante.agregarNota(60);
        estudiante.agregarNota(70);
        assertEquals(70.0, estudiante.calcularPromedio(), 0.0001);
    }

    @Test
    public void testAprobo() {
        // Caso que APRUEBA (>= 60)
        estudiante.agregarNota(60);
        estudiante.agregarNota(60);
        assertTrue(estudiante.aprobo());

        // Caso que NO APRUEBA (< 60) con otra instancia
        Estudiante e2 = new Estudiante("Luis");
        e2.agregarNota(40);
        e2.agregarNota(50);
        assertFalse(e2.aprobo());
    }

}
