package com.yxp.eguodu.controller;

import com.alibaba.fastjson.JSON;
import com.yxp.eguodu.common.AliyunOSSUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@Controller
public class UpLoadMediaController {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
    private static final String TO_PATH="upLoad";
    private static final String RETURN_PATH="success";

    @Autowired
    private AliyunOSSUtil aliyunOSSUtil;
    @RequestMapping("/toUpLoadMediaFile")
    public String toUpLoadFile(){
        return TO_PATH;
    }


    String uploadUrl="";
    /** 文件上传*/
    @RequestMapping(value = "/uploadMediaFile")
    @ResponseBody
    public void uploadBlog( MultipartFile file,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Methods", "POST,PUT,OPTIONS,DELETE,GET");
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,content-type,Origin");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        logger.info("文件上传");
        String filename = file.getOriginalFilename();
        System.out.println(filename);
        uploadUrl="http://wxg-sign.oss-cn-qingdao.aliyuncs.com/";
        try {

            if (file!=null) {
                if (!"".equals(filename.trim())) {
                    File newFile = new File(filename);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(file.getBytes());
                    os.close();
                    file.transferTo(newFile);
                    // 上传到OSS
                    uploadUrl += aliyunOSSUtil.upLoad(newFile);
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Map<String,String> retmap = new HashMap<String,String>(){{
            put("aliUrl" , uploadUrl);
        }};
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        writer.print(JSON.toJSONString(retmap));
    }

}
