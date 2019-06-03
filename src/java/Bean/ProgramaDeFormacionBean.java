/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Business.ProgramaDeFormacionBusiness;
import Dao.ProgramaDeFormacionDao;
import Model.ProgramaDeFormacion;
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

public class ProgramaDeFormacionBean {

    //crear una nueva instancia de programa de formacion bean
    
    List<ProgramaDeFormacion> listaProgramaDeFormacion;

    private ProgramaDeFormacion programaDeFormacion;

    public ProgramaDeFormacionBean() {
        
        programaDeFormacion = new ProgramaDeFormacion();

    }
    
     public void crearProgramaDeFormacion() throws IOException{
    
        ProgramaDeFormacionDao programaDeFormacionNegocio = new ProgramaDeFormacionBusiness();
        Usuario usuarioLogeado = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
        ProgramaDeFormacion programaDeFormacionCreado = new ProgramaDeFormacion();
        programaDeFormacion.setIdUsuarioModifica(usuarioLogeado.getIdUsuario());
//        persona.setNombreUsuarioModifica(usuarioLogeado.getPersona().getPrimerNombre());
        programaDeFormacionCreado = programaDeFormacionNegocio.crearProgramaDeFormacion(programaDeFormacion);
        if(programaDeFormacionCreado != null)
        {
           FacesContext.getCurrentInstance().getExternalContext().redirect("CrearProgramaDeFormacion.xhtml");
        }
        
    }
        public void modificarProgramaDeFormacion(){
        
        int val = 1;
        //se convierte a entero para hacer nuestra comprobacion
        if( programaDeFormacion.getIdPrograma()!=0){
            ProgramaDeFormacionDao programaDeFormacionNegocio = new ProgramaDeFormacionBusiness();
            programaDeFormacionNegocio.modificarProgramaDeFormacion(programaDeFormacion);
            programaDeFormacion = new ProgramaDeFormacion();
        }
        
    }
    
    
    public List<ProgramaDeFormacion> getListaProgramaDeFormacion() {
        ProgramaDeFormacionDao programaDeFormacionNegocio = new ProgramaDeFormacionBusiness();
        this.listaProgramaDeFormacion = programaDeFormacionNegocio.listaProgramaDeFormacion();
        return listaProgramaDeFormacion;
    }

    public void setListaProgramasDeFormacion(List<ProgramaDeFormacion> ListaProgramasDeFormacion) {
        this.listaProgramaDeFormacion = ListaProgramasDeFormacion;
    }//listo

    public ProgramaDeFormacion getProgramaDeFormacion() {
        return programaDeFormacion;
    }

    public void setProgramaDeFormacion(ProgramaDeFormacion programaDeFormacion) {
        this.programaDeFormacion = programaDeFormacion;
    }
}
