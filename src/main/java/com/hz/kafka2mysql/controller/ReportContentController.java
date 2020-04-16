package com.hz.kafka2mysql.controller;

import com.hz.kafka2mysql.domain.KafkaOffset;
import com.hz.kafka2mysql.domain.ReportContent;
import com.hz.kafka2mysql.repository.KafkaOffsetRepository;
import com.hz.kafka2mysql.service.ReportContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportContentController {


    @Autowired
    private ReportContentService reportContentService;

    @RequestMapping("/getReportContentById")
    public ReportContent getAllGrade(Integer id){
        return  reportContentService.getReportContentById(id);
    }

    @RequestMapping("/addReportContent")
    public ReportContent addAllGrade(ReportContent reportContent){
        return  reportContentService.InsertReportContent(reportContent);
    }
}
