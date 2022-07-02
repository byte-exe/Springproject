package com.istidataproject.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.istidataproject.dto.SearchFormData;
import com.istidataproject.entity.Information;
import com.istidataproject.service.DataInformation;


@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private DataInformation dataInformation;

    @GetMapping
    public String welcome(Model model) {
        //doing something before getting return page index
        String Header = "Aplikasi Data Pribadi";
        model.addAttribute("headerString",Header);
        model.addAttribute("searchForm", new SearchFormData()); 
        model.addAttribute("informations", dataInformation.findAll());

        return "index";
        
    }

    @GetMapping("/input")
    public String input( Model model){
        //header form
        String HeaderInput = "Tambah Data Baru";
        model.addAttribute("headerInputString",HeaderInput);
        //get data dari form input
        model.addAttribute("information", new Information());
        return "input";
    }


    @PostMapping("/save")
    public String save(Information information, Model model){
        dataInformation.saveInformation(information);
        return "redirect:/";
    }

    @GetMapping("/delete/{nik}")
    public String delete(@PathVariable("nik") Long nik){
        dataInformation.deleteByNik(nik);
        return "redirect:/";

    }

    @GetMapping("/edit/{nik}")
    public String edit(@PathVariable("nik") Long nik, Model model){
        //header edit
        String HeaderEdit = "Edit Data";
        model.addAttribute("headerEditString",HeaderEdit);
        //
        model.addAttribute("information", dataInformation.findByNik(nik));
        return "edit";

    }

    @GetMapping("/info/{nik}")
    public String info(@PathVariable("nik") Long nik, Model model){
        //header edit
        String HeaderEdit = "View Data";
        model.addAttribute("headerEditString",HeaderEdit);
        //
        model.addAttribute("information", dataInformation.findByNik(nik));
        return "info";

    }

    @PostMapping("/update")
    public String update(Information information, Model model){
        dataInformation.updateInformation(information);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search( SearchFormData searchFormData, Model model){
        String Header = "Aplikasi Data Pribadi";
        model.addAttribute("headerString",Header);
        model.addAttribute("searchForm", searchFormData); 
        model.addAttribute("informations", dataInformation.findByName(searchFormData.getKeyword()));

        return "index";
    }

    
    
}
