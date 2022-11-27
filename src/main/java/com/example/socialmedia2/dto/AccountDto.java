package com.example.socialmedia2.dto;

import com.example.socialmedia2.base.BaseDto;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class AccountDto extends BaseDto {
    private Long id;
    private Integer version;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @NotEmpty
    @NotNull
    private String username;
    @NotBlank
    @NotNull
    @Size(min = 6, max = 12)
    private String password;
}
