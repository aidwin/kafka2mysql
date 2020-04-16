package com.hz.kafka2mysql.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "kafka_offset")
public class KafkaOffset implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String topic;

    private String groupId;

    @Column(name = "partitioned")
    private Integer partition;

    @Column(name = "kafka_offset")
    private Integer offset;
}
