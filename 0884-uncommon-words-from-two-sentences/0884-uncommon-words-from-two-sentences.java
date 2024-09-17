class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Using HashMap to count occurrences of words
        Map<String, Integer> wordCount=new HashMap<>();
        
        // Splitting and counting words from both sentences
        Arrays.stream((s1 + " " + s2).split(" "))
              .forEach(word->wordCount.put(word, wordCount.getOrDefault(word, 0)+1));
        
        // Collecting words with a count of 1 (uncommon words)
        List<String> uncommonWords=wordCount.entrySet()
            .stream()
            .filter(entry->entry.getValue()==1)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        
        // Converting the list of uncommon words to an array and returning
        return uncommonWords.toArray(new String[0]);
    }
}