package com.example.socialmedia2.dto;

import com.example.socialmedia2.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class  CommentDtoId extends BaseDto {
    private Long id;
//    private Integer version;
    private String comment;
    private Long accountId;
    private Long postId;
}
