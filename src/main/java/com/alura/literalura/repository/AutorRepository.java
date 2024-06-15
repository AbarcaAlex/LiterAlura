package com.alura.literalura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alura.literalura.model.Autor;

public interface AutorRepository extends JpaRepository<Autor,Long>{

    @Query(value = "select * from autor where libro_id_libro = ?1", nativeQuery = true)
    List<Autor> mostrarAutores(Long idLibro);
}
