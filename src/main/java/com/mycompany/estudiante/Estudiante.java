/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.estudiante;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rapaz
 */
public class Estudiante {

    private String nombre;
    private List<Integer>notas;

    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList<>();
    }
   
       public void agregarNota(int nota) {
        // Validar rango permitido
        if (nota < 0 || nota > 100) {
            throw new IllegalArgumentException("Nota inválida: " + nota);
        }
        notas.add(nota);
    }

    public double calcularPromedio() {
        if (notas.isEmpty()) return 0.0; // o lanza excepción si lo prefieres
        double suma = 0;
        for (int n : notas) suma += n;
        return suma / notas.size();
    }

    public boolean aprobo() {
        return calcularPromedio() >= 60.0;
    }

    // (Opcional) útil para verificar tamaño/lista en tests
    public List<Integer> getNotas() {
        return new ArrayList<>(notas);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    
   
}
