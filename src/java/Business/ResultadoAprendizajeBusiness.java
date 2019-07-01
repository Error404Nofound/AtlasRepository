/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Dao.ResultadoAprendizajeDao;
import Model.ResultadoAprendizaje;
import Model.Persona;
import Persistence.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Asus
 */
public class ResultadoAprendizajeBusiness implements ResultadoAprendizajeDao{
    
   // @override
    public ResultadoAprendizaje resultadoAprendizaje(ResultadoAprendizaje resultadoAprendizajeCrear){
      Session session = null;
      try {
           java.sql.Date fechaActual = new java.sql.Date(0, 0, 0);
           resultadoAprendizajeCrear.setFechaRegistro(fechaActual);
           session = NewHibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.save(resultadoAprendizajeCrear);
           session.getTransaction().commit();
      } catch (Exception ex) {
          System.err.println(ex.getMessage());
          session.getTransaction().rollback();
          resultadoAprendizajeCrear = null;
      } finally {
        if (session != null) {
                session.close();
            }
      }
      
       return resultadoAprendizajeCrear; 
    }
    
   // @override
    public ResultadoAprendizaje consultarResultadoAprendizajePorId (int Id){  
        Session session = null;
        
        ResultadoAprendizaje resultadoAprendizaje = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            resultadoAprendizaje = (ResultadoAprendizaje) session.get(ResultadoAprendizaje.class, Id);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
          if (session != null && session.isOpen()) {
                session.close();
        }
    }
        return resultadoAprendizaje;
    }
    
    //@override
    public List<ResultadoAprendizaje> consultarlistaResultadoAprendizaje(){
        Session session = null;
        
        List <ResultadoAprendizaje> listaResultadoAprendizaje = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from ResultadoAprendizaje");
            listaResultadoAprendizaje = (List<ResultadoAprendizaje>) query.list();
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
    } finally {

            if (session != null) {
                session.close();
            }
        }
        return listaResultadoAprendizaje;
    }
    
    //@override
    public boolean modificarResultadoAprendizaje (ResultadoAprendizaje resultadoAprendizajeModificar){
        Session session = null;
        ResultadoAprendizaje registroActualizar = new ResultadoAprendizaje();
        boolean resultado = false;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
        
            session.beginTransaction();
            registroActualizar.setNombreResultado(resultadoAprendizajeModificar.getNombreResultado());
            registroActualizar.setCompetencia(resultadoAprendizajeModificar.getCompetencia());
            session.update(registroActualizar);
            session.getTransaction().commit();
            resultado = true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            session.getTransaction().rollback();

        } finally {
            if (session != null) {
                session.close();
            } 
        }
        return resultado;
    }
    
    //@override
    public boolean eliminarResultadoAprendizaje(ResultadoAprendizaje resultadoAprendizajeEliminar){
        Session session = null;
        boolean resultado = false;
         try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(resultadoAprendizajeEliminar);
            session.getTransaction().commit();
            resultado = true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            session.getTransaction().rollback();

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return resultado;
    }
}
