/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Dao.CompetenciaDao;
import Model.Competencia;
import Model.Persona;
import Persistence.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Asus
 */
public class CompetenciaBusiness implements CompetenciaDao {
    
    @Override
    public Competencia crearCompetencia (Competencia competenciaCrear){
    Session session = null;
        try {
            java.sql.Date fechaActual = new java.sql.Date(0, 0, 0);
            competenciaCrear.setFechaRegistro(fechaActual);
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(competenciaCrear);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            session.getTransaction().rollback();
            competenciaCrear = null;
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return competenciaCrear;
    }
    
    @Override
    public Competencia consultarCompetenciaPorId(int Id){
    Session session = null;

        Competencia competencia = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            competencia = (Competencia) session.get(Competencia.class, Id);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return competencia;
    }
    
    @Override
    public List<Competencia> consultarListaCompetencia(){
    Session session = null;

        List<Competencia> listaCompetencia = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Competencia");
            listaCompetencia = (List<Competencia>) query.list();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {

            if (session != null) {
                session.close();
            }
        }
        return listaCompetencia;
    }
    
    @Override
    public boolean modificarCompetencia (Competencia competenciaModificar){
        Session session = null;
        Competencia registroActualizar = new Competencia();
        boolean resultado = false;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();//Toca competar con los demas registros
            registroActualizar.setNombreCompetencia(competenciaModificar.getNombreCompetencia());
            registroActualizar.setProgramaDeFormacion(competenciaModificar.getProgramaDeFormacion());
            registroActualizar.setEstado(competenciaModificar.getEstado());
            registroActualizar.setDescripcion(competenciaModificar.getDescripcion());
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
    
    @Override
    public boolean eliminarCompetencia(Competencia competenciaEliminar){
        Session session = null;
        boolean resultado = false;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(competenciaEliminar);
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

    @Override
    public List<Competencia> listaCompetencia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
