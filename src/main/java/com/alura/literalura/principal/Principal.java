package com.alura.literalura.principal;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.alura.literalura.datos.DatosBusqueda;
import com.alura.literalura.datos.DatosLibro;
import com.alura.literalura.model.Autor;
import com.alura.literalura.model.Libro;
import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LibroRepository;
import com.alura.literalura.service.ConsumoApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Principal{
    private Scanner scanner = new Scanner(System.in);
    private ObjectMapper objectMapper = new ObjectMapper();
    private LibroRepository libroRepository;
    private AutorRepository autorRepository;

    public Principal(LibroRepository libroRepository, AutorRepository autorRepository){
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public void lanzarAplicacion() throws JsonMappingException, JsonProcessingException{
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
                    mostrarLibrosRegistrados();
                    break;
                case 3:
                    mostrarAutoresRegistrados();
                    break;
                case 4:
                    mostrarAutoresVivosEnCiertoAnio();
                    break;
                case 5:
                    mostrarLibrosEnCiertoIdioma();
                    break;
                default:
                    System.out.println("Ocurrio un error inesperado!");
                    break;
            }
        }
    }

    private int mostrarMenu(){
        
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

    private void mostrarLibrosEnCiertoIdioma() {
        System.out.printf("""
            Escriba las iniciales del idioma a buscar:
            en - ingles
            es - español
            fr - frances
            fi - finlandes
            pt - portugues
            """);
        String idioma = scanner.next().toLowerCase();
        var libros = libroRepository.librosEnCiertoIdioma(idioma);
        if(libros.isEmpty()){
            System.out.println("No se encontraron libros en ese idioma");
        }else{
            libros.stream().forEach(l -> l.setAuthors(autorRepository.mostrarAutoresUsandoIdLibro(l.getId())));
            System.out.println(libros);
        }
    }

    private void mostrarLibrosRegistrados() {
        var libros = libroRepository.mostrarLibros();
        libros.stream().forEach(l -> l.setAuthors(autorRepository.mostrarAutoresUsandoIdLibro(l.getId())));
        System.out.println(libros);
    }

    private void buscarLibroPorTitulo() throws JsonMappingException, JsonProcessingException{
        
        System.out.println("Escriba el titulo del libro que desea buscar:");
        String titulo = scanner.next();

        String url = "https://gutendex.com/books/?search="+titulo.toLowerCase().replace(" ", "%20");
        String json = ConsumoApi.obtenerDatos(url);

        DatosBusqueda data = objectMapper.readValue(json, DatosBusqueda.class);

        if (data.numResultados() == 0) {
            System.out.println("No se encontro ningun libro con ese titulo");
        }else{
            DatosLibro libro = data.resultados().getFirst();
            
            var yaExiste = libroRepository.buscarSiYaExisteElLibro(libro.id());
            
            if (yaExiste.isEmpty()) {
                Libro libroAGuardar = new Libro(libro);
                List<Autor> autoresAGuardar = libro.autores().stream().map(a -> new Autor(a)).collect(Collectors.toList());

                libroAGuardar.setAuthors(autoresAGuardar);
                autoresAGuardar.stream().forEach(a -> a.setLibro(libroAGuardar));

                System.out.println("Mostrando el resultado de la busqueda:\n"+libroAGuardar);
                libroRepository.save(libroAGuardar);
                autorRepository.saveAll(autoresAGuardar);
            }else{
                System.out.println("El libro ya fue buscado y se encuentra registrado!");
            }
            
        }
        
    }

    private void mostrarAutoresVivosEnCiertoAnio() {
        try {
            System.out.println("Escriba el año: ");
            int anio = scanner.nextInt();
            var autores = autorRepository.autoresVivosEnCiertoAnio(anio);
            if (autores.isEmpty()) {
                System.out.println("No se encontraron autores vivos durante ese año");
            }else{
                System.out.println(autores);
            }
        } catch (Exception e) {
            System.out.println("La fecha no es valida!");
        }
        
    }

    private void mostrarAutoresRegistrados() {
        var autores = autorRepository.mostrarAutores();
        System.out.println(autores);
    }
    
}
