package com.mytutorial.test;

public class AddOperation extends Operation {
	
	public AddOperation(int numOperands) {
		this.numOperand = numOperands;
		this.symbol = "+";
	}
	

	@Override
	public double function(Double...values) {
		if(values.length!=numOperand){
			System.out.println("Multiply Operation Shpuld have "+this.numOperand+ "operands");
		}
		double result = 0.0; 
		for(int i=0;i<this.numOperand;i++){
			result +=values[i].doubleValue();
		}
		return result;
	}

}
