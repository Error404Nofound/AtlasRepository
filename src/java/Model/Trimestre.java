package Model;
// Generated 29-may-2019 19:08:18 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Trimestre generated by hbm2java
 */
public class Trimestre  implements java.io.Serializable {


     private Integer idTrimestre;
     private Ficha ficha;
     private Date fechaInicio;
     private Date fechaFin;
     private short numeroTrimestre;

    public Trimestre() {
    }

	
    public Trimestre(Ficha ficha, short numeroTrimestre) {
        this.ficha = ficha;
        this.numeroTrimestre = numeroTrimestre;
    }
    public Trimestre(Ficha ficha, Date fechaInicio, Date fechaFin, short numeroTrimestre) {
       this.ficha = ficha;
       this.fechaInicio = fechaInicio;
       this.fechaFin = fechaFin;
       this.numeroTrimestre = numeroTrimestre;
    }
   
    public Integer getIdTrimestre() {
        return this.idTrimestre;
    }
    
    public void setIdTrimestre(Integer idTrimestre) {
        this.idTrimestre = idTrimestre;
    }
    public Ficha getFicha() {
        return this.ficha;
    }
    
    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public short getNumeroTrimestre() {
        return this.numeroTrimestre;
    }
    
    public void setNumeroTrimestre(short numeroTrimestre) {
        this.numeroTrimestre = numeroTrimestre;
    }
    public void setFechaModificacio(java.sql.Date fechaActual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setIdUsuarioModifica(Integer idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }





}


