package com.hz.kafka2mysql.service.impl;

import com.hz.kafka2mysql.domain.KafkaOffset;
import com.hz.kafka2mysql.repository.KafkaOffsetRepository;
import com.hz.kafka2mysql.service.KafkaOffsetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaOffsetServiceImpl  implements KafkaOffsetService {
    @Autowired
    private KafkaOffsetRepository kafkaOffsetRepository;

    @Override
    public KafkaOffset getKafkaOffsetByTopicAndAndGroupId(String topic,String groupId) {
        KafkaOffset kafkaOffset = kafkaOffsetRepository.getKafkaOffsetByTopicAndAndGroupId(topic, groupId);
        return kafkaOffset;
    }

    @Override
    public KafkaOffset updateKafkaOffset(KafkaOffset kafkaOffset) {
        KafkaOffset resKafkaOffset = kafkaOffsetRepository.saveAndFlush(kafkaOffset);
        return resKafkaOffset;
    }

    @Override
    public KafkaOffset insertKafkaOffset(KafkaOffset kafkaOffset) {
        KafkaOffset resKafkaOffset = kafkaOffsetRepository.saveAndFlush(kafkaOffset);
        return resKafkaOffset;
    }
}
