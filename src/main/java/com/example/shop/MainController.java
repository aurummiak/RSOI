package com.example.shop;

import com.example.shop.domain.Clients;
import com.example.shop.domain.Drive;
import com.example.shop.domain.Offence;
import com.example.shop.repos.ClientRepo;
import com.example.shop.repos.DriveRepo;
import com.example.shop.repos.OffenceRepo;
import com.example.shop.service.OffenceCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
public class MainController {

    @Autowired
    private DriveRepo driveRepository;
    @Autowired
    private ClientRepo clientRepository;
    @Autowired
    private OffenceRepo offenceRepository;


    @GetMapping("/")
    public ModelAndView menu(Model model) {
        return new ModelAndView("menu");
    }

    @GetMapping("/result")
    public ModelAndView result(Model model) {
        return new ModelAndView("result");
    }


    @GetMapping("/seeDrives")
    public ModelAndView showDrives(Model model) {
        Iterable<Drive> drives = driveRepository.findAll();
        model.addAttribute("drives", drives);
        return new ModelAndView("showDrives");
    }

    @PostMapping("/seeDrives/{driveId}")
    public ModelAndView delete(@PathVariable(value = "driveId") int id, Model model) {
        Drive drive = driveRepository.findById(id).orElseThrow();
        driveRepository.delete(drive);
        return new ModelAndView("redirect:/seeDrives");
    }

    @GetMapping("/seeClients")
    public ModelAndView showClients(Model model) {
        Iterable<Clients> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        return new ModelAndView("showClients");
    }

    @PostMapping("/seeClients/{clientId}")
    public ModelAndView deleteClient(@PathVariable(value = "clientId") int id, Model model) {
        Clients clients = clientRepository.findById(id).orElseThrow();
        clientRepository.delete(clients);
        return new ModelAndView("redirect:/seeClients");
    }

    @PostMapping("/seeOffence/{clientId}")
    public ModelAndView showOffence(@PathVariable(value = "clientId") int id, Model model, RedirectAttributes redirectAttributes) {
        ArrayList<Offence> list = (ArrayList<Offence>) offenceRepository.findAll();
        ArrayList<Offence> offences = new ArrayList<Offence>();
        for (Offence element : list) {
            if (element.getClient() == id) {
                offences.add(element);
            }
        }
        System.out.println(offences);
        redirectAttributes.addFlashAttribute("offences", offences);
        return new ModelAndView("redirect:/showOffence");
    }

    @GetMapping("/showOffence")
    public ModelAndView showOffence(@ModelAttribute("offences") ArrayList<Offence> offenceList, Model model) {
        Iterable<Offence>offences = offenceList;
        model.addAttribute("offences", offences);
        return new ModelAndView("showOffence");
    }



    @PostMapping("/seeAverageOffence/{clientId}")
    public ModelAndView showAverageOffence(@PathVariable(value = "clientId") int id, Model model, RedirectAttributes redirectAttributes) {
        ArrayList<Offence> list = (ArrayList<Offence>) offenceRepository.findAll();
        ArrayList<Offence> offences = new ArrayList<Offence>();
        for (Offence element : list) {
            if (element.getClient() == id) {
                offences.add(element);
            }
        }
        System.out.println(offences);
        redirectAttributes.addFlashAttribute("offences", offences);
        return new ModelAndView("redirect:/showAverageOffence");
    }

    @GetMapping("/showAverageOffence")
    public ModelAndView showAverageOffence(@ModelAttribute("offences") ArrayList<Offence> offenceList, Model model) {
        Iterable<Offence> offences = offenceList;
        float avOffence = OffenceCount.count(offenceList);
        model.addAttribute("avOffence", avOffence);
        model.addAttribute("offences", offences);
        return new ModelAndView("showAverageOffence");
    }



    @GetMapping("/addDrive")
    public ModelAndView addDrive(Model model) {
        return new ModelAndView("addDrive");
    }

    @PostMapping("/addDrive")
    public ModelAndView addPost(@RequestParam int clientId, Model model) {
        Drive drive = new Drive(clientId);
        driveRepository.save(drive);

        ArrayList<Clients> clients = (ArrayList<Clients>) clientRepository.findAll();
        for (Clients element: clients) {

        }

        return new ModelAndView("redirect:/seeDrives");
    }


    @GetMapping("/addOffence")
    public ModelAndView addOffence(Model model) {
        return new ModelAndView("addOffence");
    }

    @PostMapping("/addOffence")
    public ModelAndView addOffencePost(@RequestParam int clientId, @RequestParam int fine, Model model) {
        Offence offence1 = new Offence(clientId, fine, LocalDate.now());
        offenceRepository.save(offence1);
        return new ModelAndView("redirect:/seeDrives");
    }




}
