
public abstract class Circuit {
	
	Circuit circuitI1;
	Circuit circuitI2;
	
	int output;
	int input1;
	int input2;
	String description = " ";
	String circuitId = "";
	
	
	public abstract int evaluate();
	public String getDescription() {
		return description;
	}
	
	public void setInput1(Circuit circuitI1){
		this.circuitI1 = circuitI1;
	}
	
	public void setInput2(Circuit circuitI2){
		this.circuitI2 = circuitI2;
	}
	
	public void setOutput(int i1){
		this.output = i1;
	}
	
	public void setCircuitId(String cid){
		circuitId = cid;
	}
	
	public String getCircuitId(){
		return circuitId;
	}
	
}
