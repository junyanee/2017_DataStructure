package vector;

import java.lang.reflect.Array;

public class DVectorGeneric<TYPE_NAME> {
	// internal structure
	private TYPE_NAME aData[];
	private int size;

	// constructor
	public DVectorGeneric(Class<TYPE_NAME> clazz, int capacity) {
		// type casting, generic array creation
		aData = (TYPE_NAME[]) new Object[DConstant.VECTOR_SIZE];
		// aData = new TYPE_NAME[5];
		
		//object.method(parameter);
		
		this.size = 0;
	}
	// getters & setters
	public int getSize() {
		return size;
	}
	// CRUD (Create, Read, Update, Delete)
	public TYPE_NAME get(int index) throws Exception {
		// precondition
		if ((index >= this.size) && (index < 0)) {
			throw new Exception(this.getClass().getSimpleName() +
					":" + DConstant.EMSG_ARRAY_INDEX_OUT_OF_BOUNDS);
		}

		return this.aData[index];
	}

	// behavior
	public void add(TYPE_NAME data) throws Exception {
		if (this.size == aData.length) {
			//overflow
			throw new Exception(this.getClass().getSimpleName() + 
					":" + DConstant.EMSG_ARRAY_INDEX_OUT_OF_BOUNDS);
		}
		this.aData[this.size] = data;
		this.size++;

		// aData[i]=data;
		// i=i+1;
	}

	public TYPE_NAME remove() throws Exception {
		if (this.size <= 0) {
			throw new Exception(this.getClass().getSimpleName() + 
					":" + DConstant.EMSG_ARRAY_INDEX_OUT_OF_BOUNDS);
		}
		// aData[aData.length] = 0;
		TYPE_NAME returnValue = aData[size];
		this.size--;
		return returnValue;
	}

	public void add(int index, TYPE_NAME data) throws Exception {
		if (((index > this.size) || (index < 0)) || (this.size > (this.aData.length - 1))) {
			throw new Exception(this.getClass().getSimpleName() + 
					":" + DConstant.EMSG_ARRAY_INDEX_OUT_OF_BOUNDS);
		}
		// move elements
		for (int i = this.size - 1; i >= index; i--) {
			this.aData[i + 1] = this.aData[i];
		}
		this.aData[index] = data;
		this.size++;
	}

	public TYPE_NAME remove(int index) {
		TYPE_NAME returnValue = aData[size];
		if ((index >= this.size) || (index < 0)) {
			for (int i = index + 1; i <= size - 1; i++) {
				// data를 삭제하려는 index부터 리스트 안의 데이터를 한칸씩 앞으로 당김
				aData[i - 1] = aData[i];
			}
			size--;
		}
		return returnValue;
	}
}
