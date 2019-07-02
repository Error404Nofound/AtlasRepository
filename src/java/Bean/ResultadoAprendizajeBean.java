/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Business.ResultadoAprendizajeBusiness;
import Business.CompetenciaBusiness;
import Dao.ResultadoAprendizajeDao;
import Dao.CompetenciaDao;
import Model.ResultadoAprendizaje;
import Model.Competencia;
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
public class ResultadoAprendizajeBean {
    
    /**
     * Creates a new instance of FichaBean
     */
    List<ResultadoAprendizaje> listaResultadoAprendizaje;
    private List<ResultadoAprendizaje> ListaResultadoAprendizaje;
    private ResultadoAprendizaje resultadoAprendizaje;
    private String IdCompetencia;
    private List<Competencia> ListaCompetencia;
    
    // Constructor clase
    public ResultadoAprendizajeBean (){
        resultadoAprendizaje = new ResultadoAprendizaje();
    }
    
    public void crearResultadoAprendizaje() throws IOException {
    
    ResultadoAprendizajeDao resultadoAprendizajeNegocio = new ResultadoAprendizajeBusiness();
    // se instancia el business de programa de formacion para llamar al metodo que consulta por id
    CompetenciaDao competenciaNegocio = new CompetenciaBusiness();
    // Se crea un objeto de tipo programa de formación
    Competencia competencia = new Competencia();
    // Se hace la consulta y el resultado se guarda en el objeto anteriormente declarado
    competencia = competenciaNegocio.consultarCompetenciaPorId(Integer.parseInt(IdCompetencia));
    // El programa que se habia consultado, se agrega a la ficha para que funcione la llave foranea
    resultadoAprendizaje.setCompetencia(competencia);
    // Se crea un objeto de tipo ficha que contendrá los datos de la ficha que se guarde en la bd
    ResultadoAprendizaje resultadoAprendizajeCreado = new ResultadoAprendizaje();
    
    resultadoAprendizajeCreado = resultadoAprendizajeNegocio.crearResultadoAprendizaje(resultadoAprendizaje);
    if (resultadoAprendizajeCreado.getIdResultadoAprendizaje()!=0){
        FacesContext.getCurrentInstance().getExternalContext().redirect("CrearResultadoAprendizaje.xhtml");
    }
  }
    
    // Este metodo es llamado desde la vista, lo unico que hace es redireccionar a la vista de modificacion
    public void redireccionarModificarResultadoAprendizaje() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("ModificarResultadoAprendizaje.xhtml");
    }
    
    public void modificarResultadoAprendizaje(ResultadoAprendizaje resultadoAprendizajeModificar) throws IOException{
        ResultadoAprendizajeDao resultadoAprendizajeNegocio = new ResultadoAprendizajeBusiness();
        // Se crea un objeto de tipo programa de formación
        Competencia competencia = new Competencia();
        // se instancia el business de programa de formacion para llamar al metodo que consulta por id
        CompetenciaDao competenciaNegocio =new CompetenciaBusiness();
        // Se hace la consulta y el resultado se guarda en el objeto anteriormente declarado
        competencia = competenciaNegocio.consultarCompetenciaPorId(Integer.parseInt(IdCompetencia));
        // El programa que se habia consultado, se agrega a la ficha para que funcione la llave foranea
        resultadoAprendizajeModificar.setCompetencia(competencia);
        // se declara una variable de tipo boolean que se declara como falso
        boolean resultadoActualizacion = false;
        // Se llama al metodo que hace la actualización, si la actualización fue exitosa la variable resultadoActualizacion
        //quedará con el valor true o verdadero
        resultadoActualizacion = resultadoAprendizajeNegocio.modificarResultadoAprendizaje(resultadoAprendizajeModificar);
        if (resultadoActualizacion == true) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("AdministrarResultadoAprendizaje.xhtml");
            
        }
    }
    
    public void eliminarResultadoAprendizaje(ResultadoAprendizaje resultadoAprendizajeEliminar) throws IOException {
        ResultadoAprendizajeDao resultadoAprendizajeNegocio = new ResultadoAprendizajeBusiness();
        boolean resultado = resultadoAprendizajeNegocio.eliminarResultadoAprendizaje(resultadoAprendizajeEliminar);
        if (resultado) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("AdministrarResultadoAprendizaje.xhtml");
        }
    }
    // Metodos Get y Set de ficha
    public List<ResultadoAprendizaje> getListaResultadoAprendizaje() {
        ResultadoAprendizajeDao resultadoAprendizajeNegocio = new ResultadoAprendizajeBusiness();
        listaResultadoAprendizaje = resultadoAprendizajeNegocio.consultarListaResultadoAprendizaje();
        return listaResultadoAprendizaje;
    }

    public void setListaResultadoAprendizaje(List<ResultadoAprendizaje> listaResultadoAprendizaje) {
        this.listaResultadoAprendizaje = listaResultadoAprendizaje;
    }

       public ResultadoAprendizaje getResultadoAprendizaje() {
        return resultadoAprendizaje;
    }

    public void setResultadoAprendizaje(ResultadoAprendizaje resultadoAprendizaje) {
        this.resultadoAprendizaje = resultadoAprendizaje;
    }

    public String getIdCompetencia() {
        return IdCompetencia;
    }

    public void setIdCompetencia(String IdCompetencia) {
        this.IdCompetencia = IdCompetencia;
    }

    public List<Competencia> getListaCompetencia() {
        // Se crea la instacia del Negocio de programa de formación para consultar el listado
        CompetenciaDao competenciaNegocio = new CompetenciaBusiness();
        // Se guarda la lista de programas en la lista global de programas
        ListaCompetencia = competenciaNegocio.listaCompetencia();
        
        return ListaCompetencia;
    }

    public void setListaCompetencia(List<Competencia> ListaCompetencia) {
        this.ListaCompetencia = ListaCompetencia;
    }
}
