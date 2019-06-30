/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Business.CompetenciaBusiness;
import Business.ProgramaDeFormacionBusiness;
import Dao.CompetenciaDao;
import Dao.ProgramaDeFormacionDao;
import Model.Competencia;
import Model.ProgramaDeFormacion;
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
public class CompetenciaBean {

    /**
     * Creates a new instance of FichaBean
     */
    List<Competencia> listaCompetencias;
    private List<ProgramaDeFormacion> ListaProgramas;
    private Competencia competencia;
    private String IdProgramaFormacion;

    // Constructor de la clase 
    public CompetenciaBean() {
        competencia = new Competencia();
    }

    public void crearCompetencia() throws IOException {

        CompetenciaDao competenciaNegocio = new CompetenciaBusiness();
        // se instancia el business de programa de formacion para llamar al metodo que consulta por id
        ProgramaDeFormacionDao programaNegocio = new ProgramaDeFormacionBusiness();
        // Se crea un objeto de tipo programa de formación
        ProgramaDeFormacion programa = new ProgramaDeFormacion();
        // Se hace la consulta y el resultado se guarda en el objeto anteriormente declarado
        programa = programaNegocio.consultarProgramaDeFormacionPorId(Integer.parseInt(IdProgramaFormacion));
        // El programa que se habia consultado, se agrega a la ficha para que funcione la llave foranea
        competencia.setProgramaDeFormacion(programa);
        // Se crea un objeto de tipo ficha que contendrá los datos de la ficha que se guarde en la bd
        Competencia competenciaCreada = new Competencia();

        competenciaCreada = competenciaNegocio.crearCompetencia(competencia);
        if (competenciaCreada.getIdCompetencia() != 0) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("CrearCompetencia.xhtml");
        }
    }

    // Este metodo es llamado desde la vista, lo unico que hace es redireccionar a la vista de modificacion
    public void redireccionarModificarCompetencia() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("ModificarCompetencia.xhtml");
    }
    //no funciona
    public void modificarCompetencia(Competencia competenciaModificar) throws IOException {
        CompetenciaDao competenciaNegocio = new CompetenciaBusiness();
        // Se crea un objeto de tipo programa de formación
        ProgramaDeFormacion programa = new ProgramaDeFormacion();
        // se instancia el business de programa de formacion para llamar al metodo que consulta por id
        ProgramaDeFormacionDao programaNegocio = new ProgramaDeFormacionBusiness();
        // Se hace la consulta y el resultado se guarda en el objeto anteriormente declarado
        programa = programaNegocio.consultarProgramaDeFormacionPorId(Integer.parseInt(IdProgramaFormacion));
        // El programa que se habia consultado, se agrega a la ficha para que funcione la llave foranea
        competenciaModificar.setProgramaDeFormacion(programa);
        // se declara una variable de tipo boolean que se declara como falso
        boolean resultadoActualizacion = false;
        // Se llama al metodo que hace la actualización, si la actualización fue exitosa la variable resultadoActualizacion
        //quedará con el valor true o verdadero
        resultadoActualizacion = competenciaNegocio.modificarCompetencia(competenciaModificar);
        if (resultadoActualizacion == true) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("AdministrarCompetencia.xhtml");
        }
    }

    public void eliminarCompetencia(Competencia competenciaEliminar) throws IOException {
        CompetenciaDao competenciaNegocio = new CompetenciaBusiness();
        boolean resultado = competenciaNegocio.eliminarCompetencia(competenciaEliminar);
        if (resultado) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("AdministrarFicha.xhtml");
        }
    }

    public List<Competencia> getListaCompetencias() {
        CompetenciaDao competenciaNegocio= new CompetenciaBusiness();
        listaCompetencias = competenciaNegocio.consultarListaCompetencia();
        return listaCompetencias;
    }

    public void setListaCompetencias(List<Competencia> listaCompetencias) {
        this.listaCompetencias = listaCompetencias;
    }

    public List<ProgramaDeFormacion> getListaProgramas() {
        return ListaProgramas;
    }

    public void setListaProgramas(List<ProgramaDeFormacion> ListaProgramas) {
        this.ListaProgramas = ListaProgramas;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public String getIdProgramaFormacion() {
        return IdProgramaFormacion;
    }

    public void setIdProgramaFormacion(String IdProgramaFormacion) {
        this.IdProgramaFormacion = IdProgramaFormacion;
    }
    
}