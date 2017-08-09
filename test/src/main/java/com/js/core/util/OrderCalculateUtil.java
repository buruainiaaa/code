package com.js.core.util;

/**
 * @author Jason.Zhang
 */
public class OrderCalculateUtil {
    /**
     * 计算管理费用(本金管理费或者收益管理费)
     * 
     * @param money 实际投资金额或者收益
     * @param manageFeeRate 管理费率
     * @return
     */
    public static double getManageFee(double money, double manageFeeRate) {
        return CalculateUtil.multiply(money, manageFeeRate / 100);
    }

    /**
     * 计算认购费
     * 
     * @param investMoney 投资金额
     * @param subscriptionFeeRate 认购费率
     * @return
     */
    public static double getSubscriptionFee(double investMoney, double subscriptionFeeRate) {
        return CalculateUtil.multiply(investMoney, subscriptionFeeRate / 100);
    }

    /**
     * 收益
     * 
     * @param realInvestMoney 实际投资金额
     * @param profitFeeRate 年化收益率
     * @param investTerm 投资周期
     * @return
     */
    public static double getProfit(double realInvestMoney, double profitFeeRate, int investTerm) {
        double yearProfit = CalculateUtil.multiply(realInvestMoney, profitFeeRate / 100);
        double dayProfit = yearProfit / 365;
        return CalculateUtil.round(CalculateUtil.multiply(dayProfit, investTerm), 2);
    }

    /**
     * 汇款中计算实际收益（扣除收益管理费）
     * 
     * @param realInvestMoney
     * @param profitFeeRate
     * @param manageFeeRate
     * @param investTerm
     * @return
     */
    public static double getRealProfit(double realInvestMoney, double profitFeeRate, double manageFeeRate, int investTerm) {
        double profit = getProfit(realInvestMoney, profitFeeRate / 100, investTerm);
        double manageFee = getManageFee(profit, manageFeeRate / 100);
        return CalculateUtil.sub(profit, manageFee);
    }

    /**
     * 获取实际收益
     * 
     * @param realInvestMoney 实际投资金额
     * @param profitFeeRate 产品收益率（已包含加息券）
     * @param manageFeeRate 管理费率
     * @param investTerm （投资期限）
     * @return
     */
    public static double getRealIncome(double realInvestMoney, double profitFeeRate, double manageFeeRate, int investTerm) {
        double yearProfit = CalculateUtil.multiply(realInvestMoney, profitFeeRate / 100);
        double dayProfit = yearProfit / 365;
        // 预回款收益金额
        double profitProfit = CalculateUtil.multiply(dayProfit, investTerm);
        // 预回款总金额
        double incomeProfit = CalculateUtil.add(realInvestMoney, profitProfit);
        // 应扣管理费总额
        double totalManagementFee = CalculateUtil.multiply(incomeProfit, manageFeeRate / 100);
        // 实际回款金额
        double realIncome = CalculateUtil.sub(incomeProfit, totalManagementFee);
        return CalculateUtil.round(realIncome, 2);
    }
}
