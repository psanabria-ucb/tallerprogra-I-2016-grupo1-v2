package bo.edu.ucbcba.group1v2.controller;

import bo.edu.ucbcba.group1v2.dao.TallerEntityManager;
import bo.edu.ucbcba.group1v2.exceptions.ValidationException;
import bo.edu.ucbcba.group1v2.model.Editorial;
import bo.edu.ucbcba.group1v2.model.Libro;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Rebeca on 16/06/2016.
 */
public class LibroController {

    public void create(String nombre, String genero, String description, String lanzamiento,String isbn, Editorial d)
    {
        Libro pelicula = new Libro();

        if(d==null ){
            throw new ValidationException("Primero debe registrar al menos un editor mediante -> Agregar Editorial");
        }
        if(nombre.isEmpty()){
            throw new ValidationException("Ingrese un Titulo");
        }
        if(genero.isEmpty()){
            throw new ValidationException("Ingrese un genero");
        }
        if(description.isEmpty()){
            throw new ValidationException("Ingrese una descripcion");
        }
        if(lanzamiento.isEmpty()){
            throw new ValidationException("Ingrese año de lanzamiento");
        }
        if(isbn.isEmpty()){
            throw new ValidationException("Ingrese isbn");
        }


        if (nombre.matches("[a-zA-Z]+")){
            if(nombre.length()>25){
                throw new ValidationException("EL Titulo no puede tener mas de 24");
            }
            else {
                pelicula.setNombre(nombre);
            }

        }
        else {
            throw new ValidationException("titulo son admite letras");
        }



        if (description.matches("[a-zA-Z]+"))
        {
            if(description.length()>50){
                throw new ValidationException ("DESCRIPCION NO PUEDE TENER MAS DE 50 CARACTERES");
            }
            else {
                pelicula.setDescription(description);
            }

        }
        else
            throw new ValidationException("Descripcion solo admite letras");

        pelicula.setEditorial(d);
        pelicula.setEditname(d.getName());
        pelicula.setGenero(genero);
       // length = lanzamiento.length();

        if (lanzamiento.matches("[0-9]+")){
            if(lanzamiento.length()<=4)
            {
                if ((Integer.parseInt(lanzamiento) <= 2016) && (Integer.parseInt(lanzamiento) >= 1900)) {
                    pelicula.setLanzamiento(Integer.parseInt(lanzamiento));
                } else
                    throw new ValidationException("El año no puede ser menor a 1952 o mayor a 2016");
            }else throw new ValidationException("El año no puede ser tan grande");
        }
        else
            throw new ValidationException("El año de lanzamiento no es un número");


        if(isbn.matches("[0-9]+")){
            if(isbn.length()>13 || isbn.length()<13){
                throw new ValidationException("EL ISBN NO PUEDE TENER MAS DE 13 DIGITOS");
            }
            if(isbn.length()<13){
                throw new ValidationException("EL ISBN DEBE TENER DE 13 DIGITOS");
            }
            else {
                pelicula.setIsbn(Long.parseLong(isbn));
            }
        }
        else
            throw new ValidationException("isbn no es un número");
      //  Double p;

//        p = Double.parseDouble(Gbpeso);
//        pelicula.setPeso(p);
     /*   length = duracMinutos.length();
        if (duracMinutos.matches("[0-9]+")) {
            if (length > 3)
            {
                throw new ValidationException("La duración es muy larga");
            }
            else
            {
                if (length < 1)
                {
                    throw new ValidationException("La duración es muy corta");
                }
                else
                {
                    //                    if (Integer.parseInt(duracMinutos) <=999 && Integer.parseInt(duracMinutos) >= 1)
                    pelicula.setDuracMinutos(Integer.parseInt(duracMinutos));
                    //                      else
                    //                          throw new ValidationException("La duracion debe estar en rango 1 - 999 minutos");
                }
            }
        }
        else
            throw new ValidationException("La duración no esta en minutos");*/

        EntityManager entityManager = TallerEntityManager.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(pelicula);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(String nombre, String genero, String description, String lanzamiento,String isbnn)
    {
        EntityManager entityManager = TallerEntityManager.createEntityManager();
        entityManager.getTransaction().begin();
        Libro libro = entityManager.find(Libro.class,nombre);
        libro.setNombre(nombre);
        libro.setGenero(genero);
        libro.setDescription(description);
        if (lanzamiento.matches("[0-9]+")) {
            libro.setLanzamiento(Integer.parseInt(lanzamiento));
        }
        else {
            throw new ValidationException("El año de lanzamiento no es un número");
        }
        long isb;
        isb = Long.parseLong(isbnn);
        libro.setIsbn(isb);

       /* if (duracMinutos.matches("[0-9]+")) {
            libro.setDuracMinutos(Integer.parseInt(duracMinutos));
        }
        else {
            throw new ValidationException("La duración no esta en minutos");
        }
*/



        entityManager.persist(libro);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

   public List<Libro> BuscarLibros(String q,String Gender, String ord) {
        TypedQuery<Libro> query = null;
        EntityManager entityManager = TallerEntityManager.createEntityManager();
        //TypedQuery<Juego> query = entityManager.createQuery("select e from Juego e WHERE lower(e.nombre) like :nombre order by e.nombre", Juego.class);
        if(ord=="Titulo")
            query = entityManager.createQuery("select e from Libro e WHERE lower(e.nombre) like :nombre and lower(e.genero) like :genero   order by e.nombre", Libro.class);
        if(ord=="Género")
            query = entityManager.createQuery("select e from Libro e WHERE lower(e.nombre) like :nombre and lower(e.genero) like :genero   order by e.genero", Libro.class);
        if(ord=="Lanzamiento")
           query = entityManager.createQuery("select e from Libro e WHERE lower(e.nombre) like :nombre and lower(e.genero) like :genero     order by e.lanzamiento", Libro.class);

        query.setParameter("nombre", "%" + q.toLowerCase() + "%");
        query.setParameter("genero", "%" + Gender.toLowerCase() + "%");
      //  query.setParameter("diredit", "%" + direc.toLowerCase() + "%");
       // query.setParameter("lanzamiento", "%" + Gender.toLowerCase() + "%");

        List<Libro> response = query.getResultList();
        entityManager.close();
        return response;
    }
    public void delete(String id)
    {
        EntityManager entityManager = TallerEntityManager.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Libro.class,id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
