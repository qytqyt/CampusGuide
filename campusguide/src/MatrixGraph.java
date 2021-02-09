public class MatrixGraph<T> extends AbstractGraph<T> {      //�ڽӾ����ʾ������ͼ��
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
        String str = super.toString() + "�ڽӾ���\n";
        int n = this.vexNum();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (this.matrix.get(i, j) == MAX_WEIGHT)
                    str += "INFINITY";      //�����ֵ
                else
                    str += String.format("%8d", this.matrix.get(i, j));
            str += "\n";
        }
        return str;
    }

    // �����
    public void insertEdge(int i, int j, int weight) {
        if (i != j) {
            if (weight <= 0 || weight > MAX_WEIGHT)
                weight = MAX_WEIGHT;
            this.matrix.set(i, j, weight);
        } else
            throw new IllegalArgumentException("���ܲ�������,i=" + i + ",j=" + j);
    }

    public void insertEdge(Triple edge) {
        this.insertEdge(edge.row, edge.col, edge.value);
    }

    // ���붥��
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

    // ɾ����
    public void removeEdge(int i, int j) {
        if (i != j)
            this.matrix.set(i, j, MAX_WEIGHT);
    }

    public void removeEdge(Triple edge) {
        this.removeEdge(edge.row, edge.col);
    }

    // ɾ������vi�������й����ı�
    public void removeVex(int i) {
        int n = this.vexNum();
        if (i >= 0 && i < n) {
            this.vex.remove(i);
            for (int j = i + 1; j < n; j++)// ��i+1~n-1��Ԫ������һ��
                for (int k = 0; k < n; k++)
                    this.matrix.set(j - 1, k, this.matrix.get(j, k));
            for (int j = 0; j < n; j++)// ��i+1~n-1��Ԫ������һ��
                for (int k = i + 1; k < n; k++)
                    this.matrix.set(j, k - 1, this.matrix.get(j, k));
            this.matrix.setRowsCols(n - 1, n - 1);
        } else
            throw new IndexOutOfBoundsException("i = " + i);
    }

    // ��ñߵ�Ȩֵ
    public int weight(int i, int j) {
        return this.matrix.get(i, j);
    }

    // ��̽��
    protected int next(int i, int j) {
        int n = this.vexNum();
        if (i >= 0 && i < n && j >= -1 && j < n && i != j)// ��j=-1�ǣ�k��0��ʼѰ�Һ�̽��
            for (int k = j + 1; k < n; k++)
                if (this.matrix.get(i, k) > 0 && this.matrix.get(i, k) < MAX_WEIGHT)
                    return k;
        return -1;
    }

    // ������ȱ���
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
                //��������ɴ���δ������
                if(i == end) {
                    System.out.println("��" + i + "��·Ϊ��");
                    count ++;
                    for(j = 0; j < top; j++) {
                        System.out.print("->" + getVex(stack[j]));
                        if(j < top-1) {
                            dis += weight(stack[j], stack[j+1]);
                        }
                    }
                    dis += weight(stack[top-1], stack[end]);
                    System.out.println(getVex(end));
                    System.out.println("�ܳ���Ϊ��" + dis);
                }
                else {
                    DFSTraverse(i, end);
                    top--;
                    visited[i] = false;
                }
            }
        }
    }

    // �Ӷ���vi������һ�������������������һ����ͨ����;visitedָ�����ʱ�����飬�ݹ��㷨
    private void depthfs(int i, boolean[] visited) {
        System.out.print(this.getVex(i) + "->");// ���ʶ���vi
        visited[i] = true;// ���÷��ʱ��
        int j = this.next(i, -1);// ����vi�ĵ�һ���ڽӶ������
        while (j != -1) {// ��vi���ڵ�һ���ڽӶ���vj
            if (!visited[j])
                depthfs(j, visited);// ��vj�������еݹ����������ȱ���
            j = this.next(i, j);
        }
    }

    // ������ȱ���
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
            i = que.poll();// ���ӣ��Զ�ת����int
            for (int j = next(i, -1); j != -1; j = next(i, j))
                if (!visited[j]) {
                    System.out.print(this.getVex(j) + "->");
                    visited[j] = true;
                    que.add(j);
                }
        }
    }

    // ��Դ���·��,Dijkstra�㷨
    public void shortestPathDIJ(int i) {
        int n = this.vexNum();
        boolean[] vset = new boolean[n];// ��������·���ļ��ϣ���ֵȫΪfalse
        vset[i] = true;// ���Դ��vi�ڼ���S��
        int[] dist = new int[n];// ���·������
        int[] path = new int[n];// ���·�����յ��ǰһ������
        // ��ʼ��dist��path����
        for (int j = 0; j < n; j++) {
            dist[j] = this.weight(i, j);
            path[j] = (j != i && dist[j] < MAX_WEIGHT) ? i : -1;
        }
        // Ѱ�Ҵ�vi��vj�����·��,vj��V-S������
        for (int j = (i + 1) % n; j != i; j = (j + 1) % n) {
            int mindist = MAX_WEIGHT, min = 0;// ��·��������Сֵ�����±�
            for (int k = 0; k < n; k++)
                if (!vset[k] && dist[k] < mindist) {
                    mindist = dist[k];
                    min = k;
                }
            if (mindist == MAX_WEIGHT)
                break;
            vset[min] = true;// ȷ��һ�����·��(vi,min),�յ�min���뼯��S
            for (int k = 0; k < n; k++)
                if (!vset[k] && this.weight(min, k) < MAX_WEIGHT && dist[min] + this.weight(min, k) < dist[k]) {
                    dist[k] = dist[min] + this.weight(min, k);// �ø���·���滻
                    path[k] = min;// ���·������min����
                }
        }
        // �������vi�ĵ�Դ���·��
        System.out.print(this.getVex(i) + "����ĵ�Դ���·����\n");
        for (int j = 0; j < n; j++)
            if (j != i) {
                // ·����������¼���·�������ĸ����㣬���ڷ���
                SinglyList<T> pathlink = new SinglyList<T>();
                pathlink.insert(0, this.getVex(j));// ������������·���յ�vj
                for (int k = path[j]; k != i && k != j && k != -1; k = path[k])
                    pathlink.insert(0, this.getVex(k));// ��������뾭���Ķ��㣬����
                pathlink.insert(0, this.getVex(i));// ���·�������

                System.out.print(pathlink.toString() + "����" + (dist[j] == MAX_WEIGHT ? "��" : dist[j]) + "\n");
            }
        System.out.println();
    }

    // ����������·��,Dijkstra�㷨
    public void shortestPathDIJ(int i, int end) {
        int n = this.vexNum();
        boolean[] vset = new boolean[n];// ��������·���ļ��ϣ���ֵȫΪfalse
        vset[i] = true;// ���Դ��vi�ڼ���S��
        int[] dist = new int[n];// ���·������
        int[] path = new int[n];// ���·�����յ��ǰһ������
        // ��ʼ��dist��path����
        for (int j = 0; j < n; j++) {
            dist[j] = this.weight(i, j);
            path[j] = (j != i && dist[j] < MAX_WEIGHT) ? i : -1;
        }
        // Ѱ�Ҵ�vi��vj�����·��,vj��V-S������
        for (int j = (i + 1) % n; j != i; j = (j + 1) % n) {
            int mindist = MAX_WEIGHT, min = 0;// ��·��������Сֵ�����±�
            for (int k = 0; k < n; k++)
                if (!vset[k] && dist[k] < mindist) {
                    mindist = dist[k];
                    min = k;
                }
            if (mindist == MAX_WEIGHT)
                break;
            vset[min] = true;// ȷ��һ�����·��(vi,min),�յ�min���뼯��S
            for (int k = 0; k < n; k++)
                if (!vset[k] && this.weight(min, k) < MAX_WEIGHT && dist[min] + this.weight(min, k) < dist[k]) {
                    dist[k] = dist[min] + this.weight(min, k);// �ø���·���滻
                    path[k] = min;// ���·������min����
                }
        }
        // �������vi�ĵ�Դ���·��
        System.out.print(this.getVex(i) + "��" + this.getVex(end) + "�����·��Ϊ��\n");
        for (int j = 0; j < n; j++)
            if (j != i) {
                // ·����������¼���·�������ĸ����㣬���ڷ���
                SinglyList<T> pathlink = new SinglyList<T>();
                pathlink.insert(0, this.getVex(j));// ������������·���յ�vj
                for (int k = path[j]; k != i && k != j && k != -1; k = path[k])
                    pathlink.insert(0, this.getVex(k));// ��������뾭���Ķ��㣬����
                pathlink.insert(0, this.getVex(i));// ���·�������
                if (j == end)
                    System.out.println(pathlink.toString() + "��·��Ϊ��" + (dist[j] == MAX_WEIGHT ? "��" : dist[j]));
            }
        System.out.println();
    }

    // ����������·��,Floyd�㷨
    public void shortestPathFloyd(int start,int end) {
        int n=this.vexNum();
        Matrix path=new Matrix(n),dist=new Matrix(n);//���·�����󼰳��Ⱦ���
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++) {
                int w=this.weight(i, j);
                dist.set(i, j, w);
                path.set(i, j, (i!=j&&w<MAX_WEIGHT?i:-1));
            }
        for(int k=0;k<n;k++) {//��vk��Ϊ����·�����м䶥��
            for(int i=0;i<n;i++) {//����ÿ�Դ�vi��vj·�������Ƿ����
                if(i!=k) {
                    for(int j=0;j<n;j++) {
                        if(j!=k&&j!=i&&dist.get(i, j)>dist.get(i, k)+dist.get(k, j)) {//�����̣����滻
                            dist.set(i, j, dist.get(i, k)+dist.get(k, j));
                            path.set(i,j,path.get(k, j));
                        }
                    }
                }
            }
        }
        System.out.println(start+"��"+end+"֮������·��Ϊ��");
        if(start!=end)
            System.out.println(toPath(path,start,end)+"��·��Ϊ��"+(dist.get(start,end)==MAX_WEIGHT?"��":dist.get(start, end)));
        System.out.println();
    }

    private String toPath(Matrix path,int i,int j) {
        SinglyList<T> pathlink=new SinglyList<T>();//�������¼���·���������㣬���ڷ���
        pathlink.insert(0,this.getVex(j));//������������·���յ�vj
        for(int k=path.get(i,j);k!=i&&k!=j&&k!=-1;k=path.get(i, k))
            pathlink.insert(0,this.getVex(k));//������ͷ���뾭���Ķ��㣬����
        pathlink.insert(0,this.getVex(i));
        return pathlink.toString();
    }
}