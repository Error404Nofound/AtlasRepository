/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Dao.TrimestreDao;
import Model.Trimestre;
import Persistence.NewHibernateUtil;
import java.util.List;
import Model.Persona;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Asus
 */
public class TrimestreBusiness implements TrimestreDao {

    @Override
    public Trimestre crearTrimestre(Trimestre trimestreCrear) {
        Session session = null;
        try{
            java.sql.Date fechaActual = new java.sql.Date(0, 0, 0);
            trimestreCrear.setFechaModificacio(fechaActual);
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(trimestreCrear);
            session.getTransaction().commit();
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
            session.getTransaction().rollback();
            trimestreCrear = null;
        } finally {
            if (session !=null) {
                session.close();
            }
        }
        
        return trimestreCrear;
    }

    @Override
    public Trimestre consultarTrimestrePorId(int idTrimestre) {
        Session session = null;
        
        Trimestre trimestre = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            trimestre  = (Trimestre) session.get(Trimestre.class,idTrimestre);
            
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }finally
        {
            if(session !=null && session.isOpen()){
                session.close();
            }
        }
        return trimestre;
    }

    @Override
    public List<Trimestre> listaTrimestre() {
        Session session = null;
        
        List <Trimestre> listaTrimestre = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Trimestre");
            listaTrimestre = (List<Trimestre>) query.list();
            
            
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }finally
        {
        
            if(session !=null){
                session.close();
            }
        }
        return listaTrimestre;
    }

    @Override
    public boolean modificarTrimestre(Trimestre trimestreModificar) {
        Session session = null;
        
        Trimestre registroActualizar = new Trimestre();
        boolean resultado = false;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            
            session.beginTransaction();
            registroActualizar.setFechaInicio(trimestreModificar.getFechaInicio());
            registroActualizar.setFechaFin(trimestreModificar.getFechaFin());
            registroActualizar.setNumeroTrimestre(trimestreModificar.getNumeroTrimestre());
            registroActualizar.setFicha(trimestreModificar.getFicha());
            
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

    @Override
    public boolean eliminarTrimestre(Trimestre trimestreEliminar) {
        Session session = null;
        boolean resultado = false;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(trimestreEliminar);
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

    @Override
    public List<Trimestre> consultarListaTrimestre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
