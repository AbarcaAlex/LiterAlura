// package com.alura.literalura.model;

// import java.util.List;
// import java.util.stream.Collectors;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "libro")
// public class Libro {

//     @Id
//     private long id;
//     private String title;
//     @OneToMany(mappedBy = "id_author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//     private List<Autor> authors;
//     private List<String> languages;
//     private int download_count;

//     public Libro(){}

//     public Libro(DatosLibro dl){
//         this.id = dl.id();
//         this.title = dl.titulo();
//         this.authors = dl.autores().stream().map(a -> new Autor(a)).collect(Collectors.toList());
//         this.languages = dl.lenguajes();
//         this.download_count = dl.descargas();
//     }

//     public long getId() {
//         return id;
//     }

//     public void setId(long id) {
//         this.id = id;
//     }

//     public String getTitle() {
//         return title;
//     }

//     public void setTitle(String title) {
//         this.title = title;
//     }

//     public List<Autor> getAuthors() {
//         return authors;
//     }

//     public void setAuthors(List<Autor> authors) {
//         this.authors = authors;
//     }

//     public List<String> getLanguages() {
//         return languages;
//     }

//     public void setLanguages(List<String> languages) {
//         this.languages = languages;
//     }

//     public int getDownload_count() {
//         return download_count;
//     }

//     public void setDownload_count(int download_count) {
//         this.download_count = download_count;
//     }

//     @Override
//     public String toString() {
//         return "Libro [id=" + id + ", title=" + title + ", authors=" + authors + ", languages=" + languages
//                 + ", download_count=" + download_count + "]";
//     }

    
// }
