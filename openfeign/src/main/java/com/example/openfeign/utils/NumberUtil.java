package com.example.openfeign.utils;


import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtil {
	// 默认金额精度保留2为小数
	public static final int SCALE_DEFAULT = 2;
	// 中间数据保留4为小数
	public static final int SCALE_MIDDLE = 4;
	// 默认四舍五入
	public static final int ROUND_MODEL_DEFAULT = BigDecimal.ROUND_HALF_UP;

	public static BigInteger add(BigInteger v1, BigInteger v2) {
		if (v1 == null && v2 == null) {
			return null;
		}
		if (v1 == null) {
			return new BigInteger(v2.toByteArray());
		}
		if (v2 == null) {
			return new BigInteger(v1.toByteArray());
		}
		return v1.add(v2);
	}



	/**
	 *
	 * @Title: add
	 * @Description: 中间数据相加保留4位小数
	 * @param v1
	 * @param v2
	 * @return
	 * @author Mr.Cui
	 */
	public static BigDecimal add(BigDecimal v1, BigDecimal v2) {
		if (v1 == null && v2 == null) {
			return null;
		}
		if (v1 == null) {
			return new BigDecimal(v2.doubleValue()).setScale(SCALE_MIDDLE, ROUND_MODEL_DEFAULT);
		}
		if (v2 == null) {
			return new BigDecimal(v1.doubleValue()).setScale(SCALE_MIDDLE, ROUND_MODEL_DEFAULT);
		}
		return new BigDecimal(String.valueOf(add(v1.doubleValue(), v2.doubleValue()))).setScale(SCALE_MIDDLE,
				ROUND_MODEL_DEFAULT);
	}

	public static BigDecimal sub(BigDecimal v1, BigDecimal v2) {
		if (v1 == null && v2 == null) {
			return null;
		}
		if (v1 == null) {
			return new BigDecimal(Math.abs(v2.doubleValue()));
		}
		if (v2 == null) {
			return new BigDecimal(v1.doubleValue());
		}
		return new BigDecimal(sub(v1.doubleValue(), v2.doubleValue()));
	}

	/**
	 *
	 * @Title: subScale
	 * @Description: 中间数相减保留4位小数
	 * @param v1
	 * @param v2
	 * @return
	 * @author Mr.Cui
	 */
	public static BigDecimal subScale(BigDecimal v1, BigDecimal v2) {
		if (v1 == null && v2 == null) {
			return null;
		}
		if (v1 == null) {
			return new BigDecimal(Math.abs(v2.doubleValue())).setScale(SCALE_MIDDLE, ROUND_MODEL_DEFAULT);
		}
		if (v2 == null) {
			return new BigDecimal(v1.doubleValue()).setScale(SCALE_MIDDLE, ROUND_MODEL_DEFAULT);
		}
		return new BigDecimal(String.valueOf(sub(v1.doubleValue(), v2.doubleValue()))).setScale(SCALE_MIDDLE,
				ROUND_MODEL_DEFAULT);
	}

	public static double add(double v1, double v2) {// 加法
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	public static double sub(double v1, double v2) {// 减法
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	// 两个BigDecimal乘法，成完之后是啥就是啥，不进行四舍五入保留两位。
	public static BigDecimal mulcommon(BigDecimal v1, BigDecimal v2) {
		if (v1 == null || v2 == null) {
			return null;
		}
		return new BigDecimal(String.valueOf(mul(v1.doubleValue(), v2.doubleValue())));
	}

	public static BigDecimal divcommon(BigDecimal v1, BigDecimal v2) {// BigDecimal除法
		return v1.divide(v2, 10, ROUND_MODEL_DEFAULT);
	}

	// C1T24 X件数
	public static BigDecimal divcommonInt(BigDecimal v1, BigDecimal v2) {// BigDecimal除法。保留小数点后0位，且取整
		return v1.divide(v2, 0, BigDecimal.ROUND_DOWN);
	}

	public static BigDecimal mul(BigDecimal v1, BigDecimal v2) {
		if (v1 == null || v2 == null) {
			return null;
		}
		return new BigDecimal(String.valueOf(mul(v1.doubleValue(), v2.doubleValue()))).setScale(SCALE_DEFAULT,
				ROUND_MODEL_DEFAULT);
	}

	public static double mul(double v1, double v2) {// 乘法
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	public static double div(double v1, double v2) {// 除法
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, SCALE_DEFAULT, ROUND_MODEL_DEFAULT).doubleValue();
	}

	public static BigDecimal div(BigDecimal v1, BigDecimal v2) {// BigDecimal除法，除数为0，返回0
		if (v1 == null || v2 == null || BigDecimal.ZERO.compareTo(v2) == 0) {
			return BigDecimal.ZERO;
		} else {
			return v1.divide(v2, SCALE_DEFAULT, ROUND_MODEL_DEFAULT);
		}
	}

	public static BigDecimal divFloor(BigDecimal v1, BigDecimal v2) {// BigDecimal除法
		// 向下取整
		if (v1 == null || v2 == null || BigDecimal.ZERO.compareTo(v2) == 0) {
			return BigDecimal.ZERO;
		} else {
			return new BigDecimal(Math.floor(v1.divide(v2, 5, ROUND_MODEL_DEFAULT).doubleValue()));
		}
	}

	// BigDecimal除法,保留4位小数
	public static BigDecimal div4(BigDecimal v1, BigDecimal v2) {
		if (v1 == null || v2 == null || v2.compareTo(new BigDecimal(0)) == 0) {
			return BigDecimal.ZERO;
		} else {
			return v1.divide(v2, 4, ROUND_MODEL_DEFAULT);
		}
	}

	public static BigDecimal div5(BigDecimal v1, BigDecimal v2) {// BigDecimal除法
																	// 保留5位小数
		// ↓ update linzhiyi20170714
		// if (v1 == null || v2 == null || v2 == BigDecimal.ZERO) {
		if (v1 == null || v2 == null || v2.compareTo(new BigDecimal(0)) == 0) {
			// ↑ update linzhiyi20170714
			return BigDecimal.ZERO;
		} else {
			return v1.divide(v2, 5, ROUND_MODEL_DEFAULT);
		}
	}

	public static BigDecimal round(BigDecimal v) {// 截取2位
		return round(v, SCALE_DEFAULT, ROUND_MODEL_DEFAULT);
	}

	public static double round(double v) {// 截取2位
		BigDecimal b = new BigDecimal(Double.toString(v));
		return round(b).doubleValue();
	}

	public static BigDecimal round(BigDecimal v, int newScale, int roundingMode) {
		if (v == null) {
			return null;
		}
		return v.setScale(newScale, roundingMode);
	}

	public static String decimalFormat(String pattern, double value) {
		return new DecimalFormat(pattern).format(value);
	}

	public static String decimalFormat(double value) {
		return new DecimalFormat("0.00").format(value);
	}

	public static String decimalFormat(double value, String pattern) {
		return new DecimalFormat(pattern).format(value);
	}

	public static String decimalBlankFormat(double value) {
		return new DecimalFormat("0").format(value);
	}

	public static boolean isNumber(String value) { // 检查是否是数字
		String patternStr = "^\\d+$";
		Pattern p = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE); // 忽略大小写;
		Matcher m = p.matcher(value);
		return m.find();
	}

	/**
	 *
	 * <p>
	 * Title: trunc
	 * </p>
	 * <p>
	 * Description: TRUNC（number,num_digits） Number 需要截尾取整的数字。 Num_digits
	 * 用于指定取整精度的数字。Num_digits 的默认值为 0。 TRUNC()函数截取时不进行四舍五入 用例描述： 1select
	 * trunc(123.458,0) from dual --123 2.select trunc(123.458,1) from dual
	 * --123.4 3.select trunc(123.458,-1) from dual --120 4.select
	 * trunc(123.458,-4) from dual --0 5.select trunc(123.458,4) from dual
	 * --123.458 6.select trunc(123,1) from dual --123 7.select trunc(123,-1)
	 * from dual --120
	 * </p>
	 *
	 * @param value
	 * @param param
	 * @return
	 * @author Mr.Cui
	 */
	public static String trunc(BigDecimal value, int param) {
		String divStr = value + "";
		String result = "";
		int point = divStr.indexOf(".");
		int num = divStr.length();
		int before = point;// 小数点前面的数字个数 3
		int after = num - before - 1;// 小数点后面的个数7-3-1=3
		if (param > 0) {
			if (after > param) {
				result = divStr.substring(0, before + param + 1);
			} else {
				result = divStr.substring(0, num);
			}
		} else if (param == 0) {
			result = divStr.substring(0, before);
		} else {
			if (before > Math.abs(param)) {
				String zeroStr = "";
				for (int i = 0; i < Math.abs(param); i++) {
					zeroStr = zeroStr + "0";
				}
				result = divStr.substring(0, before + param) + zeroStr;
			} else {
				result = "0";
			}
		}
		return result;
	}

	public static BigDecimal add(BigDecimal... bds) {
		List<BigDecimal> tempList = new ArrayList<BigDecimal>();
		for (BigDecimal bigDecimal : bds) {
			if (bigDecimal != null) {
				tempList.add(bigDecimal);
			}
		}
		if (tempList.size() == 0) {
			return null;
		}
		BigDecimal sum = new BigDecimal(0);
		for (BigDecimal bd : tempList) {
			if (bd == null) {
				bd = BigDecimal.ZERO;
			}
			sum = add(bd, sum);
		}
		return sum;
	}

	/**
	 * 取v1、v2较小值
	 *
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static BigDecimal getLeast(BigDecimal v1, BigDecimal v2) {
		if (v1 == null || v2 == null) {
			return BigDecimal.ZERO;
		}
		if (v1.doubleValue() <= v2.doubleValue()) {
			return v1;
		} else {
			return v2;
		}
	}

	/**
	 *
	 * <p>
	 * Title: compareTo
	 * </p>
	 * <p>
	 * Description: 兼容compare双方为空的情况
	 * </p>
	 *
	 * @param v1
	 * @param v2
	 * @return
	 * @author Mr.Cui
	 */
	public static int compareTo(Integer v1, Integer v2) {
		int result;
		if (v1 == null) {
			v1 = 0;
		}
		if (v2 == null) {
			v2 = 0;
		}
		result = v1.compareTo(v2);
		return result;
	}

	public static int compareTo(BigDecimal v1, BigDecimal v2) {
		int result;
		if (v1 == null) {
			v1 = BigDecimal.ZERO;
		}
		if (v2 == null) {
			v2 = BigDecimal.ZERO;
		}
		result = v1.compareTo(v2);
		return result;
	}

	/**
	 *
	 * <p>
	 * Title: compareTo
	 * </p>
	 * <p>
	 * Description: 除法，自定义保留多少位小数
	 * </p>
	 *
	 * @param v1
	 * @param v2
	 * @param scale
	 * @return
	 * @author Mr.Cui
	 */
	public static BigDecimal div(BigDecimal v1, BigDecimal v2, int scale) {// BigDecimal除法
		if (v1 == null || v2 == null || BigDecimal.ZERO.compareTo(v2) == 0) {
			return BigDecimal.ZERO;
		} else {
			return v1.divide(v2, scale, ROUND_MODEL_DEFAULT);
		}
	}

	/**
	 * @Title:getNegateValue
	 * @Description:取值的反数
	 * @param value
	 * @return
	 * @author Mr.Cui
	 */
	public static BigDecimal getNegateValue(BigDecimal value) {
		if (value == null) {
			return null;
		}
		return value.negate();
	}

	/**
	 * 舍弃{@code null}值，获取默认值的{@code java.math.BigDecimal}值。
	 *
	 * @param decimal
	 * @param defaultValue
	 * @author Mr.Cui
	 */
	public static BigDecimal requireNonNull(BigDecimal decimal, int defaultValue) {
		return (decimal == null) ? new BigDecimal(defaultValue) : decimal;
	}

	/**
	 *
	 * @Title: division
	 * @Description: 除法，如果整除取值，有余数加1
	 * @param a
	 * @param b
	 * @return
	 * @author Mr.Cui
	 */
	public static int division(Integer a, Integer b) {

		if (a % b != 0) {
			return a / b + 1;
		}
		return a / b;

	}

	/**
	 * @Title: isNumeric
	 * @Description: 是否为整数
	 * @param str
	 * @return
	 * @author Mr.Cui
	 */
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 *
	 * @Title: handleNumber
	 * @Description: 有小数返回两位小数，否则整数
	 * @param bigDecimal
	 * @return
	 * @author Mr.Cui
	 */
	public static BigDecimal handleNumber(BigDecimal bigDecimal) {
		if (bigDecimal == null) {
			bigDecimal = BigDecimal.ZERO;
		}
		double aDouble = bigDecimal.doubleValue();
		DecimalFormat fnum = new DecimalFormat("##0.00");
		String format = fnum.format(aDouble);
		String[] split = format.split("\\.");
		if (split[1].equals("00")) {
			return new BigDecimal(split[0]);
		}
		return new BigDecimal(format).stripTrailingZeros();
	}

	/**
	 * @title: handleNumber
	 * @description: 有小数返回两位小数，否则整数
	 * @param str:
	 * @return: java.math.BigDecimal
	 * @author: Mr.Cui
	 */
	public static BigDecimal handleNumber(String str) {
		if (str == null) {
			str = "0";
		}
		return handleNumber(new BigDecimal(str));
	}

	/**
	 * @title: handleNumberToString
	 * @description: 有小数返回两位小数，否则整数
	 * @param bigDecimal:
	 * @return: java.math.BigDecimal
	 * @author: Mr.Cui
	 */
	public static String handleNumberToString(BigDecimal bigDecimal) {
		return handleNumber(bigDecimal).toString();
	}


    /**
     * @return java.math.BigDecimal
     * @Author Mr.Cui
     * @Description 如果数值小于0，按0计算
     * @Param [number]
     **/
    public static BigDecimal handleNumToZeroIfNumLessThenZero(BigDecimal number) {
        if (number == null) {
            return null;
        }
        if (BigDecimal.ZERO.compareTo(number) > 0) {
            return BigDecimal.ZERO;
        } else {
            return number;
        }
    }


	/**
	 * @Description 根据多个月份返回最大值
	 * @param wageNoList
	 * @return 最大值
	 * @Author Mr.Cui
	 */
	public static String getMaxWageNo(List<String> wageNoList) {
		String maxWageNo = null;
		ArrayList<Integer> integerWageNo = new ArrayList<>();
		for (String wageNo : wageNoList) {
			integerWageNo.add(Integer.parseInt(wageNo));
		}
		Collections.sort(integerWageNo);
		maxWageNo = integerWageNo.get(wageNoList.size() - 1).toString();
		return maxWageNo;
	}

	public static BigDecimal getNumber(BigDecimal num) {
		return num == null ? BigDecimal.ZERO : num;
	}
	/**
	 * @Title: getDecimal
	 * @Description: 处理 BigDecimal类型为空的情况
	 * @param num
	 * @return
	 * @author Mr.Cui
	 */
	public static BigDecimal getDecimal(BigDecimal num) {
		return num == null ? BigDecimal.ZERO : num;
	}

	/**
	 * @description:  如何为整数，取整，不为整数，取保留一位
	 * @author: Mr.Cui
	 */
	public static BigDecimal getScaleValue(BigDecimal bigDecimal){
		if (BigDecimal.ZERO.equals(bigDecimal) || bigDecimal == null) {
			return BigDecimal.ZERO;
		}
		if (bigDecimal.toString().contains(".0000")) {
			return new BigDecimal(bigDecimal.stripTrailingZeros().toPlainString());
		}
		return bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * @param crossFyc
	 * @param maxValue
	 * @return 综合最多计入多少，如果为负值，则不能小于最大值的相反数
	 */
	public static BigDecimal getMaxCrossFycValue(BigDecimal crossFyc, BigDecimal maxValue) {
		BigDecimal maxCrossFyc = BigDecimal.ZERO;
		if (maxCrossFyc.compareTo(crossFyc) == 0) {
			return crossFyc;
		}
		/**传进来的如果小于0则按照负值处理**/
		if (maxCrossFyc.compareTo(crossFyc) > 0) {
			maxValue = maxValue.negate();
			maxCrossFyc = crossFyc.compareTo(maxValue) <= 0 ? maxValue : crossFyc;
		}
		/**传进来的如果大于0则按照正值处理**/
		if (maxCrossFyc.compareTo(crossFyc) < 0) {
			maxCrossFyc = crossFyc.compareTo(maxValue) >= 0 ? maxValue : crossFyc;
		}
		return maxCrossFyc;
	}
    /**
     * @return java.lang.String
     * @Author Mr.Cui
     * @Description 返回BigDecimal 两位小数，支持空，空默认返回0.00
     * @Param [num]
     **/
    public static BigDecimal formatBigDeciamlTwoPoint(BigDecimal num) {
        if (num == null) {
            num = BigDecimal.ZERO;
        }
        return round(num);
    }

	/**
	 * @return java.lang.String
	 * @Author Mr.Cui
	 * @Description 返回BigDecimal 四位小数，支持空，空默认返回0.0000
	 * @Param [num]
	 **/
	public static BigDecimal formatBigDeciamlFourPoint(BigDecimal num) {
		if (num == null) {
			num = BigDecimal.ZERO;
		}
		return round(num, SCALE_MIDDLE, ROUND_MODEL_DEFAULT);
	}

    /**
     * @return java.lang.String
     * @Author Mr.Cui
     * @Description 返回Double 两位小数，支持空，空默认返回0.00
     * @Param [num]
     **/
    public static double convertDoubleTwoPoint(BigDecimal num) {
        String numStr = formatBigDeciamlTwoPoint(num).toString();
        return Double.parseDouble(numStr);
    }


	/**
	 * @return java.lang.String
	 * @Author Mr.Cui
	 * @Description 返回Double 两位小数，支持空，空默认返回0.00
	 * @Param [num]
	 **/
	public static double convertDoubleFourPoint(BigDecimal num) {
		String numStr = formatBigDeciamlFourPoint(num).toString();
		return Double.parseDouble(numStr);
	}

	/**
	 *
	 * 功能描述:两数相减，如果有值为null置为0
	 *
	 * @param: [v1, v2]
	 * @return: java.math.BigDecimal
	 * @auther: Mr.Cui
	 */
	public static BigDecimal subtract(BigDecimal v1, BigDecimal v2) {
		if (v1 == null) {
			v1 = BigDecimal.ZERO;
		}
		if (v2 == null) {
			v2 = BigDecimal.ZERO;
		}
		return v1.subtract(v2);
	}

	/**
	 *
	 * 功能描述: 两数相加，如果有值为null置为0
	 *
	 * @param: [v1, v2]
	 * @return: java.math.BigDecimal
	 * @auther: Mr.Cui
	 */
	public static BigDecimal sum(BigDecimal v1, BigDecimal v2) {
		if (v1 == null) {
			v1 = BigDecimal.ZERO;
		}
		if (v2 == null) {
			v2 = BigDecimal.ZERO;
		}
		return v1.add(v2);
	}


	   /**
     *
     * @Title: getMaxResult
     * @Description: TODO
     * @param arrayList
     * @return
     * @throws Exception
     * @author  Mr.Cui
     */
	public static BigDecimal getMaxResult(List<BigDecimal> arrayList) throws Exception{
		BigDecimal result = BigDecimal.ZERO;
		if (CollectionUtils.isEmpty(arrayList)) {
			return result;
		}
		Collections.sort(arrayList, new Comparator<BigDecimal>() {
			@Override
			public int compare(BigDecimal o1, BigDecimal o2) {
				return o2.compareTo(o1);
			}
		});
		result = arrayList.get(0);
		return result;
	}

    /**
     * @Title: getDecimalToDouble
     * @Description: 获取Double类型的Bigdecimal格式
     * @param: [num]
     * @return: java.lang.String
     * @Author: Mr.Cui
     */
    public static Double getDecimalToDouble(BigDecimal num) {
        return num == null ? BigDecimal.ZERO.doubleValue() : num.doubleValue();
    }
}

