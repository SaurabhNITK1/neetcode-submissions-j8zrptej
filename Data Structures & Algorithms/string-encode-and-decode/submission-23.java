/*
The main thing in this problem is delimmitter. We cant use ASCII characters as delimmitter bcz if 
the character used as delimmitter itself is the part of string, then it'll fail.

Thats why we track the length of each string and use it with the delimitter before the string so that first time
we encounter delimitter, we konow the length of the coming string and can skip the characters same
as delimmitter within the string.
*/
class Solution {
    private static final String EMPTY_LIST_MARKER = "empty_list";

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return EMPTY_LIST_MARKER;
        StringBuilder encodedStr = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String str = strs.get(i);
            encodedStr.append(str.length()).append('#').append(str);
        }
        return encodedStr.toString();
    }

    
    public List<String> decode(String str) {
        System.out.println(str);
        List<String> result = new ArrayList<>();
        if (str.equals(EMPTY_LIST_MARKER)) {
          return result; // Return an empty list
        }
        if (str.isEmpty()) {
            result.add(""); // Return a list with an empty string
            return result;
        }
        int i=0, j=0;
        while(i<str.length()) {
            while(str.charAt(j) != '#') {
                j++;
            }
            /* In java for substr for index i, j-1 we need to give i, j as last index is not counted in java.
               Here we need to make sure that i points on length(number) and j points to delimitter('#') */
            int length = Integer.parseInt(str.substring(i,j)); 
            // point i to the start of string and j to the end+1 of the string. end+1 to use substring method()
            i=j+1; // j+1 is start of a string
            j=i+length; // (j+1)+length, ie. (end+1) of a string
            result.add(str.substring(i, j));
            i=j;
        }
        return result;
    }
}
