public class GenerateGraph{
    public static final int INFINITY=Integer.MAX_VALUE;
    public static MatrixGraph<MessageNode> generateGraph() {
        MessageNode[] vexs= {new MessageNode("ͼ����Ϣ����","A0" ,"ͼ������Ϻ�������ѧ�ĵر��Խ����������ڶ�" ),
                new MessageNode("һ�Ź�����ѧ¥","A1" ,"һ�Ź�����ѧ¥��Ҫ�ṩ�������ң�ʦ���ɽ����ϻ���ѧ" ),
                new MessageNode("���Ź�����ѧ¥","A2" ,"���Ź�����ѧ¥��ҪΪ���������ѧ���ṩ�Ͽν���" ),
                new MessageNode("���Ź�����ѧ¥","A3" ,"���Ź�����ѧ¥��ҪΪ��һѧ���ṩ�Ͽν���" ),
                new MessageNode("�ܻ�ѧԺ","A4" ,"�ܻ�ѧԺ���ܼ�ѧԺѧԺ¥��5���������ѧԺ���Զ���ѧԺ��������" ),
                new MessageNode("ѧ��������ѧ����������","A5" ,"ѧ��������ѧ�����������ǽ��񴦡��װ��ѧ���������ģ������ٰ콲���" ),
                new MessageNode("����ʳ��","A6" ,"����ʳ���ܱ߻��������������ʳ�õ��ṩ��ͬ��ζ�ķ��ˣ�3��Ϊ����" ),
                new MessageNode("ѧ�������","B0" ,"ѧ���������ѧ���ٰ������̨��ĵط�" ),
                new MessageNode("����/�����ѧԺ","B1" ,"����/�����ѧԺ�ǵ���ѧԺ�ͼ����ѧԺ��ѧԺ¥���л�����ʵ���ҵ�" ),
                new MessageNode("����ѧԺ","B2" ,"����ѧԺ������ѧԺ��ѧԺ¥��������������ʵ����" ),
                new MessageNode("����/����/����ѧԺ","B3" ,"����/����/����ѧԺ�Ǿ���ѧԺ������ѧԺ������ѧԺ��ѧԺ¥" ),
                new MessageNode("����ѧԺ","B4" ,"����ѧԺ�ǻ���ѧԺ��ѧԺ¥" ),
                new MessageNode("��ѧ��/��ʦ����","B5" ,"��ѧ��/��ʦ����" ),
                new MessageNode("ѧ����Ԣ1","C1~4" ,"ѧ����Ԣ1��ҪΪ����������ѧ�����ޡ������������ѧ��Ů��" ),
                new MessageNode("ѧ����Ԣ2","C5~9" ,"ѧ����Ԣ2��ҪΪ��һ���ѧ�����ޡ���һŮ�޺��о�������" ),
                new MessageNode("һ��ʳ��","C10" ,"һ��ʳ������¥��һ¥��¥��ҪΪ��ͣ���¥Ϊ��ɫ����" ),
                new MessageNode("������","C11" ,"������" ),
                new MessageNode("�ۺ�������","D1" ,"�ۺ������������㣬����ƹ���򳡡�����ݵȣ���һ¥Ϊ����" ),
                new MessageNode("��������̨","D2" ,"��������̨Ϊ¶�������������Թۿ������������������ݵ�" ),
                new MessageNode("�ٸ���У������ָ�Ӳ�","E1" ,"�ٸ���У������ָ�Ӳ���У������ָ�Ӳ�" ),
                new MessageNode("���´�ҵ����ѵ������","E2" ,"���´�ҵ����ѵ��������ѧ�����й���ʵѵ�ĵط�" ),
                new MessageNode("��Դ����/������","E3" ,"��Դ����/��������ѧУ����Դ�ܿ�����" ),
        };

        Triple edge[]= {
                new Triple(0,1,372),new Triple(0,2,193),new Triple(0,3,171),new Triple(0,4,442),new Triple(0,5,127),new Triple(0,6,397),new Triple(0,7,679),new Triple(0,10,1152),new Triple(0,11,1753),new Triple(0,12,1548),new Triple(0,19,794),
                new Triple(1,0,372),new Triple(1,2,73),new Triple(1,3,236),new Triple(1,4,999),new Triple(1,13,236),new Triple(1,15,563),new Triple(1,17,468),new Triple(1,18,503),new Triple(1,19,628),new Triple(1,20,980),new Triple(1,21,1006),
                new Triple(2,0,193),new Triple(2,1,73),new Triple(2,3,56),new Triple(2,13,113),new Triple(2,15,168),
                new Triple(3,0,171),new Triple(3,1,236),new Triple(3,2,56),new Triple(3,6,603),new Triple(3,7,393),new Triple(3,13,399),new Triple(3,15,80),new Triple(3,16,674),
                new Triple(4,0,442),new Triple(4,1,999),new Triple(4,5,68),new Triple(4,19,1577),new Triple(4,20,1123),new Triple(4,21,1276),
                new Triple(5,0,127),new Triple(5,4,68),new Triple(5,6,93),
                new Triple(6,0,397),new Triple(6,3,603),new Triple(6,5,93),new Triple(6,10,1234),new Triple(6,11,983),new Triple(6,12,1192),
                new Triple(7,0,679),new Triple(7,3,393),new Triple(7,8,199),new Triple(7,10,498),new Triple(7,14,293),new Triple(7,15,472),new Triple(7,16,167),
                new Triple(8,7,199),new Triple(8,9,133),new Triple(8,10,368),new Triple(8,14,169),
                new Triple(9,8,133),new Triple(9,10,265),new Triple(9,14,325),
                new Triple(10,0,1152),new Triple(10,6,1234),new Triple(10,7,498),new Triple(10,8,368),new Triple(10,9,265),new Triple(10,11,212),new Triple(10,12,598),
                new Triple(11,0,1753),new Triple(11,6,983),new Triple(11,10,212),new Triple(11,12,177),
                new Triple(12,0,1548),new Triple(12,6,1192),new Triple(12,10,598),new Triple(12,11,177),
                new Triple(13,1,236),new Triple(13,2,113),new Triple(13,3,399),new Triple(13,15,76),new Triple(13,17,283),new Triple(13,18,203),
                new Triple(14,7,293),new Triple(14,8,169),new Triple(14,9,325),new Triple(14,16,75),
                new Triple(15,1,563),new Triple(15,2,168),new Triple(15,3,80),new Triple(15,7,472),new Triple(15,13,76),new Triple(15,16,193),
                new Triple(16,3,674),new Triple(16,7,167),new Triple(16,14,75),new Triple(16,15,193),
                new Triple(17,1,468),new Triple(17,13,283),new Triple(17,18,60),new Triple(17,19,783),
                new Triple(18,1,503),new Triple(18,13,203),new Triple(18,17,60),new Triple(18,19,487),
                new Triple(19,0,794),new Triple(19,1,628),new Triple(19,4,1577),new Triple(19,17,783),new Triple(19,18,487),new Triple(19,20,65),new Triple(19,21,287),
                new Triple(20,1,980),new Triple(20,4,1123),new Triple(20,19,65),new Triple(20,21,136),
                new Triple(21,1,1006),new Triple(21,4,1276),new Triple(21,19,287),new Triple(21,20,136)
        };
        MatrixGraph<MessageNode> G=new MatrixGraph<>(vexs,edge);
        return G;
    }
}