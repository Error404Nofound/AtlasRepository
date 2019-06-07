
package Dao;

import Model.Usuario;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface UsuarioDao {
       
    public Usuario crearUsuario(Usuario usuarioCrear);
    public Usuario consultarUsuarioPorId(int idUsuario);
    public List<Usuario> listaUsuarios();
    public boolean eliminarUsuario(Usuario usuarioEliminar); 
}
