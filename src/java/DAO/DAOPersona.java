/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Clases.Persona;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DAOPersona extends Conexion.Conexion {

    PreparedStatement PST;
    String error;
    
    public String RegistrarPersona(Persona persona) {
        PreparedStatement pst;
        String respuesta = "error";
        String sentencia = "INSERT INTO `persona`(`Id`, `Nombre_Completo`, `Fecha`) VALUES (null,?,?)";

        if (this.Connexion()) {
            try {
                pst = cnn.prepareStatement(sentencia);
                pst.setString(1, persona.getNombreCompleta());
                pst.setString(2, persona.getFecha());
                if (pst.executeUpdate() != 0) {
                    pst.close();
                    respuesta = "ok";
                }

            } catch (SQLException ex) {
                Logger.getLogger(DAOPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;

    }
    
    public String ModificarPersona(Persona persona) {
        PreparedStatement pst;
        String respuesta = "error";
        String sentencia = "UPDATE `persona` SET `Nombre_Completo`= ?,`Fecha`= ? WHERE Id = ?";

        if (this.Connexion()) {
            try {
                pst = cnn.prepareStatement(sentencia);
                pst.setString(1, persona.getNombreCompleta());
                pst.setString(2, persona.getFecha());
                pst.setInt(3, persona.getId());
                if (pst.executeUpdate() != 0) {
                    pst.close();
                    respuesta = "ok";
                }

            } catch (SQLException ex) {
                Logger.getLogger(DAOPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;

    }

    public JsonArray ListadoPersonas() {
        JsonArray listadoeven = new JsonArray();
        Persona persona;
        String sentencia = "select * from persona;";
        if (this.Connexion()) {
            try {
                PST = super.sentences(sentencia);
                ResultSet res = PST.executeQuery();

                while (res.next()) {
                    persona = new Persona(res.getString("Nombre_Completo"), res.getString("Fecha"), res.getInt("Id"));
                    listadoeven.add(new Gson().toJsonTree(persona));
                }
            } catch (SQLException ex) {
                listadoeven.add(new Gson().toJsonTree(ex));
            }

        } else {
            error = "Error con la conexion a la base de datos, verifique conexion";
            listadoeven.add(new Gson().toJsonTree(error));
        }
        return listadoeven;
    }
}
