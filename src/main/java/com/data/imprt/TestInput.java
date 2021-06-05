package com.data.imprt;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Random;

public class TestInput {

	public static void main(String[] args) throws Exception {
		
		Random random=new Random();
		
		String file = "C:\\myjob\\Tools\\sts-4.10.0.RELEASE\\workspace\\data-import\\input\\input_12000.csv";
		Writer writer = null;
		try {
			writer = new OutputStreamWriter(new FileOutputStream(file));
			StringBuilder line = new StringBuilder("BookId,Author,Description,Isbn,Name,Price,Type");
			writer.write(line.toString() + "\n");
			for(int i=100;i<=12000000;i++) {
			
				double price = random.nextInt(90) * 1.00;
			
				line = new StringBuilder(i +",");
				line.append("Author_" + i +",");
				line.append("Description_" + i +",");
				line.append("Isbn_" + i +",");
				line.append("Name_" + i +",");
				line.append(price +",");
				line.append("Type_" + i);
				writer.write(line.toString() + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}

	}

}
