package com.lec.quiz;
public class MemberInfo {
	public static void main(String[] args) {
		Member member1 = new Member("aaa", "ȫ�浿", "hong@company", "���� ������", "01-01", 'm');
		Member member2 = new Member("bbb", "��ҿ�", "sykim@naver.com", "���� ���빮��", "01-01", 'f');
		Member[] members = {member1, member2};
		for(Member member : members) {
			System.out.println(member.infoString());
		}
	}
	
}
