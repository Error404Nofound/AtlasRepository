/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Trimestre;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface TrimestreDao {
    
    public Trimestre crearTrimestre(Trimestre trimestreCrear);
    public Trimestre consultarTrimestrePorId(int idTrimestre);
    public List<Trimestre> consultarListaTrimestre();
    public boolean modificarTrimestre(Trimestre trimestreModificar);
    public boolean eliminarTrimestre(Trimestre trimestreEliminar);
}
