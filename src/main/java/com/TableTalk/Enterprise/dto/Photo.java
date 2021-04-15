package com.TableTalk.Enterprise.dto;

import com.sun.istack.Nullable;
import lombok.Data;

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

    @ManyToOne
    @JoinColumn(name="roomId")
    private Room room;
}