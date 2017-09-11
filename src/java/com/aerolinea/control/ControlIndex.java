package com.aerolinea.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller()
//@RequestMapping("/inicio")
public class ControlIndex {
    @RequestMapping(value="/hola", method=GET)
    public ModelAndView mostrarIndex(@RequestParam("texto")String texto){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("mensaje", "Hola "+ texto);
        return mv;
    }
    
    @RequestMapping("/home/{texto}")
    public ModelAndView mostrarIndex2(@PathVariable("texto")String texto){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("mensaje", "Hola mundo "+ texto);
        return mv;
    }
    @RequestMapping("/home")
    public String mostrarHome(){
        return "index";
    }
    
    @RequestMapping("/")
    public String mostrarIndex2(){
        return "index";
    }
}

