
public class BowlingGame {

	int ans=0;
	int getC(char x)
	{
		if(x>='1'&&x<='9')
			return x-'0';
		else if(x=='-')
			return 0;
		else if(x=='X')
			return 10;
		else if(x=='/')
			return -1;
		return 0;
	}
    public int getBowlingScore(String bowlingCode) {
    	int count=1;
    	for(int i=0;i<bowlingCode.length()&&count<11;i++)
    	{
    		char b=bowlingCode.charAt(i);
    		if(b=='|'){
    			if(count<=10) count++;
    			continue;}//
    		else if(b=='X') 
    		{	
    			ans+=10;
				if(count!=10&&count!=9)
				{
					char c=bowlingCode.charAt(i+2);
					ans+=getC(c);
					if(getC(c)==10)
						ans+=getC(bowlingCode.charAt(i+4));
					else {
						if(getC(bowlingCode.charAt(i+3))>0)
								ans+=getC(bowlingCode.charAt(i+3));
								else ans+=10-getC(c);		      
					}
				}
			else if(count==10)
			{
				ans+=getC(bowlingCode.charAt(i+3));
				ans+=getC(bowlingCode.charAt(i+4));
			}
			else {
				ans+=getC(bowlingCode.charAt(i+2));
				if(getC(bowlingCode.charAt(i+2))==10)
				{
					ans+=getC(bowlingCode.charAt(i+5));
				}
				else if(getC(bowlingCode.charAt(i+3))<=0)
					ans+=10-getC(bowlingCode.charAt(i+2));
				else ans+=getC(bowlingCode.charAt(i+3));
			}
			
    		}
		else if(b>='1'&&b<='9')
			{
				ans+=getC(b);
			}
		else if(b=='/')
		{
			ans+=10-getC(bowlingCode.charAt(i-1));
			if(count!=10)
				ans+=getC(bowlingCode.charAt(i+2));
			else ans+=getC(bowlingCode.charAt(i+3));
		}
	}
        return ans;
    }
}

	  


