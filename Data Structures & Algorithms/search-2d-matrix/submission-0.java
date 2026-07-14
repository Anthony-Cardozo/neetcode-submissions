class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix[0].length;
        int l=0;
        int r=matrix.length*matrix[0].length-1;

        while(l<=r)
        {
            int m = l+(r-l)/2;
            if(matrix[m/n][m%n]==target)
                return true;
            if(matrix[m/n][m%n]>target)
                r=m-1;
            else
                l=m+1;
        }
        return false;
    }
}