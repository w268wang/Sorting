import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//插入法排序

public class Sort1 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入排序的个数：");
	    String str=bf.readLine();
	    int n=Integer.parseInt(str);
	    int array[]=new int [n];
	    for(int i=0; i<n; i++)
	    {
	    	System.out.println("请输入需要排序的数：");
		    str=bf.readLine();
		    int x=Integer.parseInt(str);
		    array[i]=x;
	    }
	    for(int i=1; i<n; i++)
	    {
	    	for(int j=0; j<i; j++)
	    	{
	    		if(array[i]<=array[j])
	    		{
	    			int key = array[i];
	    			for(int k=j; k<i; k++)
	    			{
	    				array[k+1] = array[k];
	    			}
	    			array[j] = key;
	    			continue;
	    		}
	    	}
	    }
	    for(int i=0;i<n;i++)
	    	System.out.print(array[i]+" ");
	}
}
