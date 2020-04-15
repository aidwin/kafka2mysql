package com.hz.kafka2mysql.test;

import com.hz.kafka2mysql.repository.KafkaOffsetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceptionTest {
    @Autowired
    private static KafkaOffsetRepository kafkaOffsetRepository;
    public static void main(String[] args) {
//        try {
//            int i = 10 / 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("==========");
//            System.out.println("tostring"+e.toString());
//            System.out.println("================");
//            System.out.println("stack"+e.getStackTrace().toString());
//
//            System.out.println("message"+e.getMessage().toString());
        System.out.println(kafkaOffsetRepository.getKafkaOffsetByTopicAndAndGroupId("1", "1"));
//        }

    }
}
