package Model;
// Generated 29-may-2019 19:08:18 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ResultadoAprendizaje generated by hbm2java
 */
public class ResultadoAprendizaje  implements java.io.Serializable {


     private Integer idResultadoAprendizaje;
     private Competencia competencia;
     private String nombreResultado;
     private String descripcion;
     private Date fechaRegistro;
     private Set<InstructorResultadoAprendizaje> instructorResultadoAprendizajes = new HashSet<InstructorResultadoAprendizaje>(0);
     private Set<EvidenciaAprendizaje> evidenciaAprendizajes = new HashSet<EvidenciaAprendizaje>(0);

    public ResultadoAprendizaje() {
    }

	
    public ResultadoAprendizaje(Competencia competencia, String nombreResultado, String descripcion) {
        this.competencia = competencia;
        this.nombreResultado = nombreResultado;
        this.descripcion = descripcion;
    }
    public ResultadoAprendizaje(Competencia competencia, String nombreResultado, String descripcion, Date fechaRegistro, Set<InstructorResultadoAprendizaje> instructorResultadoAprendizajes, Set<EvidenciaAprendizaje> evidenciaAprendizajes) {
       this.competencia = competencia;
       this.nombreResultado = nombreResultado;
       this.descripcion = descripcion;
       this.fechaRegistro = fechaRegistro;
       this.instructorResultadoAprendizajes = instructorResultadoAprendizajes;
       this.evidenciaAprendizajes = evidenciaAprendizajes;
    }
   
    public Integer getIdResultadoAprendizaje() {
        return this.idResultadoAprendizaje;
    }
    
    public void setIdResultadoAprendizaje(Integer idResultadoAprendizaje) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
    }
    public Competencia getCompetencia() {
        return this.competencia;
    }
    
    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }
    public String getNombreResultado() {
        return this.nombreResultado;
    }
    
    public void setNombreResultado(String nombreResultado) {
        this.nombreResultado = nombreResultado;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public Set<InstructorResultadoAprendizaje> getInstructorResultadoAprendizajes() {
        return this.instructorResultadoAprendizajes;
    }
    
    public void setInstructorResultadoAprendizajes(Set<InstructorResultadoAprendizaje> instructorResultadoAprendizajes) {
        this.instructorResultadoAprendizajes = instructorResultadoAprendizajes;
    }
    public Set<EvidenciaAprendizaje> getEvidenciaAprendizajes() {
        return this.evidenciaAprendizajes;
    }
    
    public void setEvidenciaAprendizajes(Set<EvidenciaAprendizaje> evidenciaAprendizajes) {
        this.evidenciaAprendizajes = evidenciaAprendizajes;
    }




}


