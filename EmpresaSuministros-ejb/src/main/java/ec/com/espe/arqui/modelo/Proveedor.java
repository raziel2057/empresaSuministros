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
@Table(name = "PROVEEDOR")
public class Proveedor implements Serializable{
    @Id
    @Column(name = "CODIGO_PROVEEDOR", nullable = false)
    private String codigo;
    @Column(name = "DESCRIPCION_PROVEEDOR", nullable = false)
    private String descripcion;
    @Column(name = "IDENTIFICACION_PROVEEDOR", nullable = false)
    private String identificacion;

    public Proveedor() {
    }

    public Proveedor(String codigo, String descripcion, String identificacion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.identificacion = identificacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.codigo);
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
        final Proveedor other = (Proveedor) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", identificacion=" + identificacion + '}';
    }
    
    
}
