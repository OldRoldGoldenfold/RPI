import tree.*;
import atcs.*;

public class RandomListGenerator {
	BinaryTree b;
	KeyValuePair[] array;

	public BinaryTree getTree() {
		return b;
	}

	public KeyValuePair[] getArray() {
		return array;
	}

	public RandomListGenerator(int size) {

		ATCSArray a = new ATCSArray(size);
		array = a.getArray();
		b = new BinaryTree();

		for (KeyValuePair k : array) {
			b.add(k);
		}

	}

	public long test(int searches) {

		for (int i = 0; i < searches; i++) {
			b.find(array[(int) (Math.random() * array.length)]);
		}

		return b.getFC();
	}

	public static void main(String[] args) {
		int MAXSIZE = 2000000;
		int listSize = 32;
		int searchTime = 512;
		double scale = 1;
		boolean verbose = false;
		int attempts = 1;

		for (int i = 0; i < args.length; i++) {
			
			switch (args[i]) {
			case "-s":
				listSize = Integer.parseInt(args[++i]);
				break;
			case "-l":
				searchTime = Integer.parseInt(args[++i]);
				break;
			case "-v":
				verbose = true;
				break;
			case "-a":
				attempts = Integer.parseInt(args[++i]);
				break;
			case "-p":
				scale = Double.parseDouble(args[++i]);
			default:
				break;
			}
		}
		RandomListGenerator g;
		g = null;
		for (int i = 0; i < attempts; i++) {
			if (g == null || listSize != 1) {
				g = new RandomListGenerator(listSize);
			}
			g.test(searchTime);
			BinaryTree b = g.getTree();

			if (verbose) {
				System.out.println(searchTime + " random searches of list["
						+ listSize + "]");
				System.out.println(b.getAC()
						+ " Comparisons made while adding items");
				System.out.println(b.getFC()
						+ " Comparisons made while searching");
				System.out.println(b.getFC() / searchTime
						+ " Comparisons per search");
			} else {
				 System.out.println(b.getFC());
			}
			b.resetComparisons();
			listSize = (int) (listSize * scale);
		
			if (listSize > MAXSIZE){
				break;
			}
		}
	}
}
