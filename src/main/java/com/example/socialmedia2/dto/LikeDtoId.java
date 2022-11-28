package com.example.socialmedia2.dto;

import com.example.socialmedia2.base.BaseDto;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LikeDtoId extends BaseDto{
    private Long id;
    private Integer version;
    private Long accountId;
    private Long postId;
}
