package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Meow;
import pl.coderslab.entity.User;
import pl.coderslab.repository.CommentRepository;
import pl.coderslab.repository.MeowRepository;
import pl.coderslab.service.CommentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    MeowRepository meowRepository;

    @Autowired
    CommentService commentService;

    @GetMapping("/add/{id}")
    public String add(Model model, @PathVariable Long id){
        Comment comment = new Comment();
        comment.setMeow(meowRepository.findOne(id));
        model.addAttribute("comment",comment);
        return "comment/form";
    }

    @PostMapping("/add/{meowId}")
    public String add(@Valid Comment comment, BindingResult errors,
                      HttpServletRequest request,
                      @PathVariable Long meowId,
                      HttpSession session){

        User user = (User)session.getAttribute("currentUser");
        comment.setUser(user);
        Meow meow = meowRepository.findOne(meowId);
        comment.setMeow(meow);
//        commentService.add(comment,meow);


        if(errors.hasErrors()){
            return "comment/form";
        }
        commentRepository.save(comment);
        return "redirect:"+request.getContextPath()+"/meow/meow/"+meowId;
    }
}
