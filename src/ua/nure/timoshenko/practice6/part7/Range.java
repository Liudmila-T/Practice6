package ua.nure.timoshenko.practice6.part7;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range {
    private static final int START = -3;
    private static final int END = 3;
    private static final String SPACE = " ";
    private int n, m;
    private boolean mark;

    public Range(int n, int m) {
        this.n = n;
        this.m = m;
        this.mark = true;
    }

    public Range(int n, int m, boolean mark) {
        this.n = n;
        this.m = m;
        reverse(mark);
    }

    public void reverse(boolean b) {
        mark = b;
    }

    public Iterable<Integer> iterable() {
        return new Step();
    }

    private class Step implements Iterable<Integer> {
        private int step;

        public Step() {
            if (mark) {
                step = m + 1;
            } else {
                step = n - 1;
            }
        }

        @Override
        public Iterator<Integer> iterator() {
            return new InnerIterator();
        }

        private class InnerIterator implements Iterator<Integer> {
            @Override
            public boolean hasNext() {
                if (mark) {
                    step--;
                } else {
                    step++;
                }
                return !(step > m || step < n);
            }

            @Override
            public Integer next() {
                if ((step > m || step < n)) {
                    throw new NoSuchElementException();
                }
                return step;
            }

            @Override
            public void remove() {
                throw new IllegalStateException();
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = iterable().iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(SPACE);
        }
        sb.append(System.lineSeparator());
        return new String(sb).trim();
    }

    public static void main(String[] args) {
        Range range = new Range(-3, 3, false);
        System.out.println(range);
        Range range2 = new Range(-3, 3, true);
        System.out.println(range2);

    }
}
