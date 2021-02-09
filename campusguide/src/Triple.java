public class Triple implements Comparable<Triple>{  //ϡ�������Ԫ���࣬�洢ͼ��Ȩֵ�ı�
    int row, col, value;

    public Triple(int row, int col, int value) {
        if(row >= 0 && col >= 0) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
        else throw new IllegalArgumentException("�С��кŲ���Ϊ����! row="+row+",col="+col);
    }

    public Triple(Triple triple) {    //����һ����Ԫ��
        this(triple.row,triple.col,triple.value);
    }


    public String toString() {      //��д��Ȩֵ�����toString����
        return "(" + row + "," + col + "," + value + ")";
    }
    //��������λ�ñȽ���Ԫ������С,��Ԫ��ֵ�޹�,Լ����Ԫ���������
    public int compareTo(Triple triple) {
        if(this.row == triple.row && this.col == triple.col)
            return 0;
        return (this.row < triple.row || this.row == triple.row && this.col < triple.col) ? -1 : 1;
    }
    //�ӷ�
    public void add(Triple term) {
        if(this.compareTo(term)==0)
            this.value+=term.value;
        else throw new IllegalArgumentException("�����ָ����ͬ���������");
    }
    //Լ��ɾ��Ԫ������
    public boolean removable() {
        return this.value==0;
    }
}
