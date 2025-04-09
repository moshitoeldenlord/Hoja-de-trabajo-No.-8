import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> {
    private Vector<E> data;

    public VectorHeap() {
        data = new Vector<>();
    }

    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    public E remove() {
        if (data.isEmpty()) return null;
        E minVal = data.get(0);
        E lastVal = data.remove(data.size() - 1);
        if (!data.isEmpty()) {
            data.set(0, lastVal);
            percolateDown(0);
        }
        return minVal;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private void percolateUp(int index) {
        E value = data.get(index);
        while (index > 0) {
            int parent = (index - 1) / 2;
            E parentVal = data.get(parent);
            if (value.compareTo(parentVal) >= 0) break;
            data.set(index, parentVal);
            index = parent;
        }
        data.set(index, value);
    }

    private void percolateDown(int index) {
        E value = data.get(index);
        int size = data.size();
        while (index * 2 + 1 < size) {
            int left = index * 2 + 1;
            int right = left + 1;
            int smallest = left;

            if (right < size && data.get(right).compareTo(data.get(left)) < 0) {
                smallest = right;
            }

            if (data.get(smallest).compareTo(value) >= 0) break;

            data.set(index, data.get(smallest));
            index = smallest;
        }
        data.set(index, value);
    }
}
