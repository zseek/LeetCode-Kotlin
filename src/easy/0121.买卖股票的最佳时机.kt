package easy

/**
 * 买卖股票的最佳时机(数组,动态规划)
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * 给定一个数组 prices, 它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格, 你在某一天买入并在未来的某一天卖出该股票, 设计一个算法来计算你所能获取的最大利润, 如果你不能获取任何利润，返回 0。
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 5
 */
fun maxProfit(prices: IntArray): Int {
    var minPrice = Int.MAX_VALUE  // 初始化最低价格为最大可能的整数
    var maxProfit = 0             // 初始化最大利润为0

    for (price in prices) {       // 遍历每一天的股票价格
        if (price < minPrice) {   // 如果当前价格低于已记录的最低价格
            minPrice = price      // 更新最低价格
        } else {
            val profit = price - minPrice  // 计算当前利润
            if (profit > maxProfit) {      // 如果当前利润大于已记录的最大利润
                maxProfit = profit         // 更新最大利润
            }
        }
    }
    return maxProfit  // 返回最大利润
}


