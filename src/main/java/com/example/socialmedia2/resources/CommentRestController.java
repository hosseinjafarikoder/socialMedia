package com.example.socialmedia2.resources;

import com.example.socialmedia2.dto.CommentDto;
import com.example.socialmedia2.entity.AccountEntity;
import com.example.socialmedia2.entity.CommentEntity;
import com.example.socialmedia2.entity.PostEntity;
import com.example.socialmedia2.exceptions.BaseException;
import com.example.socialmedia2.mapper.CommentMapper;
import com.example.socialmedia2.service.AccountService;
import com.example.socialmedia2.service.CommentService;
import com.example.socialmedia2.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentRestController {
    private final CommentService commentService;
    private final CommentMapper commentMapper;
    private final PostService postService;
    private final AccountService accountService;

    @PostMapping
    public CommentDto createComment(Principal principal, @RequestBody CommentDto commentDto) throws BaseException {
        AccountEntity accountEntity = accountService.findByUsername(principal.getName());
        CommentEntity commentEntity = commentMapper.convertDtoToT(commentDto);
        PostEntity post = postService.findById(commentDto.getPostId());
        AccountEntity account = accountService.findById(accountEntity.getId());
        commentEntity.setPost(post);
        commentEntity.setAccount(account);
        return commentMapper.convertTToDto(commentService.saveOrUpdate(commentEntity));
    }


    @DeleteMapping("/{id}")
    public void deleteCommentById(@PathVariable Long id) throws BaseException {
        commentService.deleteById(id);
    }
}
