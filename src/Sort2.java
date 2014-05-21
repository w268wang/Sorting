import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//组合法排序-》merge sorting

public class Sort2 
{
	public static void main(String[] args) throws IOException
	{
		Sort2 s = new Sort2();
		int[] mer = s.merge(s.input(), 3);
		s.print(mer);
	}
	public static int[] input() throws IOException
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
	    return zu;
	}
	public int[] process(int zu[])
	{
		return zu;
	}
	public int[] merge(int input[], int p)
	{
		int i,j=0,m=0;
		int n1=p;
		int n2=input.length-p;
		int[] merge = new int[input.length];
		int[] a = new int[n1];
		int[] b = new int[n2];
		for(i=0; i<n1; i++)
			a[i]=input[i];
		for(i=n1; i<n1+n2; i++)
			b[i]=input[i];
		for(i=0;(i<a.length&&j<b.length)||(m<(a.length)+(b.length));)
		{
			//if(i==a.length-1)
			if(i==a.length)
		    {
		    	merge[m]=b[j];
		    	j++;
		    	m++;
		    	continue;
		    }
		    //else if(j==b.length-1)
			else if(j==b.length)
		    {
		    	merge[m]=a[i];
		    	i++;
		    	m++;
		    	continue;
		    }
		    else
		    {
		    	if(a[i]<=b[j])
		    	{
		    		merge[m]=a[i];
					i++;
					m++;
		    	}
		    	else
				{
					merge[m]=b[j];
					j++;
					m++;
				}
		    }
		}
		return merge;
	}
	public void print(int zu[])
	{
		for(int i=0; i<zu.length; i++)
			System.out.print(zu[i]+" ");
	}
}


/*[java] 

 Merge sorting

MERGE(new Sortable() { 
    public <T extends Comparable<T>> void sort(T[] array, boolean ascend) { 
        this.sort(array, 0, array.length - 1, ascend); 
    } 
 
    private <T extends Comparable<T>> void sort(T[] array, int lo, int hi, boolean ascend) { 
        // OPTIMIZE ONE 
        // if the substring's length is less than 20, 
        // use insertion sort to reduce recursive invocation 
        if (hi - lo < 20) { 
            for (int i = lo + 1; i <= hi; i++) { 
                T toInsert = array[i]; 
                int j = i; 
                for (; j > lo; j--) { 
                    int compare = array[j - 1].compareTo(toInsert); 
                    if (compare == 0 || compare < 0 == ascend) { 
                        break; 
                    } 
                    array[j] = array[j - 1]; 
                } 
 
                array[j] = toInsert; 
            } 
 
            return; 
        } 
 
        int mid = lo + (hi - lo) / 2; 
        sort(array, lo, mid, ascend); 
        sort(array, mid + 1, hi, ascend); 
        merge(array, lo, mid, hi, ascend); 
    } 
 
    private <T extends Comparable<T>> void merge(T[] array, int lo, int mid, int hi, boolean ascend) { 
        // OPTIMIZE TWO 
        // if it is already in right order, skip this merge 
        // since there's no need to do so 
        int leftEndCompareToRigthStart = array[mid].compareTo(array[mid + 1]); 
        if (leftEndCompareToRigthStart == 0 || leftEndCompareToRigthStart < 0 == ascend) { 
            return; 
        } 
 
        @SuppressWarnings("unchecked") 
        T[] arrayCopy = (T[]) new Comparable[hi - lo + 1]; 
        System.arraycopy(array, lo, arrayCopy, 0, arrayCopy.length); 
 
        int lowIdx = 0; 
        int highIdx = mid - lo + 1; 
 
        for (int i = lo; i <= hi; i++) { 
            if (lowIdx > mid - lo) { 
                // left sub array exhausted 
                array[i] = arrayCopy[highIdx++]; 
            } else if (highIdx > hi - lo) { 
                // right sub array exhausted 
                array[i] = arrayCopy[lowIdx++]; 
            } else if (arrayCopy[lowIdx].compareTo(arrayCopy[highIdx]) < 0 == ascend) { 
                array[i] = arrayCopy[lowIdx++]; 
            } else { 
                array[i] = arrayCopy[highIdx++]; 
            } 
        } 
    } 
})*/
//----------------------------------********----------------------------------------------------
//----------------------------------********----------------------------------------------------
//----------------------------------********----------------------------------------------------
//----------------------------------********----------------------------------------------------
//----------------------------------********--------------------------------------------
/*public static int[] mergeSort(int[] data1,int[] data2)
{
	int[] temp=new int[data1.length+data2.length];
	int i=0,j=0,iter=0;
	for(;i<data1.length&&j<data2.length;)
	{
		if(data1[i]<=data2[j])
		{
			temp[iter]=data1[i];
			iter++;
			i++;
		}
		else
		{
			temp[iter]=data2[j];
			iter++;
			j++;
		}
	}
	for(;i<data1.length;i++,iter++)
	{
		temp[iter]=data1[i];
	}
	for(;j<data2.length;j++,iter++)
	{
		temp[iter]=data2[j];
	}
	return temp;
}
归并排序有两种实现方法：自底向上和自顶向下，算法实现如下：
1.自底向上算法
#include <stdio.h>
#include <time.h>
void Merge(int *a,int low,int mid,int high)
{
	int i = low,j = mid + 1,k = 0;
	int *temp = (int *)malloc((high - low + 1)*sizeof(int));
	while(i <= mid && j <= high)
		a[i] < a[j] ? (temp[k++] = a[i++]):(temp[k++] = a[j++]);
	while(i <= mid)
		temp[k++] = a[i++];
	while(j <= high)
		temp[k++] = a[j++];
	memcpy(a + low,temp,(high -low + 1)*sizeof(int));
	free(temp);
}
void MergeSort(int *a,int n)
{
	int length;
	for(length = 1;length < n;length *= 2)
	{
		int i;
		for( i = 0;i + 2*length - 1 <= n - 1;i += 2*length)
			Merge(a,i,i+length-1,i+2*length -1);
		if(i + 2*length - 1 <= n - 1)//尚有两个子文件，其中后一个长度小于length
			Merge(a,i,i +2* length -1,n - 1);
	}
}
int main()
{
	int n;
	cin >> n;
	int *data = new int[n];
	if(!data) exit(1);
	int k = n;
	while(k --)
	{
		cin >> data[n-k-1];
	}
	clock_t s = clock();
	MergeSort(data, n);
	clock_t e = clock();
	k = n;
	while(k --)
	{
		cout << data[n-k-1] << ' ';
	}
	cout << endl;
	cout << "the algrothem used " << e-s << " miliseconds."<< endl;
	delete data;
	return 0;
}
2.自顶向下
void Merge(int r[],int r1[],int s,int m,int t)
{
int i=s;int j=m+1;int k=s;
while(i<=m&&j<=t)
{
if(r[i]<=r[j])r1[k++]=r[i++];
else r1[k++]=r[j++];
}
while(i<=m) r1[k++]=r[i++];
while(j<=t)
r1[k++]=r[j++];
for(int l=0;l<8;l++)
r[l]=r1[l];
}
void MergeSort(int r[],int r1[],int s,int t)
{
if(s==t);
else{
int m=(s+t)/2;
MergeSort(r,r1,s,m);
MergeSort(r,r1,m+1,t);
Merge(r,r1,s,m,t);
}
}*/