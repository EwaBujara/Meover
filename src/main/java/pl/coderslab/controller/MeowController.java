package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Meow;
import pl.coderslab.entity.User;
import pl.coderslab.repository.CommentRepository;
import pl.coderslab.repository.MeowRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/meow")
@Controller
public class MeowController {

    @Autowired
    MeowRepository meowRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("meow", new Meow());
        return "meow/form";
    }

    @PostMapping("/add")
    public String add(@Valid Meow meow, BindingResult errors,
                      HttpServletRequest request,
                      HttpSession session){

        if(errors.hasErrors()){
            return "meow/form";
        }
        User user = (User)session.getAttribute("currentUser");
        meow.setUser(user);
        meowRepository.save(meow);
        return "redirect:"+request.getContextPath()+"/meow/list";
    }

    @GetMapping("/list")
    public String showAll(Model model){
        model.addAttribute("meows", meowRepository.findAll());
        return "meow/list";
    }

    @GetMapping("/list/{id}")
    public String showAll(Model model,@PathVariable Long id){
        User user = userRepository.findOne(id);
        model.addAttribute("meows",meowRepository.findAllByUserOrderByCreatedDesc(user));
        return "meow/list";
    }


    @GetMapping("/meow/{id}")
    public String showMeow(@PathVariable Long id, Model model){
        model.addAttribute("meow", meowRepository.findOne(id));
        Meow meow = meowRepository.findOne(id);
        model.addAttribute("comments",commentRepository.findAllByMeowOrderByCreatedDesc(meow));
        return "meow/meow";
    }

//    @ModelAttribute("meows")
//    public List<User> usersList(){return userRepository.findAll();}
}

