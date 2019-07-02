/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Dao.JuicioEvaluativoDao;
import Model.JuicioEvalutivo;
import Model.Persona;
import Persistence.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Johan
 */
public class JuicioEvaluativoBusiness implements JuicioEvaluativoDao {

    @Override
    public JuicioEvaluativo crearJuicioEvaluativo (JuicioEvaluativo jucioEvaluativoCrear){
        Session session = null;
        try {
            java.sql.Date fechaActual = new java.sql.Date(0, 0, 0);
            juicioEvaluativoCrear.setFechaRegistro(fechaActual);
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(juicioEvaluativoCrear);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            session.getTransaction().rollback();
            juicioEvaluativoCrear = null;
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return juicioEvaluativoCrear;
    }

    @Override
    public JuicioEvaluativo consultarJuicioEvaluativoPorId(int Id) {
        Session session = null;

        JuicioEvaluativo juicioEvaluativo = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            juicioEvaluativo = (JuicioEvaluativo) session.get(JuicioEvaluativo.class, Id);

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
    public List<JuicioEvaluativo> consultarListaJuicioEvaluativo() {
        Session session = null;

        List<JuicioEvaluativo> listaJuicioEvaluativo = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Ficha");
            listaJuicioEvaluativo = (List<JuicioEvaluativo>) query.list();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {

            if (session != null) {
                session.close();
            }
        }
        return listaJuicioEvaluativo;
    }

    @Override
    public boolean modificarJuicioEvaluativo(JuicioEvaluativo juicioEvaluativoModificar) {
        Session session = null;
        JuicioEvaluativo registroActualizar = new JuicioEvaluativo();
        boolean resultado = false;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();
            registroActualizar.setCupo(juicioEvaluativoModificar.getCupo());//arreglar
            registroActualizar.setEvidenciaAprendizaje(juicioEvaluativoModificar.getEVidenciaAprendizaje());
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
    public boolean eliminarJuicioEvaluativo(JuicioEvaluativo juicioEvaluativoEliminar) {
        Session session = null;
        boolean resultado = false;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(juicioEvaluativoEliminar);
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

