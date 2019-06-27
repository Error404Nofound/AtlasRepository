/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Dao.FichaDao;
import Model.Ficha;
import Model.Persona;
import Persistence.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Johan
 */
public class FichaBusiness implements FichaDao {

    @Override
    public Ficha crearFicha(Ficha fichaCrear) {
        Session session = null;
        try {
            java.sql.Date fechaActual = new java.sql.Date(0, 0, 0);
            fichaCrear.setFechaRegistro(fechaActual);
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(fichaCrear);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            session.getTransaction().rollback();
            fichaCrear = null;
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return fichaCrear;
    }

    @Override
    public Ficha consultarFichaPorId(int Id) {
        Session session = null;

        Ficha ficha = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            ficha = (Ficha) session.get(Ficha.class, Id);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return ficha;
    }

    @Override
    public List<Ficha> consultarListaFicha() {
        Session session = null;

        List<Ficha> listaFichas = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Ficha");
            listaFichas = (List<Ficha>) query.list();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {

            if (session != null) {
                session.close();
            }
        }
        return listaFichas;
    }

    @Override
    public boolean modificarFicha(Ficha fichaModificar) {
        Session session = null;
        Ficha registroActualizar = new Ficha();
        boolean resultado = false;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();
            registroActualizar.setCupo(fichaModificar.getCupo());
            registroActualizar.setProgramaDeFormacion(fichaModificar.getProgramaDeFormacion());
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
    public boolean eliminarFicha(Ficha fichaEliminar) {
        Session session = null;
        boolean resultado = false;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(fichaEliminar);
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
