package dataDriven_cmd_line;

public class JavaClassRunTimeParameterTest {

	public static void main(String[] args) {
		System.out.println(args.length);
		
		for(String var: args) {
			System.out.println(var);
		}
	}
}
