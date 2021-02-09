public abstract class AbstractGraph<T> {
    protected static final int MAX_WEIGHT = 0x0000ffff; //��ʾ���������Ȩֵ
    protected SeqList<T> vex;   //����˳������ڴ洢ͼ�Ķ��㼯��

    public AbstractGraph(int length) {   //�����ͼ,lengthΪ��ָ����˳�������
        this.vex = new SeqList<T>(length);
    }

    public AbstractGraph() {
        this(99);
    }

    public int vexNum() {           //���ظ�ͼ�Ķ�����
        return this.vex.size();
    }

    public String toString() {      //��д���㼯�ϵ�toString����
        return "��ͼ�Ķ��㼯��Ϊ:" + this.vex.toString() + "\n";
    }

    public T getVex(int i) {        //���ض���Ԫ��
        return this.vex.get(i);
    }

    public void setVex(int i, T x){ //���ö���vi��Ԫ��Ϊx
        this.vex.set(i, x);
    }

    public abstract void insertEdge(int i, int j, int weight);//�����

    public abstract int insertVex(T x);    //���붥��

    public abstract void removeEdge(int i, int j) ;    //ɾ����

    public abstract void removeVex(int i);    //ɾ������

    public abstract int weight(int i,int j);    //����Ȩֵ

    protected abstract int next(int i,int j);    //���ڽӶ������

    public abstract void BFSTraverse(int i);    //������ȱ���

    public abstract void shortestPathDIJ(int i);    // ��Դ���·��,Dijkstra�㷨

    public abstract void shortestPathDIJ(int i, int end) ;    // ����������·��,Dijkstra�㷨

    public abstract void shortestPathFloyd(int start,int end);    // ����������·��,Floyd�㷨
}
