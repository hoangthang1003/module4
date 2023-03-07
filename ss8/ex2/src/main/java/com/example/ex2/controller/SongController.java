package com.example.ex2.controller;


import com.example.ex2.dto.SongDTO;
import com.example.ex2.model.Song;
import com.example.ex2.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String showListSong(Model model) {

        Iterable<Song> songList = songService.findAll();

        List<SongDTO> songDtoList = new ArrayList<>();

        for (Song x : songList) {
            songDtoList.add(new SongDTO(x.getId(), x.getName(), x.getPerformer(), x.getGenre()));
        }

        model.addAttribute("songList", songDtoList);

        return "/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {

        model.addAttribute("songNew", new SongDTO());

        return "/create";
    }

    @PostMapping("/create")
    public String createSong(@Validated @ModelAttribute(value = "songNew") SongDTO songNew,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {


        new SongDTO().validate(songNew, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/create";
        }

        Song song = new Song();
        BeanUtils.copyProperties(songNew, song);

        songService.save(song);

        redirectAttributes.addFlashAttribute("mess", "New song created successfully!");

        return "redirect:/list";
    }

    @GetMapping("/edit-song/{idEdit}")
    public String showEditForm(Model model, @PathVariable Integer idEdit) {
        Optional<Song> songEdit = songService.findById(idEdit);

        if (songEdit.isPresent()) {
            SongDTO songDtoEdit = new SongDTO();
            BeanUtils.copyProperties(songEdit.get(), songDtoEdit);
            model.addAttribute("songEdit", songDtoEdit);
            return "/edit";
        } else {
            return "/error";
        }
    }

    @PostMapping("/edit")
    public String editBlog(@Validated @ModelAttribute(value = "songEdit") SongDTO songEdit,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        new SongDTO().validate(songEdit, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/edit";
        }

        Song song = new Song();
        BeanUtils.copyProperties(songEdit, song);

        songService.save(song);

        redirectAttributes.addFlashAttribute("mess", "Song Edited successfully!");

        return "redirect:/list";
    }

}
