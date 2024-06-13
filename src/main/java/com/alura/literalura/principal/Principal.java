package com.alura.literalura.principal;

import java.util.Scanner;

import com.alura.literalura.service.ConsumoApi;

public class Principal {
    private static Scanner scanner = new Scanner(System.in);

    public static int mostrarMenu(){
        
        int menu=0;
        
        while (true) {

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

            try {
                menu = scanner.nextInt();
                if (menu >= 0 && menu <=5) {
                    break;
                }else{
                    System.out.println("\nLa opcion no es valida!\n");
                }
            } catch (Exception e) {
                System.out.println("\nLa opcion no es valida!\n");
                scanner.next();
            }
        }
        return menu;
    }

    public static void lanzarAplicacion(){
        int salir = 1;
        int opcionMenu;

        while (salir != 0) {
            opcionMenu = mostrarMenu();

            switch (opcionMenu) {
                case 0:
                    System.out.println("Saliendo de la aplicación...");
                    salir = 0;
                    break;
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
    
                    break;
                case 3:
    
                    break;
                case 4:
    
                    break;
                case 5:
    
                    break;
                default:
                    System.out.println("Ocurrio un error inesperado!");
                    break;
            }
        }
    }

    public static void buscarLibroPorTitulo(){
        
        System.out.println("Escriba el titulo del libro que desea buscar:");
        String titulo = scanner.next();

        String url = "https://gutendex.com/books/?search="+titulo.toLowerCase().replace(" ", "%20");
        String json = ConsumoApi.obtenerDatos(url);
        System.out.println(json);
        // var data = ConvierteDatos.obtenerDatos(json, DatosBusqueda.class);
        // List<DatosLibro> libros = data.results();
        // if (libros.isEmpty()) {
        //     System.out.println("No se encontro ningun libro");
        // }else{
        //     libros.stream()
        //         .limit(1)
        //         .forEach(System.out::println);
        // }
            
    }

    
}
