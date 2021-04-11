package vector;

public class DVector {
	// internal structure
	private int size;
	private int aData[];
	

	// constructor
	public DVector() {
		this.aData = new int[DConstant.VECTOR_SIZE];
		this.size = 0;
	}
	// getters & setters
	public int getSize() {
		return size;
	}
	// CRUD (Create, Read, Update, Delete)
	public int get(int index) throws Exception {
		// precondition
		if ((index >= this.size) && (index < 0)) {
			throw new Exception(this.getClass().getSimpleName() +
					":" + DConstant.EMSG_ARRAY_INDEX_OUT_OF_BOUNDS);
		}

		return this.aData[index];
	}

	// behavior
	public void add(int data) throws Exception {
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

	public int remove() throws Exception {
		if (this.size <= 0) {
			throw new Exception(this.getClass().getSimpleName() + 
					":" + DConstant.EMSG_ARRAY_INDEX_OUT_OF_BOUNDS);
		}
		// aData[aData.length] = 0;
		int returnValue = aData[size];
		this.size--;
		return returnValue;
	}

	public void add(int index, int data) throws Exception {
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

	public Object remove(int index) {
		int returnValue = aData[size];
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
