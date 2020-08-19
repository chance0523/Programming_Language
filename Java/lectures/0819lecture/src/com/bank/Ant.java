package com.bank;
//Ant.java   예금만 하는 Thread class

public class Ant extends Thread {
	Account account;
	int money = 10000;

	public Ant(Account a) {
		account = a;
	}

	public void run() {
		try {
			for (int i = 1; i <= 20; i++) {
				account.deposit(money);
				Thread.sleep((int) (Math.random() * 20));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}