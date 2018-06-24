public class BinarySearchSpan {

    public static void main(String[] args) {

        int x = Integer.parseInt(args[0]);
        int[] a = new int[args.length-1];

        for (int i = 1; i<args.length; i++) {
            a[i - 1] = Integer.parseInt(args[i]);
        }

        int start = startBinarySearch(x, a);
		
        
		System.out.print(start);
		
		if(a.length == 0 || (start == 0 && a[start] != x) || start == a.length || a[start] != x) {
			System.out.print(" 0");
		 	return;	
		}

		                       
		System.out.print(" ");
		System.out.print(finishBinarySearch(x, a) - start + 1);
		                                       	
    }                                                                                            


    //pre: 0 < i < a.length : a[i-1] >= a[i] && a.length >= 0
	//post: (0 < R < a.length && a.length > 2 && a[R] >= x && a[R-1]>x) ) || (a.length > 0 && R == a.length && a[a.length-1] > x) || (R == 0 && (a.length == 0 || (a.length != 0 && a[0] <= x) ) )
    private static int startBinarySearch(int x, int[] a) {
        //pre: a.length ==  0
		if (a.length == 0) return 0;
	    //post: R = 0

		int l = 0;
        int r = a.length;

 
        while (l < r) {
            //inv: 0 <= l <= R <= r <= a.length && l < r

			//pre: 0 <= l < r <= a.length		
			int m = (l + r) / 2;
			//post: 0 <= l <= m < r <= a.length && r-l+1 >= (r-m)*2 && r-l+1 >= (m-l+1)*2 
			
			//pre: (a[R] < a[m] && m+1 <= R <= r) || (a[R] >= a[m] && l <= R <= m)
            if (x < a[m]) {
				//pre: (a[R] < a[m] && m+1 <= R <= r)                           
                l = m + 1;
				//post: l <= R <= r
            } else{  
				//pre: (a[R] >= a[m] && l <= R <= m)     
                r = m;
				//post: l <= R <= r
            }
			//post: 0 <= l <= m <= r <= a.length
        }
		//post: l == r == R
        return l;
    }                                       


	//pre: 0 < i < a.length : a[i-1] >= a[i] && a.length >= 0
	//post: (0 <= R < a.length-1 && a.length > 2 && a[R] <= x && (a[R+1]<x || R == a.length-1)) ) || (a.length > 0 && R == a.length && a[a.length-1] > x) || (R == 0 && (a.length == 0 || (a.length != 0 && a[0] < x) ) )
	private static int finishBinarySearch(int x, int[] a) {
        //pre: a.length == 0 || a.length > 0
		if(a.length == 0) {
			//pre: a.length == 0
			return 0;
			//post: R = 0
		}
		if (a[a.length-1] > x) {
			//pre: a.length-1 > x
			return a.length;
			//post: R = a.length 
		} 


		//pre: 0 < i < a.length : a[i-1] >= a[i] && a.length > 0 && a[a.length-1] <= x && R < a.length 
		return finishBinarySearch(x, a, 0, a.length-1);
    	//post: (0 <= R < a.length-1 && a.length > 2 && a[R] <= x && (a[R+1]<x || R == a.length-1)) ) || (R == 0 && a.length != 0 && a[0] < x ) 
	}

	
	//pre: 0 < i < a.length : a[i-1] >= a[i] && a.length > 0 && a[a.length-1] <= x && R < a.length && 0 <= l <= R <= r < a.length
    //post: (0 <= R < a.length-1 && a.length > 2 && a[R] <= x && (a[R+1]<x || R == a.length-1)) ) || (R == 0 && a.length != 0 && a[0] < x )
	private static int finishBinarySearch(int x, int[] a, int l, int r) {
         
		if(l == r) {
			//pre: l == r
			return l;
			//post R = l
		}	

		//pre: 0 <= l < r < a.length
        int m = (l+r) / 2 + (l + r) % 2;
        //post: 0 <= l <= m < r <= a.length && r-l+1 >= (r-m+1)*2 && r-l+1 >= (m-l)*2
		
		//pre: (x <= a[m] && m <= R <= r) || (x > a[m] && l <= R <= m-1)
		if (x <= a[m] ) {		

			//pre: x <= a[m] && m <= R <= r && 0 < i < a.length : a[i-1] >= a[i] && a.length > 0 && a[a.length-1] <= x && R < a.length && 0 <= m <= R <= r < a.length 
            return finishBinarySearch(x, a, m, r);
            //post: (m <= R <= r && a.length > 2 && a[R] <= x && (a[R+1]<x || R == a.length-1)) ) || (R == 0 && a.length != 0 && a[0] < x )
		}
	    //pre: x > a[m] && l <= R <= m  && 0 < i < a.length : a[i-1] >= a[i] && a.length > 0 && a[a.length-1] <= x && R < a.length && 0 <= l <= R <= m-1 < a.length
        return finishBinarySearch(x, a, l, m-1);
		////post: (l <= R <= m-1 && a.length > 2 && a[R] <= x && (a[R+1]<x || R == a.length-1)) ) || (R == 0 && a.length != 0 && a[0] < x )
    }



}
