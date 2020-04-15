package com.hz.kafka2mysql.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "report_info")
public class ReportContent {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer healthReportId;

    private String reportContent;

    private Date createDate;

    private Date createTime;

    private Date lastUpdateTime;
}
