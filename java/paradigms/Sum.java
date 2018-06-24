public class Sum {

	
	
	public static void main(String[] args) {
		int ans = 0;
		                                        
		for(int i = 0; i < args.length; i++) {
			String[] s = args[i].split("\\p{javaWhitespace}");
			
			for(int j = 0; j < s.length; j++) {
				if(!s[j].equals("") ) 
                               		ans += Integer.parseInt(s[j]);

			}
			
		}
		System.out.print(ans);                
		                                        
	                                               
	}


}
