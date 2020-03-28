package source;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameDemo extends JFrame {
    public int MODE;
    JButton button1 = new JButton(" human vs human");
    JFrameDemo() {
        JFrame frame = new JFrame("BattleShip game");    //创建Frame窗口
        JPanel p1 = new JPanel();    //面板1
        JPanel p2 = new JPanel();    //面板2
        JPanel cards = new JPanel(new CardLayout());    //卡片式布局的面板

        button1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("fyckkkkckckckck");
                MODE = 1;
                System.out.println(MODE);
            }
        });

        p1.add(button1);
        p1.add(new JButton(" human vs computer"));
        p1.add(new JButton(" quit"));
        p2.add(new JTextField("用户名文本框", 20));
        p2.add(new JTextField("密码文本框", 20));
        p2.add(new JTextField("验证码文本框", 20));
        cards.add(p1, "card1");    //向卡片式布局面板中添加面板1
        cards.add(p2, "card2");    //向卡片式布局面板中添加面板2
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "card1");    //调用show()方法显示面板2
        frame.add(cards);
        frame.setBounds(300, 200, 400, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}












//    JList list;
//    JLabel label;
//    JButton button1;
//    int clicks = 0;
//
//    public JFrameDemo() {
//        setTitle("动作事件监听器示例");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(100, 100, 400, 200);
//        JPanel contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        contentPane.setLayout(new BorderLayout(0, 0));
//        setContentPane(contentPane);
//        label = new JLabel(" ");
//        label.setFont(new Font("楷体", Font.BOLD, 16));    //修改字体样式
//        contentPane.add(label, BorderLayout.SOUTH);
//        button1 = new JButton("我是普通按钮");    //创建JButton对象
//        button1.setFont(new Font("黑体", Font.BOLD, 16));    //修改字体样式
//        button1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                label.setText("按钮被单击了 " + (clicks++) + " 次");
//            }
//        });
//        contentPane.add(button1);
//    }

    //处理按钮单击事件的匿名内部类
    //class button1ActionListener implements ActionListener {
     //   @Override
      //  public void actionPerformed(ActionEvent e) {
      //      label.setText("按钮被单击了 " + (clicks++) + " 次");
       // }
   // }
//        public static void main(String[] args)
//        {
//            ActionListenerDemo frame=new ActionListenerDemo();
//            frame.setVisible(true);
//        }
//}