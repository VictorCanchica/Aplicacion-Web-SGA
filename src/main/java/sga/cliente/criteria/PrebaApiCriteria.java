package sga.cliente.criteria;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;
import org.apache.logging.log4j.*;
import sga.domain.Persona;

public class PrebaApiCriteria {
    static Logger log=LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em=emf.createEntityManager();
        
        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery=null;
        Root<Persona>fromPersona=null;
        TypedQuery<Persona> query=null;
        Persona persona=null;
        List<Persona> personas=null;
        
        //query utilizando Api de criteria
        //1 consulta de todas las personas
        
        //paso 1 el objeto em cre un criteriabuilder
        cb=em.getCriteriaBuilder();
        //paso 2 se crea un objeto criteria querty
        criteriaQuery=cb.createQuery(Persona.class);
        //paso 3 creamos el objeto raiz de query
        fromPersona=criteriaQuery.from(Persona.class);
        //paso 4 seleccionamos lo necesario del from
        criteriaQuery.select(fromPersona);
        //paso 5 creamos el query typesafe
        query=em.createQuery(criteriaQuery);
        //paso 6 ejecutamos la consulta
        personas=query.getResultList();
        
       // mostrarPersonas(personas);
        //2-a consulta de la persona con id=12
        //jpql="select p from Persona p where p.idpersona=12
        log.debug("\n 2-a consulta de la persona con id=12");
        cb=em.getCriteriaBuilder();
        criteriaQuery=cb.createQuery(Persona.class);
        fromPersona=criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"), 12 ));
        persona=em.createQuery(criteriaQuery).getSingleResult();
        log.debug(persona);
        
        //2-b consulta de la persona con id=12
        
        log.debug("\n 2-b consulta de la persona con id=12");
        cb=em.getCriteriaBuilder();
        criteriaQuery=cb.createQuery(Persona.class);
        fromPersona=criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona);
        
        //la clase predicate permite agregar varios criterios dinamicamente
        
        List<Predicate> criterios=new ArrayList<Predicate>();
        
        //verificamos si tenemos criterios que agregar
        
        Integer idPersonaParam=12;
        ParameterExpression<Integer> parameter=cb.parameter(Integer.class, "idPersona");
        criterios.add(cb.equal(fromPersona.get("idPersona"), parameter));
        //se agregan los criterios
        
        if (criterios.isEmpty()){
        throw new RuntimeException ("Sin Criterios");
        }
        else if (criterios.size()==1){
        criteriaQuery.where(criterios.get(0));
        }
        else{
        criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0])));
        }
        query=em.createQuery(criteriaQuery);
        query.setParameter("idPersona", idPersonaParam);
         //se ejecuta el query
         persona=query.getSingleResult();
         log.debug(persona);
        
    }
    private static void mostrarPersonas(List<Persona> personas){
    for (Persona p:personas){
    log.debug(p);
            }
    }
        
        
        
                
        
        
    }
            
    

