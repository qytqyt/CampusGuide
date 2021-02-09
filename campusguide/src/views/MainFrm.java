package views;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;
public class MainFrm {
    public MainFrm() {
        //选项卡1组件 --- 校园地图一览
        JLabel label1 = new JLabel();
        label1.setIcon(new ImageIcon("images/map.jpg"));

        //选项卡2组件 --- 景点信息查询


        JFrame jf = new JFrame();
        jf.setTitle("校园导游程序");
        jf.setSize(852, 680);
        jf.setLocationRelativeTo(null);		//窗口居中显示
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        Container c = jf.getContentPane();

        JTabbedPane tabbedPane = new JTabbedPane();// 创建一个默认的选项卡面板
        JPanel panel1 = new JPanel(new FlowLayout());
        panel1.add(label1);

        JPanel panel2 = new JPanel(null);


        // 将标签组件添加到选项卡中
        tabbedPane.addTab("校园平面图一览", panel1);
        tabbedPane.addTab("景点信息查询", panel2);

        c.add(tabbedPane);
        jf.setVisible(true);
    }
}