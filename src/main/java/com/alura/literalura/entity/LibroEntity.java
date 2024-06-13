// package com.alura.literalura.entity;

// import java.util.List;
// import java.util.stream.Collectors;

// import com.alura.literalura.model.DatosLibro;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "libro")
// public class LibroEntity {

//     @Id
//     private long id;
//     private String title;
//     @OneToMany(mappedBy = "id_author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//     private List<AutorEntity> authors;
//     private String languages;
//     private int download_count;

//     public LibroEntity(){}

//     public LibroEntity(DatosLibro dl){
//         this.id = dl.id();
//         this.title = dl.titulo();
//         this.authors = dl.autores().stream().map(a -> new AutorEntity(a)).collect(Collectors.toList());
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

//     public List<AutorEntity> getAuthors() {
//         return authors;
//     }

//     public void setAuthors(List<AutorEntity> authors) {
//         this.authors = authors;
//     }

//     public String getLanguages() {
//         return languages;
//     }

//     public void setLanguages(String languages) {
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
//         return "LibroEntity [id=" + id + ", title=" + title + ", authors=" + authors + ", languages=" + languages
//                 + ", download_count=" + download_count + "]";
//     }

    
// }
