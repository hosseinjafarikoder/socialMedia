package com.example.socialmedia2.entity;

import com.example.socialmedia2.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String comment;
    @ManyToOne
    private AccountEntity account;
    @ManyToOne
    private PostEntity post;
}
