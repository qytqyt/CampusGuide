public class Triple implements Comparable<Triple>{  //稀疏矩阵三元组类，存储图带权值的边
    int row, col, value;

    public Triple(int row, int col, int value) {
        if(row >= 0 && col >= 0) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
        else throw new IllegalArgumentException("行、列号不能为负数! row="+row+",col="+col);
    }

    public Triple(Triple triple) {    //复制一个三元组
        this(triple.row,triple.col,triple.value);
    }


    public String toString() {      //重写带权值边类的toString方法
        return "(" + row + "," + col + "," + value + ")";
    }
    //根据行列位置比较三元组对象大小,与元素值无关,约定三元组排序次序
    public int compareTo(Triple triple) {
        if(this.row == triple.row && this.col == triple.col)
            return 0;
        return (this.row < triple.row || this.row == triple.row && this.col < triple.col) ? -1 : 1;
    }
    //加法
    public void add(Triple term) {
        if(this.compareTo(term)==0)
            this.value+=term.value;
        else throw new IllegalArgumentException("两项的指数不同，不能相加");
    }
    //约定删除元素条件
    public boolean removable() {
        return this.value==0;
    }
}
