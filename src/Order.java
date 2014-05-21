import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//冒泡法排序

public class Order 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入排序的个数：");
	    String str=bf.readLine();
	    int n=Integer.parseInt(str);
	    int zu[]=new int [n];
	    for(int i=0; i<n; i++)
	    {
	    	System.out.println("请输入需要排序的数：");
		    str=bf.readLine();
		    int x=Integer.parseInt(str);
		    zu[i]=x;
	    }    
	    for(int j=0;j<n-1;j++)
	    {
	    	for(int k=0;k<n-j-1;k++)
	    	{
	    		int temp;
	    		if(zu[k]>zu[k+1])
		    	{
		    		temp = zu[k];
		    		zu[k] = zu[k+1];
		    		zu[k+1] = temp;
		    	}
	    	}
	    }
	    for(int i=0;i<n;i++)
	    	System.out.print(zu[i]+" ");
	}

}
