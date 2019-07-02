/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ResultadoAprendizaje;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface ResultadoAprendizajeDao {

    public ResultadoAprendizaje crearResultadoAprendizaje(ResultadoAprendizaje resultadoAprendizajeCrear);
    public ResultadoAprendizaje consultarResultadoAprendizajePorId (int Id);
    public List<ResultadoAprendizaje> consultarListaResultadoAprendizaje();
    public boolean modificarResultadoAprendizaje(ResultadoAprendizaje resultadoAprendizajeModificar);
    public boolean eliminarResultadoAprendizaje(ResultadoAprendizaje resultadoAprendizajeEliminar);    
}
