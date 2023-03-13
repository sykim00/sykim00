package com.lec.quiz;
public class Member {
	private String id;
	private String name;
	private String email;
	private String address;
	private String birth;
	private char gender;
	public Member() {}
	public Member(String id,String name, String email, String address, String birth, char gender) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
	}
	public String infoString(){
		String genderStr = (gender=='M' || gender=='m') ? "����" : (gender=='F' || gender=='f') ? "����":"";
		return String.format("���̵� = %s\n�̸� = %s\n�̸��� = %s\n�ּ� = %s\n���� = %s\n���� = %s\n", id, name, email, address, birth, genderStr);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
}
