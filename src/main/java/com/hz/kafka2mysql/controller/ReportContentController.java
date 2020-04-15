package com.hz.kafka2mysql.controller;

import com.hz.kafka2mysql.domain.KafkaOffset;
import com.hz.kafka2mysql.domain.ReportContent;
import com.hz.kafka2mysql.repository.KafkaOffsetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportContentController {
    @Autowired
    private KafkaOffsetRepository kafkaOffsetRepository;

    @RequestMapping("/test")
    public KafkaOffset getAllGrade(ReportContent reportContent){
//        return  kafkaOffsetRepository.getKafkaOffsetByTopicAndAndGroupId("1","1");
        KafkaOffset kafkaOffset = new KafkaOffset();
        kafkaOffset.setTopic("222");
        kafkaOffset.setGroupId("222");
        return  kafkaOffsetRepository.saveAndFlush(kafkaOffset);
    }

}
