/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Persona;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface PersonaDao {
    public Persona crearPersona(Persona personaCrear);
    public Persona consultarPersonaPorCedula(String cedula);
    public List<Persona> listaPersonas();
    public boolean eliminarPersona(Persona personaEliminar);
    public boolean modificarPersona(Persona personaModificar);
}
