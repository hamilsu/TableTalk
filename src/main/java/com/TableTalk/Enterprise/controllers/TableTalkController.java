package com.tabletalk.enterprise.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
    public class TableTalkController {
        /**
         * Handle the root (/) endpoint and return a start page.
         * @return
         */
        @RequestMapping("/")
        public String index() {
            return "start";
        }

    }



