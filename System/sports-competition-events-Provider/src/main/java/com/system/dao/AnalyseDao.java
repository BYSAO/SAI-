package com.system.dao;

import com.system.common.entity.Analyse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalyseDao {
    //分析数据
    List<Analyse> AnalyseItinerary(Analyse o);

    List<Analyse> AnalyseSum(Analyse o);
}
