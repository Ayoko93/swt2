package de.fhdo.swt.example.swtexampleapplication.controller;

import de.fhdo.swt.example.swtexampleapplication.entity.Journey;
import de.fhdo.swt.example.swtexampleapplication.entity.SupportTicket;
import de.fhdo.swt.example.swtexampleapplication.repository.SupportTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupportTicketController {

    @Autowired
    private SupportTicketRepository supportTicketRepository;

    @GetMapping("/support")
    public String showSupportTicketsForm(SupportTicket ticket, Model model){
        model.addAttribute("tickets", supportTicketRepository.findAll());
        return "support";
    }

    @GetMapping("/support/add")
    public String showAddSupportTicketForm(Journey journey)
    {
        return "add-journey";
    }

}
