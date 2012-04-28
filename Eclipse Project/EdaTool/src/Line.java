
public class Line {
	
	String lineId;
	int start;
	int end;
	
	public Line(){
		
	}
	
	public void setId(String id){
		this.lineId = id;
	}
	
	public void setStart(int start){
		this.start = start;
		this.setEnd(start);
	}
	
	private void setEnd(int end){
		this.end = end;
	}
	
}
