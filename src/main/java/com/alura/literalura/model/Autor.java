package com.alura.literalura.model;

import com.alura.literalura.datos.DatosAutor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor", nullable = false, unique = true)
    private long id_author;

    @Column(name = "nombre")
    private String name;

    @Column(name = "anioNacimiento")
    private int birth_year;

    @Column(name = "anioFallecimiento")
    private int death_year;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id_libro")
    private Libro libro;

    public Autor(){}

    public Autor(DatosAutor da){
        this.name = da.nombre();
        this.birth_year = da.anio_nacimiento();
        this.death_year = da.anio_fallecimiento();
    }

    public long getId_author() {
        return id_author;
    }

    public void setId_author(long id_author) {
        this.id_author = id_author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public int getDeath_year() {
        return death_year;
    }

    public void setDeath_year(int death_year) {
        this.death_year = death_year;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + name + ", Año de nacimiento: " + birth_year + ", Año de fallecimiento: "
                + death_year + "\n";
    }
    
}
