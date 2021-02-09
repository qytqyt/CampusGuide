public class MatrixGraph<T> extends AbstractGraph<T> {      //邻接矩阵表示的无向图类
    protected Matrix matrix;

    public MatrixGraph(int length) {
        super(length);
        this.matrix = new Matrix(length);
    }

    public MatrixGraph() {
        this(50);
    }

    public MatrixGraph(T[] vexs) {
        this(vexs.length);
        for (int i = 0; i < vexs.length; i++)
            this.insertVex(vexs[i]);
    }

    public MatrixGraph(T[] vexs, Triple[] edges) {
        this(vexs);
        for (int j = 0; j < edges.length; j++)
            this.insertEdge(edges[j]);
    }

    public String toString() {
        String str = super.toString() + "邻接矩阵\n";
        int n = this.vexNum();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (this.matrix.get(i, j) == MAX_WEIGHT)
                    str += "INFINITY";      //无穷大值
                else
                    str += String.format("%8d", this.matrix.get(i, j));
            str += "\n";
        }
        return str;
    }

    // 插入边
    public void insertEdge(int i, int j, int weight) {
        if (i != j) {
            if (weight <= 0 || weight > MAX_WEIGHT)
                weight = MAX_WEIGHT;
            this.matrix.set(i, j, weight);
        } else
            throw new IllegalArgumentException("不能插入自身环,i=" + i + ",j=" + j);
    }

    public void insertEdge(Triple edge) {
        this.insertEdge(edge.row, edge.col, edge.value);
    }

    // 插入顶点
    public int insertVex(T x) {
        int i = this.vex.insert(x);
        if (i >= this.matrix.getRows())
            this.matrix.setRowsCols(i + 1, i + 1);
        for (int j = 0; j < i; j++) {
            this.matrix.set(i, j, MAX_WEIGHT);
            this.matrix.set(j, i, MAX_WEIGHT);
        }
        return i;
    }

    // 删除边
    public void removeEdge(int i, int j) {
        if (i != j)
            this.matrix.set(i, j, MAX_WEIGHT);
    }

    public void removeEdge(Triple edge) {
        this.removeEdge(edge.row, edge.col);
    }

    // 删除顶点vi及其所有关联的边
    public void removeVex(int i) {
        int n = this.vexNum();
        if (i >= 0 && i < n) {
            this.vex.remove(i);
            for (int j = i + 1; j < n; j++)// 第i+1~n-1行元素上移一行
                for (int k = 0; k < n; k++)
                    this.matrix.set(j - 1, k, this.matrix.get(j, k));
            for (int j = 0; j < n; j++)// 第i+1~n-1列元素左移一列
                for (int k = i + 1; k < n; k++)
                    this.matrix.set(j, k - 1, this.matrix.get(j, k));
            this.matrix.setRowsCols(n - 1, n - 1);
        } else
            throw new IndexOutOfBoundsException("i = " + i);
    }

    // 获得边的权值
    public int weight(int i, int j) {
        return this.matrix.get(i, j);
    }

    // 后继结点
    protected int next(int i, int j) {
        int n = this.vexNum();
        if (i >= 0 && i < n && j >= -1 && j < n && i != j)// 当j=-1是，k从0开始寻找后继结点
            for (int k = j + 1; k < n; k++)
                if (this.matrix.get(i, k) > 0 && this.matrix.get(i, k) < MAX_WEIGHT)
                    return k;
        return -1;
    }

    // 深度优先遍历
    public void DFSTraverse(int start,int end) {
        int dis = 0;
        boolean[] visited = new boolean[this.vexNum()];
        int i, j, count = 0;
        int[] stack = null;
        int top = 0;
        stack[top] = start;
        top ++;
        visited[start] = true;
        for(i = 0; i < vexNum(); i++)
        {
            if(weight(start,i) > 0 && weight(start, i) != Integer.MAX_VALUE && !visited[i])
            {
                //表明两点可达且未被访问
                if(i == end) {
                    System.out.println("第" + i + "条路为：");
                    count ++;
                    for(j = 0; j < top; j++) {
                        System.out.print("->" + getVex(stack[j]));
                        if(j < top-1) {
                            dis += weight(stack[j], stack[j+1]);
                        }
                    }
                    dis += weight(stack[top-1], stack[end]);
                    System.out.println(getVex(end));
                    System.out.println("总长度为：" + dis);
                }
                else {
                    DFSTraverse(i, end);
                    top--;
                    visited[i] = false;
                }
            }
        }
    }

    // 从顶点vi出发的一次深度优先搜索，遍历一个连通分量;visited指定访问标记数组，递归算法
    private void depthfs(int i, boolean[] visited) {
        System.out.print(this.getVex(i) + "->");// 访问顶点vi
        visited[i] = true;// 设置访问标记
        int j = this.next(i, -1);// 返回vi的第一个邻接顶点序号
        while (j != -1) {// 若vi存在第一个邻接顶点vj
            if (!visited[j])
                depthfs(j, visited);// 从vj出发进行递归调用深度优先遍历
            j = this.next(i, j);
        }
    }

    // 广度优先遍历
    public void BFSTraverse(int i) {
        boolean[] visited = new boolean[this.vexNum()];
        int j = i;
        do {
            if (!visited[j]) {
                System.out.print("{");
                breadthfs(j, visited);
                System.out.print("}");
            }
            j = (j + 1) % this.vexNum();
        } while (j != i);
        System.out.println();
    }

    private void breadthfs(int i, boolean[] visited) {
        System.out.print(this.getVex(i) + "->");
        visited[i] = true;
        LinkedQueue<Integer> que = new LinkedQueue<Integer>();
        que.add(i);
        while (!que.isEmpty()) {
            i = que.poll();// 出队，自动转化成int
            for (int j = next(i, -1); j != -1; j = next(i, j))
                if (!visited[j]) {
                    System.out.print(this.getVex(j) + "->");
                    visited[j] = true;
                    que.add(j);
                }
        }
    }

    // 求单源最短路径,Dijkstra算法
    public void shortestPathDIJ(int i) {
        int n = this.vexNum();
        boolean[] vset = new boolean[n];// 已求出最短路径的集合，初值全为false
        vset[i] = true;// 标记源点vi在集合S中
        int[] dist = new int[n];// 最短路径长度
        int[] path = new int[n];// 最短路径的终点的前一个顶点
        // 初始化dist和path数组
        for (int j = 0; j < n; j++) {
            dist[j] = this.weight(i, j);
            path[j] = (j != i && dist[j] < MAX_WEIGHT) ? i : -1;
        }
        // 寻找从vi到vj的最短路径,vj在V-S集合中
        for (int j = (i + 1) % n; j != i; j = (j + 1) % n) {
            int mindist = MAX_WEIGHT, min = 0;// 求路径长度最小值及其下标
            for (int k = 0; k < n; k++)
                if (!vset[k] && dist[k] < mindist) {
                    mindist = dist[k];
                    min = k;
                }
            if (mindist == MAX_WEIGHT)
                break;
            vset[min] = true;// 确定一条最短路径(vi,min),终点min并入集合S
            for (int k = 0; k < n; k++)
                if (!vset[k] && this.weight(min, k) < MAX_WEIGHT && dist[min] + this.weight(min, k) < dist[k]) {
                    dist[k] = dist[min] + this.weight(min, k);// 用更短路径替换
                    path[k] = min;// 最短路径经过min顶点
                }
        }
        // 输出顶点vi的单源最短路径
        System.out.print(this.getVex(i) + "顶点的单源最短路径：\n");
        for (int j = 0; j < n; j++)
            if (j != i) {
                // 路径单链表，记录最短路径经过的各顶点，用于反序
                SinglyList<T> pathlink = new SinglyList<T>();
                pathlink.insert(0, this.getVex(j));// 单链表插入最短路径终点vj
                for (int k = path[j]; k != i && k != j && k != -1; k = path[k])
                    pathlink.insert(0, this.getVex(k));// 单链表插入经过的顶点，反序
                pathlink.insert(0, this.getVex(i));// 最短路径的起点

                System.out.print(pathlink.toString() + "长度" + (dist[j] == MAX_WEIGHT ? "∞" : dist[j]) + "\n");
            }
        System.out.println();
    }

    // 求两点间最短路径,Dijkstra算法
    public void shortestPathDIJ(int i, int end) {
        int n = this.vexNum();
        boolean[] vset = new boolean[n];// 已求出最短路径的集合，初值全为false
        vset[i] = true;// 标记源点vi在集合S中
        int[] dist = new int[n];// 最短路径长度
        int[] path = new int[n];// 最短路径的终点的前一个顶点
        // 初始化dist和path数组
        for (int j = 0; j < n; j++) {
            dist[j] = this.weight(i, j);
            path[j] = (j != i && dist[j] < MAX_WEIGHT) ? i : -1;
        }
        // 寻找从vi到vj的最短路径,vj在V-S集合中
        for (int j = (i + 1) % n; j != i; j = (j + 1) % n) {
            int mindist = MAX_WEIGHT, min = 0;// 求路径长度最小值及其下标
            for (int k = 0; k < n; k++)
                if (!vset[k] && dist[k] < mindist) {
                    mindist = dist[k];
                    min = k;
                }
            if (mindist == MAX_WEIGHT)
                break;
            vset[min] = true;// 确定一条最短路径(vi,min),终点min并入集合S
            for (int k = 0; k < n; k++)
                if (!vset[k] && this.weight(min, k) < MAX_WEIGHT && dist[min] + this.weight(min, k) < dist[k]) {
                    dist[k] = dist[min] + this.weight(min, k);// 用更短路径替换
                    path[k] = min;// 最短路径经过min顶点
                }
        }
        // 输出顶点vi的单源最短路径
        System.out.print(this.getVex(i) + "到" + this.getVex(end) + "的最短路径为：\n");
        for (int j = 0; j < n; j++)
            if (j != i) {
                // 路径单链表，记录最短路径经过的各顶点，用于反序
                SinglyList<T> pathlink = new SinglyList<T>();
                pathlink.insert(0, this.getVex(j));// 单链表插入最短路径终点vj
                for (int k = path[j]; k != i && k != j && k != -1; k = path[k])
                    pathlink.insert(0, this.getVex(k));// 单链表插入经过的顶点，反序
                pathlink.insert(0, this.getVex(i));// 最短路径的起点
                if (j == end)
                    System.out.println(pathlink.toString() + "总路径为：" + (dist[j] == MAX_WEIGHT ? "∞" : dist[j]));
            }
        System.out.println();
    }

    // 求两点间最短路径,Floyd算法
    public void shortestPathFloyd(int start,int end) {
        int n=this.vexNum();
        Matrix path=new Matrix(n),dist=new Matrix(n);//最短路径矩阵及长度矩阵
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++) {
                int w=this.weight(i, j);
                dist.set(i, j, w);
                path.set(i, j, (i!=j&&w<MAX_WEIGHT?i:-1));
            }
        for(int k=0;k<n;k++) {//以vk作为其他路径的中间顶点
            for(int i=0;i<n;i++) {//测试每对从vi到vj路径长度是否更短
                if(i!=k) {
                    for(int j=0;j<n;j++) {
                        if(j!=k&&j!=i&&dist.get(i, j)>dist.get(i, k)+dist.get(k, j)) {//若更短，则替换
                            dist.set(i, j, dist.get(i, k)+dist.get(k, j));
                            path.set(i,j,path.get(k, j));
                        }
                    }
                }
            }
        }
        System.out.println(start+"与"+end+"之间的最短路径为：");
        if(start!=end)
            System.out.println(toPath(path,start,end)+"总路径为："+(dist.get(start,end)==MAX_WEIGHT?"∞":dist.get(start, end)));
        System.out.println();
    }

    private String toPath(Matrix path,int i,int j) {
        SinglyList<T> pathlink=new SinglyList<T>();//单链表记录最短路径经过顶点，用于反序
        pathlink.insert(0,this.getVex(j));//单链表插入最短路径终点vj
        for(int k=path.get(i,j);k!=i&&k!=j&&k!=-1;k=path.get(i, k))
            pathlink.insert(0,this.getVex(k));//单链表头插入经过的顶点，反序
        pathlink.insert(0,this.getVex(i));
        return pathlink.toString();
    }
}