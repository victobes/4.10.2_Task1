import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		TreeMap<String, TreeMap<String, Integer>> buyers = new TreeMap<String, TreeMap<String, Integer>>();

		String s = new String();
		while (sc.hasNextLine()) {

			s = sc.nextLine();

			 if (s.isEmpty()) {
				 break;
			 }
			 
			String[] parts = s.split(" ");

			String name = parts[0];
			String product = parts[1];
			Integer count = Integer.parseInt(parts[2]);

			if (!buyers.containsKey(name))
				buyers.put(name, new TreeMap<String, Integer>());

			TreeMap<String, Integer> buyer = buyers.get(name);

			if (!buyer.containsKey(product))
				buyer.put(product, 0);

			Integer oldCount = buyer.get(product);

			buyer.put(product, oldCount + count);

			if (!sc.hasNext())
				break;
		}

		for (Map.Entry<String, TreeMap<String, Integer>> entry : buyers.entrySet()) {
			String key = entry.getKey();
			TreeMap<String, Integer> value = entry.getValue();
			System.out.println(key + ":");

			for (Entry<String, Integer> product : value.entrySet()) {
				String keyProduct = product.getKey();
				Integer valueProduct = product.getValue();

				System.out.println(keyProduct + " " + valueProduct);
			}
		}
	}

}
