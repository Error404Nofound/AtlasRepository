/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Business.PersonaBusiness;
import Business.UsuarioBusiness;
import Dao.PersonaDao;
import Dao.UsuarioDao;
import Model.Persona;
import Model.Usuario;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Johan
 */
@ManagedBean
@ViewScoped
public class PersonaBean {

    /**
     * Creates a new instance of BeanPersona
     */
    List<Persona> listaPersonas;
    private Persona persona;
    
    public PersonaBean() {
        
        persona = new Persona();
    }
    
    
    public void crearPersona() throws IOException{
    
        PersonaDao personaNegocio = new PersonaBusiness();
        Usuario usuarioLogeado = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
        Persona personaCreada = new Persona();
        persona.setIdUsuarioModifica(usuarioLogeado.getIdUsuario());
//        persona.setNombreUsuarioModifica(usuarioLogeado.getPersona().getPrimerNombre());
        personaCreada = personaNegocio.crearPersona(persona);
        if(personaCreada != null)
        {
           FacesContext.getCurrentInstance().getExternalContext().redirect("CrearPersona.xhtml");
        }
        
    }
    
    public void modificarPersona(){
        
        int val = 1;
        if( persona.getNumeroDocumento()!=""){
            // Se instancia el business
            PersonaDao personaNegocio = new PersonaBusiness();
            // Se llama al metodo que modifica y se le pasa por parametro el registro con los nuevos valores
            personaNegocio.modificarPersona(persona);
            persona = new Persona();
        }
    }
    
    public void eliminarPersona(Persona personaEliminar) throws IOException {
        PersonaDao personaNegocio = new PersonaBusiness();
        boolean resultado = personaNegocio.eliminarPersona(personaEliminar);
        if (resultado) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("AdministrarPersona.xhtml");
        }
    }
    
    // Metodos Get y Set de Persona
    public List<Persona> getListaPersonas() {
        PersonaDao personaNegocio = new PersonaBusiness();
        this.listaPersonas = personaNegocio.listaPersonas();
        return listaPersonas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }//listo

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
