package com.yxp.eguodu.common;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.Charset;
import java.util.Base64;


public class DesUtil {

    public static final Charset DEFAULT_CHARSET = Charset.forName("utf-8");
    public static final String  DEFAULT_SKEY    = "ygd@2019";







    public static String encrypt(String srcStr) throws Exception {
        return encrypt(srcStr,DEFAULT_CHARSET,DEFAULT_SKEY);
    }

    public static String encrypt(String srcStr, String sKey) throws Exception {
       return encrypt(srcStr,DEFAULT_CHARSET,sKey);
    }


    /**
     * 加密
     * @param srcStr
     * @param charset
     * @param sKey
     * @return
     */
    public static String encrypt(String srcStr, Charset charset, String sKey) throws Exception {
        byte[] src = srcStr.getBytes(charset);
        byte[] buf = doEncrypt(src, sKey);
        return parseByte2HexStr(buf);
    }


    public static String decrypt(String hexStr) throws Exception {
       return decrypt(hexStr,DEFAULT_CHARSET,DEFAULT_SKEY);
    }

    public static String decrypt(String hexStr, String sKey) throws Exception {
        return decrypt(hexStr,DEFAULT_CHARSET,sKey);
    }

    /**
     * 解密
     *
     * @param hexStr
     * @param charset
     * @param sKey
     * @return
     * @throws Exception
     */
    public static String decrypt(String hexStr, Charset charset, String sKey) throws Exception {
        byte[] src = parseHexStr2Byte(hexStr);
        byte[] buf = doDecrypt(src, sKey);
        return new String(buf, charset);
    }





        /**
         * 加密
         * @param data
         * @param sKey
         * @return
         */
        public static byte[] doEncrypt(byte[] data, String sKey) throws Exception{
            try {
                byte[] key = sKey.getBytes();
                // 初始化向量
                IvParameterSpec iv = new IvParameterSpec(key);
                DESKeySpec desKey = new DESKeySpec(key);
                // 创建一个密匙工厂，然后用它把DESKeySpec转换成securekey
                SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
                SecretKey securekey = keyFactory.generateSecret(desKey);
                // Cipher对象实际完成加密操作
                Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
                // 用密匙初始化Cipher对象
                cipher.init(Cipher.ENCRYPT_MODE, securekey, iv);
                // 现在，获取数据并加密
                // 正式执行加密操作
                return cipher.doFinal(data);
            } catch (Throwable e) {
                e.printStackTrace();
                throw e;
            }



        }

        /**
         * 解密
         * @param src
         * @param sKey
         * @return
         * @throws Exception
         */
        public static byte[] doDecrypt(byte[] src, String sKey) throws Exception {
            try {
                byte[] key = sKey.getBytes();
                // 初始化向量
                IvParameterSpec iv = new IvParameterSpec(key);
                // 创建一个DESKeySpec对象
                DESKeySpec desKey = new DESKeySpec(key);
                // 创建一个密匙工厂
                SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
                // 将DESKeySpec对象转换成SecretKey对象
                SecretKey securekey = keyFactory.generateSecret(desKey);
                // Cipher对象实际完成解密操作
                Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
                // 用密匙初始化Cipher对象
                cipher.init(Cipher.DECRYPT_MODE, securekey, iv);
                // 真正开始解密操作
                return cipher.doFinal(src);
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }

        }

        /**
         * 将二进制转换成16进制
         *
         * @param buf
         * @return
         */
        public static String parseByte2HexStr(byte buf[]) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < buf.length; i++) {
                String hex = Integer.toHexString(buf[i] & 0xFF);
                if (hex.length() == 1) {
                    hex = '0' + hex;
                }
                sb.append(hex.toUpperCase());
            }
            return sb.toString();
        }

        /**
         * 将16进制转换为二进制
         *
         * @param hexStr
         * @return
         */
        public static byte[] parseHexStr2Byte(String hexStr) {
            if (hexStr.length() < 1) return null;
            byte[] result = new byte[hexStr.length() / 2];
            for (int i = 0; i < hexStr.length() / 2; i++) {
                int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
                int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
                result[i] = (byte) (high * 16 + low);
            }
            return result;
        }


    /**
     * 通过Base64转换String为byte[]
     * @param src 带转换字符串
     * @return  转换后数组
     */
    public static byte[] convertBase642bytes(String src){
        return Base64.getDecoder().decode(src.getBytes());
    }
    /**
     * 通过Base64转换byte[]为String
     * @param bytes 待转换数组
     * @return 转换后字符串
     */
    public static String convertBytes2String(byte[] bytes){
        return Base64.getEncoder().encodeToString(bytes);
    }




//      public static Paper encryptPaper(Paper paper){
//          if (paper!=null && paper.getPaperId()!=null && !paper.getPaperId().equals("")){
//              try {
//                  String paperId = DesUtil.encrypt(paper.getPaperId());
//                  paper.setPaperId(paperId);
//              } catch (Exception e) {
//                  e.printStackTrace();
//              }
//          }
//          return paper;
//
//      }
//
//    public static Paper decryptPaper(Paper paper){
//        if (paper!=null && paper.getPaperId()!=null && !paper.getPaperId().equals("")){
//            try {
//                String paperId = DesUtil.decrypt(paper.getPaperId());
//                paper.setPaperId(paperId);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return paper;
//
//    }
}