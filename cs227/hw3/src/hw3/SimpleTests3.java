package hw3;

import java.io.FileNotFoundException;

import mini2.CS227Comp;

public class SimpleTests3 {

	public static void main(String[] args) throws FileNotFoundException
	{
//		int[] code = AsmFileUtil.createMemoryImageFromFile("test1.asm227");
//		CS227Comp comp = new CS227Comp(10);
//		comp.loadMemoryImage(code);
//		comp.runProgram();
//		System.out.println(code);
		
		int[] testing = AsmFileUtil.createMemoryImageFromFile("test1.asm227");
		for (int i = 0; i < testing.length; i++)
		{
			System.out.println(testing[i]);
		}
	}

}
