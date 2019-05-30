package Model;
// Generated 29-may-2019 19:08:18 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer idUsuario;
     private Persona persona;
     private String estadoUsuario;
     private String contrasena;
     private Date fechaContrasena;
     private String contrasenaAnterior;
     private Integer intentosLogin;
     private Date fechaRegistro;
     private String correoSena;
     private Date fechaModificacio;
     private Integer idUsuarioModifica;
     private String nombreUsuarioModifica;
     private Set<Aprendiz> aprendizs = new HashSet<Aprendiz>(0);
     private Set<Perfil> perfils = new HashSet<Perfil>(0);
     private Set<Instructor> instructors = new HashSet<Instructor>(0);
     private String DocumentoUsuario;

    public Usuario() {
    }

	
    public Usuario(Persona persona, String estadoUsuario, String contrasena) {
        this.persona = persona;
        this.estadoUsuario = estadoUsuario;
        this.contrasena = contrasena;
    }
    public Usuario(Persona persona, String estadoUsuario, String contrasena, Date fechaContrasena, String contrasenaAnterior, Integer intentosLogin, Date fechaRegistro, String correoSena, Date fechaModificacio, Integer idUsuarioModifica, String nombreUsuarioModifica, Set<Aprendiz> aprendizs, Set<Perfil> perfils, Set<Instructor> instructors) {
       this.persona = persona;
       this.estadoUsuario = estadoUsuario;
       this.contrasena = contrasena;
       this.fechaContrasena = fechaContrasena;
       this.contrasenaAnterior = contrasenaAnterior;
       this.intentosLogin = intentosLogin;
       this.fechaRegistro = fechaRegistro;
       this.correoSena = correoSena;
       this.fechaModificacio = fechaModificacio;
       this.idUsuarioModifica = idUsuarioModifica;
       this.nombreUsuarioModifica = nombreUsuarioModifica;
       this.aprendizs = aprendizs;
       this.perfils = perfils;
       this.instructors = instructors;
    }
   
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public String getEstadoUsuario() {
        return this.estadoUsuario;
    }
    
    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public Date getFechaContrasena() {
        return this.fechaContrasena;
    }
    
    public void setFechaContrasena(Date fechaContrasena) {
        this.fechaContrasena = fechaContrasena;
    }
    public String getContrasenaAnterior() {
        return this.contrasenaAnterior;
    }
    
    public void setContrasenaAnterior(String contrasenaAnterior) {
        this.contrasenaAnterior = contrasenaAnterior;
    }
    public Integer getIntentosLogin() {
        return this.intentosLogin;
    }
    
    public void setIntentosLogin(Integer intentosLogin) {
        this.intentosLogin = intentosLogin;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public String getCorreoSena() {
        return this.correoSena;
    }
    
    public void setCorreoSena(String correoSena) {
        this.correoSena = correoSena;
    }
    public Date getFechaModificacio() {
        return this.fechaModificacio;
    }
    
    public void setFechaModificacio(Date fechaModificacio) {
        this.fechaModificacio = fechaModificacio;
    }
    public Integer getIdUsuarioModifica() {
        return this.idUsuarioModifica;
    }
    
    public void setIdUsuarioModifica(Integer idUsuarioModifica) {
        this.idUsuarioModifica = idUsuarioModifica;
    }
    public String getNombreUsuarioModifica() {
        return this.nombreUsuarioModifica;
    }
    
    public void setNombreUsuarioModifica(String nombreUsuarioModifica) {
        this.nombreUsuarioModifica = nombreUsuarioModifica;
    }
    public Set<Aprendiz> getAprendizs() {
        return this.aprendizs;
    }
    
    public void setAprendizs(Set<Aprendiz> aprendizs) {
        this.aprendizs = aprendizs;
    }
    public Set<Perfil> getPerfils() {
        return this.perfils;
    }
    
    public void setPerfils(Set<Perfil> perfils) {
        this.perfils = perfils;
    }
    public Set<Instructor> getInstructors() {
        return this.instructors;
    }
    
    public void setInstructors(Set<Instructor> instructors) {
        this.instructors = instructors;
    }
    public String getDocumentoUsuario() {
        return DocumentoUsuario;
    }

    public void setDocumentoUsuario(String DocumentoUsuario) {
        this.DocumentoUsuario = DocumentoUsuario;
    }


}


