package TopCoder;
/*
 * Problem Statement  
You are given three points in the plane. Currently, these points are the vertices of a triangle with side lengths a, b, and c meters.
You can pick any one of the three points and move it by at most 1 meter in any direction. The other two vertices remain in their places.
After you finish moving the point, you look at the triangle they now define. What is the largest possible area of this new triangle?
Definition
    
Class:
VertexMove
Method:
largestTriangleArea
Parameters:
int, int, int
Returns:
double
Method signature:
double largestTriangleArea(int a, int b, int c)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
256
Notes
-
Answers with an absolute or a relative error up to 1e-9 will be accepted.
Constraints
-
Each of a, b, c is an integer between 1 and 1000, inclusive.
-
It is guaranteed that the lengths a, b, c satisfy the triangle inequality.
 (I.e., the three lengths define a valid triangle with a positive area.)
Examples
0)  
3
4
5
Returns: 8.5
If we have a coordinate system in the plane, the three points may be located at
 (0, 0), (0, 3), and (4, 0). If this is the case, the optimal solution is to take
  the point (0, 0) and move it to (-0.6, -0.8). This is a move by exactly 1 meter
  , and it produces a triangle with the area 8.5 square meters.
1)
10
10
10
Returns: 48.30127018922193

2)
12
13
16
Returns: 84.68727078205352

This problem statement is the exclusive and proprietary property
of TopCoder, Inc. Any unauthorized use or reproduction of this 
information without the prior written consent of TopCoder, Inc.
is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 * 
 * */
public class Triangule {
	public static void main(String[] args) {
	}
}
