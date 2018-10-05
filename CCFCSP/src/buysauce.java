import java.util.*;
public class buysauce {
	
	public static void main(String []args) {
		int n;
		Scanner a=new Scanner(System.in);
		n=a.nextInt();
		int b=re(n);
		System.out.print(b);
	}
	
		public static int re(int n){
		int i,temp,max=0;
		for(i=0;i<=n;i+=10) {
			if(i%30==0&&(n-i)%50==0)
	        {
	            temp=(i/30)*4+(n-i)/50*7;
	        }
	        else if(i%30==0&&(n-i)%50!=0)
	        {
	            temp=(i/30)*4+(n-i)/10;
	        }
	        else if(i%30!=0&&(n-i)%50==0)
	        {
	            temp=i/10+(n-i)/50*7;
	        }
	        else
	        {
	            temp=n/10;
	        }
	        if(max<temp)
	            max=temp;
		}
		
		return max;
	}
}
