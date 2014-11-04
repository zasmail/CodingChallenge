import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;


public class GetAround {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		LinkedList <Long> nums = new LinkedList <Long>();
		LinkedList <String> ops = new LinkedList <String>();
		String expression = console.nextLine();
		long cur=0;
		int index=0;
		String remainder="";
		while (index<expression.length()){
			remainder= expression.substring(index, expression.length()-1);
			if (expression.charAt(index)=='*'){
				index++;
				int startIndex = index;
				while (index<expression.length() && Character.isDigit(expression.charAt(index))) {
					index++;
				}
				long nextUp= Long.valueOf(expression.substring(startIndex,index));
				cur=nums.pop()*nextUp;
				nums.push(cur);
			}
			else if (expression.charAt(index)=='/'){
				index++;
				int startIndex = index;
				while (index<expression.length() && Character.isDigit(expression.charAt(index))) {
					index++;
				}
				long nextUp= Long.valueOf(expression.substring(startIndex,index));
				cur=nums.pop()/nextUp;
				nums.push(cur);
			}
			else if (expression.charAt(index)=='+'){
				ops.push("+");
				index++;
			}
			else if (expression.charAt(index)=='-'){
				ops.push("-");
				index++;
			}
			else{
				int startIndex = index;
				while (index<expression.length() && Character.isDigit(expression.charAt(index))) {
					index++;
				}
				long nextUp= Long.valueOf(expression.substring(startIndex,index));
				//System.out.println(nextUp);
				nums.push(nextUp);
			}
			
		}
		int total=0;
		while (nums.size()>1){
			if (ops.peekLast()=="+"){
				ops.pollLast();
				nums.add(nums.pollLast()+nums.pollLast());
			}
			else if (ops.peekLast()=="-"){
				ops.pollLast();
				nums.add(nums.pollLast()-nums.pollLast());
			}
		}
		

		if (nums.peek()!=null)
			  System.out.println(nums.pollLast()); 
	}

}
