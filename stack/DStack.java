package stack;

public class DStack<ELEMENT_TYPE> {
	public final static int MAXSIZE = 20;

	private ELEMENT_TYPE elements[];
	private int top; //stack top : 어디까지 데이터가 차있는가 (젤 위쪽)
	public DStack() {
		this.elements = (ELEMENT_TYPE[])new Object[MAXSIZE];
		this.top = 0;
	}
	public void push(ELEMENT_TYPE element) throws Exception {
		if (this.top < MAXSIZE) {
			this.elements[this.top] = element;
			this.top++;
		} else {
			throw new Exception("Stack Overflow" + this.top);
		}
	}

	public ELEMENT_TYPE pop() throws Exception {
		if (this.top > 0) {
		this.top--;
		ELEMENT_TYPE element = this.elements[this.top];
		return element;
	} else {
		throw new Exception("Stack Empty");
	}
	}

}
