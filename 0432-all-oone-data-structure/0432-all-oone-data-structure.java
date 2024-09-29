class AllOne {
    class Node {
        String str;
        int ct;
        Node next, prev;
        Node(String s) {
            str = s;
            ct = 1;
        }
    }
    
    Map<String, Node> map;
    Node head, tail;
    public AllOne() {
        map = new HashMap<>();
        head = new Node("-1");
        tail = new Node("-1");
        head.next = tail;
        tail.prev = head;
        tail.ct = (int)1e5;
    }
    
    public void inc(String key) {
        if(!map.containsKey(key)) {
            Node curr = new Node(key);
            map.put(key, curr);
            
            curr.next = head.next;
            head.next.prev = curr;
            
            curr.prev = head;
            head.next = curr;
            
        } else {
            Node curr = map.get(key);
            curr.ct++;
            
            while(curr.ct > curr.next.ct) {
                Node ahead = curr.next;
                
                ahead.prev = curr.prev;
                curr.prev.next = ahead;
                
                ahead.next.prev = curr;
                curr.next = ahead.next;
                
                ahead.next = curr;
                curr.prev = ahead;
            }
        }
    }
    
    public void dec(String key) {
        Node curr = map.get(key);
        if(map.get(key).ct == 1) {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            map.remove(key);

        } else {
            curr.ct--;
            while(curr.ct < curr.prev.ct) {
                Node behind = curr.prev;
                
                behind.next = curr.next;
                curr.next.prev = behind;
                
                curr.prev = behind.prev;
                behind.prev.next = curr;
                
                behind.prev = curr;
                curr.next = behind;
            }
        }
    }
    
    public String getMaxKey() {
        return head.next == tail ? "" : tail.prev.str;
    }
    
    public String getMinKey() {
        return head.next == tail ? "" : head.next.str;
    }
}