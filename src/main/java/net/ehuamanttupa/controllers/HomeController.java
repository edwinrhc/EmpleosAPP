package net.ehuamanttupa.controllers;

import net.ehuamanttupa.model.Vacante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/tabla")
    public String mostrarTabla(Model model){

        List<Vacante> lista = getVacantes();
        model.addAttribute("vacantes", lista);
        return "tabla";

    }


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

    /*
     *  Método que regresa una lista de objetos de tipo Vacante
     */
    private List<Vacante> getVacantes(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        List<Vacante> lista = new LinkedList<Vacante>();

        try {
            //Creamos la oferta de trabajo 1
            Vacante vacante1 = new Vacante();
            vacante1.setId(1);
            vacante1.setNombre("Ingeniero Civil");
            vacante1.setDescripcion("Solicitamos Ing Civil para diseñar puente peatonal");
            vacante1.setFecha(sdf.parse("08-02-2019"));
            vacante1.setSalario(8500.0);
            vacante1.setDestacado(1);

            //Creamos la oferta de trabajo 1
            Vacante vacante2 = new Vacante();
            vacante2.setId(2);
            vacante2.setNombre("Inigeniero Sistemas");
            vacante2.setDescripcion("Solicitamos Ing Sistemas para diseñar una aplicación");
            vacante2.setFecha(sdf.parse("09-02-2019"));
            vacante2.setSalario(12300.0);
            vacante2.setDestacado(0);

            //Creamos la oferta de trabajo 1
            Vacante vacante3= new Vacante();
            vacante3.setId(3);
            vacante3.setNombre("Contador Publico");
            vacante3.setDescripcion("Empresa importante solicita contador de 5 años de experiencia titulado");
            vacante3.setFecha(sdf.parse("09-02-2019"));
            vacante3.setSalario(14500.0);
            vacante3.setDestacado(0);

            Vacante vacante4= new Vacante();
            vacante4.setId(4);
            vacante4.setNombre("Diseñador Gráfico");
            vacante4.setDescripcion("Solicitamos Diseñador Gráfico titulado para diseñar publicidad de la empresa");
            vacante4.setFecha(sdf.parse("11-02-2019"));
            vacante4.setSalario(7500.0);
            vacante4.setDestacado(1);

            //Agregamos los 4 objetos
            lista.add(vacante1);
            lista.add(vacante2);
            lista.add(vacante3);
            lista.add(vacante4);
        } catch (ParseException e) {
            System.out.println("Error: "+ e.getMessage());
        }
        return lista;

    }

}

