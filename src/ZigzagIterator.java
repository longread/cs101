import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator implements Iterator<Integer> {

    private final Queue<Iterator<Integer>> iterators;

    public ZigzagIterator(List<List<Integer>> lists) {
        this.iterators = new LinkedList<>();
        if (lists == null) {
            return;
        }
        for (List<Integer> list : lists) {
            if (list != null && !list.isEmpty()) {
                this.iterators.add(list.iterator());
            }
        }
    }

    @Override
    public Integer next() {
        Iterator<Integer> currentIterator = iterators.poll();
        Integer value = currentIterator.next();

        if (currentIterator.hasNext()) {
            iterators.add(currentIterator);
        }

        return value;
    }

    @Override
    public boolean hasNext() {
        return !iterators.isEmpty();
    }
}