package com.yxp.eguodu.common;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * excel 导入基类
 */
public abstract class XlsRead {
    public String path;
    public String tablename;
    public String guidname;
    //接收获取上传文件,并返回路径名称
   public  Map<String ,Object>  GetUploadfile(@RequestParam MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
       String s = UUID.randomUUID().toString();
       String guid= System.currentTimeMillis()+s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
       //response.setHeader("Access-Control-Allow-Origin", "*");
       response.setHeader("Access-Control-Allow-Methods", "POST,PUT,OPTIONS,DELETE,GET");
       response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,content-type,Origin");
       response.setHeader("Access-Control-Allow-Credentials", "true");
       Map<String, Object> resMap = new HashMap<String, Object>();
       String realPath = "";
       String saveurl = "";
       String retstr = "";
       if (file.isEmpty()) {
           // 未选择文件
           resMap.put("status", "未选择文件");
       } else {
           // 文件后缀名
           String originFileName = file.getOriginalFilename().split("\\.")[1]
                   .toUpperCase();
           realPath = URLDecoder.decode(ClassUtils.getDefaultClassLoader().getResource("").getPath(), "UTF-8") + "/static/backfiles/excelImport/";
           saveurl = "/static/backfiles/excelImport/";
           path=realPath;
           tablename=file.getOriginalFilename().split("\\.")[0];
           guidname=guid + "." + originFileName;
           try {
               // 这里使用Apache的FileUtils方法来进行保存
               FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, guid + "." + originFileName));
               resMap.put("url", saveurl + guid + "." + originFileName);
               resMap.put("filename", file.getOriginalFilename());
               resMap.put("size", file.getSize());
               resMap.put("guid", guid);
               resMap.put("status", "ok");

           } catch (IOException e) {
               System.out.println("文件上传失败");
               resMap.put("status", "服务器IO异常");
               e.printStackTrace();
           }

       }
        return resMap;
   }

    /**
     * multfile转file
     * @param multfile
     * @return
     * @throws IOException
     */
    private File multipartToFile(MultipartFile multfile) throws IOException {
        CommonsMultipartFile cf = (CommonsMultipartFile)multfile;
        //这个myfile是MultipartFile的
        DiskFileItem fi = (DiskFileItem) cf.getFileItem();
        File file = fi.getStoreLocation();
        if(file.length() < multfile.getSize()){
            File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") +
                    file.getName());
            multfile.transferTo(tmpFile);
            return tmpFile;
        }
        System.out.println(file.length());
        System.out.println(multfile.getSize());
        return file;
    }

   //读取文件,并做相应处理
    /**
     * 处理xls
     * @param path
     * @param guidname
     * @param tablename
     * @return
     */
    public  abstract boolean dealXlsFile(String path,String guidname,String tablename,String otherMsgJson) throws IOException;///xls






//
//    /**
//     * 处理xlsx
//     * @param path
//     * @param guidname
//     * @param tablename
//     * @return
//     */
//    public  abstract boolean dealXlsxFile(String path,String guidname,String tablename,String otherMsgJson);///xlsx




}
