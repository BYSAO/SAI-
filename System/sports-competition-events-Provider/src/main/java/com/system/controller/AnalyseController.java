package com.system.controller;


import com.system.common.entity.Analyse;
import com.system.service.AnalyseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/Analyse")
public class AnalyseController {

    @Autowired
    private AnalyseService AnalyseService;

    @RequestMapping("/AnalyseItinerary")
    @ResponseBody
    //查询全部
    public List<Analyse> AnalyseItinerary(@RequestBody Analyse t) {
        return AnalyseService.AnalyseItinerary(t);
    }

    @RequestMapping("/AnalyseSum")
    @ResponseBody
    //查询全部
    public List<Analyse> AnalyseSum(@RequestBody Analyse t) {
        return AnalyseService.AnalyseSum(t);
    }


}
