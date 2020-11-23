package nl.miwgroningen.cohort4.ernstw.moviesDemo.controller;

import nl.miwgroningen.cohort4.ernstw.moviesDemo.model.Director;
import nl.miwgroningen.cohort4.ernstw.moviesDemo.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Ernst van der Wal
 */

@Controller
public class DirectorController {

    @Autowired
    DirectorRepository directorRepository;

    @GetMapping("/director")
    protected String showAuthor(Model model) {
        model.addAttribute("allDirectors", directorRepository.findAll());
        model.addAttribute("director", new Director());
        return "directorOverview";
    }

    @PostMapping("/director/add")
    protected String saveOrUpdatedirector(@ModelAttribute("director")Director director, BindingResult result) {
        if (result.hasErrors()) {
            return "directorOverview";
        } else {
            directorRepository.save(director);
            return "redirect:/director";
        }
    }
}
