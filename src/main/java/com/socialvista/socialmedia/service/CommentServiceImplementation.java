package com.socialvista.socialmedia.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialvista.socialmedia.models.Comment;
import com.socialvista.socialmedia.models.User;
import com.socialvista.socialmedia.models.UserPost;
import com.socialvista.socialmedia.repository.CommentRepository;
import com.socialvista.socialmedia.repository.PostRepository;
import com.socialvista.socialmedia.repository.UserRepository;

@Service
public class CommentServiceImplementation implements CommentService {

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public Comment createComment(Comment comment, Integer postId, Integer userId) {
        
        User user = userService.findUserById(userId);

        UserPost post = postService.findPostById(postId);

        Comment newComment = new Comment();

        newComment.setUser(user);
        newComment.setContent(comment.getContent());
        newComment.setCreatedAt(LocalDateTime.now());

        Comment savedComment = commentRepository.save(newComment);

        post.getComments().add(savedComment);

        postRepository.save(post);

        return savedComment;
    }

    @Override
    public Comment likComment(Integer commentId, Integer userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'likComment'");
    }

    @Override
    public Comment findCommentById(Integer commentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findCommentById'");
    }
    
}
