package com.eventhub.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("events", service.findAll());
        return "event/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        if (service.delete(id)) {
            redirect.addFlashAttribute("success", "Evento apagado com sucesso");
        } else {
            redirect.addFlashAttribute("error", "Evento não encontrado");
        }
        return "redirect:/event";
    }

}
