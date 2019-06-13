/**
 * Autor: Victor Manuel Niño Martínez
 * Experiencia Educativa: Principios de Construcción de Software
 * Docente: Fredy Castañeda Sánchez
 * Fecha de creación: 10/06/2019
 * Fecha de ultima actualización: 11/06/2019
 * Descripción: Implementación de la interfaz IInscripcion para la persistencia
 * de los datos
 */
package dao.inscripcionDAO;

import dao.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import modelo.Inscripcion;

/**
 *
 * @author Vik-t
 */
public class InscripcionImp implements IInscripcion{

    /**
     * Método para obtener la lista de las Inscripcion registradas en la
     * base de datos
     * @return lista de Inscricion de la base de datos
     */
    @Override
    public List<Inscripcion> getInscripciones() {
        List<Inscripcion> listaInscripciones = new ArrayList();
        Connection conexionBD = new ConexionBD().getConexionBD();
        String sQuery = "SELECT * from estudiante_detalles;";
        if(conexionBD == null) {
            return null;
        }

        System.out.println(sQuery);
        try {
            Statement statement = conexionBD.createStatement();
            ResultSet rs = statement.executeQuery(sQuery);
            while (rs != null && rs.next()) {
                Inscripcion ins = new Inscripcion();
                ins.getEstudiante().getInicioSesion().setIdInicioSesion(rs.getInt("idinicioSesion"));
                ins.getSeguimiento().setIdSeguimiento(rs.getInt("idseguimiento"));
                ins.getServicioSocial().setIdServicioSocial(rs.getInt("idservicioSocial"));
                ins.getEstudiante().setIdEstudiante(rs.getInt("idestudiante"));
                ins.getEstudiante().setMatricula(rs.getString("matricula"));
                ins.getEstudiante().setNombre(rs.getString("nombre"));
                ins.getEstudiante().setPaterno(rs.getString("paterno"));
                ins.getEstudiante().setMaterno(rs.getString("materno"));
                ins.getEstudiante().setProgramaEducativo(rs.getString("programaeducativo"));
                ins.getEstudiante().setEmail(rs.getString("email"));
                ins.getEstudiante().setPromedio(rs.getFloat("promedio"));
                ins.getEstudiante().setTelefono(rs.getString("telefono"));
                ins.getEstudiante().setNombreContacto(rs.getString("nombrecontacto"));
                ins.getEstudiante().setTelefonoContacto(rs.getString("telefonocontacto"));
                ins.setFolioInscripcion(rs.getInt("folio_inscripcion"));
                ins.setTipoInscripcion(rs.getString("tipo_incripcion"));
                ins.setFechaInscripcion(rs.getDate("fecha_inscripcion"));
                ins.getServicioSocial().setBloque(rs.getInt("bloque"));
                ins.getServicioSocial().setCreditos(rs.getInt("creditos"));
                ins.getServicioSocial().setNrc(rs.getInt("nrc"));
                ins.getServicioSocial().setSeccion(rs.getInt("seccion"));
                ins.getServicioSocial().setNombreProfesor(rs.getString("nombre_profesor"));
                ins.getSeguimiento().setCalificacion(rs.getDouble("calificacion"));
                ins.getSeguimiento().setEstado(rs.getString("estado"));
                ins.getSeguimiento().setHorasAcumuladas(rs.getInt("horasAcumuladas"));
                ins.getEstudiante().getInicioSesion().setUsuario(rs.getString("usuario"));
                ins.getEstudiante().getInicioSesion().setContrasenia(rs.getString("contrasenia"));
                listaInscripciones.add(ins);
                
                
            }
        } catch (SQLException ex) {
            System.out.println("Error en la creacion de el Statement: " + ex.getMessage());
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con BD");
            alert.setHeaderText("Hubo un error con la conexión a la Base de Datos,"
                    + "por favor intente más tarde");
            alert.showAndWait();
            return null;
        } finally {
            /*try {
                conexionBD.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion" + ex.getMessage());
            }*/
        }
        return listaInscripciones;
    }

    /**
     * Método para obtener la lista de las Inscripcion registradas en la
     * base de datos
     * @param idEstudiante identificador unico del un Estudiante que servira 
     * para filtrar la consulta
     * @return lista de Inscripcion con la base de datos
     */
    @Override
    public List<Inscripcion>  getInscripcion(int idEstudiante) {
         List<Inscripcion> listaInscripciones = new ArrayList();
        Connection conexionBD = new ConexionBD().getConexionBD();
        String sQuery = "SELECT * from estudiante_detalles where idestudiante = '"+
                idEstudiante +"';";

        System.out.println(sQuery);
        try {
            Statement statement = conexionBD.createStatement();
            ResultSet rs = statement.executeQuery(sQuery);
            while (rs != null && rs.next()) {
                Inscripcion ins = new Inscripcion();
                ins.getEstudiante().getInicioSesion().setIdInicioSesion(rs.getInt("idinicioSesion"));
                ins.getSeguimiento().setIdSeguimiento(rs.getInt("idseguimiento"));
                ins.getServicioSocial().setIdServicioSocial(rs.getInt("idservicioSocial"));
                ins.getEstudiante().setIdEstudiante(rs.getInt("idestudiante"));
                ins.getEstudiante().setMatricula(rs.getString("matricula"));
                ins.getEstudiante().setNombre(rs.getString("nombre"));
                ins.getEstudiante().setPaterno(rs.getString("paterno"));
                ins.getEstudiante().setMaterno(rs.getString("materno"));
                ins.getEstudiante().setProgramaEducativo(rs.getString("programaeducativo"));
                ins.getEstudiante().setEmail(rs.getString("email"));
                ins.getEstudiante().setPromedio(rs.getFloat("promedio"));
                ins.getEstudiante().setTelefono(rs.getString("telefono"));
                ins.getEstudiante().setNombreContacto(rs.getString("nombrecontacto"));
                ins.getEstudiante().setTelefonoContacto(rs.getString("telefonocontacto"));
                ins.setFolioInscripcion(rs.getInt("folio_inscripcion"));
                ins.setTipoInscripcion(rs.getString("tipo_incripcion"));
                ins.setFechaInscripcion(rs.getDate("fecha_inscripcion"));
                ins.getServicioSocial().setBloque(rs.getInt("bloque"));
                ins.getServicioSocial().setCreditos(rs.getInt("creditos"));
                ins.getServicioSocial().setNrc(rs.getInt("nrc"));
                ins.getServicioSocial().setSeccion(rs.getInt("seccion"));
                ins.getServicioSocial().setNombreProfesor(rs.getString("nombre_profesor"));
                ins.getSeguimiento().setCalificacion(rs.getDouble("calificacion"));
                ins.getSeguimiento().setEstado(rs.getString("estado"));
                ins.getSeguimiento().setHorasAcumuladas(rs.getInt("horasAcumuladas"));
                ins.getEstudiante().getInicioSesion().setUsuario(rs.getString("usuario"));
                ins.getEstudiante().getInicioSesion().setContrasenia(rs.getString("contrasenia"));
                listaInscripciones.add(ins);
                
                
            }
        } catch (SQLException ex) {
            System.out.println("Error en la creacion de el Statement: " + ex.getMessage());
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con BD");
            alert.setHeaderText("Hubo un error con la conexión a la Base de Datos,"
                    + "por favor intente más tarde");
            alert.showAndWait();
        } finally {
            /*try {
                conexionBD.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion" + ex.getMessage());
            }*/
        }
        return listaInscripciones;
    }
    
}
