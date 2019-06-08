
package Business;

import Dao.UsuarioDao;
import Model.Usuario;
import Persistence.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Johan
 */
public class UsuarioBusiness  implements UsuarioDao{

    @Override
    public Usuario crearUsuario(Usuario usuarioCrear) {
                     Session session = null;
        try
        {
            java.sql.Date fechaActual = new java.sql.Date(0, 0, 0);
             
            usuarioCrear.setFechaModificacio(fechaActual);
            usuarioCrear.setFechaContrasena(fechaActual);
            
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(usuarioCrear);
            session.flush();
            session.getTransaction().commit();
        }catch(Exception ex)
        {
            System.err.println(ex.getMessage());
            session.getTransaction().rollback();
            usuarioCrear = null;
        }finally
        {
            if(session !=null)
            {
                session.close();
            }
        }
        
        return usuarioCrear;
    }

    @Override
    public Usuario consultarUsuarioPorId(int idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listaUsuarios() {
       Session session = null;
        
        List <Usuario> listaUsuario = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM Usuario");
            listaUsuario = (List<Usuario>) query.list();
            
            
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }finally
        {
        
            if(session !=null){
                session.close();
            }
        }
        return listaUsuario;
    }

    @Override
    public boolean eliminarUsuario(Usuario usuarioEliminar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
