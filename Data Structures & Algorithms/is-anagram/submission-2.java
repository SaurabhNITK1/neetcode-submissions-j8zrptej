class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character, Integer> frequencyS = new HashMap<>();
        HashMap<Character, Integer> frequencyT = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            int count = frequencyS.getOrDefault(s.charAt(i), 0);
            count++;
            frequencyS.put(s.charAt(i), count);
        }
        for(int i=0; i<t.length(); i++) {
            int count = frequencyT.getOrDefault(t.charAt(i), 0);
            count++;
            frequencyT.put(t.charAt(i), count);
        }
        
        // compare
        for(int i=0; i<s.length();i++) {
           if(!frequencyS.get(s.charAt(i)).equals(frequencyT.getOrDefault(s.charAt(i), -1))) {
             return false;
           }
        }
        return true;
    }
}
