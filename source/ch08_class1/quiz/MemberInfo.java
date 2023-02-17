package com.lec.quiz;
public class MemberInfo {
	public static void main(String[] args) {
		Member member1 = new Member("aaa", "홍길동", "hong@company", "서울 강남구", "01-01", 'm');
		Member member2 = new Member("bbb", "김소연", "sykim@naver.com", "서울 서대문구", "01-01", 'f');
		Member[] members = {member1, member2};
		for(Member member : members) {
			System.out.println(member.infoString());
		}
	}
	
}
