package com.ityb.iv.arithmetic.written.exam02;

public class Main {
	public static void main(String[] args) {
		//1 2 7
		Node head1=new Node(1);
		Node node2=new Node(2);
		head1.setNext(node2);
		Node node7=new Node(7);
		node2.setNext(node7);
		node7.setNext(null);
		
		//3 4 8 9
		Node head2=new Node(3);
		Node node4=new Node(4);
		head2.setNext(node4);
		Node node8=new Node(8);
		node4.setNext(node8);
		Node node9=new Node(9);
		node8.setNext(node9);
		node9.setNext(null);
		
		//1 2 3 4 7 8 9 
		Function.show(Function.merge(head1, head2));
		
	}
}
