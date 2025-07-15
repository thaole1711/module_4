package com.example.caculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService{
    @Override
    public double calculate(String first, String second, String operator) {
        try{
            double fistParse=Double.parseDouble(first);
            double secondParse=Double.parseDouble(second);
            double result;
            switch (operator){
                case "+":
                    result=fistParse+secondParse;
                    break;
                case "-":
                    result=fistParse-secondParse;
                    break;
                case "*":
                    result=fistParse*secondParse;
                    break;
                case "/":
                    if(secondParse==0){
                        throw new ArithmeticException();
                    }
                    result=fistParse/secondParse;
                    break;
                default:
                    throw new IllegalArgumentException();

            }
            return result;
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
}
