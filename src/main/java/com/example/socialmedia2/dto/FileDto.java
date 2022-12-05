package com.example.socialmedia2.dto;


import com.example.socialmedia2.base.BaseDto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class FileDto extends BaseDto {
    private Long id;
//    private Integer version;
    private String name;
    private String type;
    private byte[] data;
    private Long postDto;

}
