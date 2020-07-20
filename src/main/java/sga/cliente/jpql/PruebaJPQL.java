package sga.cliente.jpql;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.logging.log4j.*;
import sga.domain.*;

public class PruebaJPQL {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        String jpql = null;
        Query q = null;
        List<Persona> personas = null;
        Persona persona = null;
        Iterator iter = null;
        Object[] tupla = null;
        List<String> nombres = null;
        List<Usuario> usuarios = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
//        1 consulta de todos los objetos de tipo persona
//        log.debug("\n 1.Consulta de todas las personas");
//        jpql="select p from Persona p";
//        personas=em.createQuery(jpql).getResultList();
//        mostrarPersonas(personas);
//        
//        2 consulta de la persona con id
//        log.debug("\n 2.Consulta de la persona con id 12");
//        jpql="select p from Persona p where p.idPersona=12";
//        persona=(Persona) em.createQuery(jpql).getSingleResult();
//        log.debug(persona);
//        3 consulta de la persona con nombre
//        jpql="select p from Persona p where p.nombre='Ninisbeth'";
//                personas=em.createQuery(jpql).getResultList();
//                mostrarPersonas(personas);
//        
//        4 Consulta de datos individuales se crea un arreglo q es un tupla de tipo object de 3 columnas
//        log.debug("\n consulta de datos individuales, se crea un arreglo(tupla) de tipo object de 3 columnas");
//        jpql="select p.nombre as Nombre, p.apellido as Apellido, p.email as Email from Persona p";
//        iter=em.createQuery(jpql).getResultList().iterator();
//        while (iter.hasNext()){
//        tupla=(Object[]) iter.next();
//        String nombre=(String) tupla[0];
//        String apellido=(String)tupla[1];
//        String email=(String)tupla[2];
//        log.debug("nombre "+nombre+", apellido "+apellido+ " , email "+email);
//        
//        5 obtiene el objeto persona y el id, se crea un arreglo tipo object con 2 columnas
//        log.debug("obtiene el objeto persona y el id, se crea un arreglo tipo object con 2 columnas");
//        jpql="select p, p.idPersona from Persona p";
//         iter=em.createQuery(jpql).getResultList().iterator();
//        while (iter.hasNext()){
//            tupla=(Object[]) iter.next();
//            persona=(Persona) tupla[0];
//            int idPersona=(int)tupla[1];
//            log.debug("objeto persona "+persona);
//            log.debug("id persona:"+idPersona);
//        
//        6 consulta todas las personas
//            System.out.println("consulta todas las personas");
//        jpql="select new sga.domain.Persona(p.idPersona) from Persona p";
//        personas=em.createQuery(jpql).getResultList();
//        mostrarPersonas(personas);
//        
//        7 regresa el valor minimo y maximo del valor id persona
//            System.out.println("\n regresa el valor minimo y maximo del valor id persona");
//            jpql="select min(p.idPersona) as MinId, max(p.idPersona) as MaxId, count(p.idPersona)as Contador from Persona p";
//            iter=em.createQuery(jpql).getResultList().iterator();
//            while (iter.hasNext()){
//            tupla=(Object[]) iter.next();
//            Integer idMin=(Integer) tupla[0];
//            Integer idMax=(Integer) tupla[1];
//            Long count=(Long) tupla[2];
//            log.debug("idMin: "+idMin+ "idMax: "+idMax+"count: "+count);
//            
        //8. cuenta los nombres de las personas que son distintos
//        log.debug("\n Cuenta los nombres de las personas que son distintos");
//        jpql="select count(distinct p.nombre) from Persona p";
//        Long contador=(Long) em.createQuery(jpql).getSingleResult();
//        log.debug("no. de personas con nombre distinto: "+contador);
        
//9.Concatena y convierte a mayusculas el nombre y apellido
//log.debug("\n Concatena y convierte a mayusculas el nombre y apellido");
//jpql="select CONCAT(p.nombre,' ',p.apellido) as Nombre from Persona p";
//nombres=em.createQuery(jpql).getResultList();
//for(String nombreCompleto: nombres){
//log.debug(nombreCompleto);

//10.Obtiene el objeto persona con id igual al parametro proporcionado
//log.debug("\nObtiene el objeto persona con id igual al parametro proporcionado");
//int idPersona=12;
//jpql="select p from Persona p where p.idPersona= :id";
//q=em.createQuery(jpql);
//q.setParameter("id", idPersona);
//persona=(Persona) q.getSingleResult();
//log.debug(persona);

//11 obtiene las personas q contengan una letra a en el nombre sin impórtar si es mayscla o minuscula
//log.debug("\nobtiene las personas q contengan una letra a en el nombre sin impórtar si es mayscla o minuscula");
//jpql="select p from Persona p where upper(p.nombre) like upper(:parametro)";
//String parametroString="%a%";//%permite buscar una sola letra dentro de un string
//q=em.createQuery(jpql);
//q.setParameter("parametro", parametroString);
//personas=q.getResultList();
//mostrarPersonas(personas);

//12 Uso de between
//log.debug("Uso de between");
//jpql="select p from Persona p where p.idPersona between 12 and 14";
//personas=em.createQuery(jpql).getResultList();
//mostrarPersonas(personas);

//13 Uso del ordenamiento
//log.debug("\nUso del ordenamiento");
//jpql="select p from Persona p where p.idPersona >13 order by p.nombre desc, p.apellido desc";
//personas=em.createQuery(jpql).getResultList();
//mostrarPersonas(personas);

//14 uso de subquery
//log.debug("\n uso de subquery");
//jpql="select p from Persona p where p.idPersona in(select min(p1.idPersona) from Persona p1)";
//personas=em.createQuery(jpql).getResultList();
//mostrarPersonas(personas);

//15 uso de join con lazy loading
//log.debug("uso de join con lazy loading");
//jpql="select u from Usuario u join u.persona p";
//usuarios=em.createQuery(jpql).getResultList();
//mostrarUsuarios(usuarios);

//16 uso  de left join con eager loading
log.debug("uso  de left join con eager loading");
jpql="select u from Usuario u left join fetch u.persona p";
usuarios=em.createQuery(jpql).getResultList();
mostrarUsuarios(usuarios);







    }
    private static void mostrarPersonas(List<Persona> personas) {
        for(Persona p:personas){
        log.debug(p);
        }
    }

    private static void mostrarUsuarios(List<Usuario> usuarios) {
        {
        for(Usuario u:usuarios){
        log.debug(u);
        }
    }
    }
}


        
            
            
            
        
        
        
        
        
        
    

    
    

