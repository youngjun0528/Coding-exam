package Yoon.Ex06;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

public class Program {
	
	private int choice; // �޴�����
	private BankVO bank;
	private List<CustomerVO> customerList;
	private ScannerManage scan;
	private boolean result;
	
	public Program() {
		this.bank = new BankVO();
		new CustomerVO();
		this.scan = new ScannerManage();
		this.customerList = new ArrayList<CustomerVO>();
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

	public void setChoice() { // choice �� ���� InputMismatchException����ó��
		while(true){
			try{
				this.choice = scan.inputScannerInt();
				break;
			}
			catch(InputMismatchException ime){
				System.out.println("1,2,3,4,5 �߿� �Է����ּ���.");
			}
		}
	}

	public void startProgram() {
		int choice = 0;
		bank.setTotalMoney(1000000000); // �ʱ� ���� �� 10������ ����
		while ( true ) {
			System.out.println("========bank �������� ����========");
			System.out.println("1.����");
			System.out.println("2.������");
			System.out.println("3.���⳻������");
			System.out.println("4.�Ļ��û");
			System.out.println("5.����");
			System.out.println("==============================="); // �޴�
			
			this.setChoice();
			choice = this.getChoice(); // choice �Է¹ް� ����ó��
			
			if ( choice == 1 ) {
				while(true){
					System.out.println("�̸�, ��ȭ��ȣ, ������ ���� ��(��), �㺸�� �Է��ϼ���.(�ִ� ���� ���ɾ�: 1��)");
					String name = scan.inputScanner();
					if(scan.checkScanner("^[��-�Ra-zA-Z]*$", name)){ //�̸��� ���� üũ
						System.out.println("���Է�");
					}
					else{
						if ( this.checkName(name) ){
							String phoneNumber = scan.inputScanner();
							int money = scan.inputScannerInt();// ����ó���ؾ���
							this.checkInputMoney(name, phoneNumber, money);
							bank.printBankInfo(); // ���� �� ���� �� ���
							break;
						}
						else {
							System.out.println("���ο� ������ �������ּ���.");
						}
					}//else
				}//while
			}//if
			else if ( choice == 2 ) { // ������
				while (true) {
					System.out.println("�̸��� �Է����ּ���.");
					String searchName = scan.inputScanner();
					if(scan.checkScanner("^[��-�Ra-zA-Z]*$", searchName)){ //searchName  üũ
					}
					else{
						if ( this.returnMoney(searchName) ){
							break;
						}
						else {
							System.out.println(searchName + "�� �� ������ �����ϴ�.");
							break;
						}//else					
					}//else
				}//while
			}//else if
			else if ( choice == 3 ) { // ���⳻�� Ȯ��
				while(true){
					System.out.println("�̸��� �Է����ּ���.");
					String searchName = scan.inputScanner();
					if ( scan.checkScanner("^[��-�Ra-zA-Z]*$", searchName) ){// searchName üũ
					}
					else {
						this.searchMyInfo(searchName);
						bank.printBankInfo(); // �������� ���
						break;
					}
				}
			}
			else if ( choice == 4 ) { // �Ļ��û
				while (true) {
					System.out.println("�̸��� �Է��ϼ���.");
					String deleteName = scan.inputScanner();
					if ( scan.checkScanner("^[��-�Ra-zA-Z]*$", deleteName) ){ // deleteName üũ
					}
					else{ 
						this.bankruptcy(deleteName);
						bank.printBankInfo();//�������� ���
						break;
					}//if
				}//while
			}//else if
			else if ( choice == 5){//���α׷� ����
				System.exit(0);
			}
		}//while
	}
	
	public boolean isResult() {
		return result;
	}

	public boolean setResult(boolean result) {
		this.result = result;
		return result;
	}
	
	/**
	 * inputMoney�� üũ�ϴ� �޼ҵ�
	 * ���μ���
	 * 1) �㺸 üũ (�̹� ���� �� ����)
	 * 2) 1�� �̻� ���� �Ұ� 
	 * 3) ���࿡ �ִ� ������ ũ�� ���� �Ұ�
	 * 4) ������ ������ ���¶�� ���� ����
	 * 5) �ش� �ݾ׿� ���ؼ� ����
	 * 6) ���࿡ �ִ� ���� 0 �̸� �ý��� ����
	 * 
	 * @param name
	 * @param phoneNumber
	 * @param money
	 */
	public void checkInputMoney( String name, String phoneNumber, int money ) { // 
		String dambo = scan.inputScanner();
		if(scan.checkScanner("^[��-�Ra-zA-Z]*$", dambo)){ // �㺸�� ���� üũ
			System.out.println("���Է�");
		}
		else if (money > bank.MAX_LOAN){ // 1�� �̻� ������ ���Է�
			System.out.println("1�� ������ ���� �� �ֽ��ϴ�.");
		}
		else if(money > bank.getTotalMoney()) { // ���࿡ �ִ� ������ �����Ϸ��� ���� ũ��
			System.out.println("���࿡ ���� ���ڸ��ϴ�.");
		}
		else {
			Date curDate = new Date();
			Calendar now = Calendar.getInstance();
			long dateTime = now.getTimeInMillis();
			CustomerVO customer = new CustomerVO();
			
			customer.setName(name);
			customer.setPhoneNumber(phoneNumber);
			//customer.setMoney(money);
			customer.setDambo(dambo);
			customer.setLoanTime(curDate);
			customer.setMillisTime(dateTime);
			customer.setLoanMoney(money);
			
			this.customerList.add(customer);
			System.out.println("���� �ð� : " + customer.getLoanTime()); // ���� (���� ����)
			
			int out = bank.getTotalMoney() - money; // ���൷���� ������ ��
			bank.setTotalMoney(out); // �׵��� ���� �ѱݾ׿� �־�
			System.out.println(money + "���� ���� ���Ƚ��ϴ�.");
			
			if ( bank.getTotalMoney() == 0 ) {
				System.exit(0); // ���൷�� 0���̸� ����
			}
		}
	}
	
	/**
	 * �̸��� �޾� �Ļ��ϴ� �޼ҵ�
	 * ���μ���
	 * 1) customerList�� ���ϴ� �� ������ �ִ��� ��ȸ
	 * 2) �ִٸ� nameCheck = true, �ش� �� ������ �ӽ� ����
	 * 3) ���ٸ� nameCheck = false
	 * 3) ���� ���� ���� ���� �㺸 ������ ����ϰ� customerList���� ����
	 * @param deleteName
	 */
	public void bankruptcy(String deleteName) { // �Ļ��ϴ� �޼ҵ�
		
		boolean nameCheck = false;
		CustomerVO checkedCustomer = new CustomerVO();
		
		for ( CustomerVO customer : this.customerList ) {
			if ( customer.getName().equals(deleteName) ){
				checkedCustomer = customer;
				nameCheck =  true;
			}
		}
		nameCheck = false;
		
		if ( this.setResult(nameCheck) ){ //�����ϸ�
				System.out.println("����� �㺸 " + checkedCustomer.getDambo() + "�� ���� ��������." );// �㺸 ����
				this.customerList.remove(checkedCustomer); // ��� ����
				System.out.println("���������� ���ٰ�");
		}
		else{ //�̸��� ��������������
			System.out.println(deleteName+"�� ������ �����ϴ�.\n");
		}//else
	}
	
	/**
	 * �̸��� �Է��Ͽ� ���� ������ Ȯ��
	 * ���μ���
	 * 1) customerList�� ���ϴ� �� ������ �ִ��� ��ȸ
	 * 2) �ִٸ� nameCheck = true, �ش� �� ������ �ӽ� ����
	 * 3) ���ٸ� nameCheck = false
	 * 3) ���� ���� ���� �� ���� ��� Ȥ�� �� ���� ���� �޼��� ���
	 * @param searchName
	 */
	public void searchMyInfo(String searchName) { // ���� ���� ���� ������ ã�´�.
		
		boolean nameCheck = false;
		CustomerVO selectedCustomer = new CustomerVO();
		
		for ( CustomerVO customer : this.customerList ) {
			if ( customer.getName().equals(searchName) ){
				selectedCustomer = customer;
				nameCheck =  true;
			}
		}
		nameCheck = false;
		
		if ( this.setResult(nameCheck)) { 
			this.printInfo(selectedCustomer);//�ش��ϴ� ���� ���
			System.out.println("");
		}
		else { 
			System.out.println(searchName + "�� �� ������ �����ϴ�.");
		}
	}
	
	/**
	 * ���� ���� ���� �޼ҵ�
	 * ���μ���
	 * 1) ������ �ϴ� ����� ���� Ȯ��
	 * 2) ���ƾ��� �� ��� ( ��ü ���� �ݾ� �� ���� �ݾ� ����)
	 * 3) ���� �ݾ��� 0�� �� �� ���� �ݺ��Ͽ� ���� ���� �Է��Ѵ�.
	 * @param searchName
	 * @return
	 */
	public boolean returnMoney( String searchName ) { // �� ���� �� 
		boolean nameCheck = false;
		CustomerVO selectedCustomer = new CustomerVO();
		System.out.println("�󸶸� ���� �ǰ���?");
		int money = scan.inputScannerInt();
		
		for ( CustomerVO customer : this.customerList ) {
			if ( customer.getName().equals(searchName) ){
				selectedCustomer = customer;
				nameCheck =  true;
			}
		}
		nameCheck = false;
		
		if (this.setResult(nameCheck)) {
			this.printInfo(this.getInfo(searchName)); // ã������ ���
			
			Calendar when = Calendar.getInstance();
			long time = when.getTimeInMillis();
			long result = ((time - selectedCustomer.getMillisTime()) / 1000);
			int sc = (int)Math.round((double)result);
			double down = Math.floor(sc/5); // �Ҽ��� ����
			double pow = Math.pow((1+bank.RATE),down);
			int totalLoan = (int)(selectedCustomer.getLoanMoney() * pow);
			
			int loan = totalLoan	-  this.getInfo(searchName).getRepayMoney(); // ���ƾ��� �� ���
			System.out.println("");
			bank.printBankInfo();// ���� ���� ���
			if (money > loan) { // ���ƾ��� ������ ������
				System.out.println("�׷��� ���� ���൵ �Ǵµ�...;;");
			} else if (money == loan) {
				System.out.println("���� ���� �����̽��ϴ�.");
				
				selectedCustomer.setRepayMoney(money); // ���� ���� �� �ױ�
				bank.setTotalMoney(bank.getTotalMoney() + money); // ���࿡ ���� �� ��ŭ �ѱݾ׿� �߰�
				System.out.println(money + "��ŭ�� ���� ���ҽ��ϴ�.");
				
				this.getCustomerList().remove(this.getInfo(searchName)); // �ٰ�������
																				// ��������
				System.out.println("������ �����Ǿ����ϴ�.\n");
			} else {
				selectedCustomer.setRepayMoney(money); // ���� ���� �� �ױ�
				bank.setTotalMoney(bank.getTotalMoney() + money); // ���࿡ ���� �� ��ŭ �ѱݾ׿� �߰�
				System.out.println(money + "��ŭ�� ���� ���ҽ��ϴ�.");
				bank.printBankInfo();
				System.out.println("");
			}
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * �̹� �����ϴ� ������ üũ
	 * @param searchName �Է¹��� �̸�
	 * @return
	 */
	public boolean checkName ( String searchName ){ 
		boolean nameCheck = false;
		
		for ( CustomerVO customer : this.customerList ) {
			if ( customer.getName().equals(searchName) ){
				nameCheck =  true;
			}
		}
		nameCheck = false;
		
		if ( this.setResult(nameCheck)) { 
			System.out.println("�̹� �����ϴ� ���Դϴ�.");
			return false;
		}
		else { 
			return true;
		}
		
	}

	/**
	 * ���� ���
	 * @param customer
	 */
	public void printInfo(CustomerVO customer){
		System.out.println("�̸� : " + customer.getName());
		System.out.println("��ȭ��ȣ : " + customer.getPhoneNumber());
		System.out.println("����ݾ� : " + customer.getLoanMoney());
		System.out.println("���� �ݾ� :" + customer.getRepayMoney());
		System.out.println("�㺸 : " + customer.getDambo());
		System.out.println("����ð� : " + customer.getLoanTime());
	}
	
	/**
	 * �ش��������������
	 * @param name
	 * @return
	 */
	public CustomerVO getInfo( String name ) {
		CustomerVO selectedCustomer = new CustomerVO();
		for ( CustomerVO customer : this.customerList ) {
			if ( customer.getName().equals(name)){
				selectedCustomer = customer;
				return selectedCustomer;
			}
		}
		return new CustomerVO();
	}
	
}
