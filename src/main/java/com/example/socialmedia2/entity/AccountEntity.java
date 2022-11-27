package com.example.socialmedia2.entity;

import com.example.socialmedia2.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "accounts")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    @NotBlank
    private String lastName;
    @Column(name = "username", unique = true, nullable = false)
    @NotBlank
    @NotEmpty
    @NotNull
    private String username;
    @Column(name = "password", nullable = false)
    @NotNull
    @NotBlank
    @Size(max = 120)
    private String password;
    @OneToMany(mappedBy = "account")
    private List<PostEntity> post;
    @OneToMany(mappedBy = "account")
    private List<CommentEntity> comment;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    //   Only for testing by constructor
    public AccountEntity(Long id, Integer version, String firstName, String lastName, String username, String password, Set<Role> roles, List<PostEntity> post, List<CommentEntity> comment) {
        super(version);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.post = post;
        this.comment = comment;
    }

    //   Only for testing by constructor
    public AccountEntity(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
    //   Only for method testing by constructor
    public AccountEntity( Integer version, String username, String password) {
        super(version);
        this.username = username;
        this.password = password;
    }
}
