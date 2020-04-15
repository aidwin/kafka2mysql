package com.hz.kafka2mysql.service;

import com.hz.kafka2mysql.domain.KafkaOffset;
import com.hz.kafka2mysql.domain.ReportContent;
import org.springframework.stereotype.Service;


public interface KafkaOffsetService {

    KafkaOffset getKafkaOffsetByTopicAndAndGroupId (String topic,String groupId);

    KafkaOffset updateKafkaOffset (KafkaOffset kafkaOffset);

    KafkaOffset insertKafkaOffset (KafkaOffset kafkaOffset);
}
