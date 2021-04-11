package polymorphism;

public class DTestMain {
	public void execute() {
		// overriding - polymorphism
		DShape shape = new DShape();
		shape.draw();
		
		//겉모양은 DShape 이지만 실체는 DRectangle
		shape = new DRectangle();
		shape.draw();
		
		//겉모양은 DShape 이지만 실체는 DEllipse
		shape = new DEllipse();
		shape.draw();
		
		// overloading = inheritance
		DRectangle rectangle;
		rectangle = new DRectangle();
		rectangle.draw();
		
		// Type Casting
		
		Object object = new DRectangle();
		rectangle = (DRectangle)object;
	}
}
