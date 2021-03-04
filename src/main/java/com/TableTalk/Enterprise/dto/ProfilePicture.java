package com.tabletalk.Enterprise.dto;

import lombok.Data;

//creating a profile picture class for efficiency. Might change it to a generic Photo class if we need photos anywhere else.

   // @Entity
   // @Table(name="photos")
    public @Data
    class ProfilePicture {

       // @Id
      //  @GeneratedValue
        private int photoId;
        private String path;
        private String fileName;

     //   @ToString.Exclude
      //  @ManyToOne
      //  @JoinColumn(name="username")
        private User user;
    }


