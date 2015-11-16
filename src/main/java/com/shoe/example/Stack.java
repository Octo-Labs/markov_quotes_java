package com.shoe.example;

public class Stack {
    private java.util.Stack<Object> stack = new java.util.Stack<Object>();
    
    public void push(Object o) {
        stack.push(o);
    }

    public int size() {
        return stack.size();
    }

    public Object pop() {
        return stack.pop();
    }
}
