package com.alura.literalura.principal;

public class Principal {

    public static void mostrarMenu(){

        System.out.printf("""
        ----------------------
        Elija la opción a traves de su numero:
        1 - Buscar libro por titulo
        2 - Listar libros registrados
        3 - Listar autores registrados
        4 - Listar autores vivos en un determinado año
        5 - Listar libros por idioma
        0 - Salir
        """);

        
    }
}
