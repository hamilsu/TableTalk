package com.TableTalk.Enterprise.dto;



import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Users")
public @Data
class User {
    @Id
    private String id;

    @NotNull
    private String displayedName;

    @ElementCollection
    @CollectionTable(name = "user_rooms", joinColumns = @JoinColumn(name = "id"))
    private Set<String> availableRooms;


}
