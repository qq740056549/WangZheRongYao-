import java.util.*;
public class distribute_cakes {
	static int re(int n,int k,int a[]) {
		int sum=0,count=0;
		int i;
		for(i=0;i<n;i++) {
			sum+=a[i];
			if(sum>=k) {
				sum=0;
				count++;
			}
			else if(sum<k&&i==n-1) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String []args) {
		int n,k;
		int a[];
		a=new int[1000];
		Scanner p=new Scanner(System.in);
		n=p.nextInt();
		k=p.nextInt();
		for(int i=0;i<n;i++)
			a[i]=p.nextInt();
		System.out.print(re(n,k,a));
	}
}
