public class Pailie {
	 public static void main(String[] args) {
	        int[] ia = {1, 2, 3, 4, 5};
	        int n = 3;
	        System.out.println("排列结果 : ");
	        permutation("",ia, n);
	        System.out.println("组合结果 : ");
	        combination(ia, n);
	    }
	    public static void permutation(String s, int[] nums, int n) {
	        if(n == 1) {   //最后一层就输出，s是前面已经排好的
	            for(int i = 0; i < nums.length; i++) {
	                System.out.println(s + nums[i]);
	            }
	        } else {
	        	//确定选哪一个，用for循环在可供选择的里面选一个
	            for(int i = 0; i < nums.length; i++) {              
	                String ss = s + nums[i];
	                //建立没有第i个元素的子数组
	                int[] tempNums = new int[nums.length-1];
	                int index = 0;
	                for(int j = 0; j < nums.length; j++) {  //确定下一层可供选择的数
	                    if(j != i) {
	                    	tempNums[index++] = nums[j];
	                    }
	                }
	                permutation(ss, tempNums, n-1);
	            }
	        }
	    }
	    public static void combination(int[] ia, int n) {
	        combination("", ia, n);
	    }
	    public static void combination(String s, int[] nums, int n) {
	        if(n == 1) {
	            for(int i = 0; i < nums.length; i++) {
	                System.out.println(s+nums[i]);
	            }
	        } else {
	        	//比如{1,2,3,4,5}里面选3个，起始的那个最大的是3，不可能出现选4或5作为的起始的组合的
	        	//所以开始的for循环只到nums.length - n
	        	//而可供选择的也只有在nums[i]后面的，比如说起始的是3，那么可供选择的也就只有4,5了.
	            for(int i = 0; i < nums.length - n + 1; i++) {
	                String ss = s + nums[i];
	                //建立从i开始的子数组
	                int[] tempNums = new int[nums.length-i-1];
	                for(int j = 0; j < nums.length-i-1; j++) {
	                	tempNums[j] = nums[i+j+1];
	                }
	                combination(ss, tempNums, n-1);
	            }
	        }
	    }
}
