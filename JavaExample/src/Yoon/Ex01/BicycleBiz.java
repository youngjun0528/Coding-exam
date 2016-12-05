package Yoon.Ex01;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BicycleBiz {
	
	private List<CustomerVO> customerList;
	private CustomerVO customer;
	private BicycleVO high;
	private BicycleVO mid;
	private BicycleVO low;
	private Scanner input;
	private static Date curDate;
	private int choice; // �޴�
	private int choiceBicycle; // �����ż���
	private boolean result;
	
	public BicycleBiz() {
		this.customerList = new ArrayList<CustomerVO>();
		this.input = new Scanner(System.in);
		this.high = new BicycleVO("�����", 5000, 2);
		this.mid = new BicycleVO("�߱���", 3000, 5);
		this.low = new BicycleVO("������", 1000, 15);
	}

	public List<CustomerVO> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CustomerVO> customerList) {
		this.customerList = customerList;
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice() { // �޴� choice �� ���� InputMismatchException����ó��
		while(true){
			try{
				this.choice = this.inputScannerInt();
				break;
			}
			catch(InputMismatchException ime){
				System.out.println("1,2 �߿� �Է����ּ���.");
			}
		}
	}
	
	public int getChoiceBicycle() {
		return choiceBicycle;
	}

	public void setChoiceBicycle() { // ������ ���� choice �� ���� ���� ó��
		while(true){
			try{
				this.choiceBicycle = this.inputScannerInt();
				break;
			}
			catch(InputMismatchException ime){
				System.out.println("1,2,3 �߿� �Է����ּ���.");
			}
		}
	}

	public int inputScannerInt(){
		input = new Scanner(System.in);
		return input.nextInt();
	}
	
	public void startProgram() {
		int choice = 0;
		
		while ( true ) {
			this.customer = new CustomerVO();
			//customer.bicycleList = new ArrayList<String>();
			System.out.println("=====������ �뿩 ���α׷� �Դϴ�.=====");
			System.out.println("1. �뿩");
			System.out.println("2. �ݳ�");
			System.out.println("3. ����");
			System.out.println("===================================");
			
			this.setChoice();
			choice = this.getChoice();
			
			if ( choice == 1 ) { // �뿩
				int choiceBicycle = 0;				
				while(true){
					System.out.println("���� �����Ÿ� �����ϼ���.");
					System.out.println("1. ����");
					System.out.println("2. �߱�");
					System.out.println("3. ���");
					System.out.println("������ ���� ��Ȳ");
					low.currentCount(); // ������ ���� ���
					mid.currentCount();
					high.currentCount();
				
					this.setChoiceBicycle(); 
					choiceBicycle = this.getChoiceBicycle();
					
					if ( choiceBicycle == 1 ) { //�������������� �� 
						rent(low);
						this.addNewCustomerInfo(customer);
						break;
					}
					else if ( choiceBicycle == 2 ){
						rent(mid);
						this.addNewCustomerInfo(customer);
						break;
					}
					else if (choiceBicycle == 3){
						rent(high);
						this.addNewCustomerInfo(customer);
						break;
					}
					else{
						System.out.println("�ٽ��Է����ּ���.");//if
					}
				}//while
			}
			else if ( choice == 2 ) { // �ݳ�
				while(true) {
					System.out.println("�ݳ��� �̸��� �Է��ϼ���.");
					String deleteName = input.next();
					if ( checkScanner("^[��-�Ra-zA-Z]*$", deleteName) ){
					}
					else{ 
						if (this.result = this.deleteCustomerByName(deleteName) ){ //�����ϸ�
							Calendar cal = Calendar.getInstance();
							long time = cal.getTimeInMillis() + 1800000; //�׽�Ʈ��
							//long time = cal.getTimeInMillis();
							this.checkCount(getInfo(deleteName), high, time);
							this.checkCount(getInfo(deleteName), mid, time);
							this.checkCount(getInfo(deleteName), low, time);// � ������ ���Ⱦ����� �˻� �ؼ� �ݳ�
							this.customerList.remove(getInfo(deleteName)); // �� ���� ����
							System.out.println(deleteName + "���� ������ �����Ǿ����ϴ�.\n");
							break;
						}
						else{ //�̸��� ��������������
							System.out.println(deleteName+"�� ������ �����ϴ�.\n");
							break;
						}//else
					}//else
				}//while
			}//else if
			else if ( choice == 3 ) {
				System.exit(0);
			}
		}//while
	}
	
	private void rent(BicycleVO type){
		curDate = new Date();
		Calendar now = Calendar.getInstance();
		customer.setRentTime(now.getTimeInMillis());
		if ( type.checkCount() ){ // ���� �� Ȯ��
			System.out.println("�����Ű� 0�뿡��.");
		}
		else{ // �����Ű� ���� �ִٸ�
			System.out.println("�̸��� ���� ���� �Է��ϼ���."); // �� ���� ���
			String name = input.next();
			customer.setName(name);
			int money = input.nextInt();
			customer.setMoney(money);
			customer.setType(type.getType());
			type.rent(); // �������� count�� 1 ���δ�.
			System.out.println(name + ": " + type.getType() + "�����Ÿ� �Ѵ� �뿩�ϼ̽��ϴ�.");
			System.out.println("�뿩�� �ð� : " + curDate); // �뿩�� �ð� ���
		}		
	}
	
	public void checkCount ( CustomerVO customer , BicycleVO type, long time) { //  �ݳ� ��� �޼ҵ�
		if ( customer.getType() == type.getType()){ // ���� ������� ������ �ִٸ�
			type.back(); // ����� ������ count 1 ���� (�ݳ������Ƿ�)
			long result = (time - customer.getRentTime()) / 1000;
			int minute = (int)Math.round((double)result / 60); //�ð����� �����
			System.out.println("�̿�ð�(��) : " + minute);
			if ( minute < 10) { // 10�к��� ������ �� �ȳ��� �ȴٰ�
				System.out.println("�̿��Ͻ� �ð��� 10�� �̸��Դϴ�. �� �ȳ�����");
				System.out.println("�ݳ��Ǿ����ϴ�. ������ �ܾ� : " + customer.getMoney());
			}
			else {
				int cost = (minute / 10) * type.getCost(); // 10�д� �� ���
				System.out.println("�ݾ� :" + cost);
				customer.setMoney(customer.getMoney() - cost);
				System.out.println("�ݳ��Ǿ����ϴ�. ������ �ܾ� : " + customer.getMoney());
			}
		}
		else{
		}
	}
	
	public boolean deleteCustomerByName( String name ) {
		for ( CustomerVO customer : this.customerList ) {
			if( customer.getName().equals(name) ) {
				return true;
			}
		}
		return false;
	}
	
	public CustomerVO getInfo( String name ) {
		for ( CustomerVO customer : this.customerList ) {
			if ( customer.getName().equals(name) ){
				this.customer = customer;
				return customer;
			}
		}
		return new CustomerVO();
	}
	
	public boolean checkScanner( String checkScan, String whatString ) {
		if ( !whatString.matches(checkScan) ) {
			System.out.println("���Է�");
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addNewCustomerInfo(CustomerVO customer){
		this.customerList.add(customer);
	}

}