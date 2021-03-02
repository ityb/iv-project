package com.ityb.iv.cacheStrategy;

import java.util.HashMap;

/**
 * 思想：构建一个双向链表和一个哈希表
 *      哈希表存key-value，给定初始值
 *      哈希表get操作时，将结点移到链表末尾
 *      set操作时如果set一个已经存在的值则将该值移到链表默认，如果不存在的值则需要判断是否大于设置的容量
 *      如果大于设置的容量则移除链表头部的数据，于此同时也需要移除哈希表中的值
 *      如果不大于设置的容量则添加到链表末尾
 */

public class LRU {

    public static class Node<V>{
        private V value;
        private Node<V> next;
        private Node<V> last;
        public Node(V value) {
            this.value = value;
        }
    }

    public static class NodeDoubleLinkedList<V>{
        private Node<V> head;
        private Node<V> tail;
        //新建双端链表
        public NodeDoubleLinkedList(){
            this.head = null;
            this.tail = null;
        }
        //增加节点
        public void addNode(Node<V> newNode){
            if(newNode == null){
                return;
            }
            if(this.head == null){
                this.head = newNode;
                this.tail = newNode;
            }else{
                this.tail.next = newNode;
                newNode.last = this.tail;
                this.tail = newNode;
            }
        }
        //将节点移到结尾的位置
        public void moveNodeToTail(Node<V> node){
            if(this.tail == node){
                return ;
            }
            if(this.head == node){
                this.head = node.next;
                this.head.last = null;
            }else{
                node.last.next = node.next;
                node.next.last = node.last;
            }
            node.last = this.tail;
            node.next = null;
            this.tail.next = node;
            this.tail = node;
        }
        //移除头节点
        public Node<V> removeHead(){
            if(this.head == null){
                return null;
            }
            Node<V> res = this.head;
            //如果整个链表中只含有一个元素，移除后头和尾都要指向空
            if(this.head == this.tail){
                this.head = null;
                this.tail = null;
            }else{
                this.head = res.next;
                res.next = null;
                this.head.last = null;
            }
            return res;
        }
    }
    //node存入map中，存入的是内存地址，而不会存入具体的数值，即使node中有很多的文本，也不会有很大影响
    public static class LRUCache<K,V> {
        private HashMap<K,Node<V>> keyNodeMap;
        private HashMap<Node<V>,K> nodeKeyMap;
        private NodeDoubleLinkedList<V> nodeList;
        private int capacity;

        public LRUCache(int capacity){
            if(capacity <1){
                throw new RuntimeException("should be more than 0");
            }
            this.keyNodeMap = new HashMap<K,Node<V>>();
            this.nodeKeyMap = new HashMap<Node<V>,K>();
            this.nodeList = new NodeDoubleLinkedList<V>();
            this.capacity = capacity;
        }

        public V get(K key){
            if(this.keyNodeMap.containsKey(key)){
                Node<V> res = this.keyNodeMap.get(key);
                this.nodeList.moveNodeToTail(res);
                return res.value;
            }
            return null;
        }

        public void set(K key,V value){
            if(this.keyNodeMap.containsKey(key)){
                Node<V> node = this.keyNodeMap.get(key);
                node.value = value ;
                this.nodeList.moveNodeToTail(node);
            }else{
                Node<V> newNode = new Node<V>(value);
                this.keyNodeMap.put(key,newNode);
                this.nodeKeyMap.put(newNode,key);
                this.nodeList.addNode(newNode);
                if(this.keyNodeMap.size() == this.capacity +1){
                    this.removeMostUnusedCache();
                }
            }
        }

        private void removeMostUnusedCache(){
            Node<V> removeNode = this.nodeList.removeHead();
            K removeKey = this.nodeKeyMap.get(removeNode);
            this.nodeKeyMap.remove(removeNode);
            this.keyNodeMap.remove(removeKey);
        }
    }

    public static void main(String[] args) {
        LRUCache<String,Integer> lruCache = new LRUCache<>(3);
        lruCache.set("1",1);
        lruCache.set("2",2);
        lruCache.set("3",3);
        lruCache.get("2");
        lruCache.get("1");
        lruCache.set("4",4);
        System.out.println(lruCache.get("1"));
    }
}
