class Solution {
    public int maxProfit(int[] prices) {
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int minleft = prices[0];        
        for(int i = 0; i  < prices.length; ++i) {
            left[i] = Math.min(prices[i], minleft);
            if(prices[i] < minleft)     minleft = prices[i];
        }
        
        int maxright = prices[prices.length-1];
        int maxprofit = 0;
        for(int i = prices.length-1; i >=0; --i) {
            right[i] = Math.max(prices[i], maxright);
            if(prices[i] > maxright)  {
                maxright = prices[i];                 
            }   
            maxprofit = Math.max(maxright - left[i], maxprofit);
            
        }
        
        return maxprofit;
    }
    
}