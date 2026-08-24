class Solution {
    public int maxArea(int[] height) {
        
        int l=0;
        int r=height.length-1;
        int cur_area=0;
        while(l<=r){
            int area=Math.min(height[l],height[r])*(r-l);
             cur_area=Math.max(area,cur_area);
            if(height[l]<height[r]){
                   l++;     
            }
            else{
                     r--;
            }
            
           
        }
        return cur_area;
    }
}