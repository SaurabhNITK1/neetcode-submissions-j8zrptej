class Solution {
    private static final String EMPTY_LIST_MARKER = "empty_list";

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return EMPTY_LIST_MARKER;
        StringBuilder encodedStr = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String str = strs.get(i);
            encodedStr.append(str);
            if (i != strs.size() - 1) {
                encodedStr.append("/");
            }
        }
        return encodedStr.toString();
    }

    
public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        if (str.equals(EMPTY_LIST_MARKER)) {
          return result; // Return an empty list
        }
        if (str.isEmpty()) {
            result.add(""); // Return a list with an empty string
            return result;
        }
        String[] parts = str.split("/", -1); // Use -1 to include trailing empty strings
        for (String part : parts) {
          result.add(part);
        }
        return result;
    }
}
