package Model;
// Generated 29-may-2019 19:08:18 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Competencia generated by hbm2java
 */
public class Competencia  implements java.io.Serializable {


     private Integer idCompetencia;
     private ProgramaDeFormacion programaDeFormacion;
     private String nombreCompetencia;
     private String descripcion;
     private String estado;
     private Date fechaRegistro;
     private Set<ResultadoAprendizaje> resultadoAprendizajes = new HashSet<ResultadoAprendizaje>(0);

    public Competencia() {
    }

	
    public Competencia(ProgramaDeFormacion programaDeFormacion, String nombreCompetencia, String estado) {
        this.programaDeFormacion = programaDeFormacion;
        this.nombreCompetencia = nombreCompetencia;
        this.estado = estado;
    }
    public Competencia(ProgramaDeFormacion programaDeFormacion, String nombreCompetencia, String descripcion, String estado, Date fechaRegistro, Set<ResultadoAprendizaje> resultadoAprendizajes) {
       this.programaDeFormacion = programaDeFormacion;
       this.nombreCompetencia = nombreCompetencia;
       this.descripcion = descripcion;
       this.estado = estado;
       this.fechaRegistro = fechaRegistro;
       this.resultadoAprendizajes = resultadoAprendizajes;
    }
   
    public Integer getIdCompetencia() {
        return this.idCompetencia;
    }
    
    public void setIdCompetencia(Integer idCompetencia) {
        this.idCompetencia = idCompetencia;
    }
    public ProgramaDeFormacion getProgramaDeFormacion() {
        return this.programaDeFormacion;
    }
    
    public void setProgramaDeFormacion(ProgramaDeFormacion programaDeFormacion) {
        this.programaDeFormacion = programaDeFormacion;
    }
    public String getNombreCompetencia() {
        return this.nombreCompetencia;
    }
    
    public void setNombreCompetencia(String nombreCompetencia) {
        this.nombreCompetencia = nombreCompetencia;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public Set<ResultadoAprendizaje> getResultadoAprendizajes() {
        return this.resultadoAprendizajes;
    }
    
    public void setResultadoAprendizajes(Set<ResultadoAprendizaje> resultadoAprendizajes) {
        this.resultadoAprendizajes = resultadoAprendizajes;
    }




}

