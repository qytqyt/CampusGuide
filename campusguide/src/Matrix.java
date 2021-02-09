//������
public class Matrix{
    private int rows,cols;//���������������
    private int[][] element;
    //����m*n�����
    public Matrix(int m,int n) {
        this.element=new int[m][n];
        this.rows=m;
        this.cols=n;
    }
    //����n*n�����
    public Matrix(int n) {
        this(n,n);
    }
    public Matrix(int m,int n,int[][] value) {
        this(m,n);
        for(int i=0;i<value.length&&i<m;i++)
            for(int j=0;j<value[i].length;j++)
                this.element[i][j]=value[i][j];
    }
    //���ؾ�������
    public int getRows() {
        return this.rows;
    }
    //���ؾ�������
    public int getCols() {
        return this.cols;
    }
    //��ȡԪ��
    public int get(int i,int j) {
        if(i>=0&&i<this.rows&&j>=0&&j<this.cols)
            return this.element[i][j];
        throw new IndexOutOfBoundsException("i="+i+",j="+j);
    }
    //����Ԫ��
    public void set(int i,int j,int x) {
        if(i>=0&&i<this.rows&&j>=0&&j<this.cols) {
            this.element[i][j]=x;
        }
        else throw new IndexOutOfBoundsException("i="+i+",j="+j);
    }
    //���ؾ���Ԫ�������ַ���
    public String toString() {
        String str="����"+this.getClass().getName()+"("+this.rows+"*"+this.cols+"):\n";
        for(int i=0;i<this.rows;i++) {
            for(int j=0;j<this.cols;j++)
                str+=String.format("%8d", this.element[i][j]);//ʮ��������ռ����
            str+="\n";
        }
        return str;
    }
    //��������
    public void setRowsCols(int m,int n) {
        if(m>0&&n>0) {
            if(m>this.element.length||n>this.element[0].length) {
                int[][]source=this.element;
                this.element=new int[m][n];
                for(int i=0;i<this.rows;i++)
                    for(int j=0;j<this.cols;j++)
                        this.element[i][j]=source[i][j];
            }
            this.rows=m;
            this.cols=n;
        }
        else
            throw new IllegalArgumentException("��������������<=0,m="+m+",n="+n);
    }
}