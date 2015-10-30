package com.paloit.paloma.rest;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * REST controller for managing Statistical Information.
 */
@RestController
@RequestMapping("/app")
public class StatisticInfoResource {

    @RequestMapping(value = "/rest/homepage/getHomePageStatisticInfo",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Integer> getHomePageStatisticInfo(){
        /**
         *  method to get statistic info for home page
         */
        List<Integer> list = new ArrayList<Integer>();
        return list;
    }
}
