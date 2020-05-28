package com.windaka.suizhi.webapi.service.impl;

import com.windaka.suizhi.common.exception.OssRenderException;
import com.windaka.suizhi.common.utils.PropertiesUtil;
import com.windaka.suizhi.webapi.dao.CaptureAlarmCarMapper;
import com.windaka.suizhi.webapi.dao.MsgSocketIdMapper;
import com.windaka.suizhi.webapi.service.CaptureAlarmCarService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class CaptureAlarmCarServiceImpl implements CaptureAlarmCarService {
    @Autowired
    private MsgSocketIdMapper msgSocketIdMapper;
    @Autowired
    private CaptureAlarmCarMapper captureAlarmCarMapper;
    @Override
    public List<Map<String, Object>> queryCapCarList(Map<String, Object> params) throws OssRenderException {
        //        根据记录表查找 上一次查询的最大id
        int lastId = msgSocketIdMapper.queryLastIdByRecordName("capture_alarm_car");

        //未发送的 告警人员列表
        List<Map<String, Object>> lists = captureAlarmCarMapper.queryAlarmCarList(lastId);
        if (lists.size() > 0) {

            Iterator i=lists.iterator();
            while (i.hasNext()){
                Map<String,Object> t=(Map<String,Object>)i.next();


                //处理图片 拼接地址
                if (t.get("capImage")!=null &&! StringUtils.isEmpty(t.get("capImage").toString()) &&
                        t.get("groupImage")!=null &&! StringUtils.isEmpty(t.get("groupImage").toString())){

                    t.put("capImage", PropertiesUtil.getLocalTomcatImageIp()+t.get("capImage"));
                    t.put("groupImage", PropertiesUtil.getLocalTomcatImageIp()+t.get("groupImage"));
                }
                t.put("webStatus","c");//推送标志
                t.put("msgType","4");//推送标志
            }

//            更新id记录表
            Map<String, Object> lastRecord = lists.get(lists.size() - 1);//获取最后一条id (max)
            lastId = (Integer) lastRecord.get("id");
            Map<String, Object> innerParam = new HashMap<>();
            innerParam.put("recordName", "capture_alarm_car");
            innerParam.put("maxId", lastId);
            msgSocketIdMapper.updateLastIdByRecordName(innerParam);
        }

        return lists;
    }
}
