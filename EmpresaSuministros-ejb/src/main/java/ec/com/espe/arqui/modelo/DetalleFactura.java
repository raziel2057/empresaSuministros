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
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author rdne1
 */
@Entity
@Table(name = "DETALLE_FACTURA")
@IdClass(DetalleFacturaPK.class)
public class DetalleFactura implements Serializable{
    @Id
    @Column(name = "CODIGO_PRODUCTO", nullable = false)
    private String codigoProducto;
    
    @JoinColumn(name = "CODIGO_PRODUCTO", referencedColumnName = "CODIGO_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    
    @Id
    @Column(name = "CODIGO_FACTURA", nullable = false)
    private String codigoFactura;
    
    @JoinColumn(name = "CODIGO_FACTURA", referencedColumnName = "CODIGO_FACTURA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Factura factura;
    
    @Column(name = "CANTIDAD_PRODUCTO", nullable = false)
    private Integer cantidad;
    
    @Column(name = "COSTO_UNITARIO", nullable = false)
    private BigDecimal costoUnitario;
    
    @Column(name = "COSTO_TOTAL", nullable = false)
    private BigDecimal costoTotal;

    public DetalleFactura() {
    }

    public DetalleFactura(String codigoProducto, String codigoFactura, Integer cantidad, BigDecimal costoUnitario, BigDecimal costoTotal) {
        this.codigoProducto = codigoProducto;
        this.codigoFactura = codigoFactura;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
        this.costoTotal = costoTotal;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(String codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(BigDecimal costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public BigDecimal getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(BigDecimal costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.codigoProducto);
        hash = 79 * hash + Objects.hashCode(this.codigoFactura);
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
        final DetalleFactura other = (DetalleFactura) obj;
        if (!Objects.equals(this.codigoProducto, other.codigoProducto)) {
            return false;
        }
        if (!Objects.equals(this.codigoFactura, other.codigoFactura)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" + "codigoProducto=" + codigoProducto + ", producto=" + producto + ", codigoFactura=" + codigoFactura + ", factura=" + factura + ", cantidad=" + cantidad + ", costoUnitario=" + costoUnitario + ", costoTotal=" + costoTotal + '}';
    }
    
    
    
}
