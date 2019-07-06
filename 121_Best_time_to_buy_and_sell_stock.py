class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        min_price = 2 ** 31 - 1
        
        for p in prices:
            tmp_profit = p - min_price
            if tmp_profit > max_profit:
                max_profit = tmp_profit
            if p < min_price:
                min_price = p
                
        return max_profit
