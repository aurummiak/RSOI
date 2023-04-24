package com.example.cars;

import com.example.cars.domain.Clients;
import com.example.cars.domain.Drive;
import com.example.cars.domain.Offence;
import com.example.cars.domain.Park;
import com.example.cars.repos.ClientRepo;
import com.example.cars.repos.DriveRepo;
import com.example.cars.repos.OffenceRepo;
import com.example.cars.repos.ParkRepo;
import com.example.cars.service.OffenceCount;
import com.example.cars.service.SumKmCounting;
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
    @Autowired
    private ParkRepo parkRepository;

    public String testProj(String message) {
        message = "warning";
        return message;
    }
    @GetMapping("/")
    public static ModelAndView menu(Model model) {
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


    @GetMapping("/findSumKm")
    public ModelAndView findKm(Model model) {
        return new ModelAndView("findSumKm");
    }


    @PostMapping ("/findSumKm/{clientId}")
    public ModelAndView findSumKmByIdClient(@PathVariable(value = "clientId") int id, Model model) {
        Drive drives = driveRepository.findById(id).orElseThrow();
        drives.getKm();
        SumKmCounting.countKm(drives);
        return new ModelAndView("redirect:/seeClients");
    }


    @GetMapping("/seePark")
    public ModelAndView showPark(Model model) {
        Iterable<Park> parks = parkRepository.findAll();
        model.addAttribute("park", parks);
        return new ModelAndView("showPark");
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



    @PostMapping("/showFine")
    public ModelAndView showFine(@PathVariable(value = "clientId") int id, Model model, RedirectAttributes redirectAttributes) {
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
        return new ModelAndView("showFine");
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
    public ModelAndView addOffencePost(@RequestParam int clientId, int fine, LocalDate date , Model model) {
        Offence offence1 = new Offence(clientId, fine, LocalDate.now());
        offenceRepository.save(offence1);
        return new ModelAndView("redirect:/showClients"); //redirect:/seeDrives
    }




}
