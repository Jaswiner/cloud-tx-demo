package com.jaswine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : Jaswine
 * @date : 2020-07-31 15:23
 **/
public class Oom {







	public static void main(String[] args) {


		List<String> list = new ArrayList<>();

		new Thread(()->{
			addChar(list);
		},"t1").start();


		new Thread(()->{
			addChar(list);
		},"t2").start();



	}



	private static synchronized void addChar(List<String> list){

		int a = 1024 << 1;
		char[] chars = new char[a];
		Arrays.fill(chars,'a');
		for (int i = 0; i < 100000; i++) {
			System.out.println(Thread.currentThread().getName());

			list.add(new String(chars));

		}
	}
}
