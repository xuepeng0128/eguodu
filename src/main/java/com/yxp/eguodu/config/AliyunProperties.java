package com.yxp.eguodu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AliyunProperties {

    @Value("${eguoduoos.keyid}")
    private String accessId;

    @Value("${eguoduoos.keysecret}")
    private String accessKey;

    @Value("${eguoduoos.endpoint}")
    private String ossEndpoint;

    @Value("${eguoduoos.bucketnamet}")
    private String ossBucket;

    @Value("${eguoduoos.filehost}")
    private String host;

    @Value("${eguoduoos.ueditor.dir}")
    private String ossUeditorDir;

    public String getAccessId() {
        return accessId;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public String getOssEndpoint() {
        return ossEndpoint;
    }

    public String getOssBucket() {
        return ossBucket;
    }

    public String getOssUeditorDir() {
        return ossUeditorDir;
    }

    /**
     * 获取oss host "https://"+ ossBucket+"."+ossEndpoint;
     * @return
     */
    public String getOssHost(){
        return "https://"+ ossBucket+"."+ossEndpoint;
    }

    /**
     * 获取访问的路径
     * @return
     */
    public String getHost(){
        return host;
    }
}
