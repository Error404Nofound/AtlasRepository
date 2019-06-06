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
import org.hibernate.Session;

/**
 *
 * @author Asus
 */
public class TrimestreBusiness implements TrimestreDao {

    @Override
    public Trimestre crearTrimestre(Trimestre trimestreCrear) {
        Session session = null;
        
        try
        {
            java.sql.Date fechaActual = new java.sql.Date(0, 0, 0);
            
            trimestreCrear.setFechaModificacio(fechaActual);
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(trimestreCrear);
            session.getTransaction().commit();
        }catch(Exception ex)
        {
            System.err.println(ex.getMessage());
            session.getTransaction().rollback();
            trimestreCrear = null;
        }finally
        {
            if(session !=null)
            {
                session.close();
            }
        }
        
        return trimestreCrear;
    
    }

    @Override
    
    public Trimestre consultarTrimestrePorId(int idTrimestre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Trimestre> listaTrimestre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarTrimestre(Trimestre trimestreModificar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarTrimestre(Trimestre trimestreEliminar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
