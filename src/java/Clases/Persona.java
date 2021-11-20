/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author ADMIN
 */
public class Persona {
    private String NombreCompleta;
    private String Fecha;
    private int Id;

    public Persona() {
    }

    public Persona(String NombreCompleta, String Fecha, int Id) {
        this.NombreCompleta = NombreCompleta;
        this.Fecha = Fecha;
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    
    
    public String getNombreCompleta() {
        return NombreCompleta;
    }

    public void setNombreCompleta(String NombreCompleta) {
        this.NombreCompleta = NombreCompleta;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
    
    
}
