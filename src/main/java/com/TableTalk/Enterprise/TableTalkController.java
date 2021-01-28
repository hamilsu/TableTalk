package com.TableTalk.Enterprise;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
