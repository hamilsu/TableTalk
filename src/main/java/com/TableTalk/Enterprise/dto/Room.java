package com.TableTalk.Enterprise.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public @Data
class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    private LocalDateTime finalizedDate; //Might opt to change this to a nullable class since initially dates would be tbd
    private String address;
    private String gameId;


    @Nullable
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Photo> photos;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
