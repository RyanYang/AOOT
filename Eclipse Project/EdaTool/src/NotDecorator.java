
public class NotDecorator extends GateTypeDecorator{
	public int evaluate(){
		output = circuitI1.evaluate();
		output = (output+1)%2;
		return output;
	}
	
	public String getDescription() {
		return circuitId + " NOT\n" + circuitI1.getDescription();
	}
}
