package test;

@FunctionalInterface
public interface PropertyGetter<K, V> {
	V get(K key) throws Exception;
}
