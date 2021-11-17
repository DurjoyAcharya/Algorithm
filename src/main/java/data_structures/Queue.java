package data_structures;

import data_structures.interfaces.IQueue;

import java.util.Collection;

public interface Queue<T> extends IQueue<T> {

    class ArrayQueue<T> implements Queue<T>
    {
        private static final int Min_Size=1024;
        private final T[] Array=(T[])new Object[Min_Size];
        private final int Tails=0;
        private final int Head=0;

        @Override
        public boolean offer(T value) {
            return false;
        }

        @Override
        public T poll() {
            return null;
        }

        @Override
        public T peek() {
            return null;
        }

        @Override
        public boolean remove(T value) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public boolean contains(T value) {
            return false;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean validate() {
            return false;
        }

        @Override
        public java.util.Queue<T> toQueue() {
            return null;
        }

        @Override
        public Collection<T> toCollection() {
            return null;
        }
    }

}
