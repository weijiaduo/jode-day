package com.wjd.pattern.iterator;

/**
 * @since 2022/1/21
 */
public interface Aggregate<T> {

    Iterator<T> iterator();

}
