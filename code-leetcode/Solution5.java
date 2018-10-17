import java.util.HashMap;
import java.util.Map;

public class Solution5{
    public static void main(String[] args) {
        Solution5 sol = new Solution5();
        String sub = sol.longestPalindrome("ac");
        System.out.println(sub);
    }

    public String longestPalindrome(String s) {
        if(s == null){
            return "";
        }
        if(s.equals("") || s.length()==1){
            return s;
        }

        char[] chars = s.toCharArray();
        String sub = "";
        int subLength = 0;

        for(int i = 0; i < chars.length; i++){
            int index = s.indexOf(chars[i], i+1);
            while(index != -1){
                String s1 = s.substring(i, index + 1);
                String s2 = new StringBuilder(s1).reverse().toString(); 
                if(s1.equals(s2)){
                    if(s1.length() > subLength){
                        sub = s1;
                        subLength = s1.length();
                    }
                }
                index = s.indexOf(chars[i], index+1);
            }

            if(subLength ==0){
                sub += chars[i];
                subLength = 1;
            }
        }

        return sub;
    }
}
