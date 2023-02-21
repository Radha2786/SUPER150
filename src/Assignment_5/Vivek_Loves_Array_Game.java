package Assignment_5;

import java.util.Scanner;

/*
Vivek loves to play with array . One day Vivek just came up with a new array game which was introduced to him by
his friend Ujjwal. The rules of the game are as follows:

Initially, there is an array, A , containing 'N' integers.

In each move, Vivek must divide the array into  two non-empty contiguous parts such that the sum of the elements
in the left part is equal  to the sum of the elements in the right part. If Vivek can make such a move, he gets '1'
point; otherwise, the game ends.

After each successful move, Vivek have to discards either the left part or the right part and continues playing by
using
the remaining partition as array 'A'.

Vivek loves this game and wants your help getting the best score possible. Given 'A', can you find and print the
maximum number of points he can score?

Input Format
First line of input contains an integer T denoting number of test cases. Each further Test case contains first line
an integer 'N' , the size of array 'A'. After that 'N' space separated integers denoting the elements of array.

Constraints
1 <= T <= 10 1 <= N <= 17000 0 <= A[i] <= 10^9

Output Format
For each test case, print Vivek's maximum possible score on a new line.

Sample Input
3
3
3 3 3
4
2 2 2 2
7
4 1 0 1 1 0 1
Sample Output
0
2
3
*/
public class Vivek_Loves_Array_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while(test-- >0){

            int n = sc.nextInt();
            int arr[]=new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int brr[] = new int [n+1];

            brr[0] = 0;

            for (int j = 1; j <= n; j++){
                brr[j] = brr[j-1] + arr[j-1];
            }

            System.out.println(ArrGame(arr, brr, 0, n-1));
        }
    }

    public static int ArrGame(int []arr,int []brr,int st,int end){

        if (st >= end) {
            return 0;
        }

        if ((st + 1) == end){
            if (arr[st] == arr[end]){
                return 1;
            }
            else {
                return 0;
            }

        }

        int max = 0;
        for (int i = st; i < end;i++){
            if ((brr[i+1] - brr[st]) == (brr[end+1] - brr[i+1])){

                int ans = (Math.max(ArrGame(arr, brr, st, i),ArrGame(arr, brr, i+1, end))) + 1;
                max = Math.max(max,ans);
                break;
            }
        }
        return max;
    }
}
