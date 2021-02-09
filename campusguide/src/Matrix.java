//矩阵类
public class Matrix{
    private int rows,cols;//矩阵的行数、列数
    private int[][] element;
    //构造m*n零矩阵
    public Matrix(int m,int n) {
        this.element=new int[m][n];
        this.rows=m;
        this.cols=n;
    }
    //构造n*n零矩阵
    public Matrix(int n) {
        this(n,n);
    }
    public Matrix(int m,int n,int[][] value) {
        this(m,n);
        for(int i=0;i<value.length&&i<m;i++)
            for(int j=0;j<value[i].length;j++)
                this.element[i][j]=value[i][j];
    }
    //返回矩阵行数
    public int getRows() {
        return this.rows;
    }
    //返回矩阵列数
    public int getCols() {
        return this.cols;
    }
    //获取元素
    public int get(int i,int j) {
        if(i>=0&&i<this.rows&&j>=0&&j<this.cols)
            return this.element[i][j];
        throw new IndexOutOfBoundsException("i="+i+",j="+j);
    }
    //设置元素
    public void set(int i,int j,int x) {
        if(i>=0&&i<this.rows&&j>=0&&j<this.cols) {
            this.element[i][j]=x;
        }
        else throw new IndexOutOfBoundsException("i="+i+",j="+j);
    }
    //返回矩阵元素描述字符串
    public String toString() {
        String str="矩阵"+this.getClass().getName()+"("+this.rows+"*"+this.cols+"):\n";
        for(int i=0;i<this.rows;i++) {
            for(int j=0;j<this.cols;j++)
                str+=String.format("%8d", this.element[i][j]);//十进制整数占六列
            str+="\n";
        }
        return str;
    }
    //矩阵扩容
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
            throw new IllegalArgumentException("矩阵行列数不能<=0,m="+m+",n="+n);
    }
}