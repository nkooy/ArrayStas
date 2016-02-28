import java.util.Arrays;

public class ArrayStas {
	
	
	private static void randomArray(int[] arr1 ){
		
		for(int i = 0; i < arr1.length; i++){
			arr1[i]= (int)(Math.random()*100);
		}
		
		Arrays.sort(arr1);
		
	}
	private static void printGraphTwenty(int[] arr2){
		System.out.println(Arrays.toString(arr2));
		int lessThanTwenty = 0;
		int forty = 0;
		int sixty = 0;
		int eighty = 0;
		int hundred = 0;
		
		
		String Star1 = " 1-20: ";
		String Star2 = " 21-40: ";
		String Star3 = " 41-60: ";
		String Star4 = " 61-80: ";
		String Star5 = " 81-100: ";
				
		for (int index = 0; index < arr2.length; index++){
			
			if(arr2[index]<= 20){
				 lessThanTwenty+=1;
				 Star1 = Star1 +"*";
				 
			}
			else if (arr2[index] <= 40 && arr2[index]>20){
				forty+=1;
				Star2 = Star2 + "*";
				
			}
			else if (arr2[index] <=60 && arr2[index]>40){
				sixty+=1;
				Star3 = Star3 + "*";
				
			}
			else if (arr2[index] <=80 && arr2[index]>60){
				eighty +=1;
				Star4 = Star4 + "*";
			}
			else if (arr2[index] <=100 && arr2[index]>80){
				hundred += 1;
				Star5 = Star5 + "*";
				
			}
		}
		
		System.out.println(Star1 + " " +  lessThanTwenty);
		System.out.println(Star2 + " " + forty);
		System.out.println(Star3 + " " + sixty);
		System.out.println(Star4 + " " + eighty);
		System.out.println(Star5 + " " + hundred);
		
		
		
		
		
		
		
	}
	
	
	
	public static void main(String args[]){
		int[] rand = new int[300];
		randomArray(rand);
		printGraphTwenty(rand);
		
		
	}
}
