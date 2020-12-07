package com.example.lib.life;

public class MyUtil {

    /**
     * 单位为分的金额转为元
     *
     * @param centAmount 单位为分的金额
     * @return 单位为元的金额字符
     */
    public static String centConvertForYuan(int centAmount) {
        if (centAmount == 0) {
            return "0";
        }
        String centAmountStr = String.valueOf(centAmount);
        String yuan;
        String cent;
        if (centAmountStr.length() <= 2) {
            yuan = "0";
            cent = centAmountStr;
        } else {
            yuan = centAmountStr.substring(0, centAmountStr.length() - 2);
            cent = centAmountStr.substring(centAmountStr.length() - 2);
        }
        return yuan + "." + cent;
    }
}
