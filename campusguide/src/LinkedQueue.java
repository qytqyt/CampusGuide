//队列类--用于广度优先遍历的输出
public final class LinkedQueue<T>{
    private Node<T>front,rear;
    public LinkedQueue() {
        this.front=this.rear=null;
    }
    //判空
    public boolean isEmpty() {
        return this.front==null&&this.rear==null;
    }
    //元素x入队
    public boolean add(T x) {
        if(x==null)
            return false;
        Node<T>q=new Node<T>(x,null);
        if(this.front==null)
            this.front=q;
        else this.rear.next=q;
        this.rear=q;
        return true;
    }
    //返回队头元素
    public T peek() {
        return this.isEmpty()?null:this.front.data;
    }
    //出队，返回队头元素
    public T poll() {
        if(isEmpty())
            return null;
        T x=this.front.data;
        this.front=this.front.next;
        if(this.front==null)
            this.rear=null;
        return x;
    }
}