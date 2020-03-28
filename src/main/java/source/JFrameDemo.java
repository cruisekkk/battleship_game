package source;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
public class JFrameDemo extends JFrame
{
    public JFrameDemo()
    {
        /*setTitle("Battleship Game");    //设置显示窗口标题
        setSize(400,200);    //设置窗口显示尺寸
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //置窗口是否可以关闭
        JLabel jl=new JLabel("于总我猜你能看见了");    //创建一个标签
        Container c=getContentPane();    //获取当前窗口的内容窗格
        c.add(jl);    //将标签组件添加到内容窗格上
        setVisible(true);    //设置窗口是否可见*/

//        JFrame jFrame=new JFrame("Java第四个GUI程序");    //创建Frame窗口
//        JPanel jPanel=new JPanel();    //创建面板
//        JButton btn1=new JButton("1");    //创建按钮
//        JButton btn2=new JButton("2");
//        JButton btn3=new JButton("3");
//        JButton btn4=new JButton("4");
//        JButton btn5=new JButton("5");
//        JButton btn6=new JButton("6");
//        JButton btn7=new JButton("7");
//        JButton btn8=new JButton("8");
//        JButton btn9=new JButton("9");
//        jPanel.add(btn1);    //面板中添加按钮
//        jPanel.add(btn2);
//        jPanel.add(btn3);
//        jPanel.add(btn4);
//        jPanel.add(btn5);
//        jPanel.add(btn6);
//        jPanel.add(btn7);
//        jPanel.add(btn8);
//        jPanel.add(btn9);
//        //向JPanel添加FlowLayout布局管理器，将组件间的横向和纵向间隙都设置为20像素
//        //jPanel.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
//        jPanel.setBackground(Color.gray);    //设置背景色
//        jFrame.add(jPanel);    //添加面板到容器
//        jFrame.setBounds(300,200,300,150);    //设置容器的大小
//        jFrame.setVisible(true);
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        /*JFrame frame=new JFrame("Battleship Game");    //创建Frame窗口
        JPanel p1=new JPanel();    //面板1
        JPanel p2=new JPanel();    //面板2
        JPanel cards=new JPanel(new CardLayout());    //卡片式布局的面板
        p1.add(new JButton("人人模式"));
        p1.add(new JButton("人机模式"));
        p1.add(new JButton("滚你妈，不玩"));
        p2.add(new JTextField("用户名文本框",20));
        p2.add(new JTextField("密码文本框",20));
        p2.add(new JTextField("验证码文本框",20));
        cards.add(p1,"card1");    //向卡片式布局面板中添加面板1
        cards.add(p2,"card2");    //向卡片式布局面板中添加面板2
        CardLayout cl=(CardLayout)(cards.getLayout());
        cl.show(cards,"card2");    //调用show()方法显示面板2
        frame.add(cards);
        frame.setBounds(300,200,400,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/


        JFrame frame=new JFrame("GridLayou布局计算器");
        JPanel panel=new JPanel();    //创建面板
        //指定面板的布局为GridLayout，4行4列，间隙为5
        panel.setLayout(new GridLayout(20,10,1,1));
        for (int i = 0; i < 200; ++i) {
            panel.add(new JButton(" "));    //添加按钮
        }
        frame.add(panel);    //添加面板到容器
        frame.setBounds(300,200,200,150);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}