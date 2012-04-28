
public class OrDecorator extends GateTypeDecorator{

	public int evaluate(){
		output = circuitI1.evaluate() | circuitI2.evaluate();
		return output;
	}
	
	public String getDescription() {
		return circuitId + " OR\n"+ circuitI1.getDescription() 
				+ circuitI2.getDescription();
	}
}
