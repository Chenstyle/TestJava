package com.example.lib.life;

import java.util.Calendar;

public class WorkTimeCalculator {

    private final int WEEK_DAY = Calendar.DAY_OF_WEEK;

    private final int WORK_DAY_TIME = 8;

    private final int SATURDAY_WORK_TIME = 8;

    private int mMonthSalary = 0;

    private final int MONTH_WORK_DAY = 22;

    private final int MONTH_WORK_DAY_PLUS_SATURDAY = MONTH_WORK_DAY + 4;

    public WorkTimeCalculator(int monthSalary) {
        mMonthSalary = monthSalary;
    }

    public int salaryOfDay() {
        return mMonthSalary / MONTH_WORK_DAY;
    }

    public int salaryOfHour() {
        int daySalary = salaryOfDay();
        return daySalary / WORK_DAY_TIME;
    }

    public int monthWorkHour() {
        return MONTH_WORK_DAY * WORK_DAY_TIME;
    }

    public int monthWorkHourAddSaturday() {
        return MONTH_WORK_DAY_PLUS_SATURDAY * WORK_DAY_TIME;
    }
}
