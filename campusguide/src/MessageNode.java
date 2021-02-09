//景点结点类
import java.util.*;
public class MessageNode{
    public String name;//存放景点名称
    public String num;//存放景点代号
    public String introduction;//存放景点简介
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