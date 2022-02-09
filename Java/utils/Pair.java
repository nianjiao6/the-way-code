package utils;

/**
 * 测试数据实体
 */
public class Pair<K,V> {
    /**
     * 源数据
     */
    private K left;
    /**
     * 结果
     */
    private V right;

    public K getLeft() {
        return left;
    }

    public V getRight() {
        return right;
    }

    public Pair(K left,V right){
        this.left = left;
        this.right = right;
    }
}
