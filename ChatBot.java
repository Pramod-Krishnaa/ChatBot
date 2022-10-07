package ChatBot;

import java.awt.Image;
import java.io.IOException;
//import java.net.URL;
import javax.imageio.ImageIO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
//import java.awt.geom.*;
//import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
//import javax.swing.border.Border;
import javax.swing.*;

public class ChatBot extends JFrame implements ActionListener {
	static final String DB_URL="jdbc:mysql://localhost:3306/datalog";
    static final String USER="root";
    static final String PASS="password";
	static JTextArea area = new JTextArea();
	static JProgressBar pb = new JProgressBar(JProgressBar.HORIZONTAL);
    static int progress;
	JTextField field = new JTextField();
	JLabel jlb = new JLabel();
	JScrollPane sp;
	JButton send;
	LocalTime time = LocalTime.now();
	LocalDate date = LocalDate.now();
	Random random = new Random();
	

	public ChatBot() {
		super("TechNo ");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		getContentPane().setBackground(Color.BLACK);
		// put("JFrame.activeTitleBackground", Color.BLACK);
		Image image = null;
        try {
            URL url = new URL("https://telegram.org/file/811140058/2/7GzMJk4Ij54/a1649c56fa9f805828");
            image = ImageIO.read(url);
        } catch (IOException e) {
        	e.printStackTrace();
        }
		setIconImage(image);
		field = new JTextField();
		send = new JButton(">");
		send.setFont(new Font("Jokerman", Font.BOLD, 25));
		//send.setBorder(new RoundedBorder(10));
		send.setBackground(Color.BLACK);
		send.setForeground(Color.RED);
		send.setBounds(735, 520, 50, 35);
		send.setBorderPainted(false);
		
		add(send);
		
		// For Text area
		area.setEditable(false);
		area.setBorder(BorderFactory.createLineBorder(Color.RED));
		area.setBackground(Color.BLACK);
		area.setForeground(Color.RED);
		add(area);
		area.setFont(new Font("Serif", Font.PLAIN, 18));
		// scrollbar
		sp = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.getVerticalScrollBar().setBackground(Color.BLACK);
		sp.getVerticalScrollBar().setForeground(Color.RED);
		sp.getHorizontalScrollBar().setBackground(Color.BLACK);
		sp.getHorizontalScrollBar().setForeground(Color.RED);
		sp.getViewport().getView().setBackground(Color.BLACK);
		sp.getViewport().getView().setForeground(Color.RED);
		sp.setBounds(10, 20, 775, 470);
		sp.setBorder(BorderFactory.createLineBorder(Color.RED));
		add(sp);

		// For TextField
		field.setSize(715, 35);
		field.setLocation(10, 520);
		// field.setOpaque(false);
		field.setForeground(Color.RED);
		field.setBackground(Color.BLACK);
		field.setFont(new Font("Serif", Font.BOLD, 25));
		field.setBorder(BorderFactory.createLineBorder(Color.RED));
		add(field);

		send.addActionListener(this);
		getRootPane().setDefaultButton(send);

	}

	public void db(){

		try{
            Connection conn= DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt =conn.createStatement();
            String sql="Show databases";
            stmt.execute(sql);
            System.out.println("Successfully ...");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
	}

	public void actionPerformed(ActionEvent e) {
		String message = field.getText().toLowerCase();

		area.append("You : " + field.getText() + "\n");
		field.setText("");
		//Socket sock = new Socket();
        
		if (message.contains("how are you")) {
			int num = random.nextInt(3);
			if (num == 0) {
				bot("I'm fine !,What about you ? ");
			} else if (num == 1) {
				bot("I am good , thanks for asking !");
			} else {
				bot("I am great ,thanks for asking !");
			}
			bot("How can I help you");

		} else if (message.contains("you") && (message.contains("smart") || message.contains("good"))) {
			bot("Thank you !");
		} else if (message.contains("welcome")) {
			bot("You are so polite.How can i help you ?");
		}
        
		else if(message.contains("i'm")&&(message.contains("good")||message.contains("fine"))){
			bot("Nice to hear..");
			bot("How can I help you?");
		}
		else if (message.contains("hi") && message.charAt(0) == 'h' || message.contains("hello")
				|| message.contains("hey")) {

			int num = random.nextInt(4);
			if (num == 0) {
				bot("Whatsup dude");
			} else if (num == 1) {
				bot("Hello");
			} else if (num == 2) {
				bot("Heyy");
			} else if (num == 3) {
				bot("Hello buddy");
			}else{
				bot("Hii");
			}
		}
        
		else if(message.contains("love")&& message.contains("you")){
			bot("No wonder! If I was you, I'd love me too ;))");
		}

		else if (message.contains("bye") || message.contains("by") || message.contains("bi")||message.contains("exit")) {
			bot("Bye,See you soon ..!");
			
			this.dispose();
		}

		else if (message.contains("gender")||message.contains("sex")) {
			bot("I'm Female.. But try not to flirt with me");
			//bot("I'm bit shy...");
		}

		else if (message.contains("i am good") || message.contains("i am great")
				|| message.contains("i am ") && message.contains("fine")) {

			bot("Good to hear.");
		} else if (message.contains("thank")) {
			int num = random.nextInt(4);
			if (num == 0) {
				bot("Welcome..");
			} else if (num == 1) {
				bot("My plesure");
			} else if (num == 2) {
				bot("Happy to help");
			} else if (num == 3) {
				bot("That's why i'm here for..");
			}
		} else if (message.contains("what") && message.contains("name")) {
			if (message.contains("your")) {
				bot("I'm TechNo Bot... I just wish that everyone had a nickname as cool as mine.");
			}
			if (message.contains("my")) {
				bot("Your name is Pramod8902");
			}
		} else if (message.contains("change")) {
			bot("Sorry,I can't change anything...");
			
		} else if (message.contains("time")) {

			String ctime = new String();
			if (time.getHour() > 12) {
				int hour = time.getHour() - 12;
				ctime = ctime + hour + ":" + time.getMinute() + ":" + time.getSecond() + " PM";
			}

			else {

				ctime = ctime + time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + " AM";
			}
			bot(ctime);

		} else if (message.contains("date") || message.contains("month") || message.contains("year")
				|| message.contains("day")) {

			String cdate = new String();
			cdate = cdate + date.getDayOfWeek() + "," + date.getDayOfMonth() + " " + date.getMonth() + " "
					+ date.getYear();
			bot(cdate);

		}else if(message.contains("your")&&message.contains("age")){
			bot("I was launched in 2022 on 02 of June, so technically I'm pretty young.");
			bot("But I've learned so much! I hope I'm wise beyond my years");
		}
		else if(message.contains("your")&&(message.contains("daddy")||message.contains("dad")||message.contains("father"))){
			bot("I'm Bot. I was Created. So I dont have a dad");
			// try {
			// 	Thread.sleep(200);
			// } catch (Exception te) {
			// 	te.printStackTrace();
			// }
			
		}
		else if ((message.contains("flip")||message.contains("toss"))&& message.contains("coin")) {
			int num = random.nextInt(2);
			if (num == 0) {
				bot("It's Heads..");
			} else {
				bot("It's Tails..");
			}
			
		}

		else if (message.contains("roll")&& (message.contains("die")||message.contains("dice"))) {
			int num = random.nextInt(5);
			if (num == 0) {
				bot("It's 1");
			}else if(num == 1){
				bot("It's 2");
			}else if(num == 2){
				bot("It's 3");
			}else if(num == 3){
				bot("It's 4");
			}else if(num == 4){
				bot("It's 5");
			}else {
				bot("It's Tails..");
			}
			
		}

		else if(message.contains("like")&&message.contains("me")){
			bot("Being helpful to you is the best part of my day ;)");
		}

		else if(message.contains("be")&& message.contains("friend")){
			bot("Of course, and friends don't let friends search alone");
		}

		else if (message.contains("good morning")) {

			bot("Good morning,Have a nice day !");

		} else if (message.contains("good night")) {

			bot("Good night,Have a nice dreams !");

		} else if (message.contains("good evening")) {

			bot("Good Evening ...!");

		} else if (message.contains("good") && message.contains("noon")) {

			bot("Good Afternoon ...!");

		}
		else if(message.contains("sing")&& message.contains("song")){
			bot("Here is me doing sur practise, Sa Re Ga Ma Pa Dha Ni sa .!.!.!");
		}
		
		else if((message.contains("play")||message.contains("open"))&& (message.contains("playlist")|| message.contains("spotify"))){
			bot("One Sec");
			try{
				try{
					URL url = new URL("https://google.co.in");
					URLConnection connection = url.openConnection();
					connection.connect();
					java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://open.spotify.com/?nd=1"));
				}catch(Exception ye){
					bot("Connect with internet connection for get better results...");
				}
			}catch (Exception eee) {
				int num = random.nextInt(3);
				if (num == 0) {

					bot("Sorry ,I can't understand you !");
				} else if (num == 1) {
					bot("Sorry,I don't understand ");
				} else if (num == 2) {
					bot("My apologies...I don't understand ");
				}
			}
		}

		else if (message.contains("sick")){
			bot("I'm sorry to hear that I hope you feel better soon");
			try{
				try{
					URL url= new URL("https://google.co.in");
					URLConnection connection= url.openConnection();
					connection.connect();
					java.awt.Desktop.getDesktop().browse(java.net.URI
							.create("http://www.google.com/search?hl=en&q=doctor+near+me&btnG=Google+Search"));
				} catch (Exception ee) {
					bot("Connect with internet connection for get better results...");
				}
			}catch (Exception eee) {
				int num = random.nextInt(3);
				if (num == 0) {

					bot("Sorry ,I can't understand you !");
				} else if (num == 1) {
					bot("Sorry,I don't understand ");
				} else if (num == 2) {
					bot("My apologies...I don't understand ");
				}
			}
		}

		else if (message.contains("clear") && (message.contains("screen") || message.contains("chat"))) {
			bot("wait a few second...");
			area.setText("");
		}
		else if (message.contains("hide")&& message.contains("body")) {
			bot("You should probably talk to your lawyer at this point :}");
		}

		
		

		else if (message.contains("go") && message.contains("out")) {
			try {
				try {
					bot("Where do you wish to go?");
					URL url = new URL("https://google.co.in");
					URLConnection connection = url.openConnection();
					connection.connect();
					bot("Here some results for you ...");
					java.awt.Desktop.getDesktop().browse(java.net.URI
							.create("http://www.google.com/search?hl=en&q=location+near+me&btnG=Google+Search"));

				} catch (Exception ee) {
					bot("Connect with internet connection for get better results...");
				}

			} catch (Exception eee) {
				int num = random.nextInt(3);
				if (num == 0) {

					bot("Sorry ,I can't understand you !");
				} else if (num == 1) {
					bot("Sorry,I don't understand ");
				} else if (num == 2) {
					bot("My apologies...I don't understand ");
				}
			}
		}

		else if (message.contains("mail") || message.contains("gmail")) {
			bot("One sec.. Openning your mail!!");
			try {
				try {
					
					URL url = new URL("https://google.co.in");
					URLConnection connection = url.openConnection();
					connection.connect();
					java.awt.Desktop.getDesktop()
							.browse(java.net.URI.create("https://mail.google.com/mail/u/1/#inbox"));

				} catch (Exception ee) {
					bot("Connect with internet connection for get better results...");
				}

			} catch (Exception eee) {
				int num = random.nextInt(3);
				if (num == 0) {

					bot("Sorry ,I can't understand you !");
				} else if (num == 1) {
					bot("Sorry,I don't understand ");
				} else if (num == 2) {
					bot("My apologies...I don't understand ");
				}
			}
		}

		else {
			try {
				try {
					URL url = new URL("https://google.co.in");
					URLConnection connection = url.openConnection();
					connection.connect();
					bot("Here some results for you ...");
					java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://www.google.com/search?hl=en&q="
							+ message.replace(" ", "+") + "&btnG=Google+Search"));

				} catch (Exception ee) {
					bot("Connect with internet connection for get better results...");
				}

			} catch (Exception eee) {
				int num = random.nextInt(3);
				if (num == 0) {

					bot("Sorry ,I can't understand you !");
				} else if (num == 1) {
					bot("Sorry,I don't understand ");
				} else if (num == 2) {
					bot("My apologies...I don't understand ");
				}
			}
		}

	}

	public static void bot(String message) {
		area.append("Bot : " + message + "\n");
	}

	public static void main(String[] args) throws MalformedURLException {
		Image image = null;
        try {
            URL url = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQUysT_rmTl8Qb7LeeH3iPqqOcUUS6Ap9nesw&usqp=CAU");
            image = ImageIO.read(url);
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
        JFrame frame = new JFrame();
        frame.setSize(256,85);
        JLabel label = new JLabel(new ImageIcon(image));
		
        frame.add(label);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setOpacity(0.8f);
        frame.setVisible(true);
		Image img = null;
        try {
            URL url = new URL("https://www.apritos.com/wp-content/uploads/2021/02/sharingan-eye.jpg");
            img = ImageIO.read(url);
        } catch (IOException e) {
        	e.printStackTrace();
        }
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		frame.dispose();
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        JFrame f = new JFrame("TechNo");
		Image im = null;
        try {
            URL url = new URL("https://www.userlike.com/api/proxy/resize/whatsapp-bots/whatsapp-bots.png?height=720");
            im = ImageIO.read(url);
        } catch (IOException e) {
        	e.printStackTrace();
        }
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension prefSize = f.getPreferredSize();
        prefSize.height = 12;
        f.setSize(300,300);
		f.setIconImage(im);
        JLabel l = new JLabel(new ImageIcon(img));
		pb.setBorderPainted(false);
		pb.setStringPainted(true);
		pb.setPreferredSize(prefSize);
		pb.setBorder(BorderFactory.createLineBorder(Color.black));
		pb.setForeground(Color.RED);
		pb.setBackground(Color.BLACK);
        f.add(l);
		f.add(pb, BorderLayout.SOUTH);
		f.pack();
		f.setLocationRelativeTo(null);
		//f.setUndecorated(true);
		//frame.setOpacity(0.9f);
        f.setVisible(true);
		Timer timer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent re) {
			  progress += 1;
			  if (progress >= 100) {
				progress = 100;
				((Timer) re.getSource()).stop();
			  }
			  pb.setValue(progress);
			}
		  });
		  timer.start();
		  try {
			Thread.sleep(11000);
		} catch (Exception e) {
			e.printStackTrace();
		}
        f.dispose();




		ChatBot cb = new ChatBot();
		cb.setSize(800, 605);
		cb.setLocation(430, 140);
		

	}

}