package com.alura.literalura.datos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosBusqueda(
    @JsonAlias("count") int numResultados,
    @JsonAlias("results") List<DatosLibro> resultados
) {

}
