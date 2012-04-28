
public class AndDecorator extends GateTypeDecorator{
	
	public AndDecorator(){
		
	}
	
	public int evaluate(){
		output = circuitI1.evaluate() & circuitI2.evaluate();
		return output;
	}
	
	public String getDescription() {
		return circuitId + " AND\n" + circuitI1.getDescription() 
				+ circuitI2.getDescription();
		
	}
	
	
	
}
