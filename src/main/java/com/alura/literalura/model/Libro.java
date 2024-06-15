package com.alura.literalura.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "titulo")
    private String title;
    
    @OneToMany(mappedBy = "id_author")
    private List<Autor> authors;

    @ElementCollection
    @CollectionTable(name = "idioma_libro")
    @Column(name = "idioma")
    private List<String> languages;

    @Column(name = "descargas")
    private int download_count;

    public Libro(){}

    public Libro(DatosLibro dl){
        this.title = dl.titulo();
        this.languages = dl.idiomas();
        this.download_count = dl.descargas();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Autor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Autor> authors) {
        authors.forEach(a -> a.setLibro(this));
        this.authors = authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public int getDownload_count() {
        return download_count;
    }

    public void setDownload_count(int download_count) {
        this.download_count = download_count;
    }

    @Override
    public String toString() {
        return "\nTitulo: " + title + "\nAutores=" + authors + "\nLenguajes: " + languages
                + "\nDescargas: " + download_count + "\n";
    }

    
}
