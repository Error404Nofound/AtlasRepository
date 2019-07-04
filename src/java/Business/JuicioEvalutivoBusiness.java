/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Dao.JuicioEvalutivoDao;
import Model.JuicioEvalutivo;
import Model.Persona;
import Persistence.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author asus
 */
public class JuicioEvalutivoBusiness implements JuicioEvalutivoDao {

    @Override
    public JuicioEvalutivo crearJuicioEvalutivo (JuicioEvalutivo jucioEvalutivoCrear){
        Session session = null;
        try {
            java.sql.Date fechaActual = new java.sql.Date(0, 0, 0);
            jucioEvalutivoCrear.setFechaJuicioEvaluativo(fechaActual);
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(jucioEvalutivoCrear);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            session.getTransaction().rollback();
            jucioEvalutivoCrear = null;
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return jucioEvalutivoCrear;
    }

    @Override
    public JuicioEvalutivo consultarJuicioEvalutivoPorId(int Id) {
        Session session = null;

        JuicioEvalutivo juicioEvaluativo = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            juicioEvaluativo = (JuicioEvalutivo) session.get(JuicioEvalutivo.class, Id);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return juicioEvaluativo;
    }

    @Override
    public List<JuicioEvalutivo> consultarListaJuicioEvalutivo() {
        Session session = null;

        List<JuicioEvalutivo> listaJuicioEvalutivo = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from JuicioEvalutivo");
            listaJuicioEvalutivo = (List<JuicioEvalutivo>) query.list();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {

            if (session != null) {
                session.close();
            }
        }
        return listaJuicioEvalutivo;
    }

    @Override
    public boolean modificarJuicioEvalutivo(JuicioEvalutivo juicioEvalutivoModificar) {
        Session session = null;
        JuicioEvalutivo registroActualizar = new JuicioEvalutivo();
        boolean resultado = false;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();
            registroActualizar.setFechaJuicioEvaluativo(juicioEvalutivoModificar.getFechaJuicioEvaluativo());//completar todos los campos
            registroActualizar.setEvidenciaAprendizaje(juicioEvalutivoModificar.getEvidenciaAprendizaje());
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
    public boolean eliminarJuicioEvalutivo(JuicioEvalutivo juicioEvalutivoEliminar) {
        Session session = null;
        boolean resultado = false;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(juicioEvalutivoEliminar);
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
