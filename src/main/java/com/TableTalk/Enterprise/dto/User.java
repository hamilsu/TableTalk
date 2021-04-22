package com.TableTalk.Enterprise.dto;


import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
public @Data
class User {
    @Id
    private String id;

    @NotNull
    private String displayedName;

    @Nullable
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Room> rooms;


}
