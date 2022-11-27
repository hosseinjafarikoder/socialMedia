package com.example.socialmedia2.entity;

import com.example.socialmedia2.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "likes")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LikeEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private AccountEntity account;
    @ManyToOne
    private PostEntity post;
}
