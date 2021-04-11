package genericVector;

public class GenericClass<TYPE> {
	private TYPE object;
	public GenericClass() {
		object = (TYPE) new Object();
	}
	
	public TYPE draw() {
//		error
//		object.getX();
		return this.object;
	}
}
