package Yoon.Ex06;

public class BankVO {
	public final int MAX_LOAN = 100000000; // �ִ� ���� �����ѵ�
	public final double RATE = 0.1; // ����
	private int totalMoney; // ���࿡ �ִ� ��

	public int getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	public void printBankInfo() {// ���� ���� ���
		System.out.println("���൷ : " + this.getTotalMoney()); // ���� ���� ���
	}
}
