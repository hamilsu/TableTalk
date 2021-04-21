package com.TableTalk.Enterprise.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;
}
