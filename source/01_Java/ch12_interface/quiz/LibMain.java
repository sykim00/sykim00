package com.lec.quiz;
import java.util.Scanner;
public class LibMain {
	public static void main(String[] args) {
		BookLib[] books = {new BookLib("890��-01-11", "java", "ȫ�浿"),
						   new BookLib("890��-01-11", "oracle", "���浿"),
						   new BookLib("890��-01-11", "mysql", "���浿"),
						   new BookLib("890��-01-11", "jdbc", "���̵�"),
						   new BookLib("890��-01-11", "html", "�̿���")};
		Scanner scanner = new Scanner(System.in);
		int fn; // ��ɹ�ȣ (1:����/ 2:�ݳ�/ 3:ålist/ 0:����)
		int idx; // �����ϰų� �ݳ��� ��, ��ȸ�� å�� index
		String bTitle, borrowser, checkOutDates; // ����ڿ��� ���� å�̸�, ������, ������
		do {
			System.out.println("1:����/ 2:�ݳ�/ 3:ålist/ 0:����");	
			fn = scanner.nextInt();
			switch(fn) {
			case 1: // ���� : 1.å�̸��Է� 2.å��ȸ 3.å����Ȯ�� 4.�������Է� 5.�������Է� 6.����޼ҵ� ȣ�� 
				// 1. å�̸��Է�
				System.out.println("�����ϰ��� �ϴ� å�̸���?");
				bTitle = scanner.next(); // white-space �ձ����� ��Ʈ���� ���� 
				// 2.å��ȸ
				for(idx = 0 ; idx < books.length; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				} // for
				if(idx == books.length) {
					System.out.println("���� �������� �ʴ� �����Դϴ�.");
				}else { // books[idx] ������ ����
					// 3.å����Ȯ��	
					if(books[idx].getState() == BookLib.STATE_BORROWED) {
						System.out.println("���� ���� ���� �����Դϴ�.");
					}else {
						// 4.�������Է�
						System.out.print("��������?");
						borrowser = scanner.next();
						// 5.�������Է�
						System.out.println("������?");
						checkOutDates = scanner.next(); // 2022-12-01(o), 2002 12 01(x)
						// 6.����޼ҵ� ȣ�� 
						books[idx].checkOut(borrowser, checkOutDates);
					}
				}
				break;
			case 2:	// �ݳ����� : 1.å�̸��Է� 2.å��ȸ 3.�ݳ��޼ҵ� ȣ��
				//1.å�̸��Է�
				System.out.println("�ݳ��ϰ��� �ϴ� å�̸���?");
				bTitle = scanner.next(); // white-space �ձ����� ��Ʈ���� ���� 
				//2.å��ȸ
				for(idx = 0 ; idx < books.length; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				} // for
				if(idx == books.length) {
					System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�.");
				}else {
					//3.�ݳ��޼ҵ� ȣ��
					books[idx].checkIn();
				}
				break;
			case 3:	// å list ��� : for���� �̿��Ͽ� printState()�޼ҵ� ȣ��
				for(BookLib book : books) {
					book.printState();
				}
			}
		}while(fn != 0); 
		System.out.println("����");
		scanner.close();
	}
}
