
public class CommandLine {
	public static void main(String[] args) {
		if(args.length==0) {
			System.out.println("There are No inputs available..");
		}else {
			System.out.println("I have received ---  ");
			for(String s:args) {
				System.out.println(s);
			}
		}
	}
}
