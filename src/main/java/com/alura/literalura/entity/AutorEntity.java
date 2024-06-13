// package com.alura.literalura.entity;

// import com.alura.literalura.model.DatosAutor;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "autor")
// public class AutorEntity {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @ManyToOne
//     private long id_author;
//     private String name;
//     private int birth_year;
//     private int death_year;

//     public AutorEntity(){}

//     public AutorEntity(DatosAutor da){
//         this.name = da.nombre();
//         this.birth_year = da.anio_nacimiento();
//         this.death_year = da.anio_fallecimiento();
//     }

//     public long getId_author() {
//         return id_author;
//     }

//     public void setId_author(long id_author) {
//         this.id_author = id_author;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public int getBirth_year() {
//         return birth_year;
//     }

//     public void setBirth_year(int birth_year) {
//         this.birth_year = birth_year;
//     }

//     public int getDeath_year() {
//         return death_year;
//     }

//     public void setDeath_year(int death_year) {
//         this.death_year = death_year;
//     }

//     @Override
//     public String toString() {
//         return "AutorEntity [id_author=" + id_author + ", name=" + name + ", birth_year=" + birth_year + ", death_year="
//                 + death_year + "]";
//     }

    
// }
