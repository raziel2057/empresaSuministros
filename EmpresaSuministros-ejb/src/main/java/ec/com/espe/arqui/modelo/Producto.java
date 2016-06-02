/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.arqui.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author rdne1
 */
@Entity
@Table(name = "PRODUCTO")
public class Producto implements Serializable{
    @Id
    @Column(name = "CODIGO_PRODUCTO", nullable = false)
    private String codigo;
    @Column(name = "CODIGO_PROVEEDOR", nullable = false)
    private String codigoProveedor;
    @JoinColumn(name = "CODIGO_PROVEEDOR", referencedColumnName = "CODIGO_PROVEEDOR", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proveedor proveedor;
    @Column(name = "DESCRIPCION_PRODUCTO", nullable = false)
    private String descripcion;
    @Column(name = "PRECIO_UNITARIO_PRODUCTO", nullable = false)
    private BigDecimal precioUnitario;
    @Column(name = "STOCK_PRODUCTO", nullable = false)
    private Integer stock;

    public Producto() {
    }

    public Producto(String codigo, String codigoProveedor, String descripcion, BigDecimal precioUnitario, Integer stock) {
        this.codigo = codigo;
        this.codigoProveedor = codigoProveedor;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.codigo);
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
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", codigoProveedor=" + codigoProveedor + ", proveedor=" + proveedor + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario + ", stock=" + stock + '}';
    }
    
    
    
   
}
