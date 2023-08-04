package com.julian.fecha;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller

public class DateController {
	
	 @GetMapping("/")
	    public String home() {
	        return "home.jsp";
	    }
	
	
	  @GetMapping("/fecha")
	    public String Fecha(Model model) {
	        Date fechaActual = new Date();
	        SimpleDateFormat fecha = new SimpleDateFormat("EEEE, d 'de' MMMM, yyyy");
	        String Fecha = fecha.format(fechaActual);
	        model.addAttribute("Fecha", Fecha);
	        return "fecha.jsp";
	    }
	  
	  @GetMapping("/tiempo")
	    public String Hora(Model model) {
	        Date horaActual = new Date();
	        SimpleDateFormat tiempo = new SimpleDateFormat("hh:mm a");
	        String Hora = tiempo.format(horaActual);
	        model.addAttribute("Hora", Hora);
	        return "tiempo.jsp";
	    }

}
