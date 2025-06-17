package com.system.controller;

import com.system.common.entity.Analyse;
import com.system.service.AnalyseService;
import com.system.tools.ToolUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/Analyse")
public class AnalyseSysController {


    @Autowired
    private com.system.tools.ToolUser ToolUser;
    @Autowired
    private com.system.service.AnalyseService AnalyseService;

    //查询
    @RequestMapping("/AnalyseItinerary")
    @ResponseBody
    public List<Analyse> AnalyseItinerary(HttpServletResponse resp, HttpServletRequest req, Analyse o) {
        return AnalyseService.AnalyseItinerary(o);
    }

    //查询
    @RequestMapping("/AnalyseSum")
    @ResponseBody
    public List<Analyse> getAll(HttpServletResponse resp, HttpServletRequest req, Analyse o) {
        return AnalyseService.AnalyseSum(o);
    }

}
