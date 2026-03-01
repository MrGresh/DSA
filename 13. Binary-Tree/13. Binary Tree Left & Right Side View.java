class Solution {
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if(root!=null) q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=1;i<=size;i++) {
                Node node = q.poll();
                if(i==1) res.add(node.data);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
        }
        return res;
    }
}
------------------------
class Solution {
    ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if(root!=null) q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=1;i<=size;i++) {
                Node node = q.poll();
                if(i==size) res.add(node.data);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
        }
        return res;
    }
}
