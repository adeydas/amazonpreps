package ws.abhis.amazonpreps.careercupqs;

public class DecimalNumberToBinary {
	public void convertToBinary(int decimalNumber, char endian) { // b=big
																	// endian,
																	// l=little
																	// endian
		int[] binary = new int[25];
		int index = 0;
		while (decimalNumber > 0) {
			binary[index++] = decimalNumber % 2;
			decimalNumber = decimalNumber / 2;
		}

		if (endian == 'b') {
			// MSB in lowest address space
			for (int i = 0; i < index; i++) {
				System.out.println(binary[i]);
			}
		} else {
			// MSB in highest address space
			for (int i = index - 1; i >= 0; i--) {
				System.out.println(binary[i]);
			}
		}

	}

	public static void main(String[] args) {
		DecimalNumberToBinary obj = new DecimalNumberToBinary();
		obj.convertToBinary(25, 'b');
		obj.convertToBinary(25, 'l');
	}
}
