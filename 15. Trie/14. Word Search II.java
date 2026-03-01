class Solution {
    int rows = -1, cols = -1;
    boolean[][] vis;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        rows = board.length; cols = board[0].length;
        for(String word: words) {
            vis = new boolean[rows][cols];
            boolean flag = false;
            for(int i=0;i<rows;i++) {
                for(int j=0;j<cols;j++) {
                    if(board[i][j]==word.charAt(0)) {
                        if(rec(board, word, 1, i, j)) {
                            res.add(word);
                            flag = true;
                            break;
                        }
                    }
                }
                if(flag) break;
            }
        }
        return res;
    }
    boolean rec(char[][] board, String word, int idx, int i, int j) {
        if(idx==word.length()) return true;
        vis[i][j] = true;
        if(i-1>=0 && !vis[i-1][j] && board[i-1][j]==word.charAt(idx)) {
            if(rec(board, word, idx+1, i-1, j)) return true;
        }
        if(i+1<rows && !vis[i+1][j] && board[i+1][j]==word.charAt(idx)) {
            if(rec(board, word, idx+1, i+1, j)) return true;
        }
        if(j-1>=0 && !vis[i][j-1] && board[i][j-1]==word.charAt(idx)) {
            if(rec(board, word, idx+1, i, j-1)) return true;
        }
        if(j+1<cols && !vis[i][j+1] && board[i][j+1]==word.charAt(idx)) {
            if(rec(board, word, idx+1, i, j+1)) return true;
        }
        vis[i][j] = false;
        return false;
    }
}
---------------------------------------------------------------------------------------------------------------
class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    String word = null;
}

class Solution {
    List<String> result;
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.word = w;
        }

        result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children.containsKey(board[i][j])) {
                    backtrack(board, i, j, root);
                }
            }
        }
        return result;
    }

    private void backtrack(char[][] board, int r, int c, TrieNode parent) {
        char letter = board[r][c];
        TrieNode currNode = parent.children.get(letter);

        if (currNode.word != null) {
            result.add(currNode.word);
            currNode.word = null;
        }

        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
            return;
        }

        board[r][c] = '#';

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                if (currNode.children.containsKey(board[nr][nc])) {
                    backtrack(board, nr, nc, currNode);
                }
            }
        }

        board[r][c] = letter;
    }
}
