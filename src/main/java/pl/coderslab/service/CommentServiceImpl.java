package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Meow;
import pl.coderslab.repository.CommentRepository;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

//    @Override
//    public void add(Comment comment, Meow meow) {
//        commentRepository.save(comment);
//        List<Comment> comments = meow.getComments();
//        comments.add(comment);
//        meow.setComments(comments);
//    }
}
