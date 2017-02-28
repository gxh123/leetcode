import java.util.*;


public class BinaryWatch {

	public static void main(String[] args) {
		
		readBinaryWatch(4);
	}
	
    public static List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        int[] nums = new int[]{8,4,2,1};
        combination(list, new ArrayList<Integer>(), nums, num);
        return list;
    }
    
    public static void combination(List<String> list, 
    		List<Integer> done, int[] nums, int num){
    	if(num == 1){
    		
    		int[] temp = new int[done.size()+1];
			for(int j =0; j<done.size(); j++){
				temp[j] = done.get(j);
			}
    		for(int i =0; i<nums.length; i++){
    			temp[done.size()] = nums[i];
    			int seperator = 0;
    			while(temp[seperator]<=6){
    				seperator++;
    			}
    			int hour = 0;
    			
    		}
    		
    	}else{
    		for(int i = 0; i< nums.length - num + 1; i++){
    			List<Integer> temp = new ArrayList<>(done);
    			temp.add(nums[i]);
    			int[] tempNums = new int[nums.length - i - 1];
    			for(int j = 0; j<nums.length - i - 1; j++){
    				tempNums[j] = nums[i + j + 1];
    			}
    			combination(list,temp,tempNums, num-1);    			
    		}
    		
    		
    	}
    	
    	
    	
    }

}
