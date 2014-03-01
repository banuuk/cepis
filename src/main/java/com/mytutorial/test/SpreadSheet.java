package com.mytutorial.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * A spreadsheet consists of a two-dimensional array of cells, labeled A1, B1,
 * ...., A2, B2, .... Each cell contains either a number (its value) or an
 * expression.
 * 
 * <p>
 * For simplicity, expressions are given as RPN (reverse-polish notation). They
 * contain space-separated terms that are either numbers (in our case
 * non-negative values), cell references, and the operators '+', '-', '*', '/'.
 * </p>
 * Examples:
 * 
 * +----------------------+------------------+--------------+ 
 * | RPN 				  | infix notation 	 | evaluates to |
 * +----------------------+------------------+--------------+ 
 * | "10 4 /" 			  |"10/4" 			 | 2.5 			| 
 * +----------------------+------------------+--------------+ 
 * | "10 1 1 + / 1 +" 	  | "10/(1+1) + 1 	 | 6.0 			|
 * +----------------------+------------------+--------------+ 
 * | "10 2 3 + / 4 5 + *" | "10/(2+3)*(4+5)" | 18.0 		|
 * +----------------------+------------------+--------------+
 * 
 * <p>
 * <b>Main functionality:</b>
 * <li>1. constructor: construct the spreadsheet from the provided expressions.</li>
 * <li>2. dump(): solve the spreadsheet and return the result. If a cycle of
 * references exists, detect it and throw a CircularReferenceException.</li>
 * <li> 3. Add new operations in addition to +, -, *, / (OOP methodology).
 * <li> 4. Performs faster using Hashtable. </li>
 * <li> 5. Uses memoization principle. Evaluates expression only once. Whenever a value is 
 * computed for an expression, it will be updated in the hashtable to reflect the updated value,
 * so other expressions don't have to compute these values again.
 * </p>
 * 
 * <p>
 * <b>Time Complexity:</b>
 * The given program constructs a spreadsheet from the input values and nodes A1, B1, C1, .... 
 * It reads them and initializes the hashtable. Since  the insert operation takes just O(1). 
 * For 'V' nodes (nRows x nCols), initialization takes O(V) time. dump() function computes
 * the display value for each node. Since the dump() function uses the concept similar to 
 * Adjacency list and syntax/parse tree it take O(V+E) where E is the average number of 
 * sub-expression that need to be evaluated for each expression. Here E <<< V.
 * 
 * The best-case complexity of this program is <b>O(V)</b>.
 * The average-case complexity of this program is <b>O(V+E)</b>.
 * The worst-case complexity of this program is <b>O(2V)</b>.
 * 
 * <b>Space Complexity:</b>
 * The only space we use in this program is one hashtable which uses V spaces, one for 
 * each nodes.
 * 
 * The space complexity is <b>O(V)</b>.
 * </p>
 */
/**
 * @author keerthi
 *
 */
public class SpreadSheet {
	/**
	 * Construct a nRows x nCols SpreadSheet, with cells containing the
	 * expressions passed in the exprArray.
	 * 
	 * <p>
	 * The expressions passed in the exprArray String array are in row by row
	 * order, i.e.:
	 * 
	 * +----+----+----+ 
	 * | A1 | B1 | C1 | 
	 * +----+----+----+ 
	 * | A2 | B2 | C2 |
	 * +----+----+----+
	 * 
	 * etc.
	 * 
	 * @param nRows
	 * @param nCols
	 * @param exprArray
	 */
	
	private Hashtable<String, List<String>> expressionTable;
	private List<Operation> operations = new ArrayList<Operation>(0);
	private Set<String> circularity = new HashSet<String>(0);
	private int nRows;
	private int nCols;

	public SpreadSheet(int nRows, int nCols, String... exprArray) {
		int inputLength = exprArray.length;
		if (nRows * nCols != inputLength) {
			throw new InvalidException(
					"Invalid Parameters: Input dimensions and array does not match. Please check the input.");
		}
		this.nRows = nRows;
		this.nCols = nCols;
		int index = 0;
		
		// Create a hashtable
		expressionTable = new Hashtable<String, List<String>>(0);
		
		// Define Operations
		Operation add = new AddOperation(2);
		operations.add(add);
		Operation subtract = new SubtractOperation(2);
		operations.add(subtract);
		Operation multiply = new MultiplyOperation(2);
		operations.add(multiply);
		Operation division = new DivisionOperation(2);
		operations.add(division);
		Operation modulo = new ModuloOperation(2);
		operations.add(modulo);

		// Read Input Array
		String[] expr;
		String key;

		// Initialize Hashtable
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				List<String> values = new ArrayList<String>(0);
				index = nCols * i + j;
				key = (char) (65 + j) + ((i + 1) + "");
				expr = exprArray[index].split(" ");
				for (int k = 0; k < expr.length; k++) {
					values.add(expr[k]);
				}
				expressionTable.put(key, values);
			}
		}
	}

	/**
	 * @return the values from a "solved" SpreadSheet
	 */
	public Double[] dump() throws CircularReferenceException {
		String expr;
		int index;
		List<String> val = new ArrayList<String>(0);
		Double[] result = new Double[nRows * nCols];
		// Solve each expression
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				index = nCols * i + j;
				expr = (char) (65 + j) + ((i + 1) + "");
				circularity.clear();
				this.evalExpression(expr);
				if (expressionTable.containsKey(expr)) {
					val = expressionTable.get(expr);
					if (val.size() == 1)
						result[index] = new Double(val.get(0));
				}
			}
		}
		return result;
	}

	/**
	 * @param expr
	 * @return List with the solved value
	 */
	private List<String> evalExpression(String expr) {
		List<String> stack = new ArrayList<String>(0);
		int len = 0;
		Double result;
		Double[] values = new Double[2];
		Operation operation = null;
		String elem = "";
		if (!circularity.add(expr)) {
			throw new CircularReferenceException("Circular Exception");
		}
		if (expressionTable.containsKey(expr)) {
			//Get sub-expressions
			Iterator<String> iter = expressionTable.get(expr).iterator();
			// Evaluate each sub-expression (element)
			while (iter.hasNext()) {
				elem = iter.next();
				if (isExpression(elem)) {
					// Expression
					stack.addAll(this.evalExpression(elem));
					circularity.remove(elem);
				} else if (isDouble(elem)) {
					// Value
					stack.add(elem);
				} else {
					// Operator
					len = stack.size();
					if (isDouble(stack.get(len - 1))
							&& isDouble(stack.get(len - 2))) {
						operation = getOperation(elem);
						if (operation != null) {
							if (len - 2 < 0) {
								throw new InvalidException(
										"Invalid Postfix notation");
							}
							values[1] = new Double(stack.remove(len - 1));
							values[0] = new Double(stack.remove(len - 2));
							result = operation.function(values);
							stack.add(result + "");
						} else {
							throw new InvalidException(
									"No matching operation found for the operator "
											+ elem);
						}
					} else {
						stack.add(elem);
					}

				}
			}
			// Update the expressionTable
			// This reduces the unnecessary computation for each node. Memoization.
			if (stack.size() == 1) {
				if (isDouble(stack.get(0))) {
					expressionTable.put(expr, stack);
				}
			}
		} else {
			stack.add(expr);
			throw new InvalidException(
					"Invalid: Each cell should have either a value or an expression.");
		}
		return stack;
	}

	private boolean isDouble(String input) {
		if (input.matches("[0-9]+(\\.[0-9]+)?")) {
			return true;
		}
		return false;
	}

	private Operation getOperation(String input) {

		for (int i = 0; i < operations.size(); i++) {
			if (input.equals(operations.get(i).symbol)) {
				return operations.get(i);
			}
		}
		return null;
	}

	private boolean isExpression(String input) {
		if (input.matches("[A-Z][0-9]+")) {
			return true;
		}
		return false;
	}

	public class CircularReferenceException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public CircularReferenceException(String msg) {
			super(msg);
		}
	}

	public class InvalidException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public InvalidException(String msg) {
			super(msg);
		}
	}
}
