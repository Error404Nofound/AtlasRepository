
package Bean;


import Business.UsuarioBusiness;
import Dao.UsuarioDao;
import Model.Usuario;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author camel
 */
@ManagedBean
@ViewScoped

public class UsuarioBean {
    
    List<Usuario> listaUsuarios;
    private Usuario usuario;
    
    public UsuarioBean() {
        usuario = new Usuario();
    }

    public List<Usuario> getListaUsuarios() {
        UsuarioDao usuarioNegocio = new UsuarioBusiness();
        this.listaUsuarios = usuarioNegocio.listaUsuarios();
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    public void crearUsuario() throws IOException{
    
        UsuarioDao usuarioNegocio = new UsuarioBusiness();
        Usuario usuarioLogeado = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
        Usuario usuarioCreado = new Usuario();
        
        usuario.setIdUsuarioModifica(usuarioLogeado.getIdUsuario());
//        persona.setNombreUsuarioModifica(usuarioLogeado.getPersona().getPrimerNombre());
        usuarioCreado = usuarioNegocio.crearUsuario(usuario);
        if(usuarioCreado != null)
        {
           FacesContext.getCurrentInstance().getExternalContext().redirect("CrearUsuario.xhtml");
        }
        
    }
    
     
}
