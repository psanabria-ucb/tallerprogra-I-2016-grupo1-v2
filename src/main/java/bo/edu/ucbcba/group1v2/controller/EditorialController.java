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
        int length;
        length = Name.length();
        if (length > 40)
            throw new ValidationException("El nombre no puede ser tan largo");
        else {
            editorial.setName(Name);
        }
        editorial.setName(Name);

       length=Direccion.length();
        if(length>50) {
            throw new ValidationException("Direccion larga ");

        }
        else {
            editorial.setDireccion(Direccion);
        }

        if(Telefono.matches("[0-9]+")) {
            editorial.setTelefono(Integer.parseInt(Telefono));
        }
        else {
            throw new ValidationException("Solo numeros ");
        }

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
