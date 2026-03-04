class Node {
    String url;
    Node next;
    Node prev;
    Node(String url, Node next, Node prev) {
        this.url  = url;
        this.next = next;
        this.prev = prev;
    }
}
class BrowserHistory {
    Node curr;
    public BrowserHistory(String homepage) {
        curr = new Node(homepage, null, null);
    }
    
    public void visit(String url) {
        curr.next = new Node(url, null, curr);
        curr = curr.next;
    }
    
    public String back(int steps) {
        while(steps-->0 && curr.prev != null) curr = curr.prev;
        return curr.url;
    }
    
    public String forward(int steps) {
        while(steps-->0 && curr.next != null) curr = curr.next;
        return curr.url;
    }
}
