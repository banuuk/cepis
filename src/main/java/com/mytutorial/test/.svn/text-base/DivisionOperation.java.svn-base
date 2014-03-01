package com.mytutorial.test;

public class DivisionOperation extends Operation {
	
	public DivisionOperation(int numOperands) {
		this.numOperand = numOperands;
		this.symbol = "/";
	}
	

	@Override
	public double function(Double...values) {
		if(values.length!=numOperand){
			System.out.println("Division Operation Should have "+this.numOperand+ "operands");
		}
		double result = values[0]; 
		for(int i=1;i<this.numOperand;i++){
			if(values[i].doubleValue()==0){
				throw new ArithmeticException();
			}
			result /=values[i].doubleValue();
		}
		return result;
	}

}
