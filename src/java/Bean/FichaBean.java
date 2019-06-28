/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Business.FichaBusiness;
import Business.ProgramaDeFormacionBusiness;
import Dao.FichaDao;
import Dao.ProgramaDeFormacionDao;
import Model.Ficha;
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
public class FichaBean {

    /**
     * Creates a new instance of FichaBean
     */
    List<Ficha> listaFichas;
    private List<ProgramaDeFormacion> ListaProgramas;
    private Ficha ficha;
    private String IdProgramaFormacion;

    // Constructor de la clase 
    public FichaBean() {
        ficha = new Ficha();
    }

    public void crearFicha() throws IOException {

        FichaDao fichaNegocio = new FichaBusiness();
        // se instancia el business de programa de formacion para llamar al metodo que consulta por id
        ProgramaDeFormacionDao programaNegocio = new ProgramaDeFormacionBusiness();
        // Se crea un objeto de tipo programa de formación
        ProgramaDeFormacion programa = new ProgramaDeFormacion();
        // Se hace la consulta y el resultado se guarda en el objeto anteriormente declarado
        programa = programaNegocio.consultarProgramaDeFormacionPorId(Integer.parseInt(IdProgramaFormacion));
        // El programa que se habia consultado, se agrega a la ficha para que funcione la llave foranea
        ficha.setProgramaDeFormacion(programa);
        // Se crea un objeto de tipo ficha que contendrá los datos de la ficha que se guarde en la bd
        Ficha fichaCreada = new Ficha();

        fichaCreada = fichaNegocio.crearFicha(ficha);
        if (fichaCreada.getIdFicha() != 0) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("CrearFicha.xhtml");
        }
    }

    // Este metodo es llamado desde la vista, lo unico que hace es redireccionar a la vista de modificacion
    public void redireccionarModificarFicha() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("ModificarFicha.xhtml");
    }
    //no funciona
    public void modificarFicha(Ficha fichaModificar) throws IOException {
        FichaDao fichaNegocio = new FichaBusiness();
        // Se crea un objeto de tipo programa de formación
        ProgramaDeFormacion programa = new ProgramaDeFormacion();
        // se instancia el business de programa de formacion para llamar al metodo que consulta por id
        ProgramaDeFormacionDao programaNegocio = new ProgramaDeFormacionBusiness();
        // Se hace la consulta y el resultado se guarda en el objeto anteriormente declarado
        programa = programaNegocio.consultarProgramaDeFormacionPorId(Integer.parseInt(IdProgramaFormacion));
        // El programa que se habia consultado, se agrega a la ficha para que funcione la llave foranea
        fichaModificar.setProgramaDeFormacion(programa);
        // se declara una variable de tipo boolean que se declara como falso
        boolean resultadoActualizacion = false;
        // Se llama al metodo que hace la actualización, si la actualización fue exitosa la variable resultadoActualizacion
        //quedará con el valor true o verdadero
        resultadoActualizacion = fichaNegocio.modificarFicha(fichaModificar);
        if (resultadoActualizacion == true) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("AdministrarFicha.xhtml");
        }
    }

    public void eliminarFicha(Ficha fichaEliminar) throws IOException {
        FichaDao fichaNegocio = new FichaBusiness();
        boolean resultado = fichaNegocio.eliminarFicha(fichaEliminar);
        if (resultado) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("AdministrarFicha.xhtml");
        }
    }

    // Metodos Get y Set
    public List<Ficha> getListaFichas() {
        FichaDao fichaNegocio = new FichaBusiness();
        listaFichas = fichaNegocio.consultarListaFicha();
        return listaFichas;
    }

    public void setListaFichas(List<Ficha> listaFichas) {
        this.listaFichas = listaFichas;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public String getIdProgramaFormacion() {
        return IdProgramaFormacion;
    }

    public void setIdProgramaFormacion(String IdProgramaFormacion) {
        this.IdProgramaFormacion = IdProgramaFormacion;
    }

    public List<ProgramaDeFormacion> getListaProgramas() {

        // Se crea la instaci del Negocio de programa de formación para consultar el listado
        ProgramaDeFormacionDao programaNegocio = new ProgramaDeFormacionBusiness();
        // Se guarda la lista de programas en la lista global de programas
        ListaProgramas = programaNegocio.listaProgramaDeFormacion();
        return ListaProgramas;
    }

    public void setListaProgramas(List<ProgramaDeFormacion> ListaProgramas) {
        this.ListaProgramas = ListaProgramas;
    }

}
