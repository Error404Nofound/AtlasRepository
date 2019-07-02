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
public interface JuicioEvaluativoDao {
    
    public JuicioEvaluativo crearJuicioEvaluativo(JuicioEvaluativo JuicioEvaluativoCrear);
    public JuicioEvaluativo consultarJuicioEvaluativoPorId(int Id);
    public List<JuicioEvaluativo> consultarListaJuicioEvaluativo();
    public boolean modificarFicha(JuicioEvaluativo juicioEvaluativoModificar);
    public boolean eliminarFicha(JuicioEvaluativo juicioEvaluativoEliminar);
}
