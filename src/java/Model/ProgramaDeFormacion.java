package Model;
// Generated 29-may-2019 19:08:18 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * ProgramaDeFormacion generated by hbm2java
 */
public class ProgramaDeFormacion  implements java.io.Serializable {


     private Integer idPrograma;
     private String nombrePrograma;
     private int duracionMeses;
     private String descripcionPrograma;
     private String tipoPrograma;
     private String estado;
     private int idUsuarioModifica;
     private String nombreUsuarioModifica;
     private Set<Competencia> competencias = new HashSet<Competencia>(0);
     private Set<Ficha> fichas = new HashSet<Ficha>(0);

    public ProgramaDeFormacion() {
    }

	
    public ProgramaDeFormacion(String nombrePrograma, int duracionMeses, String tipoPrograma, String estado, int idUsuarioModifica, String nombreUsuarioModifica) {
        this.nombrePrograma = nombrePrograma;
        this.duracionMeses = duracionMeses;
        this.tipoPrograma = tipoPrograma;
        this.estado = estado;
        this.idUsuarioModifica = idUsuarioModifica;
        this.nombreUsuarioModifica = nombreUsuarioModifica;
    }
    public ProgramaDeFormacion(String nombrePrograma, int duracionMeses, String descripcionPrograma, String tipoPrograma, String estado, int idUsuarioModifica, String nombreUsuarioModifica, Set<Competencia> competencias, Set<Ficha> fichas) {
       this.nombrePrograma = nombrePrograma;
       this.duracionMeses = duracionMeses;
       this.descripcionPrograma = descripcionPrograma;
       this.tipoPrograma = tipoPrograma;
       this.estado = estado;
       this.idUsuarioModifica = idUsuarioModifica;
       this.nombreUsuarioModifica = nombreUsuarioModifica;
       this.competencias = competencias;
       this.fichas = fichas;
    }
   
    public Integer getIdPrograma() {
        return this.idPrograma;
    }
    
    public void setIdPrograma(Integer idPrograma) {
        this.idPrograma = idPrograma;
    }
    public String getNombrePrograma() {
        return this.nombrePrograma;
    }
    
    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }
    public int getDuracionMeses() {
        return this.duracionMeses;
    }
    
    public void setDuracionMeses(int duracionMeses) {
        this.duracionMeses = duracionMeses;
    }
    public String getDescripcionPrograma() {
        return this.descripcionPrograma;
    }
    
    public void setDescripcionPrograma(String descripcionPrograma) {
        this.descripcionPrograma = descripcionPrograma;
    }
    public String getTipoPrograma() {
        return this.tipoPrograma;
    }
    
    public void setTipoPrograma(String tipoPrograma) {
        this.tipoPrograma = tipoPrograma;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public int getIdUsuarioModifica() {
        return this.idUsuarioModifica;
    }
    
    public void setIdUsuarioModifica(int idUsuarioModifica) {
        this.idUsuarioModifica = idUsuarioModifica;
    }
    public String getNombreUsuarioModifica() {
        return this.nombreUsuarioModifica;
    }
    
    public void setNombreUsuarioModifica(String nombreUsuarioModifica) {
        this.nombreUsuarioModifica = nombreUsuarioModifica;
    }
    public Set<Competencia> getCompetencias() {
        return this.competencias;
    }
    
    public void setCompetencias(Set<Competencia> competencias) {
        this.competencias = competencias;
    }
    public Set<Ficha> getFichas() {
        return this.fichas;
    }
    
    public void setFichas(Set<Ficha> fichas) {
        this.fichas = fichas;
    }




}


