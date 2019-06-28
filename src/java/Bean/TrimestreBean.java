/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Business.TrimestreBusiness;
import Dao.TrimestreDao;
import Model.Trimestre;
import Business.FichaBusiness;
import Dao.FichaDao;
import Model.Ficha;
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
    
    /**
     * Creates a new instance of FichaBean
     */
    List<Trimestre> listaTrimestre;
    private List<Ficha> listaFicha;
    private Trimestre trimestre;
    private String IdFicha;
    
    // Constructor de la clase 
    public TrimestreBean () {
    trimestre =new Trimestre();
    }
    
    public void crearTrimetre() throws IOException{
    
    TrimestreDao trimestreNegocio = new TrimestreBusiness();
    // se instancia el business de trimestre para llamar al metodo que consulta por id
    FichaDao fichaNegocio = new FichaBusiness();
        // Se crea un objeto de tipo programa de formación
        Ficha ficha = new Ficha();
        // Se hace la consulta y el resultado se guarda en el objeto anteriormente declarado
        ficha = fichaNegocio.consultarFichaPorId(Integer.parseInt(IdFicha));
        // El programa que se habia consultado, se agrega a la ficha para que funcione la llave foranea
        trimestre.setFicha(ficha);
        // Se crea un objeto de tipo ficha que contendrá los datos de la ficha que se guarde en la bd
        Trimestre trimestreCreado = new Trimestre();

        trimestreCreado = trimestreNegocio.crearTrimestre(trimestre);
        if (trimestreCreado.getIdTrimestre() != 0) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("CrearTrimestre.xhtml");
        }
    }
    
    // Este metodo es llamado desde la vista, lo unico que hace es redireccionar a la vista de modificacion
    public void redireccionarModificarTrimestre() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("ModificarTrimestre.xhtml");
    }
    //no funciona
    public void modificarTrimestre(Trimestre trimestreModificar) throws IOException {
        TrimestreDao trimestreNegocio = new TrimestreBusiness();
        // Se crea un objeto de tipo ficha
        Ficha ficha = new Ficha();
        // se instancia el business de ficha para llamar al metodo que consulta por id
        FichaDao fichaNegocio = new FichaBusiness();
        // Se hace la consulta y el resultado se guarda en el objeto anteriormente declarado
        ficha = fichaNegocio.consultarFichaPorId(Integer.parseInt(IdFicha));
        // La ficha que se habia consultado, se agrega a la ficha para que funcione la llave foranea
        trimestreModificar.setFicha(ficha);
        // se declara una variable de tipo boolean que se declara como falso
        boolean resultadoActualizacion = false;
        // Se llama al metodo que hace la actualización, si la actualización fue exitosa la variable resultadoActualizacion
        //quedará con el valor true o verdadero
        resultadoActualizacion = trimestreNegocio.modificarTrimestre(trimestreModificar);
        if (resultadoActualizacion == true) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("AdministrarFicha.xhtml");
        }
    }

    public void eliminarTrimestre(Trimestre trimestreEliminar) throws IOException {
        TrimestreDao trimestreNegocio = new TrimestreBusiness();
        boolean resultado = trimestreNegocio.eliminarTrimestre(trimestreEliminar);
        if (resultado) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("AdministrarTrimestre.xhtml");
        }
    }

    // Metodos Get y Set arreglarlos
    public Trimestre getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Trimestre trimestre) {
        this.trimestre = trimestre;
    }
}// fin de la clases trimestreBean
