/**
 * Created by where1993 on 2017/2/23.
 */
public class Quick {
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    private static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];a[i]=a[j];a[j]=t;
    }
    private static void show(Comparable[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++){
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }
    public static void sort(Comparable[] a){
      sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo)
            return;
        int j=partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    private static int partition(Comparable[] a,int lo,int hi){
       int i=lo,j=hi+1;
        Comparable v=a[lo];
        while(true){
            while(less(a[++i],v)&&i<=hi);
            while(less(v,a[--j])&&j>=lo);
            if(i>=j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }
    public static void main(String[] args){
        Integer[] a={7,6,8,4,10};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
