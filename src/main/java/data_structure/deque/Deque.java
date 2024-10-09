package data_structure.deque;

/**
 * 双端队列接口
 *
 * @param <E> 队列中元素类型
 */
public interface Deque<E> {

    /**
     * queue
     * <p>
     * deque: double queue
     */

    boolean offerFirst(E e);

    boolean offerLast(E e);

    E pollFirst();

    E pollLast();

    E peekFirst();

    E peekLast();

    boolean isEmpty();

    boolean isFull();
}
