package net.ehuamanttupa.controllers;

import net.ehuamanttupa.model.Vacante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {


    @GetMapping("/detalle")
    public String mostrarDetalle(Model model){

        Vacante vacante = new Vacante();
        vacante.setNombre("Ingeniero de comunicaciones");
        vacante.setDescripcion("Se solicita ingeniero para dar soporte a intranet");
        vacante.setFecha(new Date());
        vacante.setSalario(9700.0);

        model.addAttribute("vacante",vacante);

        return "detalle";
    }

    @GetMapping("/listado")
    public String mostrarListado(Model model){

        List<String> lista = new LinkedList<>();

        lista.add("Ingeniero de Sistemas");
        lista.add("Auxiliar de Contabilidad");
        lista.add("Vendedor");
        lista.add("Arquitecto");

        model.addAttribute("empleos", lista);

        return "listado";
    }

    @GetMapping(value="/")
    public String mostrarHome(Model model){

//        LocalDate fecha = LocalDate.now();
//        model.addAttribute("titulo","Empleos APP");
//        model.addAttribute("fecha", fecha);
        String nombre = "Auxiliar de Contabilidad";
        Date fechaPub = new Date();
        double salario = 9000.0;
        boolean vigente = true;

        model.addAttribute("nombre",nombre);
        model.addAttribute("fecha",fechaPub);
        model.addAttribute("salario",salario);
        model.addAttribute("vigente",vigente);


        return "home";
    }
}
