public class SeqList<T>extends Object{
    protected Object[] element;//存放数据元素
    protected int n;//顺序表元素个数
    //构造容量为length的空表
    public SeqList(int length) {
        this.element = new Object[length];
        this.n = 0;
    }
    //创建默认容量的空表，构造方法重载
    public SeqList() {
        this(999);
    }
    //构造顺序表
    public SeqList(T[] values) {
        this(values.length);
        for(int i = 0; i < values.length; i++)
            this.element[i] = values[i];
        this.n = element.length;
    }
    //判断顺序表是否为空
    public boolean isEmpty() {
        return this.n == 0;
    }
    //返回顺序表元素个数
    public int size() {
        return this.n;
    }
    //返回第i个元素
    public T get(int i) {
        if(i>=0 && i<this.n)
            return (T)this.element[i];
        return null;
    }
    //设置第i个元素为x
    public void set(int i,T x) {
        if(x == null)
            throw new NullPointerException("x==null");
        if(i>0 && i<this.n)
            this.element[i] = x;
        else throw new java.lang.IndexOutOfBoundsException(i+" ");
    }
    //返回顺序表所有元素的描述字符串
    public String toString() {
        String str = this.getClass().getName()+"(";
        if(this.n > 0)
            str += this.element[0].toString();
        for(int i = 1; i < this.n; i++)
            str += ","+this.element[i].toString();
        return str + ")";
    }
    //插入元素
    public int insert(int i, T x) {
        if(x == null)
            throw new NullPointerException("x为空");
        if(i < 0) {
            i = 0;
        }
        if(i > this.n){
            i = this.n;
        }
        Object[] source = this.element;
        if(this.n == element.length) {
            this.element = new Object[source.length * 2];//数组扩容
            for(int j = 0; j < i; j++)
                this.element[j] = source[j];
        }
        for(int j = this.n - 1; j >= i; j--)
            this.element[j + 1] = source[j];
        this.element[i] = x;
        this.n++;
        return i;
    }
    public int insert(T x) {
        return this.insert(this.n,x);
    }
    //删除元素
    public T remove(int i) {
        if(this.n > 0 && i >= 0 && i < this.n) {
            T old = (T)this.element[i];
            for(int j = i; j < this.n - 1; j++)
                this.element[j] = this.element[j + 1];
            this.element[this.n - 1] = null;
            this.n--;
            return old;
        }
        return null;
    }
    //清空
    public void clear() {
        this.n = 0;
    }
    //查找
    public int search(T key) {
        for(int i = 0; i < this.n; i++)
            if(key.equals(this.element[i]))
                return i;
        return -1;
    }
}