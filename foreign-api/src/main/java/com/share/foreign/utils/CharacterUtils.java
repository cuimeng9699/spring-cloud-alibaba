package com.share.foreign.utils;

import com.share.foreign.enums.systemEnums.ErrorCode;
import com.share.foreign.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

/** @ClassName CharacterUtils @Description 对字符串处理 @Author Mr.Cui @Date 6/26/22 4:44 PM */
@Slf4j
public class CharacterUtils {

  /**
   * @Description: 截取某一个字符串的某个标识后面的所有字符串包含标识字段
   * @Date: 6/26/22 4:48 PM
   * @Author: Mr.Cui
   * @param str 截取的字符串
   * @param sign 要截取的标识
   * @return: String
   */
  public static String getStrLastIndex(String str, String sign) {
    checkSubStrParam(str,sign);
    String subStr = str.substring(0, str.indexOf(sign));
    String resultStr = str.substring(subStr.length());
    return resultStr;
  }

    /**
     * @Description: 截取某一个字符串的某个标识前面的所有字符串
     * @Date: 6/26/22 4:48 PM
     * @Author: Mr.Cui
     * @param str 截取的字符串
     * @param sign 要截取的标识
     * @return: String
     */
    public static String getStrStartIndex(String str, String sign) {
        checkSubStrParam(str,sign);
        String resultStr = str.substring(0, str.indexOf(sign));
        return resultStr;
    }

    /**
     * @Description: 截取参数校验
     * @Date: 6/26/22 5:58 PM
     * @Author: Mr.Cui
     * @param str 截取的字符串
     * @param sign 要截取的标识
     * @return: void
     **/
  private static void checkSubStrParam(String str, String sign){
      if (StringUtils.isEmpty(str) || StringUtils.isEmpty(sign)) {
          log.error("缺少参数 str {} ,sign {}", str, sign);
          throw new BaseException(ErrorCode.MISS_PARAM_ERROR);
      }
      if (!str.contains(sign)){
          log.error("参数有误截取标识不存在字符串内 str {} ,sign {}", str, sign);
          throw new BaseException(ErrorCode.PARAM_ERROR);
      }
    }
}
