import java.util.Arrays;

public class BinarkaSrch<V extends Comparable<V>> {
    public static void main(String[] args) {
        BinarkaSrch<Integer> bs = new BinarkaSrch<>();
        Integer[] ints = new Integer[100000000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
    }


    public boolean noBinarySearch(V[] arr, V v) {
        boolean isFound = false;
        for (int i = 0; i < arr.length; i++) {



            if (arr[i].compareTo(v) == 0) {
                isFound = true;
                break;///True == end


            }
        }
        return isFound;
    }



    public boolean search(V[] arr, V v) {
        Arrays.sort(arr);
        return binarka(arr, v);
    }




    private boolean binarka(V[] arr, V v) {
        boolean result = false;
        int x = arr.length / 2;
        if (arr.length == 1) {
            result = arr[0] == v;
        } else if (arr[x].compareTo(v) < 0) {
            V[] newArr = Arrays.copyOfRange(arr, x, arr.length);
            result = binarka(newArr, v);
        } else if (arr[x].compareTo(v) > 0) {
            V[] newArr = Arrays.copyOfRange(arr, 0, x);
            result = binarka(newArr, v);
        } else if (arr[x].compareTo(v) == 0) {
            result = true;
        }
        return result;
    }
}