class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        HashSet<String> set = new HashSet<>();
        int count = 0;
        
        for (String word : bannedWords) {
            set.add(word);
        }
        
        for (String word : message) {
            if (set.contains(word)) {
                count++;
                if (count >= 2) {
                    return true;
                }
            }
        }
        
        return false;
    }
}