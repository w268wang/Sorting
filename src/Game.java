/**********************************************************************************************************
 * David Wang
 * To make a program that can move the NUL part to up/down/left/right.
 * 23/8/2013
 * 8:57
 **********************************************************************************************************/
import java.util.Random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game 
{
	public static void main(String[] args) throws IOException
	{
		int times = 0;
		Random r = new Random();
		int[] arr = new int[9];
		arr[8] = 0;
		for(int i = 0; i < 8; i++)
		{
			int n = r.nextInt(8);
			if(n == 0)
				n = 8;
			arr[i] = n;
			for(int j = 0; j < i; j++)
			{
				if(n == arr[j])
				{
				    i--;
					break;
				}
			}
		}
		boolean bo = true;
		boolean boo = true;
		int n, z1=0, z2=0;
		do
		{
			for(int i = 0; i < 7; i++)
				System.out.print("-");
			System.out.println("");
			for(int i = 0; i < 3; i++)
			{
				System.out.print("|");
				for(int j = 0; j < 3; j++)
				{
					if(arr[j+i*3]!=0)
						System.out.print(arr[j+i*3]);
					else
						System.out.print("_");
					System.out.print("|");
				}
				System.out.println("");
				for(int q = 0; q < 7; q++)
					System.out.print("-");
				System.out.println("");
			}
			boo = decide(arr);
			do
			{
				/*BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
				System.out.println("You have moved " + times + " times already. Type in number to move the NUL: ");
			    String str=bf.readLine();
			    n=Integer.parseInt(str);
			    bo = decide1(n, arr);*/
				try
				{
					BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
					System.out.println("You have moved " + times + " times already. Type in number to move the NUL: ");
				    String str=bf.readLine();
				    n=Integer.parseInt(str);
				    bo = decide1(n, arr);
				}catch(NumberFormatException e)
				{
					n=-1;
				}//finally
				//{
					
				//}
			}while(bo == true);
			for(int i=0; i<9; i++)
			{
				if(arr[i]==n)
					z1=i;
			}
			for(int i=0; i<9; i++)
			{
				if(arr[i]==0)
					z2=i;
			}
			arr[z1]=0;
			arr[z2]=n;
			times++;
		}while(boo);
		for(int i = 0; i < 7; i++)
			System.out.print("-");
		System.out.println("");
		for(int i = 0; i < 3; i++)
		{
			System.out.print("|");
			for(int j = 0; j < 3; j++)
			{
				if(arr[j+i*3]!=0)
					System.out.print(arr[j+i*3]);
				else
					System.out.print("_");
				System.out.print("|");
			}
			System.out.println("");
			for(int q = 0; q < 7; q++)
				System.out.print("-");
			System.out.println("");
		}
		System.out.println("You have moved " + times + " times already. And finally succeed!");
	}
	static boolean decide(int[] arr)
	{
		boolean bool = false;
		for(int p = 0; p<7; p++)
		{
			for(int p1 = p+1; p1 <=7; p1++)
			{
				if(arr[p1]<arr[p])
					bool = true;
			}
		}
		return bool;
	}
	static boolean decide1(int de, int[] ar)
	{
		boolean bool = true;
		if(ar[0]==0)
		{
			bool = !(ar[1]==de||ar[3]==de);
		}else if(ar[1]==0)
		{
			bool = !(ar[0]==de||ar[2]==de||ar[4]==de);
		}else if(ar[2]==0)
		{
			bool = !(ar[1]==de||ar[5]==de);
		}else if(ar[3]==0)
		{
			bool = !(ar[0]==de||ar[4]==de||ar[6]==de);
		}else if(ar[4]==0)
		{
			bool = !(ar[1]==de||ar[3]==de||ar[5]==de||ar[7]==de);
		}else if(ar[5]==0)
		{
			bool = !(ar[2]==de||ar[4]==de||ar[8]==de);
		}else if(ar[6]==0)
		{
			bool = !(ar[3]==de||ar[7]==de);
		}else if(ar[7]==0)
		{
			bool = !(ar[4]==de||ar[6]==de||ar[8]==de);
		}else if(ar[8]==0)
		{
			bool = !(ar[5]==de||ar[7]==de);
		}
		return bool;
	}
}