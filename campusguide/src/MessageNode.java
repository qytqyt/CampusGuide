//��������
import java.util.*;
public class MessageNode{
    public String name;//��ž�������
    public String num;//��ž������
    public String introduction;//��ž�����
    public MessageNode() {
        this(null,null,null);
    }
    public MessageNode(String name,String num,String introduction) {
        this.name=name;
        this.num=num;
        this.introduction=introduction;
    }
    public MessageNode(Scanner sc) {
        this(sc.next(),sc.next(),sc.next());
    }
    public String toString() {
        return this.name;
    }
}