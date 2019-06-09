/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    @Override
    public List<Inscripcion> getInscripciones() {
        List<Inscripcion> listaInscripciones = new ArrayList();
        Connection conexionBD = new ConexionBD().getConexionBD();
        String sQuery = "SELECT * from estudiante_detalles;";

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
