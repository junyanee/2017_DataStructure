package vector;

public class DTestMain {
	public static DVector dVector;

	public void execute() {

		try {
//			DVectorGeneric<Float> dVector = new DVectorGeneric<Float>;
			for (int i = 0; i < 10; i++) {
				dVector.add(i * 10);
			}
//			for ( int i = 0; i < dVector.getSize(); i++) {
//				System.out.println(dVector.get(i));
//			}
//			int size = dVector.getSize();
//			for (int i = 0; i < size; i++) {
//				dVector.remove();
//			}
			
			// data validation
			System.out.println("size:" + dVector.getSize());
			for ( int i = 0; i < dVector.getSize(); i++) {
				System.out.println(("index-" + i + " : " + dVector.get(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}