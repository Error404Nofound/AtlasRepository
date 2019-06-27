/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Ficha;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface FichaDao {
    
    public Ficha crearFicha(Ficha fichaCrear);
    public Ficha consultarFichaPorId(int Id);
    public List<Ficha> consultarListaFicha();
    public boolean modificarFicha(Ficha fichaModificar);
    public boolean eliminarFicha(Ficha fichaEliminar);
}
