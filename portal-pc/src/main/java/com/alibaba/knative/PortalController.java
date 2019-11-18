package com.alibaba.knative;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortalController {

    @Autowired
    private BaseInfoInterface baseInfoInterface;

    @Autowired
    private ContactInfoInterface contactInfoInterface;

    @RequestMapping(value = "/api/company/{companycode}", method = {RequestMethod.GET})
    public String company() {

        Result result = new Result();

        try {
            JSONObject baseinfo = JSON.parseObject(baseInfoInterface.baseinfo());
            JSONObject contactinfo = JSON.parseObject(contactInfoInterface.contactinfo());

            Result.Rdata rdata = new Result.Rdata();
            JSONObject baseinfoData = baseinfo.getJSONObject("data");
            rdata.setAddress(baseinfoData.getString("address"));
            rdata.setName(baseinfoData.getString("name"));
            rdata.setProfile(baseinfoData.getString("profile"));
            rdata.setSite(baseinfoData.getString("site"));

            JSONObject contactinfoData = contactinfo.getJSONObject("data");

            rdata.setContact(contactinfoData.getString("contact"));
            rdata.setEmail(contactinfoData.getString("email"));
            rdata.setPhone(contactinfoData.getString("phone"));

            result.setData(rdata);

            result.setStatus("success");

        } catch (Exception e) {

            e.printStackTrace();
            result.setErrmsg(e.getMessage());
        }

        return JSONObject.toJSONString(result);
    }

    @Data
    static class Result {

        private String status;
        private String errmsg;
        private Rdata  data;

        @lombok.Data
        static class Rdata {
            private String name;
            private String address;
            private String profile;
            private String site;
            private String contact;
            private String phone;
            private String email;

        }
    }

}