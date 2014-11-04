import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;


public class GetAround {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		LinkedList <Long> nums = new LinkedList <Long>();//List of integers in string an act as either a stack or a queue
		LinkedList <String> ops = new LinkedList <String>();//List of operations in order of given string
		String expression = console.nextLine();//Get the expression string from the user
		long cur=0;//operations with multiplication or division
		int index=0;//pointer in expression
		while (index<expression.length()){
			if (expression.charAt(index)=='*'){//handle multiplication
				index++;
				int startIndex = index;
				while (index<expression.length() && Character.isDigit(expression.charAt(index))) {
					index++;
				}
				long nextUp= Long.valueOf(expression.substring(startIndex,index));
				cur=nums.pop()*nextUp;
				nums.push(cur);//push operation back on stack
			}
			else if (expression.charAt(index)=='/'){//handle division
				index++;
				int startIndex = index;
				while (index<expression.length() && Character.isDigit(expression.charAt(index))) {
					index++;
				}
				long nextUp= Long.valueOf(expression.substring(startIndex,index));
				cur=nums.pop()/nextUp;
				nums.push(cur);//push operation back on stack
			}
			else if (expression.charAt(index)=='+'){//if addition just push to the stack and handle later
				ops.push("+");
				index++;
			}
			else if (expression.charAt(index)=='-'){//if subtraction just push to the stack and handle later
				ops.push("-");
				index++;
			}
			else{
				int startIndex = index;
				while (index<expression.length() && Character.isDigit(expression.charAt(index))) {
					index++;
				}
				long nextUp= Long.valueOf(expression.substring(startIndex,index));
				nums.push(nextUp);
			}
			
		}
		while (nums.size()>1){//handle remaining queues
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
