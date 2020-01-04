package com.ebill.DBUtil;

import com.ebill.dao.EBill;
import com.ebill.dao.EbillDetail;
import com.ebill.dao.EbillTopic;
import com.ebill.dao.EbillType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EbillDao {

    @Insert("insert into e_bill(id, busDataTime, value; ) values(#{id}, #{busDataTime}, #{value})")
    boolean insert2Ebill(EBill eBill);

    @Insert("insert into e_bill_detail_show(id,e_name,male,e_location,e_type,busDataTime) " +
            "values(#{id},#{e_name},#{male},#{e_location},#{e_type},#{busDataTime})")
    boolean insert2EbillDetail(EbillDetail ebillDetail);

    @Insert("insert into e_bill_detail(id,e_name,male,e_location,e_type,busDataTime) " +
            "values(#{id},#{e_name},#{male},#{e_location},#{e_type},#{busDataTime})")
    boolean insert2EbillDetailShow(EbillDetail ebillDetail);

    @Insert("insert into e_bill_type(id, busDataTime, value; ) values(#{id}, #{busDataTime}, #{value})")
    boolean insert2EbillType(EbillType ebillType);

    @Insert("insert into e_bil(busNo,placeCode,systemcode, busDateTime,payer,patientId,sex,tel,age,) " +
            "values(#{busNo},#{placeCode},#{systemcode},#{busDateTime},#{payer},#{patientId},#{sex},#{tel},#{age})")
    boolean insert2Topic(EbillTopic ebillTopic);

    @Select({"SELECT * FROM e_bill_detail " +
            "WHERE day(FROM_UNIXTIME(busDataTime))=day(now()) limit #{start},3"})
    List<EbillDetail> selectLimitEbillDetail(int start);


    @Select({"SELECT count(1) FROM e_bill_detail " +
            "WHERE day(FROM_UNIXTIME(busDataTime))=day(now())"})
    int getTotal();

}
