package com.alura.literalura.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alura.literalura.model.Libro;

public interface LibroRepository extends JpaRepository<Libro,Long>{

    @Query(value = "select id_libro from libro where id_libro = ?1", nativeQuery = true)
    Optional<Long> buscarSiYaExisteElLibro(Long id);

    @Query(value = "select * from libro", nativeQuery = true)
    List<Libro> mostrarLibros();

    @Query(value = "select * from libro where idioma like ?1", nativeQuery = true)
    List<Libro> librosEnCiertoIdioma(String idioma);
}
