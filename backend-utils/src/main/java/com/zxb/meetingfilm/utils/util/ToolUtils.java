package com.zxb.meetingfilm.utils.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.utils
 * @description : 公共工具类
 **/
public class ToolUtils {

  private ToolUtils(){}

  public static boolean strIsNull(String str){
    if(str!=null && str.trim().length()>0){
      return false;
    }
    return true;
  }

  public static boolean strIsNotNul(String str){
    if(str!=null && str.trim().length()>0){
      return true;
    }
    return false;
  }

  /**
   * 判断数字正则表达式
   */
  private static final Pattern pattern = Pattern.compile("[0-9]*");

  public static boolean checkInt(String str) {
    Matcher isNum = pattern.matcher(str);
    if (!isNum.matches()) {
      return false;
    } else {
      return true;
    }
  }

  public static Integer str2Int(String str) {
    Matcher isNum = pattern.matcher(str);
    if (!isNum.matches()) {
      return 0;
    } else {
      return Integer.parseInt(str);
    }
  }

  public static LocalDateTime str2LocalDateTime(String dateStr) {
    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime ldt = LocalDateTime.parse(dateStr,df);
    return ldt;
  }

}