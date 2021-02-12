public class Assignment3 {

    /*Q5.
    The count-and-say sequence is a sequence of integers with the first five terms as following:
            1.     1
            2.     11
            3.     21
            4.     1211
            5.     111221

            1 is read off as "one 1" or 11.
            11 is read off as "two 1s" or 21.
            21 is read off as "one 2, then one 1" or 1211.
    Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
    Note: Each term of the sequence of integers will be represented as a string.*/

    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        String cs = "1";
        for(int i=1; i<n; i++){
            cs = countAndSay(cs);
        }
        return cs;
    }

    private String countAndSay(String cs) {
        StringBuilder temp = new StringBuilder();
        int cnt = 1;
        for(int j=0; j<cs.length(); j++){
            if(j < cs.length()-1 && cs.charAt(j) == cs.charAt(j+1))
                cnt++;
            else{
                temp.append(cnt).append(cs.charAt(j));
                cnt = 1;
            }
        }
        return temp.toString();
    }

    /*Q6. Given an input string , reverse the string word by word.
Assumptions:
A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.*/

    public String reverseStringWords(String sent){
        StringBuilder str = new StringBuilder();

        String[] sentSplit = sent.split(" ");
        int n = sentSplit.length;

        for(int i=0; i< n/2; i++){
            String temp = sentSplit[i];
            sentSplit[i] = sentSplit[n-i-1];
            sentSplit[n-i-1] = temp;
        }

        for(String s : sentSplit)
            str.append(s).append(" ");

        str.deleteCharAt(str.length()-1);
        return str.toString();
    }

    /*Q7.
    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.*/

    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m*n];
        int k = 0, x = 0, y = 0;

        while(x <= m/2 && y <= n/2){
            int i = x, j = y;
            if(i == m/2){
                while(j < n-y)
                    res[k++] = matrix[i][j++];
                break;
            }

            if(j == n/2){
                while(i < m-x)
                    res[k++] = matrix[i++][j];
                break;
            }

            while(j < n-y-1)
                res[k++] = matrix[i][j++];
            while(i < m-x-1)
                res[k++] = matrix[i++][j];
            while(j > y)
                res[k++] = matrix[i][j--];
            while(i > x)
                res[k++] = matrix[i--][j];

            x++; y++;

            if(k == m*n)
                break;
        }

        return res;
    }

    /*Q8.
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this
    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"
    Write the code that will take a string and make this conversion given a number of rows:
    String convert(string s, int numRows);*/

    public String zigzagConvert(String s, int numRows){
        StringBuilder[] strArr = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++)
            strArr[i] = new StringBuilder();

        int n = 0;
        while(n < s.length()){
            for(int i=0; i<numRows; i++){
                if(n == s.length()) break;
                strArr[i].append(s.charAt(n++));
            }
            for(int i=numRows-2; i>0; i--){
                if(n == s.length()) break;
                strArr[i].append(s.charAt(n++));
            }
        }

        StringBuilder res = new StringBuilder();
        for(int j=0; j<numRows; j++)
            res.append(strArr[j].toString());
        return res.toString();
    }

}
