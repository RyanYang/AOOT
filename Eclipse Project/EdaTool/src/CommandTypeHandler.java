import java.util.*;

public class CommandTypeHandler {
	
	HashMap< String, Circuit > gateMap;
	HashMap< String, Line > lineMap;
	HashMap< String, String> lineInfo;
	HashMap< String, String> inputMap = new HashMap< String, String>();
	
	
	
	
	Circuit I1 ;
	Circuit I2 ;

	String[] inputCommand;
	String[] inputGate1;
	String[] inputGate2;
	String[] inputGate3;
	String[] inputGate4;
	
	String lastGate = " ";
	String lastLine = " ";
	String circuitId = " ";
	
	public CommandTypeHandler(){
		
	}
	
	public void CommandHandle(){
		if(inputCommand[0].equals("add")){
			if(inputCommand[1].equals("gate")){
				if(inputCommand[2].equals("AND")){					
					Circuit c1 = new AndDecorator();
					c1.setCircuitId(inputCommand[3]);
					c1.setInput1(I1);
					c1.setInput2(I2);
					gateMap.put(inputCommand[3], c1);
					System.out.println("one AND-gate called \"" + inputCommand[3] + "\" has been added to  circuit " + circuitId);
				}
				else if(inputCommand[2].equals("OR")){
					Circuit c1 = new OrDecorator();
					c1.setCircuitId(inputCommand[3]);
					c1.setInput1(I1);
					c1.setInput2(I2);
					gateMap.put(inputCommand[3], c1);
					System.out.println("one OR-gate called \"" + inputCommand[3] + "\" has been added to  circuit " + circuitId);

				}
				else if(inputCommand[2].equals("NAND")){
					Circuit c1 = new NAndDecorator();
					c1.setCircuitId(inputCommand[3]);
					c1.setInput1(I1);
					c1.setInput2(I2);
					gateMap.put(inputCommand[3], c1);
					System.out.println("one NAND-gate called \"" + inputCommand[3] + " \"has been added to  circuit " + circuitId);
				}
				else if(inputCommand[2].equals("NOR")){
					Circuit c1 = new NOrDecorator();
					c1.setCircuitId(inputCommand[3]);
					c1.setInput1(I1);
					c1.setInput2(I2);
					gateMap.put(inputCommand[3], c1);
					System.out.println("one NOR-gate called \"" + inputCommand[3] + "\" has been added to  circuit " + circuitId);
				}
				else if(inputCommand[2].equals("NOT")){
					Circuit c1 = new NotDecorator();
					c1.setCircuitId(inputCommand[3]);
					c1.setInput1(I1);
					gateMap.put(inputCommand[3], c1);
					System.out.println("one NOT-gate called \"" + inputCommand[3] + "\" has been added to  circuit " + circuitId);
				}
			}
			else{// add line
				
				
				//System.out.println("this is line add");
				
				String lineStringInfo;
				lineStringInfo = inputCommand[4]+" "+
								inputCommand[7]+"."+inputCommand[8];
				if(inputCommand[7].equals("output")){
					lineStringInfo = inputCommand[4]+" "+ inputCommand[7];
				}
				lineInfo.put(inputCommand[2], lineStringInfo);
				//System.out.println("Line "+inputCommand[2]+": "+lineInfo.get(inputCommand[2]));
				
				
				if(inputCommand[7].equals("output")){
					lastGate = inputCommand[4];
					lastLine = inputCommand[2];
					System.out.println("You have add a line called \"" + inputCommand[2] + "\" and its two ends are connected: ");
					System.out.println(inputCommand[2] + ".START" + ": the output 1 of gate \"" + inputCommand[4] + "\"");
					System.out.println(inputCommand[2] + ".END as output" );
				}else if(inputCommand[4].equals("input")){
					String inputToGate = inputCommand[7]+" "+inputCommand[8];
					//System.out.println(inputToGate);
					inputMap.put(inputCommand[2], inputToGate);
					System.out.println("You have add a line called \"" + inputCommand[2] + "\" and its two ends are connected: ");
					System.out.println(inputCommand[2] + ".START: as input");
					if(inputCommand[8].equals("i1")){
						System.out.println(inputCommand[2] + ".END: the input 1 of gate \"" + inputCommand[7] + "\""  );
					}else{
						System.out.println(inputCommand[2] + ".END: the input 2 of gate \"" + inputCommand[7] + "\""  );
					}
					
				}else if(!inputCommand[4].equals("input")){
					System.out.println("You have add a line called \"" + inputCommand[2] + "\" and its two ends are connected: ");
					System.out.println(inputCommand[2] + ".START: the output 1 of gate \"" + inputCommand[4] + "\"");
						if(inputCommand[8].equals("i1")){
							gateMap.get(inputCommand[7]).setInput1(gateMap.get(inputCommand[4]));
							System.out.println(inputCommand[2] + ".END: the input 1 of gate \"" + inputCommand[7] + "\""  );
						}
						else{
							gateMap.get(inputCommand[7]).setInput2(gateMap.get(inputCommand[4]));
							System.out.println(inputCommand[2] + ".END: the input 2 of gate \"" + inputCommand[7] + "\""  );
						}
				}
				
				
			}
		}
		
		else if(inputCommand[0].equals("list")){
			
			
			System.out.println("Gate information: ");
			System.out.println(gateMap.get(lastGate).getDescription());
			System.out.println("Line information: ");
			
			for(String key : lineInfo.keySet() ){
				System.out.println("Line " + key +": "+ lineInfo.get(key));
			}
		}
		
		else if(inputCommand[0].equals("evaluate")){
			String s1;
			String s2;
			String s3;
			String s4;
			
			System.out.println("this is evaluate");
			
			String whitchLine1 = inputCommand[1];
			Circuit i1 = new InitialGate();
			if(inputCommand[2].equals("1")){
				i1.setOutput(1);
			}else{
				i1.setOutput(0);
			}
			
			String whitchLine2 = inputCommand[3];
			Circuit i2 = new InitialGate();
			if(inputCommand[4].equals("1")){
				i2.setOutput(1);
			}else{
				i2.setOutput(0);
			}
			
			String whitchLine3 = inputCommand[5];
			Circuit i3 = new InitialGate();
			if(inputCommand[6].equals("1")){
				i3.setOutput(1);
			}else{
				i3.setOutput(0);
			}
			
			String whitchLine4 = inputCommand[7];
			Circuit i4 = new InitialGate();
			if(inputCommand[8].equals("1")){
				i4.setOutput(1);
			}else{
				i4.setOutput(0);
			}
			
			s1 = inputMap.get(whitchLine1);
			inputGate1 = s1.split(" ");
			if(inputGate1[1].equals("i1")){
				gateMap.get(inputGate1[0]).setInput1(i1);
			}else{
				gateMap.get(inputGate1[0]).setInput2(i1);
			}
			
			s2 = inputMap.get(whitchLine2);
			inputGate2 = s2.split(" ");
			if(inputGate2[1].equals("i1")){
				gateMap.get(inputGate2[0]).setInput1(i2);
			}else{
				gateMap.get(inputGate2[0]).setInput2(i2);
			}
			
			s3 = inputMap.get(whitchLine3);
			inputGate3 = s3.split(" ");
			if(inputGate3[1].equals("i1")){
				gateMap.get(inputGate3[0]).setInput1(i3);
			}else{
				gateMap.get(inputGate3[0]).setInput2(i3);
			}
			
			s4 = inputMap.get(whitchLine4);
			inputGate4 = s4.split(" ");
			if(inputGate4[1].equals("i1")){
				gateMap.get(inputGate4[0]).setInput1(i4);
			}else{
				gateMap.get(inputGate4[0]).setInput2(i4);
			}
			
			System.out.println("Circuit eda output are: \n" + lastLine + " = " + gateMap.get(lastGate).evaluate());
			
			
			
			
		}
		
	}
	
	public void setTokens(String[] inputCommand){
		this.inputCommand = inputCommand;
	}
	
	public void setMap(HashMap<String, Circuit> gateMap,HashMap< String, Line > lineMap,HashMap< String, String> lineInfo){
		this.gateMap = gateMap;
		this.lineMap = lineMap;
		this.lineInfo = lineInfo;
	}
	public void setInitialInput(Circuit I1, Circuit I2){
		this.I1 = I1;
		this.I2 = I2;
	}
	public void setCircuitId(String circuitId){
		this.circuitId = circuitId;
	}
	
	
}
