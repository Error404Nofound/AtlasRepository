/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Competencia;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface CompetenciaDao {

    public Competencia crearCompetencia(Competencia competencia);
    public Competencia consultarCompetenciaPorId(int Id);
    public List<Competencia> consultarListaCompetencia();
    public boolean modificarCompetencia(Competencia competenciaModificar);
    public boolean eliminarCompetencia(Competencia competenciaEliminar);
    
}
