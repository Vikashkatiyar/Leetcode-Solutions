class Solution {
    // Solution totally depend on Trie 
    class Node{
        int score=0;
        Node[] child=new Node[26];
    }

    Node root=new Node(); // Define the root node
    public int[] sumPrefixScores(String[] words) {
        
        // Insert into the Trie
        for(String word: words){
            insert(word);
        }
        
        // check the prefixes score
        int[] ans=new int[words.length];
        for(int i=0;i<words.length;i++){
            ans[i]=search(words[i]);
        }
        
        return ans;
    }
    
    public void insert(String str){
        Node temp=root;
        for(char ch: str.toCharArray()){
            if(temp.child[ch-'a']==null){
                temp.child[ch-'a']=new Node();
            }
            temp.child[ch-'a'].score++;
            temp=temp.child[ch-'a'];
        }
    }
    
    public int search(String str){
        int res=0;
        Node temp=root;
        for(char ch: str.toCharArray()){
            res+=temp.child[ch-'a'].score;
            temp=temp.child[ch-'a'];
        }
        
        return res;
    }
    
}