import java.io.*;
public class InputHandler {
	
	boolean isUsing;
	String temp;
	InputStreamReader   stdin   =   new   InputStreamReader(System.in);//��L��J  
    BufferedReader   bufin   =   new   BufferedReader(stdin); 
    CommandTypeHandler cmdler;
    String circuitId = " ";
    String[] inputCommand;
    
    public InputHandler(CommandTypeHandler cmdler){
    	this.cmdler = cmdler;
    }
    
    public void startUsing(){
    	 try  
         {  
         System.out.print   (circuitId + "> ");  
         temp = bufin.readLine();  
         stringTokenize(temp);
         //System.out.println   ("�A��J���r�Ŭ��G   "+temp);  
         }  
         catch(IOException   E)  
         {  
               System.out.println("�o��I/O���~!!!");  
         }  
    }
    
    public boolean getIsUsing(){
    	return isUsing;
    }
    
    public void setIsUsing(boolean isUsing){
    	this.isUsing = isUsing;
    }
    
    private void stringTokenize(String inputString){
    	
    	
    	inputCommand = inputString.split(" ");
    	
    	if(inputCommand[0].equals("quit")){
    		System.out.println("Bye! Thank you for using NCUEDA 1.0!");
    		this.isUsing = false;
    		//System.out.println(this.isUsing);
    	}else if(inputCommand[0].equals("create")){
    		circuitId = inputCommand[2];
    		System.out.println("An empty circuit called \"" + circuitId + "\" has been created !");
    		System.out.println("Any commands you do are toward to " + circuitId);
    	}else if(inputCommand[0].equals("delete")){
    		circuitId = " ";
    		System.out.println("Your circuit eda is deleted.");
    	}
    	else{
    		cmdler.setTokens(inputCommand);
    		cmdler.setCircuitId(circuitId);
    		cmdler.CommandHandle();
    	}
    }
    
}
