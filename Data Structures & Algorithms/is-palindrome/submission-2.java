class Solution {
    public boolean isPalindrome(String s) {
        int start=0, end=s.length()-1;

        while(start < end) {
           if(s.charAt(start) == ' ' || !Character.isLetterOrDigit(s.charAt(start))) {
            start++;
            continue;
           }
           if(s.charAt(end) == ' ' || !Character.isLetterOrDigit(s.charAt(end))) {
            end--;
            continue;
           }
           System.out.println(s.charAt(start));
           System.out.println(s.charAt(end));         
           if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;
           start++;
           end--;
        }
        return true;
    }
}
