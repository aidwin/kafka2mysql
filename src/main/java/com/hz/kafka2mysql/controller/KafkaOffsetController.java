package com.hz.kafka2mysql.controller;

import com.hz.kafka2mysql.domain.KafkaOffset;
import com.hz.kafka2mysql.domain.ReportContent;
import com.hz.kafka2mysql.repository.KafkaOffsetRepository;
import com.hz.kafka2mysql.service.ReportContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaOffsetController {
    @Autowired
    private KafkaOffsetRepository kafkaOffsetRepository;

    @RequestMapping("/addKafkaOffset")
    public KafkaOffset addKafkaOffset(KafkaOffset Offset){
        KafkaOffset kafkaOffset = new KafkaOffset();
        kafkaOffset.setTopic("222");
        kafkaOffset.setGroupId("222");
        return  kafkaOffsetRepository.saveAndFlush(kafkaOffset);
    }

    @RequestMapping("/getKafkaOffset")
    public KafkaOffset getKafkaOffset(String topic,String groupId){
        return  kafkaOffsetRepository.getKafkaOffsetByTopicAndAndGroupId("1","1");
    }
}
