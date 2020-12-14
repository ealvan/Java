package TopCoder;

public class AtLeast {
/*
 * 
 Problem Statement
    
There are N cities, numbered from 0 to N-1. For each ordered pair of cities (u, v) you know the cost costs[u][v] of flying directly from u to v. Each such flight takes one day. Flight costs are not necessarily symmetric.
Suppose you are in city u and you want to get to city v. You would like to use this opportunity to obtain a frequent flyer status. In order to get the status, you have to travel on at least minDays consecutive days. What is the minimum total cost c(u, v) of a flight schedule that gets you from u to v in minDays or more days?
Return the sum of all N*N values c(u, v). Note that this includes trips that start and end in the same city.
Definition
    
Class:
AtLeastKDays
Method:
sumOfMinCosts
Parameters:
String[], int
Returns:
long
Method signature:
long sumOfMinCosts(String[] costs, int minDays)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
256
Notes
-
The diagonal of the array costs contains the character '-' denoting that staying in a city is not a valid form of traveling.
-
Digits in costs represent the corresponding numerical values. For example, if costs[4][7] = '3', the flight from 4 to 7 has cost 3.
Constraints
-
N will be between 2 and 50, inclusive.
-
costs will contain exactly N elements.
-
Each element of costs will contain exactly N characters.
-
For each u, costs[u][u] will be '-'.
-
Each other character in costs will be between '1' and '9', inclusive.
-
minDays will be between 1 and 10^9, inclusive.
Examples
0)

    
{"-12",
 "3-6",
 "45-"}
1
Returns: 34
We are traveling for at least one day.
For some pairs of cities the optimal solution is to take the direct flight and stop. These are c(0,1) = 1, c(0,2) = 2, c(1,0) = 3, c(2,0) = 4, and c(2,1) = 5.
If we have to start and end in the same city, we need to fly for at least two days. The optimal travel costs for these cases are c(0,0) = c(1,1) = 4 and c(2,2) = 6.
This leaves us with travel from 1 to 2. There is a direct flight that costs 6, but also a cheaper option: to fly from 1 to 0 and then from 0 to 2, paying only 3+2 = 5. Thus, c(1,2) = 5.
The returned value is the sum of all c(u,v): 4+1+2+3+4+5+4+5+6 = 34.
1)

    
{"-111111111",
 "1-11111111",
 "11-1111111",
 "111-111111",
 "1111-11111",
 "11111-1111",
 "111111-111",
 "1111111-11",
 "11111111-1",
 "111111111-"}
1000000000
Returns: 100000000000
For each of the 10*10 pairs of vertices we can get from u to v in exactly 10^9 days while paying 1 for each ticket. Thus, each c(u, v) is 10^9 and therefore the final answer is 10^11.
2)

    
{"-12",
 "3-6",
 "45-"}
6
Returns: 122
The same costs as in example 0, but now we are traveling for at least 6 days.
One of the things worth noting is that c(0,1) = 13. The optimal way of traveling from 0 to 1 in at least 6 days is to travel in 7 days, alternating between cities 0 and 1 the whole time.
Another thing worth noting is that c(0,2) = 14. Again, optimal travel involves seven days, in which we travel as follows: 0-1-0-1-0-1-0-2.
 
 
 * 
 * 
 * 
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
