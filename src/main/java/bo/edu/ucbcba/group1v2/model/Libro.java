package bo.edu.ucbcba.group1v2.model;

import javax.persistence.*;

/**
 * Created by Rebeca on 16/06/2016.
 */
@Entity
public class Libro {

    @Id
    private String nombre;


    @Column(length = 100)
    private String genero;

    @Lob
    @Column(length = 500)
    private String description;
    private String diredit;//dirname
    private int lanzamiento;

    private long isbn;
   // private String nomCover;

    public Libro(){
        nombre="";
        genero="";
        description="";
        isbn=0;
        lanzamiento=0;
        diredit="";
        editorial=null;
    }

  /*  public String getNomCover() {
        return nomCover;
    }

    public void setNomCover(String nomCover) {
        this.nomCover = nomCover;
    }*/

    @ManyToOne
    private Editorial editorial;

    public String getEditname() {
        return diredit;
    }

    public void setEditname(String diredit) {
        this.diredit = diredit;
    }
    public Editorial getEditorial() {
        return editorial;
    }

    public String getEditorialName(){
        return editorial.getName();
    }

    public void setEditorial(Editorial director) {
        this.editorial = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }



    public int getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(int lanzamiento) {
        this.lanzamiento = lanzamiento;
    }


    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }




}
