package com.hz.kafka2mysql.repository;

import com.hz.kafka2mysql.domain.KafkaOffset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KafkaOffsetRepository extends JpaRepository<KafkaOffset,Integer> {

    KafkaOffset getKafkaOffsetByTopicAndAndGroupIdandAndPartition(String topic, String groupId,Integer partition);
}
