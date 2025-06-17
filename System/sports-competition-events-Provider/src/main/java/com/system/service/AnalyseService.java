package com.system.service;

import com.system.common.entity.Analyse;
import com.system.dao.AnalyseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnalyseService {
    @Autowired
    private AnalyseDao AnalyseDao;

    public List<Analyse> AnalyseItinerary(Analyse o) {
        return AnalyseDao.AnalyseItinerary(o);
    }

    public List<Analyse> AnalyseSum(Analyse o) {
        return AnalyseDao.AnalyseSum(o);
    }

}
