package Model;
// Generated 29-may-2019 19:08:18 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * JuicioEvalutivo generated by hbm2java
 */
public class JuicioEvalutivo  implements java.io.Serializable {


     private Integer idJuicio;
     private EvidenciaAprendizaje evidenciaAprendizaje;
     private int idUsuarioAprendizaje;
     private String valorJuicio;
     private Date fechaJuicioEvaluativo;

    public JuicioEvalutivo() {
    }

	
    public JuicioEvalutivo(EvidenciaAprendizaje evidenciaAprendizaje, int idUsuarioAprendizaje, String valorJuicio) {
        this.evidenciaAprendizaje = evidenciaAprendizaje;
        this.idUsuarioAprendizaje = idUsuarioAprendizaje;
        this.valorJuicio = valorJuicio;
    }
    public JuicioEvalutivo(EvidenciaAprendizaje evidenciaAprendizaje, int idUsuarioAprendizaje, String valorJuicio, Date fechaJuicioEvaluativo) {
       this.evidenciaAprendizaje = evidenciaAprendizaje;
       this.idUsuarioAprendizaje = idUsuarioAprendizaje;
       this.valorJuicio = valorJuicio;
       this.fechaJuicioEvaluativo = fechaJuicioEvaluativo;
    }
   
    public Integer getIdJuicio() {
        return this.idJuicio;
    }
    
    public void setIdJuicio(Integer idJuicio) {
        this.idJuicio = idJuicio;
    }
    public EvidenciaAprendizaje getEvidenciaAprendizaje() {
        return this.evidenciaAprendizaje;
    }
    
    public void setEvidenciaAprendizaje(EvidenciaAprendizaje evidenciaAprendizaje) {
        this.evidenciaAprendizaje = evidenciaAprendizaje;
    }
    public int getIdUsuarioAprendizaje() {
        return this.idUsuarioAprendizaje;
    }
    
    public void setIdUsuarioAprendizaje(int idUsuarioAprendizaje) {
        this.idUsuarioAprendizaje = idUsuarioAprendizaje;
    }
    public String getValorJuicio() {
        return this.valorJuicio;
    }
    
    public void setValorJuicio(String valorJuicio) {
        this.valorJuicio = valorJuicio;
    }
    public Date getFechaJuicioEvaluativo() {
        return this.fechaJuicioEvaluativo;
    }
    
    public void setFechaJuicioEvaluativo(Date fechaJuicioEvaluativo) {
        this.fechaJuicioEvaluativo = fechaJuicioEvaluativo;
    }




}


