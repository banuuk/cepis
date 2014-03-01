package com.mytutorial.test;

public class SubtractOperation extends Operation {
	
	public SubtractOperation(int numOperands) {
		this.numOperand = numOperands;
		this.symbol = "-";
	}
	

	@Override
	public double function(Double...values) {
		if(values.length!=numOperand){
			System.out.println("Subtract Operation Shpuld have "+this.numOperand+ "operands");
		}
		double result = values[0]; 
		for(int i=1;i<this.numOperand;i++){
			result -=values[i].doubleValue();
		}
		return result;
	}

}
