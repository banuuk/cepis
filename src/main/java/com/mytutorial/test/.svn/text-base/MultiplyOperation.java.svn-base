package com.mytutorial.test;

public class MultiplyOperation extends Operation {
	
	public MultiplyOperation(int numOperands) {
		this.numOperand = numOperands;
		this.symbol = "*";
	}
	

	@Override
	public double function(Double...values) {
		if(values.length!=numOperand){
			System.out.println("Multiply Operation Shpuld have "+this.numOperand+ "operands");
		}
		double result = 1.0; 
		for(int i=0;i<this.numOperand;i++){
			result *=values[i].doubleValue();
		}
		return result;
	}

}
