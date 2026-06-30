class Solution {
    public String longestPalindrome(String s) {
          String result = "";
          for(int i = 0 ; i <s.length(); i++){
          String p1 = expand(s ,i,i);
           if (p1.length() > result.length()) result = p1;

           String p2 = expand(s, i, i + 1);
            if (p2.length() > result.length()) result = p2;
          }
        return result;

    }
    public String expand(String s, int left, int right){
        while(left >=0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}