### 数据结构

## 数组

- Array
    - 固定数组增、删除、查
- GenericArray
    - 支持动态扩容的数组
    - 增、删除、查

## 链表
- LinkedListAlgo
    - 单链表反转
    - 链表中环的检测
    - 求链表的中间结点
    - 两个有序的链表合并
      
- SinglyLinkedList
    - 单链表的插入、删除、查找操作
    - 判断链表有否为回文

- LRUBasedArray
    - 基于数组实现的LRU缓存
        - 缓存容量有限，如果缓存满了就要删除一些内容，给新的内容腾位置
        - 最近最少使用策略
    - 不支持null的缓存
- LRUBaseLinkedList
    - 基于单链表LRU算法
        - 每次添加的结点都放在链表的头部
        - 当结点存在时,就将链表中的结点删除,再将结点放于链表的头部

## 栈        
- StackBasedOnLinkedList
    - 基于链表实现的栈
- SampleBrowser 
    - 使用前后栈实现浏览器的前进后退     
- StackCalculateExpression
    - 通过栈解析 四则运算表达式        