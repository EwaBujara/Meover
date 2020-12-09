package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.PrivateMeow;
import pl.coderslab.entity.User;
import pl.coderslab.repository.PrivateMeowRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/private_meow")
public class PrivateMeowController {


    @Autowired
    private PrivateMeowRepository privateMeowRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/inBox")
    public String showIn(Model model, HttpSession session){
        User currentUser = (User) session.getAttribute("currentUser");
        model.addAttribute("meows", privateMeowRepository.findAllByRecipientOrderByCreatedDesc(currentUser));
        return "private_meow/list";
    }

    @GetMapping("/out")
    public String showOut(Model model, HttpSession session){
        User currentUser = (User) session.getAttribute("currentUser");
        model.addAttribute("meows", privateMeowRepository.findAllByAuthorOrderByCreatedDesc(currentUser));
        return "private_meow/list";
    }

    @GetMapping("/show/{id}")
    public String showMessage(Model model, @PathVariable Long id){
        PrivateMeow privateMeow = privateMeowRepository.findOne(id);
        privateMeow.setStatus(false);
        privateMeowRepository.save(privateMeow);
        model.addAttribute("meow", privateMeow);
        return "private_meow/private_meow";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("meow", new PrivateMeow());
        model.addAttribute("users", userRepository.findAll());
        return "private_meow/form";
    }

    @PostMapping("/add")
    public String add(@Valid PrivateMeow privateMeow, BindingResult errors,
                      HttpServletRequest request,
                      HttpSession session){

        if(errors.hasErrors()){
            return "private_meow/form";
        }
        User currentUser = (User)session.getAttribute("currentUser");
        privateMeow.setAuthor(currentUser);
        privateMeow.setStatus(true);
        privateMeowRepository.save(privateMeow);
        return "redirect:"+request.getContextPath()+"/private_meow/inBox";
    }
}
