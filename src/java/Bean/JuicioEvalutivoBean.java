/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Business.JuicioEvalutivoBusiness;
import Business.CompetenciaBusiness;
import Dao.JuicioEvalutivoDao;
import Dao.CompetenciaDao;
import Model.JuicioEvalutivo;
import Model.Competencia;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author asus
 */
@ManagedBean
@ViewScoped
public class JuicioEvalutivoBean {
    
    /**
     * Creates a new instance of JuicioEvaluativoBean 
     */
     List<JuicioEvalutivo> listaJuicioEvalutivo;
     private List<Competencia> ListaCompetencia;
     private JuicioEvalutivo juicioEvalutivo;
     private String IdCompetencia;

    // Constructor de la clase 
    public JuicioEvalutivoBean() {
        juicioEvalutivo = new JuicioEvalutivo();
        //prueba uno
    }

    public void crearJuicioEvaluativo() throws IOException {

        JuicioEvalutivoDao juicioEvaluativoNegocio = new JuicioEvalutivoBusiness();
        // se instancia el business de Juicio Evaluativo para llamar al metodo que consulta por id
        CompetenciaDao competenciaNegocio = new CompetenciaBusiness();
        // Se crea un objeto de tipo programa de formación
        Competencia competencia= new Competencia();
        // Se hace la consulta y el resultado se guarda en el objeto anteriormente declarado
        competencia = competenciaNegocio.consultarCompetenciaPorId(Integer.parseInt(IdCompetencia));
        // El programa que se habia consultado, se agrega a la juicio evaluativo para que funcione la llave foranea
        JuicioEvalutivo.setCompetencia(competencia);
        // Se crea un objeto de tipo je que contendrá los datos de la ficha que se guarde en la bd
        JuicioEvalutivo juicioEvalutivoCreado = new JuicioEvalutivo();

        juicioEvalutivoCreado = juicioEvaluativoNegocio.crearJuicioEvaluativo(JuicioEvalutivo);
        if (juicioEvalutivoCreado.getIdJuicioEvalutivo() != 0) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("CrearJuicioEvaluativo.xhtml");
        }
    }

    // Este metodo es llamado desde la vista, lo unico que hace es redireccionar a la vista de modificacion
    public void redireccionarModificarJuicioEvaluativo() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("ModificarJuicioEvaluativo.xhtml");
    }
    //fata completar
    public void modificarJuicioEvaluativo(JuicioEvalutivo juicioEvaluativoModificar) throws IOException {
        JuicioEvalutivoDao juicioEvaluativoNegocio = new JuicioEvalutivoBusiness();
        // Se crea un objeto de tipo programa de formación
        Competencia competencia = new Competencia();
        // se instancia el business de programa de formacion para llamar al metodo que consulta por id
        CompetenciaDao competenciaNegocio = new CompetenciaBusiness();
        // Se hace la consulta y el resultado se guarda en el objeto anteriormente declarado
        competencia = competenciaNegocio.consultarCompetenciaPorId(Integer.parseInt(IdCompetencia));
        // El programa que se habia consultado, se agrega a la ficha para que funcione la llave foranea
        juicioEvalutivoModificar.setCompetencia(competencia);
        // se declara una variable de tipo boolean que se declara como falso
        boolean resultadoActualizacion = false;
        // Se llama al metodo que hace la actualización, si la actualización fue exitosa la variable resultadoActualizacion
        //quedará con el valor true o verdadero
        resultadoActualizacion = juicioEvaluativoNegocio.modificarJuicioEvalutivo(juicioEvaluativoModificar);
        if (resultadoActualizacion == true) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("AdministrarJuicioEvaluativo.xhtml");
        }
    }

    public void eliminarJuicioEvaluativo(JuicioEvalutivo juicioEvaluativoEliminar) throws IOException {
        JuicioEvalutivoDao juicioEvaluativoNegocio = new JuicioEvalutivoBusiness();
        boolean resultado = juicioEvaluativoNegocio.eliminarJuicioEvalutivo(juicioEvaluativoEliminar);
        if (resultado) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("AdministrarJuicioEvalutivo.xhtml");
        }
    }

    // Metodos Get y Set de ficha
    public List<JuicioEvalutivo> getListaJuicioEvaluativo() {
        JuicioEvalutivoDao juicioEvaluativoNegocio = new JuicioEvalutivoBusiness();
        listaJuicioEvalutivo = juicioEvaluativoNegocio.consultarListaJuicioEvalutivo();
        return listaJuicioEvalutivo;
    }

    public void setListaJuicioEvaluativo(List<JuicioEvalutivo> listaJuicioEvaluativo) {
        this.listaJuicioEvalutivo = listaJuicioEvaluativo;
    }

    public JuicioEvalutivo getJuicioEvaluativo() {
        return juicioEvalutivo;
    }

    public void setJuicioEvaluativo(JuicioEvalutivo juicioEvaluativo) {
        this.juicioEvalutivo = juicioEvaluativo;
    }

    public String getIdCompetencia() {
        return IdCompetencia;
    }

    public void setIdCompetencia(String IdCompetencia) {
        this.IdCompetencia = IdCompetencia;
    }

    public List<Competencia> getListaCompetencia() {
        // Se crea la instaci del Negocio de programa de formación para consultar el listado
        CompetenciaDao competenciaNegocio = new CompetenciaBusiness();
        // Se guarda la lista de programas en la lista global de programas
        ListaCompetencia = competenciaNegocio.listaCompetencia();
        return ListaCompetencia;
    }

    public void setListaCompetencia(List<Competencia> ListaCompetencia) {
        this.ListaCompetencia = ListaCompetencia;
    }
}
