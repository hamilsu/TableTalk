package com.TableTalk.Enterprise.dto;

import com.sun.istack.Nullable;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="photos")
public @Data
class Photo {

    @Id
    @GeneratedValue
    private int id;
    private String path;
    private String fileName;
    private String comments;


    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="roomId")
    private Room room;
}
