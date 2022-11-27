package com.example.socialmedia2.resources;

import com.example.socialmedia2.dto.PostDto;
import com.example.socialmedia2.entity.AccountEntity;
import com.example.socialmedia2.entity.FileEntity;
import com.example.socialmedia2.entity.PostEntity;
import com.example.socialmedia2.exceptions.BaseException;
import com.example.socialmedia2.mapper.PostMapper;
import com.example.socialmedia2.service.AccountService;
import com.example.socialmedia2.service.FileStorageService;
import com.example.socialmedia2.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostRestController {
    private final PostService postService;
    private final FileStorageService fileService;
    private final PostMapper postMapper;
    private final AccountService accountService;

    @PutMapping
    public PostDto updatePost(Principal principal, @RequestBody PostDto postDto) throws BaseException {
        AccountEntity accountEntity = accountService.findByUsername(principal.getName());
        PostEntity postEntity = postMapper.convertDtoToT(postDto);
        FileEntity file = fileService.getFile(postDto.getFileDto()).orElse(null);
        AccountEntity account = accountService.findById(accountEntity.getId());
        postEntity.setFileEntity(file);
        postEntity.setAccount(account);
        return postMapper.convertTToDto(postService.saveOrUpdate(postEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> findPostById(@PathVariable Long id) throws BaseException {
        PostEntity postEntity = postService.findById(id);
        return ResponseEntity.ok(
                postMapper.convertTToDto(postEntity)
        );
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> findAll() throws BaseException {
        List<PostEntity> postEntities = postService.findAll();
        return ResponseEntity.ok(
                postMapper.convertListEntityToListDto(postEntities)
        );
    }

    @DeleteMapping("/{id}")
    public void deletePostById(@PathVariable Long id) throws BaseException {
        postService.deleteById(id);
    }
}
