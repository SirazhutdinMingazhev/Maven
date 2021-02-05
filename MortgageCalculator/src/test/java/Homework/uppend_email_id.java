package Homework;

import java.util.Random;

public class uppend_email_id {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<=3;i++) {
			Random r=new Random();
			int num=r.nextInt(500);
			String email="test"+num+"@gmail.com";
			System.out.println(email);
		}
	}
}
