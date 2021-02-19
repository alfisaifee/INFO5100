package assignment4.extracredit;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args){
        System.out.println(Arrays.toString(stringIDPerm("IDID")));
        System.out.println(Arrays.toString(stringIDPerm("DDI")));
    }

    public static int[] stringIDPerm(String str){
        if(str == null || str.length() == 0)
            return new int[]{};
        int n = str.length();
        int[] res = new int[n+1];
        int i = 0;
        int low = 0, high = n;
        for(char ch : str.toCharArray()){
            if(ch == 'I')
                res[i++] = low++;
            else
                res[i++] = high--;
        }
        res[n] = low;
        return res;
    }
}
