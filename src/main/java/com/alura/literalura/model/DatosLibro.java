package com.alura.literalura.model;

import java.util.List;

public record DatosLibro(
    long id,
    String titulo,
    List<DatosAutor> autores,
    String lenguajes,
    int descargas
) {

}
