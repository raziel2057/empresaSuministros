/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.arqui.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rdne1
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente  implements Serializable{
    
    @Id
    @Column(name = "CODIGO_CLIENTE", nullable = false)
    private String codigo;
    @Column(name = "NOMBRE_CLIENTE", nullable = false)
    private String nombre;
    @Column(name = "IDENTIFICACION_CLIENTE", nullable = false)
    private String identificacion;
    @Column(name = "DIRECCION_CLIENTE", nullable = true)
    private String direccion;
    @Column(name = "TELEFONO_CLIENTE", nullable = true)
    private String telefono;

    public Cliente() {
    }

    public Cliente(String codigo, String nombre, String identificacion, String direccion, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", nombre=" + nombre + ", identificacion=" + identificacion + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
    
    
}
