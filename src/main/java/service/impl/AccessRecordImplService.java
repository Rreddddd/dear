package service.impl;

import dao.AccessRecordDao;
import entity.AccessRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pojo.AccessRecordKind;
import service.AccessRecordService;
import util.ApiTools;
import util.DateTools;
import util.IpConfig;
import util.MailTools;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

@Service("AccessRecordService")
public class AccessRecordImplService implements AccessRecordService {

    private AccessRecordDao accessRecordDao;
    private static AccessRecordImplService instance;

    @Autowired
    public AccessRecordImplService(AccessRecordDao accessRecordDao){
        this.accessRecordDao=accessRecordDao;
    }

    public void _addAccessRecord(String ip,String method){
        if(!StringUtils.isEmpty(ip) && !StringUtils.isEmpty(method)){
            AccessRecordEntity accessRecord=new AccessRecordEntity();
            accessRecord.setIp(ip);
            accessRecord.setMethod(method);
            String location=ApiTools.getIpLocate(ip);
            accessRecord.setLocation(location);
            accessRecord.setTime(new Timestamp(System.currentTimeMillis()));
            accessRecordDao.save(accessRecord);
            if(!ip.startsWith("192.168") && !location.startsWith("重庆")){
                MailTools.sendMessages("有dear的新访客",
                        "地址："+accessRecord.getLocation()+
                                "<br>模块："+ AccessRecordKind.getNameByCode(method)+
                                "<br>该ip累计访问："+accessRecordDao.getCountByIp(ip)+"次"+
                                "<br>最新访问时间："+ DateTools.YMD_HMS_FORMAT.format(accessRecord.getTime()));
            }
        }
    }

    public void _addAccessRecord(HttpServletRequest request, String method){
        _addAccessRecord(IpConfig.getIpAddr(request),method);
    }

    public static void addAccessRecord(String ip,String method){
        instance._addAccessRecord(ip,method);
    }

    public static void addAccessRecord(HttpServletRequest request, String method){
        instance._addAccessRecord(request,method);
    }

    @PostConstruct
    private void initGetInstance(){
        instance=this;
    }
}
