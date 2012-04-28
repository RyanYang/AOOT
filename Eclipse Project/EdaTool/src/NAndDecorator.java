
public class NAndDecorator extends GateTypeDecorator {
	public int evaluate(){
		output = circuitI1.evaluate() & circuitI2.evaluate();
		output = (output+1)%2;
		return output;
	}
	
	public String getDescription() {
		return circuitId + " NAND\n" + circuitI1.getDescription() 
				+ circuitI2.getDescription();
	}
}
