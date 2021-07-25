package com.challenge.currency;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyApiApplication implements Runnable {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyApiApplication.class, args);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	Integer[] arreglo =	{1, 2, 8, 23, 5, 15, 17, 15};
		List<Integer> resultado = new ArrayList<Integer>();
		
			for (Integer integer : arreglo) {
				System.out.println(Math.floorDiv(integer, integer));  
			}	
	}

}
