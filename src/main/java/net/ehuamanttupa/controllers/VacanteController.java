package net.ehuamanttupa.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vacantes")
public class VacanteController {

    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idVacante, Model model){

        System.out.println("idVacante" + idVacante);
        model.addAttribute("idVacante" , idVacante);

        //Buscar los detalles de las vacantes en la  BD;


        return "vacantes/detalle";

    }
}
