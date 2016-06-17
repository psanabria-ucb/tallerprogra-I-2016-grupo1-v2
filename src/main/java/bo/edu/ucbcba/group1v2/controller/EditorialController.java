package bo.edu.ucbcba.group1v2.controller;

import bo.edu.ucbcba.group1v2.dao.TallerEntityManager;
import bo.edu.ucbcba.group1v2.exceptions.ValidationException;
import bo.edu.ucbcba.group1v2.model.Editorial;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Rebeca on 16/06/2016.
 */
public class EditorialController {

    public void saveDirector(String Name, String Pais, String Direccion, String Telefono) {
        EntityManager em = TallerEntityManager.createEntityManager();
        em.getTransaction().begin();
        Editorial editorial = new Editorial();
        if (Name.isEmpty()){
            throw new ValidationException("debe ingresar un nombre");

        }
        if (Pais.isEmpty()){
            throw new ValidationException("debe ingresar Pais");
        }
        if (Direccion.isEmpty()){
            throw new ValidationException("Ingrese Direccion");
        }
        if (Telefono.isEmpty()){
            throw new ValidationException("Ingrese Direccion");
        }
        //if (address.isEmpty()){
        //     throw new ValidationException("Address can't be blank");
        // }
        if (Name.matches("[a-zA-Z]+"))
        {
            if(Name.length()>25){
                throw new ValidationException ("Nombre NO PUEDE TENER MAS DE 25 CARACTERES");
            }
            else {
                editorial.setName(Name);
            }

        }
        else
            throw new ValidationException("Pais solo admite letras");





        if (Direccion.matches("[a-zA-Z]+"))
        {
            if(Direccion.length()>50){
                throw new ValidationException ("DIRECCION  NO PUEDE TENER MAS DE 50 CARACTERES");
            }
            else {
                editorial.setDireccion(Direccion);
            }

        }
        else
            throw new ValidationException("Direccion solo admite letras");



        if (Telefono.matches("[0-9]+"))
        {
            if(Telefono.length()>15){
                throw new ValidationException ("TELEFONO DEL CLIENTE NO PUEDE TENER MAS DE 15 CIFRA");
            }
            else {
                editorial.setTelefono(Integer.parseInt(Telefono));
            }

        }

        else
            throw new ValidationException("Telefono no es un numero");


        if (Pais.matches("[a-zA-Z]+"))
        {
            if(Pais.length()>15){
                throw new ValidationException ("PAIS  NO PUEDE TENER MAS DE 15 CARACTERES");
            }
            else {
                editorial.setPais(Pais);
            }

        }
        else
            throw new ValidationException("Pais solo admite letras");


       /* if (Anio.matches("[0-9]+")) {
            if(Anio.length()<=4)
            {
                if(Integer.parseInt(Anio) <= 2016 && Integer.parseInt(Anio) >= 1952)
                {
                    director.setAnio(Integer.parseInt(Anio));
                }
                else throw new ValidationException("El año no puede ser menor a 1952 o mayor a 2016");
            }
            else throw new ValidationException("el año no puede ser tan grande");
        }else {
            throw new ValidationException("el año no es un numero");
        }*/
        em.persist(editorial);
        em.getTransaction().commit();
        em.close();
    }

    public List<Editorial> getAllDirectors() {
        EntityManager em = TallerEntityManager.createEntityManager();
        TypedQuery<Editorial> query = em.createQuery("select d from Editorial d order by d.Name", Editorial.class);
        List<Editorial> list = query.getResultList();
        em.close();
        return list;
    }


}
