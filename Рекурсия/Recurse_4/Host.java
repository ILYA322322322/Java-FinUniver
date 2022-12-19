public class Host<V extends Comparable<V>> {
    public static void main(String[] args) {
        Host<Integer> host = new Host<>();




        System.out.println(host.add(3));
        System.out.println(host.add(1));
        System.out.println(host.add(5));
        System.out.println(host.add(2));
        System.out.println(host.add(4));
        System.out.println(host.add(0));
        System.out.println(host.add(1));


        System.out.println();




        System.out.println(host.getVal(0));
        System.out.println(host.getVal(1));
        System.out.println(host.getVal(2));
        System.out.println(host.getVal(3));
        System.out.println(host.getVal(4));
        System.out.println(host.getVal(5));
        System.out.println(host.getVal(11));
    }

    V value = null;
    Host<V> right = null;
    Host<V> left = null;
    public Host(V value) {
        this.value = value;
    }
    public Host() {
    }

    public boolean add(V v) {
        boolean result = false;
        if (value == null) {
            value = v;
            result = true;
        } else {
            if (v.compareTo(value) > 0) {
                if (right == null) {
                    Host<V> node = new Host<>(v);
                    this.right = node;
                    result = true;
                } else {
                    result = right.add(v);
                }
            }
            if (v.compareTo(value) < 0) {
                if (left == null) {
                    this.left = new Host<>(v);
                    result = true;
                } else {
                    result = left.add(v);
                }
            }
        }
        return result;
    }
    public boolean getVal(V v) {
        boolean result = false;
        if (this.value.compareTo(v) == 0) {
            result = true;
        } else if (this.value.compareTo(v) < 0) {
            if (this.right != null) {
                result = right.getVal(v);
            }
        } else if (this.value.compareTo(v) > 0) {
            if (this.left != null) {
                result = left.getVal(v);
            }
        }
        return result;
    }
}