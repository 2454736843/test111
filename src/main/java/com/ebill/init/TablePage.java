package com.ebill.init;

import com.ebill.DBUtil.EbillDao;
import com.ebill.dao.EbillDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TablePage {

    @Autowired
    private EbillDao ebillDao;

    private Long nowDate = System.currentTimeMillis();
    private int start = 0;

    @Async
    public void updatePage(){
        if (isUpdated()){
            start=0;
            nowDate = System.currentTimeMillis();
        }else {
            //get total
            int total = ebillDao.getTotal();

            List<EbillDetail> ebillDetails = ebillDao.selectLimitEbillDetail(start);
            for (EbillDetail ebillDetail : ebillDetails) {
                ebillDao.insert2EbillDetailShow(ebillDetail);
            }
            if (start<total){
                start+=3;
            }else {
                start=0;
            }
        }
    }

    //update
    public boolean isUpdated(){
        Date dateRecord = new Date(nowDate);
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        if (fmt.format(dateRecord).equals(fmt.format(dateRecord))){
            return false;
        }else {
            return true;
        }
    }

}
