package com.mycompany.app;

public class Calculator {
    public int calModulus(int x, int y) throws ArithmeticException{
        if(y == 0){
            throw new ArithmeticException("zero modulus");
        }
        return x%y;
    }

    public double calDivision(int x, int y) throws ArithmeticException{
        if(y == 0){
            throw new ArithmeticException("zero division"); 
        }
        return (double)x/y;
    }
    
    public int calMultiplication(int x, int y){
        return x*y;
    }
    
    public int calSubtraction(int x, int y){
        return x-y;
    }

    public int calAddition(int x, int y){
        return x+y;
    }
}
