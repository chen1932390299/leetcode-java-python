package List;

public class ListSet {

    // todo List Collection :ArrayList,LinkedList
    /**List 是一个有序、可重复的集合，集合中每个元素都有其对应的顺序索引。List 集合允许使用重复元素，可以通过索引来访问指定位置的集合元素。
     * List 集合默认按元素的添加顺序设置元素的索引，第一个添加到 List 集合中的元素的索引为 0，第二个为 1，依此类推。
     * 1.
     * ArrayList 类实现了可变数组的大小，存储在内的数据称为元素。它还提供了快速基于索引访问元素的方式，对尾部成员的增加和删除支持较好。
     * 使用 ArrayList 创建的集合，允许对集合中的元素进行快速的随机访问，不过，向 ArrayList 中插入与删除元素的速度相对较慢。
     *
     * 方法：
     *
     表 1 ArrayList类的常用方法
     方法名称	说明
     E get(int index)	获取此集合中指定索引位置的元素，E 为集合中元素的数据类型
     int index(Object o)	返回此集合中第一次出现指定元素的索引，如果此集合不包含该元
     素，则返回 -1
     int lastIndexOf(Object o)	返回此集合中最后一次出现指定元素的索引，如果此集合不包含该
     元素，则返回 -1
     E set(int index, Eelement)	将此集合中指定索引位置的元素修改为 element 参数指定的对象。
     此方法返回此集合中指定索引位置的原元素
     List<E> subList(int fromlndex, int tolndex)	返回一个新的集合，新集合中包含 fromlndex 和 tolndex 索引之间
     的所有元素。包含 fromlndex 处的元素，不包含 tolndex 索引处的元素
     ================================================================
     * 2.
     *LinkedList 类采用链表结构保存对象，这种结构的优点是便于向集合中插入或者删除元素。需要频繁向集合中插入和删除元素时，使用 LinkedList
     * 类比 ArrayList 类效果高，但是 LinkedList 类随机访问元素的速度则相对较慢。这里的随机访问是指检索集合中特定索引位置的元素
     * 方法：
     *
     表 1 ArrayList类的常用方法
     方法名称	说明
     E get(int index)	获取此集合中指定索引位置的元素，E 为集合中元素的数据类型
     int index(Object o)	返回此集合中第一次出现指定元素的索引，如果此集合不包含该元
     素，则返回 -1
     int lastIndexOf(Object o)	返回此集合中最后一次出现指定元素的索引，如果此集合不包含该
     元素，则返回 -1
     E set(int index, Eelement)	将此集合中指定索引位置的元素修改为 element 参数指定的对象。
     此方法返回此集合中指定索引位置的原元素
     List<E> subList(int fromlndex, int tolndex)	返回一个新的集合，新集合中包含 fromlndex 和 tolndex 索引之间
     的所有元素。包含 fromlndex 处的元素，不包含 tolndex 索引处的
     元素
     *
     表 2 LinkList类中的方法
     方法名称	说明
     void addFirst(E e)	将指定元素添加到此集合的开头
     void addLast(E e)	将指定元素添加到此集合的末尾
     E getFirst()	返回此集合的第一个元素
     E getLast()	返回此集合的最后一个元素
     E removeFirst()	删除此集合中的第一个元素
     E removeLast()	删除此集合中的最后一个元素
     * */

}
