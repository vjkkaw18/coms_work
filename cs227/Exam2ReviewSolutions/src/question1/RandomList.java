package question1;

import java.util.ArrayList;
import java.util.Random;

public class RandomList {

	public static void main(String[] args) {
		System.out.println(generateList());

	}

	public static ArrayList<Integer> generateList(){
		Random rand = new Random();
		ArrayList<Integer>list = new ArrayList <Integer>();
		
		while(true){
			int num = rand.nextInt(99) + 1;

			if(!list.contains(num)){

				list.add(num);
			}
			return list;
		}
	}
}
