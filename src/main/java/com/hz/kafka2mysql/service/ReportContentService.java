package com.hz.kafka2mysql.service;

import com.hz.kafka2mysql.domain.ReportContent;

public interface ReportContentService {

    ReportContent getReportContentById (Integer id);

    ReportContent InsertReportContent (ReportContent reportContent);
}
