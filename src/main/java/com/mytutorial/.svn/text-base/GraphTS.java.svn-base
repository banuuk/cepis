/**
 * 
 */
package com.mytutorial;

/**
 * @author keerthi
 * 
 */
class Vertex {
	public char label;

	public Vertex(char lab) {
		label = lab;
	}
}

/**
 * @author  keerthi
 */
public class GraphTS {
	private final int MAX_VERTS = 20;

	/**
	 * @uml.property  name="vertexList"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private Vertex vertexList[]; // list of vertices

	private int matrix[][]; // adjacency matrix

	private int numVerts; // current number of vertices

	private char sortedArray[];

	public GraphTS() {
		vertexList = new Vertex[MAX_VERTS];
		matrix = new int[MAX_VERTS][MAX_VERTS];
		numVerts = 0;
		for (int i = 0; i < MAX_VERTS; i++)
			for (int k = 0; k < MAX_VERTS; k++)
				matrix[i][k] = 0;
		sortedArray = new char[MAX_VERTS]; // sorted vert labels
	}

	public void addVertex(char lab) {
		vertexList[numVerts++] = new Vertex(lab);
	}

	public void addEdge(int start, int end) {
		matrix[start][end] = 1;
	}

	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}

	public void topo() // toplogical sort
	{
		int orig_nVerts = numVerts;

		while (numVerts > 0) // while vertices remain,
		{
			// get a vertex with no successors, or -1
			int currentVertex = noSuccessors();
			if (currentVertex == -1) // must be a cycle
			{
				System.out.println("ERROR: Graph has cycles");
				return;
			}
			// insert vertex label in sorted array (start at end)
			sortedArray[numVerts - 1] = vertexList[currentVertex].label;

			deleteVertex(currentVertex); // delete vertex
		}

		// vertices all gone; display sortedArray
		System.out.print("Topologically sorted order: ");
		for (int j = 0; j < orig_nVerts; j++)
			System.out.print(sortedArray[j]);
		System.out.println("");
	}

	public int noSuccessors() // returns vert with no successors (or -1 if no
	// such verts)
	{
		boolean isEdge; // edge from row to column in adjMat

		for (int row = 0; row < numVerts; row++) {
			isEdge = false; // check edges
			for (int col = 0; col < numVerts; col++) {
				if (matrix[row][col] > 0) // if edge to another,
				{
					isEdge = true;
					break; // this vertex has a successor try another
				}
			}
			if (!isEdge) // if no edges, has no successors
				return row;
		}
		return -1; // no
	}

	public void deleteVertex(int delVert) {
		if (delVert != numVerts - 1) // if not last vertex, delete from
		// vertexList
		{
			for (int j = delVert; j < numVerts - 1; j++)
				vertexList[j] = vertexList[j + 1];

			for (int row = delVert; row < numVerts - 1; row++)
				moveRowUp(row, numVerts);

			for (int col = delVert; col < numVerts - 1; col++)
				moveColLeft(col, numVerts - 1);
		}
		numVerts--; // one less vertex
	}

	private void moveRowUp(int row, int length) {
		for (int col = 0; col < length; col++)
			matrix[row][col] = matrix[row + 1][col];
	}

	private void moveColLeft(int col, int length) {
		for (int row = 0; row < length; row++)
			matrix[row][col] = matrix[row][col + 1];
	}

	public static void main(String[] args) {
		GraphTS g = new GraphTS();
		g.addVertex('A');//0
		g.addVertex('B');//1
		g.addVertex('C');//2
		g.addVertex('D');//3
		g.addVertex('E');//4
		g.addVertex('F');//5
		g.addVertex('G');//6
		g.addVertex('H');//7
		g.addVertex('I');//8
		g.addVertex('J');//9
		g.addVertex('K');//10
		g.addVertex('L');//11
		g.addVertex('M');//12
		g.addVertex('N');//13
		g.addVertex('O');//14
		g.addVertex('P');//15
		g.addVertex('Q');//16
		g.addVertex('R');//17
		g.addVertex('S');//18

		g.addEdge(0, 1); 
		g.addEdge(1, 18);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(2, 6);
		g.addEdge(6, 10);
		g.addEdge(10, 14);
		g.addEdge(3, 7);
		g.addEdge(7, 11);
		g.addEdge(11, 15);
		g.addEdge(4, 8);
		g.addEdge(8, 12);
		g.addEdge(12, 16);
		g.addEdge(5, 9);
		g.addEdge(9, 13);
		g.addEdge(13, 17);
		g.addEdge(6, 7);
		g.addEdge(7, 8);
		g.addEdge(8, 9);
		g.addEdge(10, 11);
		g.addEdge(11, 12);
		g.addEdge(12, 13);
		g.addEdge(14, 15);
		g.addEdge(15, 16);
		g.addEdge(16, 17);

		g.topo(); // do the sort
	}
}
