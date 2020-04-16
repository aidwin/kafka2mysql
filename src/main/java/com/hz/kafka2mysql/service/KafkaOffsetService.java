package com.hz.kafka2mysql.service;

import com.hz.kafka2mysql.domain.KafkaOffset;


public interface KafkaOffsetService {

    KafkaOffset getKafkaOffsetByTopicAndAndGroupIdandAndPartition (String topic,String groupId, Integer partition);

    KafkaOffset updateKafkaOffset (KafkaOffset kafkaOffset);

    KafkaOffset insertKafkaOffset (KafkaOffset kafkaOffset);
}
