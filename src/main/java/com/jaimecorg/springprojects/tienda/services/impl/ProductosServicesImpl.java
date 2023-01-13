package com.jaimecorg.springprojects.tienda.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jaimecorg.springprojects.tienda.dao.ProductosDAO;
import com.jaimecorg.springprojects.tienda.model.Pedido;
import com.jaimecorg.springprojects.tienda.model.Producto;
import com.jaimecorg.springprojects.tienda.services.ProductosServices;

@Service
public class ProductosServicesImpl implements ProductosServices {

    @Autowired
    ProductosDAO productosDAO;

    @Override
    public Page<Pedido> findAll(Pageable pageable) {
        return productosDAO.findAll(pageable);
    }

    @Override
    public Producto find(int codigo) {
        return productosDAO.findById(codigo);
    }

    @Override
    public void save(Producto producto) {
        productosDAO.insert(producto);
    }

    @Override
    public void update(Producto producto) {
        productosDAO.update(producto);
        
        if(producto.getImage() != null && producto.getImage().length > 0 ){
            productosDAO.updateImage(producto);
        }
    }

    @Override
    public void delete(int codigo) {
        productosDAO.delete(codigo);        
    }

    @Override
    public Page<Producto> findAll(int codigo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Producto findProducto(int codigo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void insert(Producto producto) {
        // TODO Auto-generated method stub
        
    }
}
