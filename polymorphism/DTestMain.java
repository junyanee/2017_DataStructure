package polymorphism;

public class DTestMain {
	public void execute() {
		// overriding - polymorphism
		DShape shape = new DShape();
		shape.draw();
		
		//�Ѹ���� DShape ������ ��ü�� DRectangle
		shape = new DRectangle();
		shape.draw();
		
		//�Ѹ���� DShape ������ ��ü�� DEllipse
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
