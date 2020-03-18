package service;

import javax.servlet.http.HttpServletRequest;

public interface AccessRecordService {

    void _addAccessRecord(String ip,String method);

    void _addAccessRecord(HttpServletRequest request, String method);
}
