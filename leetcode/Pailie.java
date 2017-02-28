public class Pailie {
	 public static void main(String[] args) {
	        int[] ia = {1, 2, 3, 4, 5};
	        int n = 3;
	        System.out.println("���н�� : ");
	        permutation("",ia, n);
	        System.out.println("��Ͻ�� : ");
	        combination(ia, n);
	    }
	    public static void permutation(String s, int[] nums, int n) {
	        if(n == 1) {   //���һ��������s��ǰ���Ѿ��źõ�
	            for(int i = 0; i < nums.length; i++) {
	                System.out.println(s + nums[i]);
	            }
	        } else {
	        	//ȷ��ѡ��һ������forѭ���ڿɹ�ѡ�������ѡһ��
	            for(int i = 0; i < nums.length; i++) {              
	                String ss = s + nums[i];
	                //����û�е�i��Ԫ�ص�������
	                int[] tempNums = new int[nums.length-1];
	                int index = 0;
	                for(int j = 0; j < nums.length; j++) {  //ȷ����һ��ɹ�ѡ�����
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
	        	//����{1,2,3,4,5}����ѡ3������ʼ���Ǹ�������3�������ܳ���ѡ4��5��Ϊ����ʼ����ϵ�
	        	//���Կ�ʼ��forѭ��ֻ��nums.length - n
	        	//���ɹ�ѡ���Ҳֻ����nums[i]����ģ�����˵��ʼ����3����ô�ɹ�ѡ���Ҳ��ֻ��4,5��.
	            for(int i = 0; i < nums.length - n + 1; i++) {
	                String ss = s + nums[i];
	                //������i��ʼ��������
	                int[] tempNums = new int[nums.length-i-1];
	                for(int j = 0; j < nums.length-i-1; j++) {
	                	tempNums[j] = nums[i+j+1];
	                }
	                combination(ss, tempNums, n-1);
	            }
	        }
	    }
}
