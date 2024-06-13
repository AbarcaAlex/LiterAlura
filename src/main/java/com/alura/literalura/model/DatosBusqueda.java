package com.alura.literalura.model;

import java.util.List;

public record DatosBusqueda(
    int count,
    List<DatosLibro> results
) {

}
