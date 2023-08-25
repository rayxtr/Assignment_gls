
public class DecimalToBinary {
public static void main(String[] args) {
	
	String num = "12345";
	String binary = convertintoBinary(num);
	System.out.println(binary);
	
}
public static String convertintoBinary(String str) {
	
	int num = Integer.parseInt(str);
	
	String binary = "";
	
		while(num>0) {
			
			int rem = num%2;
			binary = rem+binary;
			num/=2;	
		}
		
		return binary;
	
}
}
