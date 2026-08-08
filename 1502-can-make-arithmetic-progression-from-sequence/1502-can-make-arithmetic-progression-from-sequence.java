class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        if(n<=2) return true;
        int dif=arr[n-1]-arr[n-2];
        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1]!=dif){
                return false;
            }
        }
        return true;
    }
}