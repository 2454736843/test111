package com.ebill.gettopic;

import com.ebill.DBUtil.EbillDao;
import com.ebill.dao.EBill;
import com.ebill.dao.EbillDetail;
import com.ebill.dao.EbillTopic;
import com.ebill.dao.EbillType;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class EbillConsumer {

    @Autowired
    private EbillDao ebillDao;

    private static Logger LOG = LoggerFactory.getLogger(EbillConsumer.class);

    @PostConstruct
    public void init(){
        LOG.info("e_bill kafka consumer is working!!");
    }

    @KafkaListener(topics = {"test"})
    @Transactional
    public void listen (ConsumerRecord<String, String> record){
        if (record == null){
            LOG.info("producer send a null message");
        }
        LOG.info("get topic,topic = %s, offset = %d, value = %s \n"
                ,record.topic()
                ,record.offset()
                ,record.value());
        try {
            String message = record.value();
            Map<String, String> resultMap = KafkaUtil.parseMessagg(message);
            //ebilltopic.
            EbillTopic ebillTopic = KafkaUtil.initEbillTopic(resultMap);
            ebillDao.insert2Topic(ebillTopic);
            //ebill
            EBill eBill = KafkaUtil.initEbill(resultMap);
            ebillDao.insert2Ebill(eBill);
            //ebillType
            EbillType ebillType = KafkaUtil.initEbillType(resultMap);
            ebillDao.insert2EbillType(ebillType);
            //ebilldetail
            EbillDetail ebillDetail = KafkaUtil.initEbillDetail(resultMap);
            ebillDao.insert2EbillDetail(ebillDetail);
        }catch (Exception e){
            LOG.info("parse topic failed,topic = %s, offset = %d, value = %s \n"
                    ,record.topic()
                    ,record.offset()
                    ,record.value());
            e.printStackTrace();
        }
    }
}
