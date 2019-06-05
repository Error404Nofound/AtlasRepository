/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Dao.ProgramaDeFormacionDao;
import Model.ProgramaDeFormacion;
import Persistence.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author Asus
 */
public class ProgramaDeFormacionBusiness implements ProgramaDeFormacionDao{
    
    @Override
    public ProgramaDeFormacion crearProgramaDeFormacion(ProgramaDeFormacion programaDeFormacionCreado) {
              Session session = null;
        try
        {
            //java.sql.Date fechaActual = new java.sql.Date(0, 0, 0);//no se utiliza 
            
            //no la entiendo es la fecha de modificacion del programa
            //programaDeFormacionCrear.setFechaModificacio(fechaActual);
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(programaDeFormacionCreado);
            session.getTransaction().commit();
        }catch(Exception ex)
        {
            System.err.println(ex.getMessage());
            session.getTransaction().rollback();
            programaDeFormacionCreado = null;
        }finally
        {
            if(session !=null)
            {
                session.close();
            }
        }
        
        return programaDeFormacionCreado;
    }

    /**
     *
     * @param idProgramaDeFormacion
     * @return
     */
    @Override
    // se consulta al programa de formacion atravez del id_programa
    public ProgramaDeFormacion  consultarProgramaDeFormacionPorId(int idProgramaDeFormacion) {
             Session session = null;
        
        ProgramaDeFormacion  programa = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            programa  = (ProgramaDeFormacion) session.get(ProgramaDeFormacion.class,idProgramaDeFormacion);
            
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }finally
        {
            if(session !=null && session.isOpen()){
                session.close();
            }
        }
        return programa;
    }

    @Override
    public List<ProgramaDeFormacion> listaProgramaDeFormacion() {
        Session session = null;
        
        List<ProgramaDeFormacion> listaProgramaDeFormacion = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from programa_de_formacion");// hago el selec de la tabla programa de la base de datos
            listaProgramaDeFormacion = (List<ProgramaDeFormacion>) query.list();
            
            
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }finally
        {
        
            if(session !=null){
                session.close();
            }
        }
        return listaProgramaDeFormacion;
    }
    
    @Override
    public boolean modificarProgramaDeFormacion(ProgramaDeFormacion programaDeFormacionModificar) {
           Session session = null;
        
        ProgramaDeFormacion registroActualizar = new ProgramaDeFormacion();
        boolean resultado = false;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            
            session.beginTransaction();
            //columnas que tiene nuestro programa de formacion en la base de datos
            registroActualizar.setIdPrograma(programaDeFormacionModificar.getIdPrograma());
            registroActualizar.setNombrePrograma(programaDeFormacionModificar.getNombrePrograma());
            registroActualizar.setDuracionMeses(programaDeFormacionModificar.getDuracionMeses());
            registroActualizar.setDescripcionPrograma(programaDeFormacionModificar.getDescripcionPrograma());
            registroActualizar.setTipoPrograma(programaDeFormacionModificar.getTipoPrograma());
            registroActualizar.setEstado(programaDeFormacionModificar.getEstado());
            registroActualizar.setIdUsuarioModifica(programaDeFormacionModificar.getIdUsuarioModifica());
            registroActualizar.setNombreUsuarioModifica(programaDeFormacionModificar.getNombreUsuarioModifica());
            
            session.update(registroActualizar);
            session.getTransaction().commit();
            resultado = true;
        }catch(Exception ex)
        {
            System.err.println(ex.getMessage());
            session.getTransaction().rollback();
            
        }finally
        {
            if(session !=null)
            {
                session.close();
            }
        }
        return resultado;
    }
    
    @Override
    public boolean eliminarProgramaDeFormacion(ProgramaDeFormacion programaDeFormacionEliminar) {
                      Session session = null;
        boolean resultado = false;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(programaDeFormacionEliminar);
            session.getTransaction().commit();
            resultado = true;
        }catch(Exception ex)
        {
            System.err.println(ex.getMessage());
            session.getTransaction().rollback();
            
        }finally
        {
            if(session !=null)
            {
                session.close();
            }
        }
        
        return resultado;
    }

}

