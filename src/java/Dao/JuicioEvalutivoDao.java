/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.JuicioEvalutivo;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface JuicioEvalutivoDao {
    
    public JuicioEvalutivo crearJuicioEvalutivo(JuicioEvalutivo juicioEvalutivoCrear);
    public JuicioEvalutivo consultarJuicioEvalutivoPorId(int Id);
    public List<JuicioEvalutivo> consultarListaJuicioEvalutivo();
    public boolean modificarJuicioEvalutivo(JuicioEvalutivo juicioEvalutivoModificar);
    public boolean eliminarJuicioEvalutivo(JuicioEvalutivo juicioEvalutivoEliminar);
    
}
