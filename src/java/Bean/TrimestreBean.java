
package Bean;

import Business.TrimestreBusiness;
import Dao.TrimestreDao;
import Model.Trimestre;
import Model.Usuario;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Asus
 */
@ManagedBean
@ViewScoped
public class TrimestreBean {
    
    
    List<Trimestre> listaTrimestre;
    private Trimestre trimestre;
    
    public TrimestreBean () {
    trimestre =new Trimestre();
    
    }// fin de trimestre beans()
    
    public void crearTrimetre() throws IOException{
    
    TrimestreDao trimestreNegocio = new TrimestreBusiness();
    Usuario usuarioLogeado =  (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
    Trimestre trimestreCreada = new Trimestre();
    trimestre.setIdUsuarioModifica(usuarioLogeado.getIdUsuario());
//        persona.setNombreUsuarioModifica(usuarioLogeado.getPersona().getPrimerNombre());
        trimestreCreada = trimestreNegocio.crearTrimestre(trimestre);
        if(trimestreCreada != null)
        {
           FacesContext.getCurrentInstance().getExternalContext().redirect("CrearTrimestre.xhtml");
        }
    }
    
    public void modificarTrimestre(){
        
        int val = 1;
        if( trimestre.getIdTrimestre()!=0){
            TrimestreDao trimestreNegocio = new TrimestreBusiness();
            trimestreNegocio.modificarTrimestre(trimestre);
            trimestre = new Trimestre();
        }
    }  
    
    public List<Trimestre> getlistaTrimestre(){
    
    TrimestreDao trimestreNegocio = new TrimestreBusiness();
        this.listaTrimestre = trimestreNegocio.listaTrimestre();
        return listaTrimestre;
    }
    
    public void setListaTrimestre(List<Trimestre> listaTrimestre) {
        this.listaTrimestre = listaTrimestre;
    }//listo

    public Trimestre getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Trimestre trimestre) {
        this.trimestre = trimestre;
    }
}// fin de la clases trimestreBean
