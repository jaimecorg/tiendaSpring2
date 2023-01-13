package com.jaimecorg.springprojects.tienda.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.jaimecorg.springprojects.tienda.model.Pedido;
import com.jaimecorg.springprojects.tienda.model.Producto;

public interface ProductosDAO {
    // public List<Producto> findAll();

    public PageImpl<Pedido> findAll(Pageable page);
    public Pedido findById(int codigo);
    public void insert(Producto Producto);
    public void update(Producto Producto);
    public void delete(int codigo);
    public void updateImage(Producto producto);
}
