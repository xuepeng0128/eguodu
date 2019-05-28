package com.yxp.eguodu.controller;

import com.alibaba.fastjson.JSON;
import com.yxp.eguodu.service.ActionEnterService;
import com.yxp.eguodu.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@CrossOrigin
@RestController
public class UeditorUpload {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private String configDir ="/static/assets/ueditor/config.json";

    @Autowired
    private ActionEnterService actionEnterService;

    @GetMapping("/manager/UeditorUploadImgServlet")
    public void  get(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, FileNotFoundException {
//        logger.info("GET");
//        try {
//            logger.info(JSON.toJSONString(CommonUtil.resquestParameter2Map(request)));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String rootPath = ResourceUtils.getURL("classpath:").getPath();
//        String configJsonPath = rootPath + configDir;//获取文件路径
//        request.setCharacterEncoding("utf-8");
//        response.setHeader("Content-Type", "text/html");
//        actionEnterService.init(request, rootPath, configJsonPath);
//        String result = actionEnterService.exec();
//        return result;

//        String rootPath = ResourceUtils.getURL("classpath:").getPath();
//
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        String s = "{\n"+
                "          \"imageActionName\": \"uploadMediaFile\",\n" +
                "           \"imageFieldName\": \"file\", \n" +
                "           \"imageMaxSize\": 2048000, \n" +
                "           \"imageAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"], \n" +
                "           \"imageCompressEnable\": true, \n" +
                "           \"imageCompressBorder\": 1600, \n" +
                "            \"imageInsertAlign\": \"none\", \n" +
                "             \"imageUrlPrefix\": \"\",\n" +
                "            \"imagePathFormat\": \"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\" }";

        writer.print(  s);

    }

    @PostMapping("/manager/UeditorUploadImgServlet")
    public String post(HttpServletRequest request, @RequestParam(value = "upfile", required = false) MultipartFile uploadfile) throws Exception {
        logger.info("POST");
        logger.info(JSON.toJSONString(CommonUtil.resquestParameter2Map(request)));
        String rootPath = ResourceUtils.getURL("classpath:").getPath();
        String configJsonPath = rootPath + configDir;//获取文件路径
        if(uploadfile != null){
            actionEnterService.init(request, uploadfile, rootPath, configJsonPath);
        }else{
            String source = request.getParameter("source[]");
            actionEnterService.init(request, source, rootPath, configJsonPath);
        }
        return actionEnterService.exec();
    }

}
