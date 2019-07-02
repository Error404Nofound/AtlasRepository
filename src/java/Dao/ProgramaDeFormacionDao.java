/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ProgramaDeFormacion;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface ProgramaDeFormacionDao {

    public ProgramaDeFormacion crearProgramaDeFormacion(ProgramaDeFormacion programaDeFormacionCreado);
    public ProgramaDeFormacion consultarProgramaDeFormacionPorId(int idProgramaDeFormacion);
    public List<ProgramaDeFormacion> listaProgramaDeFormacion();
    public boolean modificarProgramaDeFormacion(ProgramaDeFormacion programaDeFormacionModificar);
    public boolean eliminarProgramaDeFormacion (ProgramaDeFormacion programaDeFormacionEliminar);   
}
