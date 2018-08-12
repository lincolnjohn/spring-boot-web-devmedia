package br.edu.thot.controller;

import br.edu.thot.domain.PlayList;
import br.edu.thot.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("playlists")
public class PlayListController {

    @Autowired
    private PlayListService playListService;

    @GetMapping("/listar")
    public ModelAndView listar(ModelMap model){
        model.addAttribute("playlists",playListService.recuperar());
        return new ModelAndView("/playlist/list",model);

    }

    @GetMapping("/cadastro")
    public String preSalvar(@ModelAttribute("playlist") PlayList playlist){
        return "/playlist/add";

    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("playlist") PlayList playlist,
                         BindingResult result, RedirectAttributes attr){
        if (result.hasErrors()){
            return "/playlist/add";
        }
        playListService.salvar(playlist);
        attr.addFlashAttribute("mensagem","Playlist criada com sucesso!");
        return "redirect:/playlists/listar";


    }
}
