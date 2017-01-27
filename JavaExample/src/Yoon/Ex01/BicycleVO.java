package Yoon.Ex01;

public class BicycleVO {
	
	private String type;
	private int cost; // ���
	private int count; // count
	
	public BicycleVO(String type, int cost, int count){
		setType(type);
		setCost(cost);
		setCount(count);
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	/**
	 * ������� count���� �ϳ� ���ش�.
	 */
	public void rent(){ 
		this.count--;
		System.out.println(this.getType() + "�Ѵ븦 �뿩�ϼ̽��ϴ�.");
	}
	
	/**
	 * �ݳ� ( �ݾ��� ����ϰ�, count�� �ϳ� �÷��ش�. ) 
	 * @param time �����ð����� 10������ ���� ��
	 * @return �����ϴ� �ݾ��� ��ȯ��Ų��.
	 */
	public void back(){ 
		this.count++;
		System.out.println(this.getType()  + "�Ѵ븦 �ݳ��ϼ̽��ϴ�.");
	}
	
	/**
	 * ���� ������ �� ���
	 */
	public void currentCount(){ // ���� count ���
		System.out.println(this.getType() + " : " + this.count + "(10�д� : " + this.cost + "õ��)");
	}
	
	public boolean checkCount() { // count Ȯ��
		if ( this.getCount() == 0 ){
			return true;
		}
		return false;
	}

}