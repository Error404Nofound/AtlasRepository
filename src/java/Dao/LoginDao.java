/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Usuario;

/**
 *
 * @author Johan
 */
public interface LoginDao {
        
    public Usuario autenticarUsuario (String cedula,String contrasena);
    public Usuario cerrarSesion ();
    
}
