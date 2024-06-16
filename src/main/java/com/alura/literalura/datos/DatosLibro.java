package com.alura.literalura.datos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
    @JsonAlias("id") long id,
    @JsonAlias("title") String titulo,
    @JsonAlias("authors") List<DatosAutor> autores,
    @JsonAlias("languages") List<String> idiomas,
    @JsonAlias("download_count") int descargas
) {

}
