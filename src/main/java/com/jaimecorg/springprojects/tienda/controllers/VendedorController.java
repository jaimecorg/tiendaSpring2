package com.jaimecorg.springprojects.tienda.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jaimecorg.springprojects.tienda.model.Vendedor;

@Controller
@RequestMapping("/vendedores")
public class VendedorController {
     
    @RequestMapping(path = "/list")
    public ModelAndView list(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("vendedores", getVendedores());
        modelAndView.setViewName("vendedores/list");

        return modelAndView;
    }
    
    @RequestMapping(path = "/edit")
    public ModelAndView edit(@RequestParam(name = "codigo", required = true) int codigo ){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("vendedor", getVendedor(codigo));
        modelAndView.setViewName("vendedores/edit");

        return modelAndView;
    }

    @RequestMapping(path = "/create")
    public ModelAndView create(){

         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("vendedor", new Vendedor());
         modelAndView.setViewName("vendedores/new");

         return modelAndView;
    }

    @PostMapping(path = "/save")
    public ModelAndView save(Vendedor vendedor){

        int round = (int) (Math.random()*(100+5));

        vendedor.setCodigo(round);
        
        List <Vendedor> vendedores = getVendedores();
        vendedores.add(vendedor);

         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("vendedores", vendedores);
         modelAndView.setViewName("vendedores/list");

         return modelAndView;
    }

    @PostMapping(path = "/update")
    public ModelAndView update(Vendedor vendedor){

        List <Vendedor> vendedores = getVendedores();

        int indexOf = vendedores.indexOf(vendedor);

        vendedores.set(indexOf, vendedor);
         
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("vendedores", vendedores);
        modelAndView.setViewName("vendedores/list");

         return modelAndView;
    }

    @RequestMapping(path = "/delete/{codigo}")
    public ModelAndView delete(@PathVariable(name = "codigo", required = true) int codigo){

        List <Vendedor> vendedores = getVendedores();
        vendedores.remove(getVendedor(codigo));

         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("vendedores", vendedores);
         modelAndView.setViewName("vendedores/list");

         return modelAndView;
    }


    private Vendedor getVendedor(int codigo) {
       List <Vendedor> vendedores = getVendedores();
       int indexof = vendedores.indexOf(new Vendedor(codigo));

       return vendedores.get(indexof);
    }

    private List<Vendedor> getVendedores() {
        Vendedor p1 = new Vendedor(1, "nombre1", "apellidos1", "puesto1");
        Vendedor p2 = new Vendedor(2, "nombre2", "apellidos2", "puesto2");
        Vendedor p3 = new Vendedor(3, "nombre3", "apellidos3", "puesto3");
        Vendedor p4 = new Vendedor(4, "nombre4", "apellidos4", "puesto4");

        ArrayList<Vendedor> listaVendedores = new ArrayList<Vendedor>();

        listaVendedores.add(p1);
        listaVendedores.add(p2);
        listaVendedores.add(p3);
        listaVendedores.add(p4); 

        return listaVendedores;
    }


}
