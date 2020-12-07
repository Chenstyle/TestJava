package com.example.lib;

import com.example.lib.life.HouseLoanCalculate;
import com.example.lib.life.MyUtil;
import com.example.lib.life.WorkTimeCalculator;

public class AboutMoney {

    public static void culMoney() {
        HouseLoanCalculate loan = new HouseLoanCalculate();
        System.out.println("截止到目前已还：" + loan.paidOffMoneyCountForYuan());
        System.out.println("截止到目前待还：" + loan.residueHouseLoanAmountForYuan());
        WorkTimeCalculator cal = new WorkTimeCalculator(800000);
        System.out.println("salary of hour = " + MyUtil.centConvertForYuan(cal.salaryOfHour()));
        System.out.println("month work hour = " + cal.monthWorkHour());
        System.out.println("month work hour add saturday = " + cal.monthWorkHourAddSaturday());
        System.out.println("month add saturday need pay = " + (208 - 176) * 45.45);
        System.out.println("last vacation salary = " + 45.45 * 49);
    }
}
