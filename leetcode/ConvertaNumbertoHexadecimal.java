
public class ConvertaNumbertoHexadecimal {

	public static void main(String[] args) {
		int a = -1;
		long b = a;
		System.out.println(toHex(-1));
	}
	
    public static String toHex(int num) {
    	StringBuilder sb = new StringBuilder();
        if(num < 0){
        	num = 0xffffffff - (Math.abs(num)-1);        	
        }
    	while(num != 0){
    		int temp = num%16;
    		char c = temp>9?(char)(temp-10+'a'):(char)(temp+'0');
    		sb.insert(0, c);
    		num = num>>4;
    	} 
        return sb.toString();
    }

}
