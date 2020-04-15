package com.hz.kafka2mysql.service.impl;

import com.hz.kafka2mysql.domain.ReportContent;
import com.hz.kafka2mysql.repository.ReportContentRepository;
import com.hz.kafka2mysql.service.ReportContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportContentServiceImpl implements ReportContentService {

    @Autowired
    private ReportContentRepository reportContentRepository;

    @Override
    public ReportContent getReportContentById(Integer id) {

        Optional<ReportContent> optional = reportContentRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public ReportContent InsertReportContent(ReportContent reportContent) {
        ReportContent resReport = reportContentRepository.saveAndFlush(reportContent);
        return resReport;
    }
}
