package nl.miwgroningen.cohort4.ernstw.moviesDemo.controller;

import nl.miwgroningen.cohort4.ernstw.moviesDemo.model.MovieUser;
import nl.miwgroningen.cohort4.ernstw.moviesDemo.repository.MovieUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class MovieUserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    MovieUserRepository movieUserRepository;

    @GetMapping ("/user/new")
    @Secured("ROLE_ADMIN")
    protected String showNewUserForm (Model model) {
        model.addAttribute("user", new MovieUser());
        return "userForm";
    }

    @PostMapping("/user/new")
    @Secured("ROLE_ADMIN")
    protected String saveOrUpdateUser(@ModelAttribute("user")MovieUser user, BindingResult result) {
        if (result.hasErrors()) {
            return "userForm";
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            movieUserRepository.save(user);
            return "redirect:/";

        }
    }





}
