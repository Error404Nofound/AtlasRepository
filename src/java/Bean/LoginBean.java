/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Business.LoginBusiness;
import Dao.LoginDao;
import Model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Johan
 */
@ManagedBean
@RequestScoped
public class LoginBean {

    /**
     * Creates a new instance of LoginBean
     */
    private Usuario usuario;

    public LoginBean() {

        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Metodo llamado desde la vista al presionar el botón de iniciar sesión
    public void autenticarUsuario() {

        //Se hace la instancia del la clase business (negocio-logica)
        LoginDao instanciaNegocioLogin = new LoginBusiness();
        //la llamada al metodo de autenticació se encapsula en el try catch
        try {

            if (usuario.getContrasena() != "" || usuario.getDocumentoUsuario() != "") {
                // Se hace llamado al metodo autenticarUsuario, de la clase LoginBusiness haciendo uso del objeto instaciado anteriormente
                // se envia el numero de documento y la contraseña, haciendo uso del get(Traer - obtener) que tendrá los valores ingresados por el usuario
                // el resultado de la llamada al metodo será un objeto llamado usuario, el que contiene los datos de la consulta
                usuario = instanciaNegocioLogin.autenticarUsuario(this.usuario.getDocumentoUsuario(), this.usuario.getContrasena());
                //Si el usuario es diferente de nulo (es decir que se consulto en la base y si existe)
                if (usuario != null) {
                    //Se guarda en la variable de sesión el objeto usuario
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
                    // Se redirecciona a la vista index
                    FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
                }
            }else{
                FacesContext.getCurrentInstance().getExternalContext().redirect("Login.xhtml");
            }

        } catch (Exception e) {
        }
    }
}
