public abstract class AbstractGraph<T> {
    protected static final int MAX_WEIGHT = 0x0000ffff; //表示无穷大的最大权值
    protected SeqList<T> vex;   //顶点顺序表，用于存储图的顶点集合

    public AbstractGraph(int length) {   //构造空图,length为可指定的顺序表容量
        this.vex = new SeqList<T>(length);
    }

    public AbstractGraph() {
        this(99);
    }

    public int vexNum() {           //返回该图的顶点数
        return this.vex.size();
    }

    public String toString() {      //重写顶点集合的toString方法
        return "该图的顶点集合为:" + this.vex.toString() + "\n";
    }

    public T getVex(int i) {        //返回顶点元素
        return this.vex.get(i);
    }

    public void setVex(int i, T x){ //设置顶点vi的元素为x
        this.vex.set(i, x);
    }

    public abstract void insertEdge(int i, int j, int weight);//插入边

    public abstract int insertVex(T x);    //插入顶点

    public abstract void removeEdge(int i, int j) ;    //删除边

    public abstract void removeVex(int i);    //删除顶点

    public abstract int weight(int i,int j);    //返回权值

    protected abstract int next(int i,int j);    //求邻接顶点序号

    public abstract void BFSTraverse(int i);    //广度优先遍历

    public abstract void shortestPathDIJ(int i);    // 求单源最短路径,Dijkstra算法

    public abstract void shortestPathDIJ(int i, int end) ;    // 求两点间最短路径,Dijkstra算法

    public abstract void shortestPathFloyd(int start,int end);    // 求两点间最短路径,Floyd算法
}
