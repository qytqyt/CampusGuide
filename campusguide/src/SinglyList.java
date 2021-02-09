//单链表类
public class SinglyList<T>extends Object{
    public Node<T> head;
    //构造单链表
    public SinglyList() {
        this.head=new Node<T>();
    }
    public SinglyList(T[] values) {
        this();
        Node<T> rear=this.head;
        for(int i=0;i<values.length;i++) {
            rear.next=new Node<T>(values[i],null);
            rear=rear.next;
        }
    }
    //判空
    public boolean isEmpty() {
        return this.head.next==null;
    }
    //存取
    public T get(int i) {
        Node<T>p=this.head.next;
        for(int j=0;p!=null&&j<i;j++)
            p=p.next;
        return (i>=0&&p!=null)?p.data:null;
    }
    //返回单链表描述的字符串
    public String toString() {
        String str=this.getClass().getName().toString()+"(";
        for(Node<T>p=this.head.next;p!=null;p=p.next) {
            str+=p.data.toString();
            if(p.next!=null)
                str+=",";
        }
        return str+")";
    }
    //插入
    public Node<T>insert(int i,T x){
        if(x==null)
            throw new NullPointerException("x==null");
        Node<T>front=this.head;
        for(int j=0;front.next!=null&&j<i;j++)
            front=front.next;
        front.next=new Node<T>(x,front.next);
        return front.next;
    }
    //在单链表最后插入值为x的结点
    public Node<T>insert(T x){
        return insert(Integer.MAX_VALUE,x);
    }
    //删除
    public T remove(int i) {
        Node<T> front=this.head;
        for(int j=0;front.next!=null&&j<i;j++)
            front=front.next;
        if(i>=0&&front.next!=null) {
            T old=front.next.data;
            front.next=front.next.next;
            return old;
        }
        return null;
    }
    //清空
    public void clear() {
        this.head.next=null;
    }
}