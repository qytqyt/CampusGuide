package views;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;
public class MainFrm {
    public MainFrm() {
        //ѡ�1��� --- У԰��ͼһ��
        JLabel label1 = new JLabel();
        label1.setIcon(new ImageIcon("images/map.jpg"));

        //ѡ�2��� --- ������Ϣ��ѯ


        JFrame jf = new JFrame();
        jf.setTitle("У԰���γ���");
        jf.setSize(852, 680);
        jf.setLocationRelativeTo(null);		//���ھ�����ʾ
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        Container c = jf.getContentPane();

        JTabbedPane tabbedPane = new JTabbedPane();// ����һ��Ĭ�ϵ�ѡ����
        JPanel panel1 = new JPanel(new FlowLayout());
        panel1.add(label1);

        JPanel panel2 = new JPanel(null);


        // ����ǩ�����ӵ�ѡ���
        tabbedPane.addTab("У԰ƽ��ͼһ��", panel1);
        tabbedPane.addTab("������Ϣ��ѯ", panel2);

        c.add(tabbedPane);
        jf.setVisible(true);
    }
}