/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Dao.LoginDao;
import Model.Usuario;
import Persistence.NewHibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Johan
 */
public class LoginBusiness implements LoginDao {

    // Recibe como parametros la cedula y la contraseña, recibidos desde la vista,
    @Override
    public Usuario autenticarUsuario(String cedula, String contrasena) {

        // Instancia sesión (sesión de conexión a la base de datos) en nulo
        Session session = null;
        // instancia un objeto de tipo usuario en nulo
        Usuario usuario = null;
        try {
            // Se inicia la sesión con la conexión a la base
            session = NewHibernateUtil.getSessionFactory().openSession();
            // Se consulta el usuario donde la cedula sea igual a la ingresada¿
            Query consulta = session.createQuery("FROM Usuario WHERE numero_documento=:p").setString("p", cedula);
            // se ejecuta la consulta, los valores consultados se guardan en el objeto creado anteriormente
            usuario = (Usuario) consulta.uniqueResult();
            usuario.getPersona();
            //Se encripta la contraseña que ingresó la persona
            String contrasenaEncriptada = DigestUtils.sha1Hex(contrasena);
            // Se valida si la contraseña que ingresó la persona es igual a la que está registrada en la base
            if (usuario != null) {
                if (!contrasenaEncriptada.equals(usuario.getContrasena())) {
                    // Si la contraseña no es igual
                    // Se agrega un 1 a los intentos de incio de sesión
                    int intentos = ((usuario.getIntentosLogin()) + 1);
                    usuario.setIntentosLogin(intentos);
                    //Se inicia una transaccion a la base de datos
                    session.beginTransaction();
                    // Se actualiza el usuario, que se incrementó en 1 los intentos de login
                    session.update(usuario);
                    // Se finaliza la transacció, y se confirman los cambios
                    session.getTransaction().commit();
                    usuario = null;
                } else {
                    
                    // Si las contraseñas coinciden, se reestablecen los intentos de login en 0
                    usuario.setIntentosLogin(0);
                    session.beginTransaction();
                    session.update(usuario);
                    session.getTransaction().commit();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            usuario = null;
        } finally {
            // Se cierra la sesión si es diferente de nula o si la sesión no está abierta
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return usuario;
    }

    public String encriptarCadena(String cadena) {
        String cadenaEncriptada = DigestUtils.sha1Hex(cadena);
        return cadenaEncriptada;
    }

    @Override
    public Usuario cerrarSesion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
