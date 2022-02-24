// Queue with two stacks. Implement a queue with two stacks so that each queue operations takes a
// constant amortized number of stack operations. Hint: If you push elements onto a stack and then 
// pop them all, they appear in reverse order. If you repeat this process, they're now back in order.
import java.io.*;
import java.util.*;

class Queue {
      Stack<Integer> st1=new Stack<Integer>();
      Stack<Integer> st2=new Stack<Integer>();
      int i=0;
    public Queue() {
       

    }

    // Push element x to the back of queue.
    public void enqueue(int x) {
        while (!st1.isEmpty())
        {
            st2.push(st1.pop());
            
        }
        st1.push(x);
 
        
        while (!st2.isEmpty())
        {
            st1.push(st2.pop());
            
        }

    }

    // Removes the element from in front of queue.
    public int dequeue() {
        return st1.pop();

    }
    
    // Get the front element.
    public int peek() {
        if(!st2.isEmpty()){
            
            return st2.peek();
        }
        else {
           while(st2.isEmpty())
           st2.push(st1.pop()); 
        }
        return st2.peek();
    }
    
    // Return whether the queue is empty.
    public boolean empty() {
        return st1.isEmpty()&&st2.isEmpty();

    }

    // Return the number of elements in queue.
    public int size() {
        return st1.size()+st2.size();

    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue queue = new Queue();
        int queries = Integer.parseInt(scan.nextLine());
        for(int i = 0; i < queries; i++) {
            String input = scan.nextLine();
            if (input.charAt(0) == '1') {
                String[] tokens = input.split(" ");
                queue.enqueue(Integer.parseInt(tokens[1]));
            } else if (input.charAt(0) == '2') {
                System.out.println(queue.dequeue());
            } else if (input.charAt(0) == '3') {
                System.out.println(queue.peek());

            } 
            else if (input.charAt(0) == '4') {
                System.out.println(queue.size());
        }
    }
}
}