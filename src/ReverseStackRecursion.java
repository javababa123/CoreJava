import java.util.Stack;

public class ReverseStackRecursion {

	  // using Stack class for
    // stack implementation
  
	public static void main(String[] args) {
		   // push elements into
        // the stack
		 Stack<Character> st = new Stack<>();
		  
		st.push('1');
        st.push('2');
        st.push('3');
        st.push('4');
         
        System.out.println("Original Stack");
         
        System.out.println(st);
         
        // function to reverse 
        // the stack
        
         
        System.out.println("Reversed Stack");
         
        System.out.println(reverse(st));
        
	}
	
	public static Stack<Character> reverse(Stack<Character> st)
	{
	
		if(st.size()>0)
		{
		
		Character c=st.pop();
	
		st =reverse(st);
		appendData(st,c);
		
		}
		return st;
		
	}
	
	public static Stack<Character> appendData(Stack<Character> st,Character x)
	{
		
		if(st.isEmpty())
		{
			st.push(x);	
		return st;
		}
		
			Character temp =st.pop();
			appendData(st,x);		
			st.add(temp);
			return st;
	}

}
