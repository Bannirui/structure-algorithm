/*
 * @lc app=leetcode.cn id=706 lang=java
 *
 * [706] 设计哈希映射
 */

// @lc code=start
class MyHashMap {

    private static class Node{
        int key;
        int value;

        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }

        public int getKey(){
            return this.key;
        }

        public int getValue(){
            return this.value;
        }

        public void setKey(int key){
            this.key=key;
        }

        public void setValue(int value){
            this.value=value;
        }
    }

    private static final int size = 1024;
    LinkedList[] data = new LinkedList[size];

    public MyHashMap() {
        for(int i=0; i<size; i++) this.data[i]=new LinkedList<Node>();
    }
    
    public void put(int key, int value) {
        int hash = this.hash(key);
        LinkedList<Node> bin = this.data[hash];
        Iterator<Node> it = bin.iterator();
        while(it.hasNext()){
            Node node = it.next();
            if(node.getKey() == key) {
                node.setValue(value);
                return;
            }
        }
        bin.add(new Node(key, value));
    }
    
    public int get(int key) {
        int hash = this.hash(key);
        Iterator<Node> it = this.data[hash].iterator();
        while(it.hasNext()){
            Node node = it.next();
            if(node.getKey() == key) return node.getValue();
        }
        return -1;
    }
    
    public void remove(int key) {
        int hash = this.hash(key);
        Iterator<Node> it = this.data[hash].iterator();
        while(it.hasNext()){
            Node node = it.next();
            if(node.getKey() == key) {
                this.data[hash].remove(node);
                return;
            }
        }
    }

    private int hash(int key){
        return key % size;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// @lc code=end

