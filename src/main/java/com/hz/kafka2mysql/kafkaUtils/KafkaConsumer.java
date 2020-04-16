package com.hz.kafka2mysql.kafkaUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hz.kafka2mysql.domain.KafkaOffset;
import com.hz.kafka2mysql.domain.ReportContent;
import com.hz.kafka2mysql.service.KafkaOffsetService;
import com.hz.kafka2mysql.service.ReportContentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.hz.kafka2mysql.utils.DateUtils.DateStrConersionDate;
import static com.hz.kafka2mysql.utils.DateUtils.datetimeToDate;

@Slf4j
@Component
public class KafkaConsumer {

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    @Autowired
    private ReportContentService reportContentService;

    @Autowired
    private KafkaOffsetService kafkaOffsetService;

    @KafkaListener(topics = {"dev-syn-table-reportcontent"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            JSONObject obj = null;
            try {
                JSONObject jsonObject = JSON.parseObject(message.toString());
                obj = JSON.parseObject(jsonObject.get("obj").toString());
            } catch (Exception e) {
                e.printStackTrace();
                log.info(e.toString());
                log.info("offset = "+record.offset()+",消费失败，kakfa中的消息为"+ record.toString());
            }
            if(obj != null){
                ReportContent reportContent = new ReportContent();
                reportContent.setCreateDate( datetimeToDate(obj.get("reportCreateTime")) );
                reportContent.setHealthReportId( Integer.parseInt(obj.get("healthReportId").toString()));
                reportContent.setReportContent(obj.get("reportContent").toString());
                reportContent.setCreateTime(DateStrConersionDate(obj.get("reportCreateTime")));
                reportContent.setLastUpdateTime(DateStrConersionDate(obj.get("lastUpdateTime")));
                reportContentService.InsertReportContent(reportContent);
                //插入数据之后记录偏移量
                KafkaOffset kafkaOffset = kafkaOffsetService.getKafkaOffsetByTopicAndAndGroupIdandAndPartition(record.topic(), groupId, record.partition());
                if (kafkaOffset != null ){
                    kafkaOffset.setOffset((int) record.offset());
                    kafkaOffsetService.updateKafkaOffset(kafkaOffset);
                }else {
                    kafkaOffset  = new KafkaOffset();
                    kafkaOffset.setPartition(record.partition());
                    kafkaOffset.setOffset((int) record.offset());
                    kafkaOffset.setTopic(record.topic());
                    kafkaOffset.setGroupId(groupId);
                    kafkaOffsetService.insertKafkaOffset(kafkaOffset);
                }
                System.out.println("消费成功"+record.offset());
            }
        }
    }
}
