package com.example.socialmedia2.entity;


import com.example.socialmedia2.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "files")
@Setter
@Getter
@NoArgsConstructor
public class FileEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Lob
    private byte[] data;
    @OneToOne(mappedBy = "fileEntity")
    private PostEntity postEntity;

    public FileEntity(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public FileEntity(String name, String type, byte[] data, PostEntity postEntity) {
        this.name = name;
        this.type = type;
        this.data = data;
        this.postEntity = postEntity;
    }
}

