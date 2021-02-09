package views;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class EnterFrm extends JFrame{

    private ImageIcon background = new ImageIcon("images/bg.jpg");
    private JPanel myPanel = (JPanel)this.getContentPane();
    private JLabel label = new JLabel(background);//用于放标签
    private JLabel label1 = new JLabel("欢迎来到校园导游程序！");
    private JButton btn = new JButton("进入");
    public static void main(String[] args) {
        new EnterFrm();
    }
    public EnterFrm()
    {
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setFont(new Font("楷体", 1, 54));
        label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());	//把标签设置为和图片等高等宽
        myPanel.setOpaque(false);					//把我的面板设置为不可视
        myPanel.setLayout(new FlowLayout(1, 200, 160));		//把我的面板设置为流动布局
        this.getLayeredPane().setLayout(null);		//把分层面板的布局置空
        myPanel.add(label1);
        myPanel.add(btn);	//把按钮添加到我的面板里
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));		//把标签添加到分层面板的最底层
        this.setTitle("校园导游程序");
        this.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        btn.addActionListener(new ActionListener() {		//进入按钮
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