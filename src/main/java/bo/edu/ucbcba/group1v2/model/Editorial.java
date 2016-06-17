package bo.edu.ucbcba.group1v2.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Rebeca on 16/06/2016.
 */
@Entity
public class Editorial {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 100)
    private String Name;
    private String Pais;
    private String Direccion;
    private long  Telefono;

    public long getTelefono() {
        return Telefono;
    }

    public void setTelefono(long fono) {
        Telefono = fono;
    }

    @OneToMany
    private List<Libro> libritos;

    public Editorial() {
        id = 0;
        Name = "";
        Pais="";
        Direccion="";
        Telefono =0;
        libritos = new LinkedList<Libro>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }


    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public List<Libro> getLibros() {
        return libritos;
    }

    public void setLibros(List<Libro> peliculas) {
        this.libritos = peliculas;
    }
    @Override
    public String toString() {
        return String.format("%s", Name);
    }



}




