/*
 * Given a list with duplicate values find the first unique elements in it. 

for eg: BH BH F AL HJ AL HJ PK 
so answer is F
 */

package ws.abhis.amazonpreps.careercupqs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

public class FirstUniqueElementInList {
	public void solution(char[] elements) {
		// Used TreeMap to maintain order, hashmap may not maintain order
		NavigableMap<Character, Integer> tempContains = new TreeMap<Character, Integer>();
		for (int i = 0; i < elements.length; i++) {
			if (tempContains.containsKey(elements[i])) {
				int v = tempContains.get(elements[i]);
				v++;
				tempContains.put(elements[i], v);
			} else {
				tempContains.put(elements[i], 1);
			}
		}

		// Change order
		tempContains = tempContains.descendingMap();

		// Print the first element
		boolean flag = false;
		char result = 0;
		while (!flag) {
			Iterator it = tempContains.entrySet().iterator();
			while (it.hasNext()) {
				Entry pairs = (Entry) it.next();
				int f = (int) pairs.getValue();
				char f2 = (char) pairs.getKey();
				if (f == 1) {
					result = f2;
					flag = true;
				}
			}
		}

		System.out.println(result);
	}

	public static void main(String[] args) {
		FirstUniqueElementInList obj = new FirstUniqueElementInList();
		char[] elements = { 'B', 'H', 'B', 'H', 'F', 'A', 'L', 'H', 'J', 'A',
				'L', 'H', 'J', 'P', 'K' };
		obj.solution(elements);
	}
}
