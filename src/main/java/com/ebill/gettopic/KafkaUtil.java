package com.ebill.gettopic;

import com.alibaba.fastjson.JSON;
import com.ebill.dao.EBill;
import com.ebill.dao.EbillDetail;
import com.ebill.dao.EbillTopic;
import com.ebill.dao.EbillType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class KafkaUtil {

    private static Logger LOG = LoggerFactory.getLogger(KafkaUtil.class);

    public static Map<String,String> parseMessagg(String message) throws Exception{

        Map<String,String> parse = (Map) JSON.parse(message);
        return parse;
    }

    public static EbillTopic initEbillTopic(Map<String,String> messageMap) throws ParseException {
        EbillTopic ebillTopic = new EbillTopic();

        ebillTopic.setBusNo(messageMap.get("busNo"));
        ebillTopic.setPlaceCode(messageMap.get("placeCode"));
        ebillTopic.setSystemcode(messageMap.get("systemcode"));
        ebillTopic.setBusDateTime(dateParse(messageMap.get("busDateTime")));
        ebillTopic.setPayer(messageMap.get("payer"));
        ebillTopic.setPatientId(messageMap.get("patientId"));
        ebillTopic.setSex(messageMap.get("sex"));
        ebillTopic.setTel(messageMap.get("tel"));
        ebillTopic.setAge(messageMap.get("age"));
        return ebillTopic;
    }

    public static EBill initEbill(Map<String,String> messageMap){
        EBill eBill = new EBill();

        eBill.setId(messageMap.get("placeCode"));
        eBill.setBusDataTime(dateParse(messageMap.get("busDateTime")));
        eBill.setValue(1);

        return eBill;
    }

    public static EbillType initEbillType(Map<String,String> messageMap){
        EbillType ebillTypeype = new EbillType();

        ebillTypeype.setId(messageMap.get("systemcode"));
        ebillTypeype.setBusDataTime(dateParse(messageMap.get("busDateTime")));
        ebillTypeype.setValue(1);

        return ebillTypeype;
    }

    public static EbillDetail initEbillDetail(Map<String,String> messageMap){
        EbillDetail ebillDetail = new EbillDetail();

        ebillDetail.setId(messageMap.get("busNo"));
        ebillDetail.setBusDataTime(dateParse(messageMap.get("busDateTime")));
        ebillDetail.setE_location(messageMap.get("placeCode"));
        ebillDetail.setE_name(messageMap.get("payer"));
        ebillDetail.setE_type(messageMap.get("systemcode"));
        ebillDetail.setMale(messageMap.get("sex"));

        return ebillDetail;
    }

    public static double dateParse(String busDate){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date parse = null;
        try {
            parse = formatter.parse(busDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse.getTime()/1000;
    }

}
