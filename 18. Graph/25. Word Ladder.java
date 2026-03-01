class Solution {
    int ans = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        ans = Integer.MAX_VALUE;
        Set<String> words = new HashSet();
        words.add(beginWord);
        rec(beginWord, endWord, wordList, words);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    void rec(String currWord, String endWord, List<String> wordList, Set<String> words) {
        if(currWord.equals(endWord)) {
            ans = Math.min(ans, words.size());
            return;
        }
        for(String word: wordList) {
            if(!words.contains(word) && diffIsOne(currWord, word)) {
                words.add(word);
                rec(word, endWord, wordList, words);
                words.remove(word);
            }
        }
    }
    boolean diffIsOne(String w1, String w2) {
        int cnt = 0;
        for(int i=0;i<w2.length();i++) {
            if(w1.charAt(i)!=w2.charAt(i)) cnt++;
            if(cnt>1) return false;
        }
        return cnt==1;
    }
}
-------------------------------------------------------------------------------------------------------------
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            ++level;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();                
                if (currWord.equals(endWord)) return level;
                char[] chars = currWord.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        chars[j] = c;
                        String nextWord = String.valueOf(chars);
                        if (wordSet.contains(nextWord)) {
                            queue.add(nextWord);
                            wordSet.remove(nextWord);
                        }
                    }
                    chars[j] = originalChar;
                }
            }
        }
        return 0;
    }
}
