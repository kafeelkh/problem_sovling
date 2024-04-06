import java.util.*;


public class ValidatingBrackets{
 
 static boolean isValidExpression(String expression_str){
	Deque<Character> stack = new ArrayDeque<Character>();
	for (int i = 0; i < expression_str.length (); i++){
		char x = expression_str.charAt (i);
		if (x == '(' || x == '[' || x == '{'){
			stack.push(x);
			continue;
		  }
		if (stack.isEmpty())
		    return false;
		char check;
		switch (x){
		      case ')':
			           check = stack.pop();
			           if (check == '{' || check == '[')
			            return false;
			           break;
    		  case '}':
	            		check = stack.pop();
			            if (check == '(' || check == '[')
			            return false;
			            break;
			
		     case ']':
			            check = stack.pop();
			            if (check == '(' || check == '{')
			            return false;
			            break;
		    }
	      }
	return (stack.isEmpty());
}

public static void main(String[]args){
	Scanner myObj = new Scanner (System.in);
	String expression_str = myObj.nextLine ();	//taking input for validating brackets {}[]()

	if (isValidExpression(expression_str))
	  System.out.println ("Balanced ");
	else
	  System.out.println ("Not Balanced ");

  }
}
