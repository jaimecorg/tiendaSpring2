package com.jaimecorg.springprojects.tienda.model;

import java.sql.Date;
import java.util.List;

public class Pedido {
    
    private int codigo;
    private Cliente cliente;
    private List<DetallePedido> detallePedidos;
    private java.util.Date fecha;
    private double total;
    
    public Pedido(int codigo, Cliente cliente, List<DetallePedido> detallePedidos, Date fecha, float total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.detallePedidos = detallePedidos;
        this.fecha = fecha;
        this.total = total;
    }

    public Pedido() {
    }

    public Pedido(Cliente cliente){
        this.cliente = cliente;
    }

    public Pedido(List<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }

    public Pedido(List<DetallePedido> detallePedidos, Cliente cliente) {
        this.detallePedidos = detallePedidos;
        this.cliente = cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(List<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }

    public Date getFecha() {
        return (Date) fecha;
    }

    public void setFecha(java.util.Date date) {
        this.fecha = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double d) {
        this.total = d;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pedido other = (Pedido) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }

    
    
}
