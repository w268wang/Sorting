import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//ð�ݷ�����

public class Order 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("����������ĸ�����");
	    String str=bf.readLine();
	    int n=Integer.parseInt(str);
	    int zu[]=new int [n];
	    for(int i=0; i<n; i++)
	    {
	    	System.out.println("��������Ҫ���������");
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
