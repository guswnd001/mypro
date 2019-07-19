package com.hyeon.day_36.pm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class NonSerializableParentExample {

	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("c:/tmp/Object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Child child = new Child();
		child.field1 = "김현중";
		child.field2 = "김첨지";
		
		oos.writeObject(child);
		oos.flush();
		oos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("c:/tmp/Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Child v = (Child)ois.readObject();
		System.out.println("field1: " + v.field1);
		System.out.println("field2: " + v.field2);
		
		ois.close();
		fis.close();
	}

}
