package views;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class EnterFrm extends JFrame{

    private ImageIcon background = new ImageIcon("images/bg.jpg");
    private JPanel myPanel = (JPanel)this.getContentPane();
    private JLabel label = new JLabel(background);//���ڷű�ǩ
    private JLabel label1 = new JLabel("��ӭ����У԰���γ���");
    private JButton btn = new JButton("����");
    public static void main(String[] args) {
        new EnterFrm();
    }
    public EnterFrm()
    {
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setFont(new Font("����", 1, 54));
        label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());	//�ѱ�ǩ����Ϊ��ͼƬ�ȸߵȿ�
        myPanel.setOpaque(false);					//���ҵ��������Ϊ������
        myPanel.setLayout(new FlowLayout(1, 200, 160));		//���ҵ��������Ϊ��������
        this.getLayeredPane().setLayout(null);		//�ѷֲ����Ĳ����ÿ�
        myPanel.add(label1);
        myPanel.add(btn);	//�Ѱ�ť��ӵ��ҵ������
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));		//�ѱ�ǩ��ӵ��ֲ�������ײ�
        this.setTitle("У԰���γ���");
        this.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        btn.addActionListener(new ActionListener() {		//���밴ť
            @Override
            public void actionPerformed(ActionEvent e) {
                btnClicked();
            }
        });
    }
    private void btnClicked() {
        new MainFrm();
        this.setVisible(false);
    }
}