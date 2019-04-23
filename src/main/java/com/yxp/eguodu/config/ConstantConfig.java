package com.yxp.eguodu.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Configuration
public class ConstantConfig {

    @Value("${eguoduoos.endpoint}")
    private   String YIGUODU_END_POINT;
    @Value("${eguoduoos.keyid}")
    private  String YIGUODU_ACCESS_KEY_ID;
    @Value("${eguoduoos.keysecret}")
    private  String YIGUODU_ACCESS_KEY_SECRET;
    @Value("${eguoduoos.filehost}")
    private  String YIGUODU_FILE_HOST;
    @Value("${eguoduoos.bucketnamet}")
    private  String YIGUODU_BUCKET_NAMET;




}
