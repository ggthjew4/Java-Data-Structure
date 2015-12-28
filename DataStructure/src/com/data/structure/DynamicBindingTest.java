package com.data.structure;

public class DynamicBindingTest {

	private boolean ready = false;
	private int result = 0;
	private int number = 0;

	public void write() {
	   ready = true;
	   number = 2;
	   System.out.println("result1 = " + result);
	}

	public void read() {
	   if (ready) {
	       result = number * 3;
	   }
	   System.out.println("result = " + result);
	}

	private class ReadWriteThread extends  Thread {
	   private boolean flag;

	   public ReadWriteThread(boolean flag) {
	       this.flag = flag;
	   }

	   @Override
	   public void run() {
	       if (flag) {
	           write();
	       } else {
	           read();
	       }
	   }
	}

	public static void main(String[] args) {
		DynamicBindingTest test = new DynamicBindingTest();
	   test.new ReadWriteThread(true).start();
	   test.new ReadWriteThread(false).start();
	}

}
