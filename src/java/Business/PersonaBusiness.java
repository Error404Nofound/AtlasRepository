/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Dao.PersonaDao;

import Model.Persona;
import Persistence.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Johan
 */
public class PersonaBusiness implements PersonaDao{

    @Override
    public Persona crearPersona(Persona personaCrear) {
              Session session = null;
        try
        {
            java.sql.Date fechaActual = new java.sql.Date(0, 0, 0);
            
            
            personaCrear.setFechaModificacio(fechaActual);
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(personaCrear);
            session.getTransaction().commit();
        }catch(Exception ex)
        {
            System.err.println(ex.getMessage());
            session.getTransaction().rollback();
            personaCrear = null;
        }finally
        {
            if(session !=null)
            {
                session.close();
            }
        }
        
        return personaCrear;
    }

    @Override
    public Persona consultarPersonaPorCedula(String cedula) {
             Session session = null;
        
        Persona persona = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            persona  = (Persona) session.get(Persona.class,cedula);
            
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }finally
        {
            if(session !=null && session.isOpen()){
                session.close();
            }
        }
        return persona;
    }

    @Override
    public List<Persona> listaPersonas() {
        Session session = null;
        
        List <Persona> listaPersonas = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Persona");
            listaPersonas = (List<Persona>) query.list();
            
            
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }finally
        {
        
            if(session !=null){
                session.close();
            }
        }
        return listaPersonas;
    }

    @Override
    public boolean eliminarPersona(Persona personaEliminar) {
        Session session = null;
        boolean resultado = false;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(personaEliminar);
            session.getTransaction().commit();
            resultado = true;
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
            session.getTransaction().rollback();
            
        } finally {
            if(session !=null) {
                session.close();
                
            }
        }
        return resultado;
    }

    @Override
    public boolean modificarPersona(Persona personaModificar) {
           Session session = null;
        
        Persona registroActualizar = new Persona();
        boolean resultado = false;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            
            session.beginTransaction();
            registroActualizar.setCorreo(personaModificar.getCorreo());
            registroActualizar.setPrimerNombre(personaModificar.getPrimerNombre());
            registroActualizar.setSegundoNombre(personaModificar.getSegundoNombre());
            registroActualizar.setPrimerApellido(personaModificar.getPrimerApellido());
            registroActualizar.setSegundoApellido(personaModificar.getSegundoApellido());
            registroActualizar.setGenero(personaModificar.getGenero());
            
            session.update(registroActualizar);
            session.getTransaction().commit();
            resultado = true;
        }catch(Exception ex)
        {
            System.err.println(ex.getMessage());
            session.getTransaction().rollback();
            
        }finally
        {
            if(session !=null)
            {
                session.close();
            }
        }
        return resultado;
    }
    
}
