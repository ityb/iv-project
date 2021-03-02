package com.ityb.iv.skiplist;

import java.util.ArrayList;
import java.util.Iterator;

public class SkipListMain {

    public static class SkipListNode {
        public Integer value;
        //此数组为层数，list中存放的内容为每一层中的下一个节点，0层存放的永远都是null，下一个节点又会包含所有的信息，总共有roll出的层加一层。
        public ArrayList<SkipListNode> nextNodes;

        //code中，小的是高层，大的是低层
        public SkipListNode(Integer value) {
            this.value = value;
            nextNodes = new ArrayList<SkipListNode>();
        }
    }

    public static class SkipListIterator implements Iterator<Integer> {
        SkipList list;
        SkipListNode current;

        public SkipListIterator(SkipList list) {
            this.list = list;
            this.current = list.getHead();
        }

        public boolean hasNext() {
            return current.nextNodes.get(0) != null;
        }

        public Integer next() {
            current = current.nextNodes.get(0);
            return current.value;
        }
    }

    public static class SkipList {
        //head是巨小
        private SkipListNode head;
        private int maxLevel;//所有数据roll出来的最大层
        private int size;//加进来的所有数据个数
        private static final double PROBABILITY = 0.5;//roll的概率是多少

        //
        public SkipList() {
            size = 0;
            maxLevel = 0;
            head = new SkipListNode(null);
            head.nextNodes.add(null);
        }

        public SkipListNode getHead() {
            return head;
        }

        public void add(Integer newValue) {
            if (!contains(newValue)) {
                size++;
                int level = 0;
                while (Math.random() < PROBABILITY) {
                    level++;
                }
                //当当前高度大于现在的最大高度，则进行扩充层数
                while (level > maxLevel) {
                    head.nextNodes.add(null);
                    maxLevel++;
                }
                SkipListNode newNode = new SkipListNode(newValue);
                SkipListNode current = head;
                do {
                    //current为当前层中最后一个小于newValue的
                    current = findNext(newValue, current, level);
                    //从第0层开始放，数据会从第0层一路向上，每一次在0层存入值，之前的值会向上升，最终将当前的节点的所有信息从第0行到随机的最高的一行全部存入信息。
                    newNode.nextNodes.add(0, current.nextNodes.get(level));
                    //将current第某个level上放的是newNode
                    current.nextNodes.set(level, newNode);
                } while (level-- > 0);
            }
        }

        public void delete(Integer deleteValue) {
            if (contains(deleteValue)) {
                SkipListNode deleteNode = find(deleteValue);
                size--;
                int level = maxLevel;
                SkipListNode current = head;
                do {
                    current = findNext(deleteNode.value, current, level);
                    if (deleteNode.nextNodes.size() > level) {
                        current.nextNodes.set(level, deleteNode.nextNodes.get(level));
                    }
                } while (level-- > 0);
            }
        }

        private SkipListNode find(Integer e) {
            return find(e, head, maxLevel);
        }

        private SkipListNode find(Integer e, SkipListNode current, int level) {
            do {
                current = findNext(e, current, level);
            } while (level-- > 0);
            return current;
        }

        //返回的current是在当前层中最后一个数小于当前key的值的
        private SkipListNode findNext(Integer e, SkipListNode current, int level) {
            //得到当前level层的链表中的下一个节点，
            SkipListNode next = current.nextNodes.get(level);
            while (next != null) {
                Integer value = next.value;
                if (lessThan(e, value)) {//如果当前的值小于value，则直接跳出
                    break;
                }
                current = next;
                next = current.nextNodes.get(level);
            }
            return current;
        }

        public int size() {
            return size;
        }

        public boolean contains(Integer value) {
            SkipListNode node = find(value);
            return node != null && node.value != null && equalTo(node.value, value);
        }

        public Iterator<Integer> iterator() {
            return new SkipListIterator(this);
        }


        private boolean lessThan(Integer a, Integer b) {
            return a.compareTo(b) < 0;
        }

        private boolean equalTo(Integer a, Integer b) {
            return a.compareTo(b) == 0;
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.add(1);
        skipList.add(6);
        skipList.add(7);
        skipList.add(10);
        skipList.add(19);
        skipList.add(50);
        System.out.println(skipList.find(10).value);


    }
}