package AC_curiosity;

public class binarySystem {

	
	
	public static void main(String[] args) {
	
		//int b = binary_to_decimal("1011011001");
		//System.out.println(b);
		//String binary = decimal_to_binary(235);
		//System.out.println(binary);
		//int bits = range_number_bits(1000000);
		//System.out.print(bits);
		//String hexadecimal = decimal_to_hexadecimal(214);
		//System.out.print(hexadecimal);
		//String hex = binary_to_hex("1001011110110101");
		//System.out.print(hex);
		String bin = decimal_to_BCD(12);
		System.out.print(bin);
	}
	
	
	
	public static int binary_to_decimal(String binary){
		int decimal = 0;
		char [] number_binary = binary.toCharArray();
		for(int i = number_binary.length-1; i >= 0; i--) {
			int j = number_binary.length-1 - i;
			decimal += Math.pow(2,j)*Integer.valueOf(String.valueOf(number_binary[i]));
		}
		return decimal;
	}
	public static String decimal_to_binary(int decimal){
		String binary = "";
		while(decimal != 0) {
			int r = decimal%2;
			decimal = decimal/2;
			binary+=String.valueOf(r);
		}
		String bin = "";
		for(int i = binary.length() - 1; i >= 0 ; i--) {
			bin += binary.charAt(i);
		}
		return bin;
	}
	public static int range_number_bits(int number_max){
		int i = 0;
		double max = Math.pow(2,i);
		while( max < number_max) {
			max = Math.pow(2,i);
			i++;
		}
		return i-1;
	}
	public static String decimal_to_hexadecimal(int number) {
		
		String hexadecimal = "";
		while(number != 0) {
			int r = number%16;
			number = number/16;
			if (r >= 10) {
				char m = findLetter(r);
				hexadecimal += m;
			}else {
				hexadecimal += String.valueOf(r);
			}
			
		}
		String bin = "";
		for(int i = hexadecimal.length() - 1; i >= 0 ; i--) {
			bin += hexadecimal.charAt(i);
		}
		return bin;
	}
	public static char findLetter(int hex_n) {
		int hex[] = {'A','B','C','D','E','F'};
		for(int i = 0; i < hex.length; i++) {
			int j = i + 10;
			if(hex_n ==  j) {
				return (char) hex[i];
			}
		}
		return '-';
	}
	public static String binary_to_hex(String binary) {
		int r = binary.length() % 4;
		String hexadecimal = "";
		if (r == 0) {
			for(int i = 0; i <= binary.length() - 4; i += 4) {
				String m = binary.substring(i, i+4);
				int dec = binary_to_decimal(m);
				if (dec >= 10) {
					char hex_ = findLetter(dec);
					hexadecimal += hex_;
				}else {
					hexadecimal += String.valueOf(dec);
				}
			}
			return hexadecimal;
		}else {
			String bin = "";
			for(int i = 0; i < r; i++) {
				bin += '0';
			}
			binary = bin + binary;
			
			return binary_to_hex(binary);
		}
	}
	public static String decimal_to_BCD(int decimal) {
		String decimal_ = String.valueOf(decimal);
		String bcd = "";
		for(int i = 0 ; i < decimal_.length(); i++) {
			int digit = Integer.valueOf(decimal_.substring(i,i+1));
			String bin = decimal_to_binary(digit);
			int r = bin.length() % 4;
			if( r != 0 ) {
				if(r < 4) {
					r = 4-r;
				}
				String bin_ = "";
				for(int k = 0; k < r; k++) {
					bin_ += '0';
				}
				bcd += bin_ + bin +" ";
				
			}else {
				bcd += bin+ " ";
			}
		}
		return bcd;
	}
}








