package com.system.service;

import com.system.common.entity.Analyse;
import com.system.provider.restTemplate.AnalysePService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnalyseService {

    @Autowired
    private AnalysePService AnalyseDao;


    public List<Analyse> AnalyseItinerary(Analyse o) {
        return AnalyseDao.AnalyseItinerary(o);
    }

    public List<Analyse> AnalyseSum(Analyse o) {
        return AnalyseDao.AnalyseSum(o);
    }
}
