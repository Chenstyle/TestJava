package com.example.lib.life;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 房贷计算器
 *
 * @author lizhizhao
 * @date 2020-7-14
 */
public class HouseLoanCalculate {
    private final int MONTH_LOAN = 387894;
    private final int YEAR_LOAN = MONTH_LOAN * 12;
    private final int TOTAL_LOAN = YEAR_LOAN * 30;

    /**
     * 已还清贷款
     *
     * @return 单位分
     */
    public int paidOffMoneyCount() {
        return MONTH_LOAN * paidOffLoanMonthCount();
    }

    /**
     * 已还清贷款
     *
     * @return 单位元
     */
    public String paidOffMoneyCountForYuan() {
        return centConvertForYuan(paidOffMoneyCount());
    }

    /**
     * 剩余房贷总额
     *
     * @return 单位分
     */
    public int residueHouseLoanAmount() {
        return TOTAL_LOAN - (paidOffLoanMonthCount() * MONTH_LOAN);
    }

    /**
     * 剩余房贷总额
     *
     * @return 单位元
     */
    public String residueHouseLoanAmountForYuan() {
        return centConvertForYuan(residueHouseLoanAmount());
    }

    /**
     * 单位为分的金额转为元
     *
     * @param centAmount 单位为分的金额
     * @return 单位为元的金额字符
     */
    private String centConvertForYuan(int centAmount) {
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

    /**
     * 还清贷款月数
     *
     * @return 已还贷款月数
     */
    private int paidOffLoanMonthCount() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str1 = "2019-11-01";
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();
        try {
            bef.setTime(sdf.parse(str1));
            aft.setTime(new Date(System.currentTimeMillis()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
        int distanceMonth = Math.abs(month + result) + 1;

        return distanceMonth;
    }
}
