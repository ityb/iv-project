package com.ityb.iv.arithmetic.written.exam02;

public class Function {
	public static Node merge(Node head1,Node head2){
		if(head1==null){
			return head2;
		}
		if(head2==null){
			return head1;
		}
		//ȷ��ͷ���
		Node head=new Node();
		Node p1;
		Node p2;
		Node pcur;
		/**
		 * ѡȡhead1��Ϊͷ
		 * ����head1������ֵ
		 */
		if(head1.getData()<head2.getData()){
			head=head1;
			p1=head1.getNext();
			p2=head2;
		
		/**
		 * ѡȡhead2��Ϊͷ
		 * ����head2������ֵ
		 */
		}else{
			head=head2;
			p1=head2.getNext();
			p2=head1;
		}
		pcur=head;
		while(p1!=null&&p2!=null){
			if(p1.getData()<=p2.getData()){
				pcur.setNext(p1); //pcur->next=p1
				pcur=p1; //pcur=p1;
				p1=p1.getNext(); //p1=p1->next
			}else{
				pcur.setNext(p2);//pcur->next=p2
				pcur=p2;//pcur=p2
				p2=p2.getNext();//p2=p2->next;
			}
			/**
			 * ���p1�б���С��p2�ĳ��ȣ���ֱ�ӽ�p2����Ľڵ����pcur�ĺ���
			 */
			if(p1!=null){
				pcur.setNext(p1);
			}
			if(p2!=null){
				pcur.setNext(p2);
			}
		}
		return head;
	}
	
	public static void show(Node head){
		if(head==null){
			System.out.println("����Ϊ��");
		}
		Node p=head;
		while(p!=null){
			System.out.print(p.getData()+" ");
			p=p.getNext();
		}
	}
}
