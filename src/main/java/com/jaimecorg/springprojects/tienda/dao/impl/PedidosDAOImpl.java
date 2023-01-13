package com.jaimecorg.springprojects.tienda.dao.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.jaimecorg.springprojects.tienda.dao.ProductosDAO;
import com.jaimecorg.springprojects.tienda.model.Cliente;
import com.jaimecorg.springprojects.tienda.model.Pedido;
import com.jaimecorg.springprojects.tienda.model.Producto;

@Repository
public class PedidosDAOImpl extends JdbcDaoSupport implements ProductosDAO {

    @Autowired
    DataSource dataSource;
    
    @PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

    @Override
    public PageImpl<Pedido> findAll(Pageable page) {

    
        String queryCount = "select count(1) from Pedidos";
        Integer total = getJdbcTemplate().queryForObject(queryCount,Integer.class);


        Order order = !page.getSort().isEmpty() ? page.getSort().toList().get(0) : Order.by("codigo");

        String query = "SELECT p.*, c.nombre FROM Pedidos p, Clientes c where p.codigo_cliente = c.codigo ORDER BY " + order.getProperty() + " "
        + order.getDirection().name() + " LIMIT " + page.getPageSize() + " OFFSET " + page.getOffset();

        final List<Pedido> pedidos = getJdbcTemplate().query(query, new RowMapper<Pedido>() {

            @Override
            @Nullable
            public Pedido mapRow(ResultSet rs, int rowNum) throws SQLException {
                Pedido pedido = new Pedido();
                pedido.setCodigo(rs.getInt("codigo"));
                pedido.setCliente(new Cliente(rs.getInt("codigo_cliente")));
                pedido.getCliente().setNombre(rs.getString("nombre"));
                pedido.setFecha(new java.util.Date(rs.getDate("fecha").getTime()));
                pedido.setTotal(rs.getDouble("total"));
                return pedido;
            }
        });

        return new PageImpl<Pedido>(pedidos, page, total);

    }

    @Override
    public Pedido findById(int codigo) {
        
        String query = "select p.* from Pedidos p where p.codigo = ?";

        Object params [] = {codigo};
        int types [] = {Types.INTEGER};

        Pedido producto = (Pedido) getJdbcTemplate().queryForObject(query, params, types, new RowMapper<Pedido>() {

            @Override
            @Nullable
            public Pedido mapRow(ResultSet rs, int rowNum) throws SQLException {
                Pedido pedido = new Pedido();
                pedido.setCodigo(rs.getInt("codigo"));
                pedido.setCliente(new Cliente(rs.getInt("codigo_cliente")));
                // pedido.getCliente().setNombre(rs.getString("nombre"));
                pedido.setFecha(new java.util.Date(rs.getDate("fecha").getTime()));
                pedido.setTotal(rs.getDouble("total"));
                return pedido;
            }
            
        });
        return producto;
    }

    



    @Override
    public void delete(int codigo) {
        
        String query = "delete from Pedidos where codigo = ?";

        Object[] params = {
            codigo
        };

        final int[] types = {
            Types.INTEGER
        };
        getJdbcTemplate().update(query, params, types);
        
    }



	@Override
	public void insert(Producto Producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Producto Producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateImage(Producto producto) {
		// TODO Auto-generated method stub
		
	}

}
 