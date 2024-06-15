package com.alura.literalura.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @Column(name = "id_libro", nullable = false, unique = true)
    private long id;

    @Column(name = "titulo")
    private String title;
    
    @OneToMany(mappedBy = "id_author", fetch = FetchType.EAGER)
    private List<Autor> authors;

    @Column(name = "idioma")
    private String language;

    @Column(name = "descargas")
    private int download_count;

    public Libro(){}

    public Libro(DatosLibro dl){
        this.id = dl.id();
        this.title = dl.titulo();
        this.language = dl.idiomas().getFirst();
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(List<String> languages) {
        this.language = languages.getFirst();
    }

    public int getDownload_count() {
        return download_count;
    }

    public void setDownload_count(int download_count) {
        this.download_count = download_count;
    }

    @Override
    public String toString() {
        return "\nTitulo: " + title + "\nAutores=" + authors + "\nIdioma: " + language
                + "\nDescargas: " + download_count + "\n";
    }

    
}
