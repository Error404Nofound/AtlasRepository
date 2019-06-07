
package Bean;

import Business.PersonaBusiness;
import Dao.PersonaDao;
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
            PersonaDao personaNegocio = new PersonaBusiness();
            personaNegocio.modificarPersona(persona);
            persona = new Persona();
        }
        
    }
    
    
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
