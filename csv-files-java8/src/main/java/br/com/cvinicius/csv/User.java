package br.com.cvinicius.csv;

public class User {

	private final String columns = "{Name: %s, Cpf: %s, Age: %s, Phone: %s, Address: %s}";
	
	private String name, cpf, phone, address;
	private Integer age;
	
	public User(String name, String cpf, Integer age, String phone, String address){
		this.name 	  	= name;
		this.cpf 	  	= cpf;
		this.age 	  	= age;
		this.phone 		= phone;
		this.address 	= address;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public Integer getAge() {
		return age;
	}
	
	@Override
	public String toString(){
		return String.format(columns, this.name, this.cpf, this.age, this.phone, this.address);
	}
}