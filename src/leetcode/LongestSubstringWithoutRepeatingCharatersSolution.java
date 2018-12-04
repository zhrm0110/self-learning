package leetcode;

public class LongestSubstringWithoutRepeatingCharatersSolution {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LongestSubstringWithoutRepeatingCharatersSolution ls = new LongestSubstringWithoutRepeatingCharatersSolution();
        System.out.print(ls.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s){
        String sResultSubString ="";
        if (!s.isEmpty()) {
            int beginIndex=0;
            int endIndex=1;
            String tempSubString = s.substring(beginIndex, endIndex);
            sResultSubString = tempSubString;
            for(int i=1; i<s.length();i++){
                int j=0;
                while(j<tempSubString.length() && s.charAt(i)!=tempSubString.charAt(j)){
                    j++;
                }
                if (j==tempSubString.length()) {
                    endIndex=i+1;
                    tempSubString=s.substring(beginIndex, endIndex);
                }else {
                    beginIndex=beginIndex+j+1;
                    endIndex = i+1;
                    tempSubString=s.substring(beginIndex, endIndex);
                }
                if (tempSubString.length()>sResultSubString.length()) {
                    sResultSubString= tempSubString;
                }
            }
            System.out.println(sResultSubString);
        }
        return sResultSubString.length();
    }

}
