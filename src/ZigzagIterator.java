import java.util.*;
public class ZigzagIterator {
    int i;
    int j;
    int turn;
    List<Integer> v1;
    List<Integer> v2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.i = 0;
        this.j = 0;
        this.turn = 0;
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        int value;
        if (i<v1.size() && j<v2.size()){
            if (turn==0){
                value = v1.get(i);
                i++;
            }else{
                value = v2.get(j);
                j++;
            }
            turn = (turn + 1)%2;
        }else if (i<v1.size()){
            value = v1.get(i);
            i++;
        }else {
            value = v2.get(j);
            j++;
        }
        return value;
    }

    public boolean hasNext() {
        return i<v1.size() || j<v2.size();
    }

    public static void main(String[] args) {
        ZigzagIterator zigzagIterator = new ZigzagIterator(
                Arrays.asList(1,2,3),
                Arrays.asList(4)
        );
        while (zigzagIterator.hasNext()){
            System.out.println(zigzagIterator.next());
        }
    }
}
