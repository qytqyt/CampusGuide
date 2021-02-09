//������--���ڹ�����ȱ��������
public final class LinkedQueue<T>{
    private Node<T>front,rear;
    public LinkedQueue() {
        this.front=this.rear=null;
    }
    //�п�
    public boolean isEmpty() {
        return this.front==null&&this.rear==null;
    }
    //Ԫ��x���
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
    //���ض�ͷԪ��
    public T peek() {
        return this.isEmpty()?null:this.front.data;
    }
    //���ӣ����ض�ͷԪ��
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