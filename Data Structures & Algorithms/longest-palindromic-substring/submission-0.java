class Solution {
    public String longestPalindrome(String s) {

    int n = s.length();

    if(n < 2){
        return s;
    }
    int start = 0;
    int maxLength = 1;

    for(int i = 0; i < n; i++){

        int left = i;
        int right = i;

        while(left >= 0 && right < n &&
              s.charAt(left) == s.charAt(right)){
                if(right - left + 1 > maxLength){
                    start = left;
                    maxLength = right - left + 1;
                }
                left--;
                right++;
              }
              left = i;
              right = i + 1;

              while(left >= 0 && right < n &&
                    s.charAt(left) == s.charAt(right)){
                        if(right - left + 1 > maxLength){
                            start = left;
                            maxLength = right - left + 1;
                        }
                        left--;
                        right++;
                    }
    }
    
    return s.substring(start, start + maxLength);
        
    }
}
