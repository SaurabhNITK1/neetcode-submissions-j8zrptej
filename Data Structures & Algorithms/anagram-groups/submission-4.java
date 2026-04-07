/* Mapping characters to integer
Mapping 'a' to 0:
To map 'a' to 0, you subtract the ASCII value of 'a' from the ASCII value of the character. This is done using the expression c - 'a'.
For example:
'a' - 'a' equals 97 - 97, which is 0.
'b' - 'a' equals 98 - 97, which is 1.
'c' - 'a' equals 99 - 97, which is 2.

Use :
    for (String s : strs) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        String key = Arrays.toString(count);
        res.putIfAbsent(key, new ArrayList<>());
        res.get(key).add(s);
    }
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> hash = new HashMap<>();
        for(String s : strs) {
           int[] frequency = new int[26];
           for(int i=0; i<s.length(); i++) {
              char c = s.charAt(i);
              frequency[c - 'a']++;
           }
           String key = Arrays.toString(frequency);
           List<String> getFromHash = hash.getOrDefault(key, new ArrayList<>());
           getFromHash.add(s); /* if the val is present in map then No need to put the value back to map bcz reference is modified.
                                  but if the val is not present then we need to put it explicitly*/
           hash.putIfAbsent(key, getFromHash); 
        }

        for(Map.Entry<String, List<String>> entry : hash.entrySet()) {
           result.add(entry.getValue());
        }

        return result;
    }
}
