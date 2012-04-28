import java.util.*;
public class EdaTool {
	
	public static void main(String args[]){
		
		HashMap<String, Circuit> gateMap = new HashMap<String, Circuit>();
		HashMap<String, Line> lineMap = new HashMap<String, Line>();
		HashMap<String, String> lineInfo = new HashMap<String, String>();
		Circuit I1 = new InitialGate();
		Circuit I2 = new InitialGate();
		
		String intro = "Welcome to NCUEDA, we are waiting for your command.";
		System.out.println(intro);
		
		
		CommandTypeHandler cmdler = new CommandTypeHandler();
		InputHandler user= new InputHandler(cmdler);
		
		cmdler.setMap(gateMap, lineMap, lineInfo);
		cmdler.setInitialInput(I1, I2);
		
		user.setIsUsing(true);
		while(user.isUsing){
		user.startUsing();
		//System.out.println(user.isUsing);
		}
		
		
	
	
	}
}
