package mock;

import objects.WebMarket;

public class MockWebMarket21 extends WebMarket {
	int webmarketid;
	String name;
	String contact;
	
	public MockWebMarket21(int id,String n,String c){
		webmarketid = id;
		name=n;
		contact=c;
	}
	public int getid(){
		return webmarketid;
	}
	public String getname(){
		return name;
	}
	public String getcontact(){
		return contact;
	}
}
