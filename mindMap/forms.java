/*
AUTHOR : OKWUFULUEZE EMEKA DANIEL

PURPOSE :- To automatically counsel students applying to study an IT course in an IT Institute
             as to which course is suitable for them based on their answers to certain questions
             designed to reveal important facts about them.

           - To store in a Database, necessary information about visitors to this program to enable 
             follow-up calls.

           - To enable the co-ordinator or administrator of the IT Institute enter necessary information
             about students who qualify for scholarship in the Institute and store these information in
             a Database.
             (Students of all levels are catered for).

CLASSES USED:- The class format is indicated thus - Outer Class{ Inner Class{ Inner Inner Class{.....}}}-

               ACM{                                                       
                  Verify{}                                                        
                  Adm{}                                                    
                  Identity{                                  
                     A{                                  
                        Inquiry{}                           
                        Worker{}                                 
                        Student{                          
                           Primary{}            
                        }                          
                     }                            
                  }
               }                         

*/       

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ACM{
      JFrame fm = new JFrame("Greetings!");
      JTextArea goodDay = new JTextArea("Good day and welcome, may I help you?");
      JButton y = new JButton("Yes");
      JButton n = new JButton("No");
      private JButton admin = new JButton("Schorlarship Administrator");
      ButtonGroup g1 = new ButtonGroup();
      JPanel p = new JPanel();
      JPanel pln = new JPanel();
      JScrollPane pa = new JScrollPane(p);
      private Font font1 = new Font("Serif", Font.BOLD, 30);
      private BorderLayout bord = new BorderLayout();
      //private BorderLayout bord1 = new BorderLayout();

      // Constructor for the Greet Class
      public ACM(){
         fm.setSize(490, 230);
         fm.setLayout(bord);
         p.setLayout(null);
         fm.setLocation(400,300); 
         //p.setBounds(2, 2, 500, 1000);
         p.setBackground(Color.WHITE);
         fm.add(p, bord.CENTER);
         fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
         goodDay.setBounds(25, 25, 440, 80);
         goodDay.setForeground(Color.BLUE);
         goodDay.setFont(font1);
         goodDay.setWrapStyleWord(true);
         goodDay.setLineWrap(true);
         goodDay.setEditable(false);
         p.add(goodDay);
         
         g1.add(y);
         g1.add(n);
         g1.add(admin);

         y.setBounds(25, 150, 80, 20);
         y.setToolTipText("Click to proceed as a visitor.");
         p.add(y);

         n.setBounds(130, 150, 80, 20);
         n.setToolTipText("Click to close stop the program");
         p.add(n);

         admin.setBounds(220, 150, 200, 20);
         admin.setToolTipText("For the Schorlarship Administrator");
         p.add(admin);
         
         
         p.setVisible(true);
         fm.setVisible(true);

         //Action Listener for JButton n
         n.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
               JOptionPane.showMessageDialog(null, "Thanks Bye.");
               System.exit(0);
            }
         });
     
         //Action Listener for JButton y
         y.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent et){
               new Identity();
            }
         });

         //Action Listener for JButton admin
         admin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evg){
               new Verify();
            }
         });
    
      }

      public class Verify{
         private JFrame ad = new JFrame("The Schorlarship Administrator window");
         private JPanel ad1 = new JPanel();
         private JLabel user = new JLabel("Username"), pswd = new JLabel("Password");
         private JTextField usern = new JTextField(50);
         private JPasswordField pswdn = new JPasswordField(8);
         private JTextArea tell = new JTextArea("Enter your Username and Password");
         private JButton ok = new JButton("Ok"), cancl = new JButton("Cancel"); 
         private Font f0 = new Font(("Serif"), Font.BOLD, 15);
         private BorderLayout b = new BorderLayout();

         public Verify(){
            ad.setLayout(b);
            ad.setLocation(400, 300);
            ad.setSize(340, 250);
            ad.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ad1.setBackground(Color.WHITE);
            ad1.setLayout(null);
            ad.add(ad1, b.CENTER);
            ad1.setVisible(true);
            ad.setVisible(true);

            tell.setBounds(30, 30, 300, 40);
            tell.setEditable(false);
            tell.setForeground(Color.MAGENTA);
            tell.setFont(f0);
            
            user.setBounds(30, 80, 100, 20);
            usern.setBounds(140, 80, 120, 20);

            pswd.setBounds(30, 130, 100, 20);
           pswdn.setBounds(140, 130, 120, 20);

            ok.setBounds(30, 180, 80, 20);
            cancl.setBounds(120, 180, 80, 20);

            ad1.add(tell); ad1.add(user); ad1.add(usern); ad1.add(pswd); ad1.add(pswdn); ad1.add(ok); ad1.add(cancl);
            
            ok.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent et1){
                  if((usern.getText().equals("Daniel")||usern.getText().equals("daniel")||usern.getText().equals("DANIEL"))
                     &&(pswdn.getText().equals("danadm")||pswdn.getText().equals("Danadm")||pswdn.getText().equals("DANADM"))){
                        new Adm();
                  }
                  
                  else if ((!(usern.getText().equals("Daniel")))||(!(usern.getText().equals("daniel")))||(!(usern.getText().equals("DANIEL")))
                     &&((!(pswdn.getText().equals("danadm")))||(!(pswdn.getText().equals("Danadm")))||(!(pswdn.getText().equals("DANADM"))))){
                        JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                  }
               }
            });

            cancl.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent et2){
                  ad.setVisible(false);
                 
               }
            });
         }
      }
                 

      public class Adm {
   
         private JFrame f = new JFrame("List");   
         private JButton sub = new JButton("Submit");
         private JButton cance = new JButton("Cancel");
         private ButtonGroup grps = new ButtonGroup();   
         private JPanel pn = new JPanel();
         private BorderLayout bor = new BorderLayout();
         private GridLayout br = new GridLayout(1, 2, 200, 0 );
         private BorderLayout grl = new BorderLayout();
         private JPanel pn1 = new JPanel();
   
         public Adm(){ 
            f.setLocation(220, 50);
            String n = JOptionPane.showInputDialog("Enter the number of names given schorlarship"); 
            final int na = Integer.parseInt(n);
            String names[] = new String[na];
            String firString[] = new String[na];
            String sc[] = new String[na];
            String cours[] = new String[na];
            String acc[] = new String[na];
            final String[][] rows = new String[na][6];
            for(int i =0 ; i<na ; ++i){
               int sn = i+1;
               String m = String.valueOf(sn);
               rows[i][0] = m;
               rows[i][1] =names[i];
               rows[i][2] =firString[i];
               rows[i][3] = sc[i];
               rows[i][4] = cours[i];
               rows[i][5] = acc[i];
            }
            String col[] = {"S/n","SurName","Other Names","School", "Course Offered", "Scholar?(yes/no)"};
            //pn.setBounds(02, 02, 880, 600);
            pn.setBackground(Color.WHITE);
            f.setLayout(grl);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            //f.setResizable(false);
            pn.setLayout(bor);
            f.add(pn, grl.NORTH);
            
            JTable t = new JTable(rows, col);
            
            JScrollPane p = new JScrollPane(t);
            sub.setBounds(50, 50, 100, 20);
            sub.setToolTipText("Click to submit the data to the database");
            cance.setBounds(200, 50, 100, 20);
            grps.add(sub); grps.add(cance);
            pn1.setLayout(br);              
            pn1.add(sub); pn1.add(cance);
            f.add(pn1, grl.SOUTH);
            pn1.setVisible(true);
            pn.add(p, bor.CENTER);
            f.setSize(900,700);
            pn.setVisible(true);
            f.setVisible(true);
  
            cance.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent ev1){
                  f.setVisible(false);
               }
            });

            sub.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent ev2){
                  String v = rows[0][0], w = rows[0][1], x = rows[0][2], y = rows[0][3], z = rows[0][4]; 
                  if((w.length()>0)&&(x.length()>0)&&(y.length()>0)&&(z.length()>0)){
                     for(int i=0; i<na; ++i){
                        String a = rows[i][0], b = rows[i][1], c = rows[i][2], d = rows[i][3], e = rows[i][4]; 
                                                         
                        try{                 
                           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                           System.out.println("Driver Installed Successfully");
                            
                           Connection conn = DriverManager.getConnection("jdbc:odbc:ACM");
                           System.out.println("Connection Established Successfully");
                           Statement smt = conn.createStatement();
                           String up = "insert into Scholar(Sur_Name, Other_Names, School, Course_Offered)"
                               +"values('"+b+"','"+c+"','"+d+"','"+e+"');";
                           smt.executeUpdate(up);
                           conn.close();
                        }
                        catch (SQLException er1){
                           System.out.println("SQLException occured");
                        }
                        catch (ClassNotFoundException er2){
                           System.out.println("ClassNotFoundException");
                        }  
                     }
                        JOptionPane.showMessageDialog(null, "The names has been transfered to the Database");
                        f.setVisible(false);
                     }

                     else if(w.length()==0||x.length()==0||y.length()==0||z.length()==0){
                        JOptionPane.showMessageDialog(null, "Please fill one or more fields.");
                     }
                 }
               });
            }
        }   
        

     public class Identity{
        private static final int TEXT_WIDTH = 15;
        private JFrame frame = new JFrame("We want to know you.");
        private JPanel panel = new JPanel();
        private JLabel sur = new JLabel("SurName"), oth = new JLabel("Other Names"), phone = new JLabel("Phone Number"), mail = new JLabel("Email Address"), contact = new JLabel("Contact Address");
        private JTextField sur1 = new JTextField(TEXT_WIDTH), oth1 = new JTextField(TEXT_WIDTH) , phone1 = new JTextField(11), mail1= new JTextField(70), contact1 = new JTextField(70);
        private JButton next = new JButton("Next"), cancel = new JButton("Cancel");
        private JTextArea pInfo = new JTextArea("Please supply your personal information");
        private JTextArea click = new JTextArea("Click \"Next\" to continue or \"Cancel\" to end the process");
        private ButtonGroup grp = new ButtonGroup();
        private Rectangle rec1 = new Rectangle(100, 70, 150, 20), rec2 = new Rectangle(255, 70, 120, 20);
        private Font f1 = new Font("Serif", Font.BOLD+Font.ITALIC, 16);
        private Font f2 = new Font("Serif", Font.BOLD, 12);
        private BorderLayout bord1 = new BorderLayout();

        //Identity Constructor
        public Identity(){
           frame.setLayout(bord1);
           panel.setLayout(null);
           frame.setSize(550, 400);
           frame.setLocation(350, 180);
           frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           //panel.setBounds(03, 03, 1600, 1000);
           panel.setBackground(Color.WHITE);
           frame.add(panel,bord1.CENTER);
        
           //Components' configuration
           pInfo.setBounds(110, 30, 450, 40);
           pInfo.setFont(f1);
           pInfo.setWrapStyleWord(true);
           pInfo.setLineWrap(true);
           pInfo.setEditable(false);
           panel.add(pInfo);

           sur.setBounds(rec1);
           panel.add(sur);
           rec1.translate(0, 40);

           sur1.setBounds(rec2);
           sur1.setFont(f2);
           panel.add(sur1);
           rec2.translate(0, 40);

           oth.setBounds(rec1);
           panel.add(oth);
           rec1.translate(0,40);

           oth1.setBounds(rec2);
           oth1.setFont(f2);
           panel.add(oth1);
           rec2.translate(0, 40);

           phone.setBounds(rec1);
           panel.add(phone);
           rec1.translate(0, 40);

           phone1.setBounds(rec2);
           phone1.setToolTipText("Type 'none' if you have no phone number");
           panel.add(phone1);
           //phone1.setFont(f2);
           rec2.translate(0, 40);

           
           mail.setBounds(rec1);
           panel.add(mail);
           rec1.translate(0, 40);

           mail1.setBounds(rec2);
           mail1.setToolTipText("Type 'none' if you have no email address");
           //mail1.setFont(f2);
           panel.add(mail1);
           rec2.translate(0, 40);
                      

          
           contact.setBounds(100, 230, 120, 30);
           panel.add(contact);
           rec1.translate(0, 40);

           contact1.setBounds(230, 230, 250, 20);
           //contact1.setFont(f2);
           panel.add(contact1);
           rec2.translate(0, 40);

           click.setBounds(70, 270, 400, 40);
           click.setFont(f1);
           click.setWrapStyleWord(true);
           click.setLineWrap(true);
           click.setEditable(false);
           panel.add(click);

           next.setBounds(100, 310, 100, 20);
           next.setToolTipText("Click to continue");
           panel.add(next);

           cancel.setBounds(300, 310, 100, 20);
           cancel.setToolTipText("Click to cancel");
           panel.add(cancel);

           //Configuring visibility of the Frame and Panel
           panel.setVisible(true);
           frame.setVisible(true);
           
           next.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent ev){
                 String surn = sur1.getText();
                 String othn = oth1.getText();
                 String phn = phone1.getText();
                 String ml = mail1.getText();
                 String cnt = contact1.getText();
                 
                 int len = sur1.getText().length();
                 int len0 = oth1.getText().length();
                 int p = phone1.getText().length();
                 int m = mail1.getText().length();
                 int c = contact1.getText().length();
                 String len1 = String.valueOf(len);
                 String len2 = String.valueOf(len0);

                 if((len>0)&&(len0>0)&&(p>0)&&(m>0)&&(c>0)){
                    frame.setVisible(false);
                    new A();
                    
                    
                    
                 }
                 else if((len==0)||(len0==0)
                    &&(p>0)
                    &&(m>0)
                    &&(c>0)){
                    JOptionPane.showMessageDialog(null, "Please fill your names completely");
                 }

                 else if((len>0)&&(len0>0)
                    &&(p==0)
                    &&(m>0)
                    &&(c>0)){
                       JOptionPane.showMessageDialog(null, "Please fill your phone number or type 'none' if you have no phone number.");
                 }
                 else if((len>0)&&(len0>0)
                    &&(p>0)&&(m==0)
                    &&(c>0)){
                       JOptionPane.showMessageDialog(null, "Please supply your email address or type 'none' if you have no email address.");
                 }
                 else if((len>0)&&(len0>0)
                    &&(p>0)&&(m>0)
                    &&(c==0)){
                       JOptionPane.showMessageDialog(null, "Please give your contact address");
                 }
                 else if((len==0)&&(len0==0)
                    &&(p==0)&&(m==0)
                    &&(c==0)){
                       JOptionPane.showMessageDialog(null, "Please fill all the fields.");
                 }
                 else if((len>=0)||(len0>=0)
                    &&(p==0)||(m==0)
                    ||(c==0)){
                       JOptionPane.showMessageDialog(null, "Please fill all fields.");
                 }

                 
                 
              }
           });
           cancel.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent ev){
                 frame.setVisible(false);
              }
           });
       }
          
        


public class A {
   private JFrame fra = new JFrame("SELECTIONS");
   private JPanel p0 = new JPanel();
   private JTextArea me = new JTextArea(sur1.getText()+" "+oth1.getText()+", please select from the boxes to indicate your objective");
   private JButton inq = new JButton ("INQUIRY");
   private JButton couns = new JButton ("COUNSELLING");
   private JButton canc = new JButton ("Cancel");
   private JButton bac = new JButton("Back");
   private JLabel info = new JLabel("Select if you are a Worker or a Student and press the \"Enter\" button");
   private String[] opt = {"Student", "Worker"};
   private JComboBox sel = new JComboBox(opt);
   private JButton run = new JButton("Enter");
   private ButtonGroup gr = new ButtonGroup();
   private FlowLayout FLOW = new FlowLayout();
   private Font font1 = new Font("Serif", Font.BOLD, 17);
   private BorderLayout bord2 = new BorderLayout();

   public A(){
      fra.setSize(490, 290);
      fra.setLayout(bord2);
      fra.setLocation(420, 280);
      fra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      //p1.setBounds(02, 02, 1600, 1000);
      p0.setBackground(Color.WHITE);
      p0.setLayout(null);
      fra.add(p0, bord2.CENTER);
      gr.add(inq);
      gr.add(couns);
      gr.add(bac);
      gr.add(canc);

      me.setBounds(30, 30, 420, 60);
      me.setBackground(Color.WHITE);
      me.setEditable(false);
      me.setFont(font1);
      me.setLineWrap(true);
      me.setWrapStyleWord(true);
      me.setForeground(Color.BLUE);
      p0.add(me);

      couns.setBounds(30, 100, 140, 20);
      couns.setForeground(Color.BLUE);
      couns.setToolTipText("Click to select from the worker or student option");
      p0.add(couns);

      inq.setBounds(175, 100, 100, 20);
      inq.setForeground(Color.BLUE);
      inq.setToolTipText("Click to see the courses we offer");
      p0.add(inq);
    
      canc.setBounds(280, 100, 100, 20);
      canc.setForeground(Color.BLUE);
      canc.setToolTipText("Click to exit.");
      p0.add(canc);

      info.setBounds(30, 160, 400, 20);
      
      info.setBackground(Color.WHITE);
      p0.add(info);
      info.setEnabled(false);
      info.setVisible(false);

      run.setBounds(30, 190, 85, 20);
      run.setToolTipText("Click to enter the portal of the selected occupation");
      p0.add(run);
      run.setEnabled(false);
      run.setVisible(false);

      bac.setBounds(30, 230, 80, 20);
      bac.setToolTipText("Click to go back to your Personal Information page");
      p0.add(bac);

      sel.setBounds(120, 190, 100, 20);
      p0.add(sel);
      sel.setEnabled(false);
      sel.setVisible(false);

      p0.setVisible(true);
      fra.setVisible(true);

      inq.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            new Inquiry();
         }
      }); 

      canc.addActionListener(
         new ActionListener(){
            public void actionPerformed(ActionEvent e){
               JOptionPane.showMessageDialog(null, "Thanks for coming.");
               fra.setVisible(false);
            }
         });													
      
      couns.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            info.setEnabled(true);
            info.setVisible(true);
            run.setVisible(true);
            run.setEnabled(true);
            sel.setVisible(true);
            sel.setEnabled(true);

            run.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
                  if(sel.getSelectedItem().toString().equals("Worker")){
                     //fra.setVisible(false);
                     new Worker();
                  } 
                  else if(sel.getSelectedItem().toString().equals("Student")){
                     //fra.setVisible(false);
                     new Student();
                  }
           }});
         }
      });

      bac.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent evt){
            fra.setVisible(false);
            frame.setVisible(true);
         }
      });
   }
    

   public class Inquiry  {
      private static final int WINDOW_WIDTH = 800;
      private static final int WINDOW_HEIGHT = 600;
      private static final int TEXT_WIDTH = 15;
      private String info = " OUR COURSES INCLUDE THE FOLLOWING ";
      private int length = info.length();
      private String[] fields = {"SOFTWARE ENGINEERING", "NETWORKING", "UTILITIES", "FUNDAMENTALS OF ICT", "COMPUTER ENGINEERING", "DATABASE MANAGEMENT"};
      private String[] prog = {"*Algorithm analysis", "*Java", "*C++", "*C#", "*Visual Basic.NET", "*Java Script", "*And so much more...."};
      private String[] net = {"*Hardware Analysis", "*Information Technology", "*Wireless Networking", "*Interconnectivity","*Cisco", "*GPRS Network", "*Global Positioning System[GPS]"};
      private String[] uti = {"*Microsoft Office", "*Corel Draw"};
      private String[] ict = {"*Computer Usage", "*Hardware and Software Analysis"};
      private String[] eng = {"*Computer Organisation", "*Computer Architecture", "*System Analysis"};
      private String[] dbm = {"*SQL","*Oracle", "*Access"};    
      private FlowLayout STYLE = new FlowLayout();
      private Font font = new Font("Sanserif", Font.BOLD, 16);
      private JFrame win = new JFrame("WELCOME TO THE INQUIRY SECTION");
      private JTextArea  message = new JTextArea(info,1, length);
      private JLabel field0 = new JLabel(fields[0]);
      private JList progr  = new JList(prog);
      private JLabel field1 = new JLabel(fields[1]);
      private JList nets = new JList(net);
      private JLabel field2 = new JLabel(fields[2]);
      private JList utis = new JList(uti);
      private JLabel field3 = new JLabel(fields[3]);
      private JList icts = new JList(ict);
      private JLabel field4 = new JLabel(fields[4]);
      private JList engs = new JList(eng);
      private JLabel field5 = new JLabel(fields[5]);
      private JList dbms = new JList(dbm);
      private JPanel i = new JPanel();
      private BorderLayout bord3 = new BorderLayout();

   
   public Inquiry(){      
      win.setLayout(bord3);
      win.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      
      i.setBackground(Color.WHITE);
      //i.setBounds(2, 2, 1600, 1000);
      i.setLayout(null);
      win.add(i,bord3.CENTER);
      win.setLocation(250, 100);
      win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      message.setEditable(false);    
      message.setBounds(230, 60, 345, 20);
      message.setBackground(Color.WHITE);
      message.setFont(font);
      i.add(message);

      
      field0.setBounds(100, 100, 150, 20);
      i.add(field0);
      
      progr.setBounds(130, 120, 160, 130);
      progr.setBackground(Color.WHITE);
      i.add(progr);
      
      field1.setBounds(100, 255, 120, 20);
      i.add(field1); 
      
      nets.setBounds(130, 275, 200, 130);
      nets.setBackground(Color.WHITE);
      i.add(nets);
      
      field2.setBounds(100, 410, 100, 20);
      i.add(field2);

      utis.setBounds(130, 440, 150, 40);
      utis.setBackground(Color.WHITE);
      i.add(utis);
      
      field3.setBounds(500, 100, 160, 20);
      i.add(field3); 

      icts.setBounds(530, 125, 160, 40);
      icts.setBackground(Color.WHITE);
      i.add(icts);

      
      field4.setBounds(500, 185, 150, 20);
      i.add(field4);

      engs.setBounds(530, 210, 120, 65);
      engs.setBackground(Color.WHITE);
      i.add(engs);

      field5.setBounds(500, 285, 200, 20);
      i.add(field5);

      dbms.setBounds(530, 310, 200, 65);
      dbms.setBackground(Color.WHITE);
      i.add(dbms); 

      i.setVisible(true);
      win.setVisible(true);
   }
   }
   
   public class Worker  {

      /*Instant Constants*/
      private static final int WINDOW_WIDTH = 900;
      private static final int WINDOW_HEIGHT = 730;
      private static final int TEXT_WIDTH = 15;

      //Instance data types
      private String que = "TO HELP YOU RECOMMEND A COURSE, WE SHOULD KNOW SOMETHINGS ABOUT YOU";
      private String[] courses = {"Security", "Networking", "Desktop Publishing", "ICT Fundamentals", "Software Engineering", "D.B.A.","Information Technology", "Computer Engineering"};
      private String[] flare = {"Inquisitive", "Explorer", "Abstract Thinker", "Keeper of Records","Others"}; 
      private String[] work = {"Civil Service", "Private Firm", "Others"};
      private String[] sector = {"Banking Sector", "Science and Technology", "Enterprise", "Educational Sector", "Trade","Oil and Gas","Telecommunications","Agriculture" }; 
      private int wordlength = que.length();

      //Instant variables
      
      private JTextArea welcome = new JTextArea();
      private JFrame win = new JFrame("Counsellor/Student course recommendation");
      private JTextArea background = new JTextArea("TO HELP YOU RECOMMEND A COURSE, WE SHOULD KNOW SOMETHING ABOUT YOU",1,wordlength);
      private JLabel que5 = new JLabel("Choose your work area");
      private JComboBox ans5 = new JComboBox(work);
      private JLabel que5a = new JLabel("What sector of the economy do you work for?");
      private JComboBox ans5a = new JComboBox(sector); 
      private JLabel que6 = new JLabel("Have you had any IT experience before?");
      private ButtonGroup group1 = new ButtonGroup();
      private JRadioButton ans6 = new JRadioButton("Yes");
      private JRadioButton ans62 = new JRadioButton("No");
      private JLabel que7 = new JLabel("On what field was your study based?");
      private JComboBox ans7 = new JComboBox(courses);
      private JLabel que8 = new JLabel("Which of these characteristics describe you?");
      private JComboBox ans8 = new JComboBox(flare);
      private JLabel que9 = new JLabel("Do you enjoy keeping records of data, both old and new?");
      private ButtonGroup group2 = new ButtonGroup();
      private JRadioButton ans9 = new JRadioButton("Yes");
      private JRadioButton ans92 = new JRadioButton("No");
      private JRadioButton ans93 = new JRadioButton("Intermediate");
      private JLabel que10 = new JLabel("Do you enjoy using codes in order to restrict general access to an object?");
      private ButtonGroup group3 = new ButtonGroup();
      private JRadioButton ans10 = new JRadioButton("Yes");
      private JRadioButton ans101 = new JRadioButton("No");
      private JTextArea message = new JTextArea("Click the \"Recommendation\" Button below, for a recommended course");
      private JButton recom = new JButton("Recommendation");
      private JTextArea recom1 = new JTextArea();
      private FlowLayout STYLE = new FlowLayout();
      private Rectangle r1 = new Rectangle(100, 30, 110, 20);
      private Rectangle r2 = new Rectangle(210, 30, 150, 20);
      private Rectangle r3 = new Rectangle(100, 110, 340,20);
      private JLabel star1 = new JLabel("*");
      private JLabel star2 = new JLabel("*");
      private JLabel star3 = new JLabel("*");
      private JLabel star4 = new JLabel("*");
      private JLabel star5 = new JLabel("*");
      private Font font1 = new Font("Serif", Font.BOLD, 13);
      private Font font2 = new Font("sansSerif", Font.BOLD + Font.ITALIC, 20);
      private Font font3 = new Font("Serif2", Font.BOLD + Font.ITALIC, 30);
      private JPanel p = new JPanel();
      private BorderLayout bord4 = new BorderLayout();
      private JButton b = new JButton("Back");


      //Constructor
      public Worker(){
         win.setLayout(bord4);
         win.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
         win.setBackground(Color.WHITE);
         win.setLocation(240,40);
         win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         //p.setBounds(05, 05, 1600, 1000);
         p.setBackground(Color.WHITE);
         p.setLayout(null);
         win.add(p, bord4.CENTER);
          
         star1.setBounds(80, 230, 20, 20);
         star2.setBounds(80, 280, 20, 20);
         star3.setBounds(80, 330, 20, 20);
         star4.setBounds(80, 380, 20, 20);
         star5.setBounds(80, 430, 20, 20);
 
         star1.setForeground(Color.RED);
         star2.setForeground(Color.RED);
         star3.setForeground(Color.RED);
         star4.setForeground(Color.RED);
         star5.setForeground(Color.RED);

         p.add(star1);
         p.add(star2);
         p.add(star3);
         p.add(star4);  
         p.add(star5);

         //Arrange Components in GUI

         /*que1.setBounds(r1);
         r1.translate(0, 40);
         p.add(que1);

         ans1.setBounds(r2);
         r2.translate(0, 40); 
         p.add(ans1);

         que2.setBounds(r1);
         p.add(que2);
  
        ans2.setBounds(r2);
        r2.translate(0, 40);
        p.add(ans2);*/

        welcome.setBounds(60, 20, 800, 80);
        welcome.setEditable(false);
        welcome.setFont(font3);
        welcome.setWrapStyleWord(true);
        welcome.setLineWrap(true);
        welcome.setText(sur1.getText()+" "+oth1.getText()+" Welcome to our workers portal.Please fill the form below to get a course recommendation.");
        p.add(welcome);

        background.setBounds(100, 120, 530, 25);
        background.setEditable(false);
        background.setBackground(Color.YELLOW);
        background.setFont(font1);
        p.add(background);
          
        que5.setBounds(100, 180, 270, 20);
        p.add(que5);

        ans5.setBounds(360, 180, 120, 20);
        p.add(ans5);
 
        que5a.setBounds(100, 230, 270, 20);
        p.add(que5a);
 
        ans5a.setBounds(360, 230, 160, 20);
        p.add(ans5a);

        que6.setBounds(100, 280, 250, 20);
        p.add(que6);

        ans6.setBounds(350, 280, 65, 20);
        p.add(ans6);

        ans62.setBounds(420, 280, 40, 20);
        p.add(ans62);

        group1.add(ans6);
        group1.add(ans62);

        que7.setBounds(100, 330, 230, 20);
        p.add(que7);

        ans7.setBounds(360, 330, 125, 20);
        p.add(ans7);

        que8.setBounds(100, 380, 270, 20);
        p.add(que8);

        ans8.setBounds(360, 380, 120, 20);
        p.add(ans8);

        que9.setBounds(100, 430, 320, 20);
        p.add(que9);
 
        ans9.setBounds(420, 430, 55, 20);
        p.add(ans9);

        ans92.setBounds(480, 430, 40, 20);
        p.add(ans92);

        ans93.setBounds(530, 430, 100, 20);
        p.add(ans93);
 
        group2.add(ans9);
        group2.add(ans92);
        group2.add(ans93);

        que10.setBounds(100, 480, 450, 20);
        p.add(que10);

        ans10.setBounds(520, 480, 80, 20);
        p.add(ans10);

        ans101.setBounds(600, 480, 40, 20);
        p.add(ans101);

        group3.add(ans10);
        group3.add(ans101);

        message.setBounds(100, 530, 420, 20);
        message.setEditable(false);
        message.setBackground(Color.WHITE);
        p.add(message);

        recom.setBounds(100, 580, 140, 20);
        p.add(recom);

        
 
        recom1.setBounds(100, 625, 600, 90);
        recom1.setFont(font2);
        recom1.setLineWrap(true);
        recom1.setWrapStyleWord(true);
        recom1.setEditable(false);
        recom1.setBackground(Color.WHITE);
        p.add(recom1);
      
        //Display GUI
        p.setVisible(true);
        win.setVisible(true);

        
   
        ans6.addItemListener(new ItemListener(){
           public void itemStateChanged(ItemEvent e){
              ans7.setEnabled(true);
           }
        });
        ans62.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){ 
              ans7.setEnabled(false);
           }
        });
   
        recom.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
              String sectors = ans5a.getSelectedItem().toString();
              String course = ans7.getSelectedItem().toString();
              String flares = ans8.getSelectedItem().toString();
              
              
              if(ans6.isSelected()&&(course.equals(courses[0])||course.equals(courses[1])
                 ||course.equals(courses[2])||course.equals(courses[3])||course.equals(courses[5])||course.equals(courses[6])||course.equals(courses[7]))
                 &&(sectors.equals(sector[1])
                 ||sectors.equals(sector[3]))&&(flares.equals(flare[0])
                 ||flares.equals(flare[1])||flares.equals(flare[2]))
                 &&(ans92.isSelected()||ans93.isSelected())
                 &&(ans10.isSelected())&&(!ans101.isSelected())){

                    String adv1 =/* name+*/"I suggest you study Software Engineering.";
                    recom1.setText(adv1);
                 
                 try{
                    String occ = "Worker";
                    String cou = "Software Engineering";
                    String sw = "insert into Worker(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    } 
                    
              }
              if(ans6.isSelected()&&(course.equals(courses[0])||course.equals(courses[1])||course.equals(courses[2])||course.equals(courses[3])
                 ||course.equals(courses[4])||course.equals(courses[5])||course.equals(courses[7]))
                 &&(sectors.equals(sector[1])||sectors.equals(sector[2])
                 ||sectors.equals(sector[3])||sectors.equals(sector[4])||sectors.equals(sector[5])||sectors.equals(sector[6])
                 ||sectors.equals(sector[7]))&&(flares.equals(flare[0])
                 ||flares.equals(flare[1])||flares.equals(flare[2]))
                 &&(ans92.isSelected()||ans93.isSelected())
                 &&(ans10.isSelected())&&(!ans101.isSelected())){

                    String adv1 =/* name+*/"I suggest you study Information Technology.";
                    recom1.setText(adv1);
                 
                 try{
                    String occ = "Worker";
                    String cou = "Information Technology";
                    String sw = "insert into Worker(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    }
             } 
             if((ans6.isSelected())&&(course.equals(courses[0])||course.equals(courses[1])||course.equals(courses[2])||course.equals(courses[3])
                 ||course.equals(courses[4])||course.equals(courses[5])||course.equals(courses[7]))
                 &&(sectors.equals(sector[0])||sectors.equals(sector[1])||sectors.equals(sector[2])
                 ||sectors.equals(sector[3])||sectors.equals(sector[4])||sectors.equals(sector[5])
                 ||sectors.equals(sector[6])||sectors.equals(sector[7]))&&(flares.equals(flare[0])
                 ||flares.equals(flare[1])||flares.equals(flare[2])||flares.equals(flare[3])||flares.equals(flare[4]))
                 &&(ans92.isSelected()||ans93.isSelected())
                 &&(ans10.isSelected()&&!ans101.isSelected())){

                    String adv1 =/* name+*/"I suggest you study Security or D.B.A.";
                    recom1.setText(adv1);
                 
                 try{
                    String occ = "Worker";
                    String cou = "Security or Database Management.";
                    String sw = "insert into Worker(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    } 
                    
              }
              if(ans6.isSelected()&&(course.equals(courses[0])||course.equals(courses[1])||course.equals(courses[2])||course.equals(courses[3])
                 ||course.equals(courses[4])||course.equals(courses[5])||course.equals(courses[7]))
                 &&(sectors.equals(sector[0])||sectors.equals(sector[1])||sectors.equals(sector[2])
                 ||sectors.equals(sector[3])||sectors.equals(sector[4])||sectors.equals(sector[5])
                 ||sectors.equals(sector[6])||sectors.equals(sector[7]))&&(flares.equals(flare[0])
                 ||flares.equals(flare[1])||flares.equals(flare[2])||flares.equals(flare[3])||flares.equals(flare[4]))
                 &&(ans92.isSelected()||ans93.isSelected())
                 &&(!ans10.isSelected()&&ans101.isSelected())){

                    String adv1 =/* name+*/"I suggest you study Information Technology or Networking.";
                    recom1.setText(adv1);
                 
                 try{
                    String occ = "Worker";
                    String cou = "Information Technology or Networking";
                    String sw = "insert into Worker(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    } 
                    
              }
                            
              if(ans6.isSelected()&&(course.equals(courses[0])||course.equals(courses[1])||course.equals(courses[2])||course.equals(courses[3])
                 ||course.equals(courses[4])||course.equals(courses[6]))
                 &&(sectors.equals(sector[1])
                 ||sectors.equals(sector[3])||sectors.equals(sector[6]))&&(flares.equals(flare[0])||flares.equals(flare[1])
                 ||flares.equals(flare[2])||flares.equals(flare[3])||flares.equals(flare[4]))
                 &&(ans9.isSelected()&&!ans92.isSelected()||ans93.isSelected())
                 &&(ans10.isSelected()&&!ans101.isSelected())){

                    String adv1 =/* name+*/"I suggest you study D.B.A. or Computer Engineering";
                    recom1.setText(adv1);
                 
                 try{
                    String occ = "Worker";
                    String cou = "Database Management or Computer Engineering";
                    String sw = "insert into Worker(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    } 
                    
              }
              else if (ans6.isSelected()&&(course.equals(courses[1])||course.equals(courses[2])||course.equals(courses[3])||course.equals(courses[4])
                 ||course.equals(courses[6])||course.equals(courses[7]))
                 &&(sectors.equals(sector[0])
                 ||sectors.equals(sector[1])||sectors.equals(sector[2])
                 ||sectors.equals(sector[3])||sectors.equals(sector[4])||sectors.equals(sector[5])||sectors.equals(sector[6])||sectors.equals(sector[7]))
                 &&(flares.equals(flare[0])||flares.equals(flare[1])
                 ||flares.equals(flare[2])||flares.equals(flare[3])
                 ||flares.equals(flare[4]))
                 &&(ans9.isSelected()||ans92.isSelected()||ans93.isSelected())
                 &&(ans10.isSelected()
                 ||ans101.isSelected())){
                    recom1.setText(/*name+*/"I suggest you study, either DBA or Security or both.");
                 try{
                     String occ = "Worker";
                    String cou = "Database Management or Security";
                    String sw = "insert into Worker(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    }               }

              else if (ans6.isSelected()&&(course.equals(courses[1])||course.equals(courses[2])||course.equals(courses[3])
                 ||course.equals(courses[5])||course.equals(courses[6])||course.equals(courses[7]))
                 &&(sectors.equals(sector[0])
                 ||sectors.equals(sector[1])||sectors.equals(sector[2])
                 ||sectors.equals(sector[3])||sectors.equals(sector[4])||sectors.equals(sector[5])||sectors.equals(sector[6])||sectors.equals(sector[7]))
                 &&(flares.equals(flare[0])||flares.equals(flare[1])
                 ||flares.equals(flare[2])||flares.equals(flare[3])||flares.equals(flare[4]))
                 &&(ans9.isSelected()||ans92.isSelected()||ans93.isSelected())
                 &&(ans10.isSelected()||!ans101.isSelected())){
                    recom1.setText(/*name+*/"I suggest you study, either Software Engineering or Security or both.");
                 try{
                    String occ = "Worker";
                    String cou = "Software Engineering or Security";
                    String sw = "insert into Worker(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    }         
              }  
     
              else if((ans6.isSelected())&&(course.equals(courses[0])||course.equals(courses[1])||course.equals(courses[2])||course.equals(courses[3])
                 ||course.equals(courses[5])||course.equals(courses[6])||course.equals(courses[7]))
                 &&(sectors.equals(sector[0])
                 ||sectors.equals(sector[1])||sectors.equals(sector[2])
                 ||sectors.equals(sector[3])||sectors.equals(sector[4])||sectors.equals(sector[5])||sectors.equals(sector[6])||sectors.equals(sector[7]))
                 &&(flares.equals(flare[0])||flares.equals(flare[1]))
                 &&(ans92.isSelected()||ans93.isSelected())
                 &&(ans10.isSelected())){
                    recom1.setText(/*name+*/"I suggest you study Software Engineering.");
                   try{
                    String occ = "Worker";
                    String cou = "Software Engineering "; 
                    String sw = "insert into Worker(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    System.out.println("Driver Installed successfully");
                    Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                    System.out.println("Connection established successfully"); 
                    Statement st = vis.createStatement();
                    st.executeUpdate(sw);
                    vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    }  
              }
        
              else if((ans6.isSelected())&&(course.equals(courses[0])||course.equals(courses[1])||course.equals(courses[2])||course.equals(courses[3])
                 ||course.equals(courses[6])||course.equals(courses[7]))
                 &&(sectors.equals(sector[0])
                 ||sectors.equals(sector[1])||sectors.equals(sector[2])
                 ||sectors.equals(sector[3])||sectors.equals(sector[4]))
                 &&(flares.equals(flare[0])||flares.equals(flare[1])
                 ||flares.equals(flare[2])||flares.equals(flare[3])||flares.equals(flare[4]))
                 &&(ans9.isSelected())
                 &&(ans10.isSelected())){
                    recom1.setText(/*name+*/"I suggest you study, either Software Engineering or D.B.A. or both.");
                 try{
                    String occ = "Worker";
                    String cou = "Software Engineering or DBA"; 
                    String sw = "insert into Worker(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    System.out.println("Driver Installed successfully");
                    Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                    System.out.println("Connection established successfully"); 
                    Statement st = vis.createStatement();
                    st.executeUpdate(sw);
                    vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    } 
              }

              else if((ans6.isSelected())&&(course.equals("Security")||course.equals("Computer Engineering")||course.equals(courses[6]))
                 &&(sectors.equals(sector[0])
                 ||sectors.equals(sector[1])||sectors.equals(sector[2])
                 ||sectors.equals(sector[3])||sectors.equals(sector[4])||sectors.equals(sector[5])||sectors.equals(sector[6])||sectors.equals(sector[7]))
                 &&(flares.equals(flare[1])||flares.equals(flare[3])
                 ||flares.equals(flare[4]))
                 &&(ans9.isSelected())
                 &&(ans10.isSelected())){
                    recom1.setText(/*name+*/"I suggest you study D.B.A.");
                try{
                    String occ = "Worker";
                    String cou = "Database Management";
                    String sw = "insert into Worker(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    }  
              }

              else if((ans6.isSelected())&&(course.equals(courses[0])||course.equals(courses[1])||course.equals(courses[3])||course.equals(courses[4])
                 ||course.equals(courses[5])||course.equals(courses[6]))
                 &&(sectors.equals(sector[0])
                 ||sectors.equals(sector[1])||sectors.equals(sector[2])
                 ||sectors.equals(sector[3])||sectors.equals(sector[4])||sectors.equals(sector[5])||sectors.equals(sector[6])||sectors.equals(sector[7]))
                 &&(flares.equals(flare[0])||flares.equals(flare[1])
                 ||flares.equals(flare[2])||flares.equals(flare[3])
                 ||flares.equals(flare[4]))
                 &&(ans9.isSelected()||ans92.isSelected()||ans93.isSelected())
                 &&(ans101.isSelected())){
                    recom1.setText(/*name+*/"Since you dont like working with codes, I suggest you study Desktop Publishing or Computer Engineering.");
                  
                    try{
                       String occ = "Worker";
                       String cou = "Desktop Publishing or Computer Engineering";
                       String sw = "insert into Worker(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    } 
                    
              }

              

              else if((ans6.isSelected())&&(course.equals(courses[0])||course.equals(courses[1])||course.equals(courses[3])||course.equals(courses[4])||course.equals(courses[5])
                 ||course.equals(courses[6]))
                 &&(sectors.equals(sector[0])
                 ||sectors.equals(sector[1])||sectors.equals(sector[2])
                 ||sectors.equals(sector[3])||sectors.equals(sector[4])||sectors.equals(sector[5])||sectors.equals(sector[6])||sectors.equals(sector[7]))
                 &&(flares.equals(flare[0])||flares.equals(flare[1])
                 ||flares.equals(flare[2])||flares.equals(flare[3])
                 ||flares.equals(flare[4]))
                 &&(ans9.isSelected()||ans92.isSelected()||ans93.isSelected())
                 &&(ans10.isSelected()||ans101.isSelected())){
                    recom1.setText("I suggest you study Desktop Publishing or Computer Engineering.");
                  
                    try{
                       String occ = "Worker";
                       String cou = "Desktop Publishing or Computer Engineering";
                       String sw = "insert into Worker(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    } 
                    
              }

        
              else if(ans6.isSelected()&&(course.equals(courses[0])||course.equals(courses[1])
                 ||course.equals(courses[2])||course.equals(courses[3])||course.equals(courses[4])||course.equals(courses[5])||course.equals(courses[6])||course.equals(courses[7]))
                 &&(sectors.equals(sector[0])
                 ||sectors.equals(sector[1])||sectors.equals(sector[2])
                 ||sectors.equals(sector[3])||sectors.equals(sector[4])||sectors.equals(sector[5])||sectors.equals(sector[6])||sectors.equals(sector[7]))
                 &&(flares.equals(flare[3]))
                 &&(!ans9.isSelected()&&(ans92.isSelected()||ans93.isSelected()))
                 &&(ans10.isSelected()||ans101.isSelected())){
                    recom1.setText(/*name+*/"How come you're a keeper of records, and at the same time you dont enjoy keeping records of data?");        
              }

              else if(ans62.isSelected()
                 &&(sectors.equals(sector[0])
                 ||sectors.equals(sector[1])||sectors.equals(sector[2])
                 ||sectors.equals(sector[3])||sectors.equals(sector[4])||sectors.equals(sector[5])||sectors.equals(sector[6])||sectors.equals(sector[7]))
                 &&(flares.equals(flare[0])||flares.equals(flare[1])
                 ||flares.equals(flare[2])||flares.equals(flare[3])||flares.equals(flare[4]))
                 &&(ans9.isSelected()||ans92.isSelected()||ans93.isSelected())
                 &&(ans10.isSelected()
                 ||ans101.isSelected())){
                    recom1.setText(/*name+*/"Since you have no IT experience, I suggest you study IT Fundamentals.");
                     
                    try{
                       String occ = "Worker";
                       String cou = "IT Fundamentals";
                       String sw = "insert into Worker(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    }
              }
         
              else if (ans6.isSelected()&&(sectors.equals(sector[0])||sectors.equals(sector[1])
                 ||sectors.equals(sector[2])||sectors.equals(sector[4])||sectors.equals(sector[5])||sectors.equals(sector[6])||sectors.equals(sector[7]))
                 &&(flares.equals(flare[3])||flares.equals(flare[4]))
                 &&(course.equals(courses[0])||course.equals(courses[1])||course.equals(courses[2])||course.equals(courses[3])
                 ||course.equals(courses[4])||course.equals(courses[6])||course.equals(courses[7]))
                 &&(ans9.isSelected()&&!ans92.isSelected()&&!ans93.isSelected())
                 &&(ans10.isSelected()||ans101.isSelected())){
                    recom1.setText(/*name+*/", I advice you study DataBase Management.");
                     
                   try{
                       String occ = "Worker";
                       String cou = "Database Management";
                       String sw = "insert into Worker(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    }
              }
              else if(((!ans6.isSelected())&&(!ans62.isSelected()))
                 ||((!ans9.isSelected())&&(!ans92.isSelected())&&(!ans93.isSelected()))
                 ||((!ans10.isSelected())&&(!ans101.isSelected()))){
                 String warn = (/*name+*/"Please fill any field having an asterisk");
                    recom1.setText(warn);
              }
              try{
                       String occ = "Worker";
                       String s = "insert into Visitors(Sur_Name, Other_Names, Occupation, Phone_Number, Email_Address, Contact_Address)"
                                +" values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+phone1.getText()+"','"+mail1.getText()+"','"+contact1.getText()+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(s);
                       vis.close();
                    }
                    catch(SQLException exc){
                      System.out.println(" ");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");
                    } 
                 
         }
      });
   }
   }
   public class Student{
   private static final int WINDOW_WIDTH = 900;
   private static final int WINDOW_HEIGHT = 720;
   private static final int TEXT_WIDTH = 15;

   private String que = "TO HELP YOU RECOMMEND A COURSE, WE SHOULD KNOW SOMETHINGS ABOUT YOU";
   private String[] courses = {"Security", "Networking", "Desktop Publishing", "ICT Fundamentals", "Software Engineering", "D.B.A", "Information Technology", "Computer Engineering"};
   private String[] flare = {"Inquisitive", "Explorer", "Abstract Thinker", "Keeper of Records","Others"}; 
   private String[] dept = {"Science", "Arts", "Commerce", "Social Sciences", "Others"};
   private int wordlength = que.length();

   //Instant variables
   private JFrame win = new JFrame("Counsellor/Student course recommendation");
   /*private JLabel que1 = new JLabel("SurName");
   private JTextField ans1 = new JTextField(TEXT_WIDTH);
   private JLabel que2 = new JLabel("Other Names");
   private JTextField ans2 = new JTextField(TEXT_WIDTH);*/
   private JTextArea welcome = new JTextArea();
   private JTextArea background = new JTextArea("TO HELP YOU RECOMMEND A COURSE, WE SHOULD KNOW SOMETHINGS ABOUT YOU",1,wordlength);
   private JLabel que4 = new JLabel("Level of academics");
   private ButtonGroup group1 = new ButtonGroup();
   private JRadioButton ans4 = new JRadioButton("Primary");
   private JRadioButton ans42 = new JRadioButton("Secondary");
   private JRadioButton ans43 = new JRadioButton("Tertiary");
   private JLabel que5 = new JLabel("Choose the department you're coming from");
   private JComboBox ans5 = new JComboBox(dept); 
   private JLabel que6 = new JLabel("Have you had any IT experience before?");
   private ButtonGroup group2 = new ButtonGroup();
   private JRadioButton ans6 = new JRadioButton("Yes");
   private JRadioButton ans62 = new JRadioButton("No");
   private JLabel que7 = new JLabel("On what field was your study based?");
   private JComboBox ans7 = new JComboBox(courses);
   private JLabel que8 = new JLabel("Which of these characteristics describe you?");
   private JComboBox ans8 = new JComboBox(flare);
   private JLabel que9 = new JLabel("Do you enjoy keeping track of data, both old and new?");
   private ButtonGroup group3 = new ButtonGroup();
   private JRadioButton ans9 = new JRadioButton("Yes");
   private JRadioButton ans92 = new JRadioButton("No");
   private JRadioButton ans93 = new JRadioButton("Intermediate");
   private JLabel que10 = new JLabel("Do you enjoy using codes in order to restrict general access to an object?");
   private ButtonGroup group4 = new ButtonGroup();
   private JRadioButton ans10 = new JRadioButton("Yes");
   private JRadioButton ans101 = new JRadioButton("No");
   private JTextArea message = new JTextArea("CLICK THE \"Recommendation\" BUTTON BELOW FOR A RECOMMENDED COURSE.");
   private JButton recom = new JButton("Recommendation");
   private JTextArea recom1 = new JTextArea();
   private FlowLayout STYLE = new FlowLayout();
   private Rectangle r1 = new Rectangle(100, 30, 110, 20);
   private Rectangle r2 = new Rectangle(210, 30, 150, 20);
   private Rectangle r3 = new Rectangle(100, 110, 340,20);
   private JLabel star1 = new JLabel("*");
   private JLabel star2 = new JLabel("*");
   private JLabel star3 = new JLabel("*");
   private JLabel star4 = new JLabel("*");
   private JLabel star5 = new JLabel("*");
   private JLabel star6 = new JLabel("*");
   private Font font1 = new Font("Serif", Font.BOLD, 13);
   private Font font2 = new Font("sansSerif", Font.BOLD + Font.ITALIC, 20);
   private Font font3 = new Font("Serif2", Font.BOLD + Font.ITALIC, 30);
   private JPanel p = new JPanel();
   private BorderLayout bord5 = new BorderLayout();
   private JButton b = new JButton("Back");
   private ButtonGroup bgr = new ButtonGroup();
 

   //Constructor
   public Student(){
      win.setLayout(bord5);
      win.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      win.setLocation(240, 40);
      win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      p.setBounds(05, 05, 500, 700);
      p.setBackground(Color.WHITE);
      p.setLayout(null);
      win.add(p, bord5.CENTER);
      

      star1.setBounds(80, 170, 20, 20);
      star2.setBounds(80, 220, 20, 20);
      star3.setBounds(80, 270, 20, 20);
      star4.setBounds(80, 370, 20, 20);
      star5.setBounds(80, 420, 20, 20);
      star6.setBounds(80, 470, 20, 20);
      
      star1.setForeground(Color.RED);
      star2.setForeground(Color.RED);
      star3.setForeground(Color.RED);
      star4.setForeground(Color.RED);
      star5.setForeground(Color.RED);
      star6.setForeground(Color.RED);
      p.add(star1);
      p.add(star2);
      p.add(star3);
      p.add(star4);  
      p.add(star5);
      p.add(star6);
      
      //Arrange Components in GUI

      /*que1.setBounds(r1);
      r1.translate(0, 40);
      p.add(que1);

      ans1.setBounds(r2);
      r2.translate(0, 40); 
      p.add(ans1);

      que2.setBounds(r1);
      p.add(que2);

      ans2.setBounds(r2);
      r2.translate(0, 40);
      p.add(ans2);*/

      welcome.setBounds(60, 20, 800, 80);
      welcome.setEditable(false);
      welcome.setFont(font3);
      welcome.setWrapStyleWord(true);
      welcome.setLineWrap(true);
      welcome.setText(sur1.getText()+" "+oth1.getText()+" Welcome to our Students portal. Please fill the form below to get a course recommendation.");
      p.add(welcome);

      background.setBounds(100, 110, 520, 20);
      background.setFont(font1);
      background.setEditable(false);
      background.setBackground(Color.YELLOW);
      p.add(background);
    
      que4.setBounds(100, 170, 150, 20);
      p.add(que4);

      ans4.setBounds(220, 170, 90, 20);
      p.add(ans4);

      ans42.setBounds(315, 170, 80, 20);
      p.add(ans42);

      ans43.setBounds(410, 170, 80, 20);
      p.add(ans43);

      group1.add(ans4);
      group1.add(ans42);
      group1.add(ans43);

      que5.setBounds(100, 220, 270, 20);
      p.add(que5);

      ans5.setBounds(360, 220, 120, 20);
      p.add(ans5);

      que6.setBounds(100, 270, 250, 20);
      p.add(que6);

      ans6.setBounds(360, 270, 60, 20);
      p.add(ans6);

      ans62.setBounds(425, 270, 40, 20);
      p.add(ans62);
  
      group2.add(ans6);
      group2.add(ans62);

      que7.setBounds(100, 320, 230, 20);
      p.add(que7);

      ans7.setBounds(360, 320, 125, 20);
      p.add(ans7);

      que8.setBounds(100, 370, 270, 20);
      p.add(que8);

      ans8.setBounds(360, 370, 120, 20);
      p.add(ans8);

      que9.setBounds(100, 420, 320, 20);
      p.add(que9);

      ans9.setBounds(410, 420, 55, 20);
      p.add(ans9);

      ans92.setBounds(470, 420, 40, 20);
      p.add(ans92);

      ans93.setBounds(520, 420, 100, 20);
      p.add(ans93);

      group3.add(ans9);
      group3.add(ans92);
      group3.add(ans93);

      que10.setBounds(100, 470, 450, 20);
      p.add(que10);

      ans10.setBounds(520, 470, 80, 20);
      p.add(ans10);

      ans101.setBounds(610, 470, 40, 20);
      p.add(ans101);

      group4.add(ans10);
      group4.add(ans101);

      message.setBounds(100, 520, 520, 20);
      message.setEditable(false);
      message.setFont(font1);
      message.setBackground(Color.WHITE);
      p.add(message);

      recom.setBounds(100, 570, 140, 20);
      p.add(recom);

      /*b.setBounds(250, 570, 100, 20);
      b.setToolTipText("Click to go back to the selection pane");
      p.add(b); 
      bgr.add(recom); bgr.add(b);*/

      recom1.setBounds(100, 615, 600, 90);
      recom1.setFont(font2);
      recom1.setLineWrap(true);
      recom1.setWrapStyleWord(true);
      recom1.setForeground(Color.MAGENTA);
      recom1.setEditable(false);
      recom1.setBackground(Color.WHITE);
      p.add(recom1);
      
      //Display GUI
      win.setVisible(true);
      p.setVisible(true);
      /*b.addActionListener(new ActionListener{
         public void actionPerformed(ActionEvent evd){
            win.setVisible(false);
            fra.setVisible(true);
      }});*/
 
      ans6.addItemListener(new ItemListener(){
      public void itemStateChanged(ItemEvent e1){
         ans7.setEnabled(true);
      }
   });
   ans62.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e2){ 
         ans7.setEnabled(false);
      }
   });


   recom.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e3){

         try{
                       String occ = "Student";
                       String s = "insert into Visitors(Sur_Name, Other_Names, Occupation, Phone_Number, Email_Address, Contact_Address)"
                                +" values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+phone1.getText()+"','"+mail1.getText()+"','"+contact1.getText()+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(s);
                       vis.close();
            }
                    catch(SQLException exc){
                       System.out.println(" ");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");
                    }
         
         //String name = (ans1.getText())+" "+(ans2.getText());
         String depts = ans5.getSelectedItem().toString();
         String course = ans7.getSelectedItem().toString();
         String flares = ans8.getSelectedItem().toString();
       
           ans4.setEnabled(false);
        
        if(((!ans6.isSelected())&&(!ans62.isSelected()))
            ||((!ans9.isSelected())&&(!ans92.isSelected())&&(!ans93.isSelected()))
            &&((!ans10.isSelected())||(!ans101.isSelected()))
            ||((!ans4.isSelected())&&(!ans42.isSelected())&&(!ans43.isSelected()))){
            String warn = (/*name+*/"Please fill any field having an asterisk");
            recom1.setText(warn);
         }
        

        if(ans6.isSelected()&&(course.equals(courses[0])||course.equals(courses[2])
           ||course.equals(courses[3])||course.equals(courses[5])||course.equals(courses[6])||course.equals(courses[7]))
           &&(ans42.isSelected()||ans43.isSelected())
           &&(depts.equals(dept[0])||depts.equals(dept[1])||depts.equals(dept[2])
           ||depts.equals(dept[3])||depts.equals(dept[4]))&&(flares.equals(flare[0])
           ||flares.equals(flare[1])||flares.equals(flare[2]))
           &&(!ans9.isSelected()&&ans92.isSelected()||ans93.isSelected())
           &&(ans10.isSelected()&&(!ans101.isSelected()))){

              String adv1 = /*name+*/"I suggest you study Software Engineering or Networking";
              recom1.setText(adv1);
              try{
                    String occ = "Student";
                    String cou = "Software Engineering or DBA";
                    String sw = "insert into Student(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    } 
        }
        else if(ans6.isSelected()&&(course.equals(courses[0])||course.equals(courses[1])
           ||course.equals(courses[2])||course.equals(courses[3])||course.equals(courses[4])||course.equals(courses[5])||course.equals(courses[7]))
           &&(ans42.isSelected()||ans43.isSelected())
           &&(depts.equals(dept[0])||depts.equals(dept[1])||depts.equals(dept[2])
           ||depts.equals(dept[3])||depts.equals(dept[4]))&&(flares.equals(flare[0])
           ||flares.equals(flare[1])||flares.equals(flare[2])||flares.equals(flare[3])||flares.equals(flare[4]))
           &&(ans9.isSelected()||ans92.isSelected()||ans93.isSelected())
           &&(!ans10.isSelected())&&(ans101.isSelected())){

              String adv1 = /*name+*/"Well, you don't enjoy using codes, so I advise you study Information Technology ";
              recom1.setText(adv1);
              try{
                    String occ = "Student";
                    String cou = "Information Technology ";
                    String sw = "insert into Student(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    } 
        }

        else if(ans6.isSelected()&&(course.equals(courses[0])||course.equals(courses[1])
           ||course.equals(courses[3])||course.equals(courses[4])||course.equals(courses[5])||course.equals(courses[6]))
           &&(ans42.isSelected()||ans43.isSelected())
           &&(depts.equals(dept[0])||depts.equals(dept[1])||depts.equals(dept[2])
           ||depts.equals(dept[3])||depts.equals(dept[4]))&&(flares.equals(flare[0])
           ||flares.equals(flare[1])||flares.equals(flare[2])||flares.equals(flare[3])||flares.equals(flare[4]))
           &&(ans9.isSelected()||ans92.isSelected()||ans93.isSelected())
           &&(!ans10.isSelected())&&(ans101.isSelected())){

              String adv1 = /*name+*/"Well, you don't enjoy using codes, so I advise you study Computer Engineering or Desktop Publishing ";
              recom1.setText(adv1);
              try{
                    String occ = "Student";
                    String cou = "Computer Engineering or Desktop Publishing ";
                    String sw = "insert into Student(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    } 
        }

        else if (ans6.isSelected()&&(course.equals(courses[0])
           ||course.equals(courses[2])||course.equals(courses[3])||course.equals(courses[4])||course.equals(courses[5])||course.equals(courses[7]))
           &&(ans42.isSelected()||ans43.isSelected())
           &&(depts.equals(dept[0])
           ||depts.equals(dept[1])||depts.equals(dept[2])
           ||depts.equals(dept[3])||depts.equals(dept[4]))
           &&(flares.equals(flare[0])||flares.equals(flare[1])
           ||flares.equals(flare[2])||flares.equals(flare[3])
           ||flares.equals(flare[4]))
           &&(ans9.isSelected()||ans92.isSelected()||ans93.isSelected())
           &&(ans10.isSelected()
           ||ans101.isSelected())){
               recom1.setText(/*name+*/"I suggest you study, either Networking or Information Technology or both");
               try{
                    String occ = "Student";
                    String cou = "Networking or Information Technology";
                    String sw = "insert into Student(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    } 
        }

        else if (ans6.isSelected()&&(course.equals(courses[1])
           ||course.equals(courses[2])||course.equals(courses[3])||course.equals(courses[5])||course.equals(courses[6])||course.equals(courses[7]))
           &&(ans42.isSelected()||ans43.isSelected())
           &&(depts.equals(dept[0])
           ||depts.equals(dept[1])||depts.equals(dept[2])
           ||depts.equals(dept[3])||depts.equals(dept[4]))
           &&(flares.equals(flare[0])||flares.equals(flare[1])
           ||flares.equals(flare[2])||flares.equals(flare[3])||flares.equals(flare[4]))
           &&(ans92.isSelected()||ans93.isSelected())
           &&(ans10.isSelected()&&!ans101.isSelected())){
               recom1.setText(/*name+*/"I suggest you study, either Software Engineering or Security or both");
               try{
                    String occ = "Student";
                    String cou = "Software Engineering or Security";
                    String sw = "insert into Student(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    }         
        }  

        else if (ans6.isSelected()
           &&(course.equals(courses[1])||course.equals(courses[2])||course.equals(courses[3])||course.equals(courses[4])||course.equals(courses[5])||course.equals(courses[6]))
           &&(ans42.isSelected()||ans43.isSelected())
           &&(depts.equals(dept[0])
           ||depts.equals(dept[1])||depts.equals(dept[2])
           ||depts.equals(dept[3])||depts.equals(dept[4]))
           &&(flares.equals(flare[0])||flares.equals(flare[1])
           ||flares.equals(flare[2])||flares.equals(flare[3])||flares.equals(flare[4]))
           &&(ans9.isSelected()||ans92.isSelected()||ans93.isSelected())
           &&(ans10.isSelected()&&!ans101.isSelected())){
               recom1.setText(/*name+*/"I suggest you study, either Computer Engineering or Security or both");
               try{
                    String occ = "Student";
                    String cou = "Computer Engineering or Security";
                    String sw = "insert into Student(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    }         
        }  
     
        else if((ans6.isSelected())&&(course.equals("Security"))
           &&(ans42.isSelected()||ans43.isSelected())
           &&(depts.equals(dept[0])
           ||depts.equals(dept[1])||depts.equals(dept[2])
           ||depts.equals(dept[3])||depts.equals(dept[4]))
           &&(flares.equals(flare[0])||flares.equals(flare[1]))
           &&(ans92.isSelected()||ans93.isSelected())
           &&(ans10.isSelected())){
               recom1.setText(/*name+*/"I suggest you study Software Engineering.");
               try{
                    String occ = "Student";
                    String cou = "Software Engineering";
                    String sw = "insert into Student(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    }  
        }
        
        else if((ans6.isSelected())&&(course.equals("Computer Engineering"))
           &&(ans42.isSelected()||ans43.isSelected())
           &&(depts.equals(dept[0])
           ||depts.equals(dept[1])||depts.equals(dept[2])
           ||depts.equals(dept[3])||depts.equals(dept[4]))
           &&(flares.equals(flare[0])||flares.equals(flare[1])
           ||flares.equals(flare[2]))
           &&(ans9.isSelected())
           &&(ans10.isSelected())){
               recom1.setText(/*name+*/"I suggest you study, either Software Engineering or D.B.A. or both");
               try{
                    String occ = "Student";
                    String cou = "Software Engineering or DBA";
                    String sw = "insert into Student(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    }  
        }

        else if((ans6.isSelected())&&(course.equals("Security"))
           &&(ans42.isSelected()||ans43.isSelected())
           &&(depts.equals(dept[0])
           ||depts.equals(dept[1])||depts.equals(dept[2])
           ||depts.equals(dept[3])||depts.equals(dept[4]))
           &&(flares.equals(flare[1])||flares.equals(flare[3])
           ||flares.equals(flare[4]))
           &&(ans9.isSelected())
           &&(ans10.isSelected())){
               recom1.setText(/*name+*/"I suggest you study D.B.A.");
               try{
                    String occ = "Student";
                    String cou = "Database Management";
                    String sw = "insert into Student(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    }  
        }

        else if((ans6.isSelected())&&(course.equals("Security"))
           &&(ans42.isSelected()||ans43.isSelected())
           &&(depts.equals(dept[0])
           ||depts.equals(dept[1])||depts.equals(dept[2])
           ||depts.equals(dept[3])||depts.equals(dept[4]))
           &&(flares.equals(flare[0])||flares.equals(flare[1])
           ||flares.equals(flare[2])||flares.equals(flare[3])
           ||flares.equals(flare[4]))
           &&(ans9.isSelected()||ans92.isSelected()||ans93.isSelected())
           &&(ans101.isSelected())){
               recom1.setText(/*name+*/"Since you dont like working with codes, I suggest you study Desktop Publishing.");
               try{
                    String occ = "Student";
                    String cou = "Desktop Publishing";
                    String sw = "insert into Student(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    }   
        }


        
        else if(ans6.isSelected()&&(course.equals(courses[0])||course.equals(courses[1])
           ||course.equals(courses[2])||course.equals(courses[3])||course.equals(courses[4])||course.equals(courses[5])||course.equals(courses[6])||course.equals(courses[7]))
           &&(ans42.isSelected()||ans43.isSelected())
           &&(depts.equals(dept[0])
           ||depts.equals(dept[1])||depts.equals(dept[2])
           ||depts.equals(dept[3])||depts.equals(dept[4]))
           &&(flares.equals(flare[3]))
           &&(!ans9.isSelected()&&(ans92.isSelected()||ans93.isSelected()))
           &&(ans10.isSelected()||ans101.isSelected())){
               recom1.setText(/*name+*/"How come you're a keeper of records, and at the same time you dont enjoy keeping records of data?");        
        }

        else if(ans62.isSelected()
           &&(ans42.isSelected()||ans43.isSelected())
           &&(depts.equals(dept[0])
           ||depts.equals(dept[1])||depts.equals(dept[2])
           ||depts.equals(dept[3])||depts.equals(dept[4]))
           &&(flares.equals(flare[0])||flares.equals(flare[1])
           ||flares.equals(flare[2])||flares.equals(flare[3])||flares.equals(flare[4]))
           &&(ans9.isSelected()||ans92.isSelected()||ans93.isSelected())
           &&(ans10.isSelected()
           ||ans101.isSelected())){
              recom1.setText(/*name+*/"Since you have no IT experience, I suggest you study IT Fundamentals.");
              try{
                    String occ = "Student";
                    String cou = "IT Fundamentals";
                    String sw = "insert into Student(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    }  
           }
         
        else if (ans6.isSelected()&&(depts.equals(dept[0])||depts.equals(dept[1])
           ||depts.equals(dept[2])||depts.equals(dept[4]))
           &&(ans42.isSelected()||ans43.isSelected())
           &&(flares.equals(flare[3])||flares.equals(flare[4]))
           &&(course.equals(courses[0])||course.equals(courses[1])
           ||course.equals(courses[2])||course.equals(courses[3])||course.equals(courses[4])
           ||course.equals(courses[6])||course.equals(courses[7]))){
           recom1.setText(/*name+*/", I advice you study DataBase Management.");
           try{
                    String occ = "Student";
                    String cou = "Database Management";
                    String sw = "insert into Student(Sur_Name, Other_Names, Occupation, Recommended_Course) values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+cou+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(sw);
                       vis.close();
                    }
                    catch(SQLException exc){
                       System.out.println("SQLException occured");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");   
                    }   
         }
         
         
         
         
        
      }
   });
            
  
   ans4.addActionListener(
      new ActionListener(){
         public void actionPerformed(ActionEvent e4){
            fra.setVisible(false);
            win.setVisible(false);
            new Primary();
            
         }
      });
   ans42.addActionListener(
      new ActionListener(){
         public void actionPerformed(ActionEvent e5){
            ans5.setEnabled(true);
         }
      });

   ans43.addActionListener(
      new ActionListener(){
         public void actionPerformed(ActionEvent e6){
            ans5.setEnabled(true);
         }
      });
   }

  

   public class Primary {

   private JFrame pri = new JFrame("For the Primary School Child");
   private JTextArea welcome = new JTextArea();
   private String[] basic = {"BASIC 1", "BASIC 2", "BASIC 3", "BASIC 4", "BASIC 5", "BASIC 6"};
   private JLabel cla = new JLabel("Choose your class");
   private JComboBox choose = new JComboBox(basic);
   private JLabel sch = new JLabel("School Name");
   private JTextField sch2 = new JTextField(100);
   private JLabel addr = new JLabel("School Address");
   private JTextField addr2 = new JTextField(100);
   private JLabel que1 = new JLabel("Do you offer Computer Studies at school?");
   private JCheckBox ans1 = new JCheckBox("Yes");
   private JCheckBox ans12 = new JCheckBox("No");
   private ButtonGroup gr1 = new ButtonGroup();
   private JLabel que2 = new JLabel("Private Tutor?");
   private JCheckBox ans2 = new JCheckBox("Yes");
   private JCheckBox ans22 = new JCheckBox("No");
   private ButtonGroup gr2 = new ButtonGroup();
   private Font font1 = new Font("Serif", Font.BOLD, 13);
   private Font font2 = new Font("sansSerif", Font.BOLD + Font.ITALIC, 20);
   private JTextArea info = new JTextArea("CLICK THE \"Submit\" BUTTON BELOW TO SUBMIT THIS FORM.");
   private JButton run = new JButton("Submit");
   //private JButton bak = new JButton("Back");
   private JButton ca = new JButton("Cancel");
   private ButtonGroup gr3 = new ButtonGroup();
   private JTextArea run1 = new JTextArea();
   private JPanel p1 = new JPanel();
   private BorderLayout bord6 = new BorderLayout();



   public Primary(){
      pri.setSize(540, 580);
      pri.setLocation(300, 100);
      pri.setLayout(bord6);
      pri.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      //p1.setBounds(03, 03, 1600, 1000);
      p1.setBackground(Color.WHITE);
      p1.setLayout(null);
      pri.add(p1, bord6.CENTER);

      String name = sur1.getText()+" "+oth1.getText();
      String names = name.toUpperCase();
      welcome.setBounds(30, 30, 400, 30);
      welcome.setText(names+", WELCOME TO THE PRIMARY SCHOOL COUNSELLOR ");
      welcome.setForeground(Color.BLUE);
      welcome.setEditable(false);
      welcome.setFont(font1);
      p1.add(welcome);

      sch.setBounds(30, 100, 110, 20);
      p1.add(sch);

      sch2.setBounds(200, 100, 200, 20);
      p1.add(sch2);

      addr.setBounds(30, 150, 110, 20);
      p1.add(addr);
 
      addr2.setBounds(200, 150, 200, 20);      
      p1.add(addr2);

      cla.setBounds(30, 200, 150, 20);
      p1.add(cla);

      choose.setBounds(200, 200, 100, 20);
      p1.add(choose);

      que1.setBounds(30, 250, 300, 20);
      p1.add(que1);

      ans1.setBounds(290, 250, 60, 20);
      ans12.setBounds(360, 250, 60, 20);
      gr1.add(ans1); gr1.add(ans12);
      p1.add(ans1); p1.add(ans12);

      que2.setBounds(30, 300, 150, 20);
      p1.add(que2);

      ans2.setBounds(190, 300, 60, 20);
      ans22.setBounds(260, 300, 50, 20);
      gr2.add(ans2); gr2.add(ans22);
      p1.add(ans2); p1.add(ans22);
      
      info.setBounds(30, 390, 500, 20);
      info.setFont(font1);
      info.setEditable(false);
      p1.add(info);
      
      run.setBounds(30, 430, 100, 20);
      run.setToolTipText("Click to submit this form");
      p1.add(run);

      //bak.setBounds(140, 430, 100, 20);
     // bak.setToolTipText("Click to go back to the Student's portal");
      //p1.add(bak);

      ca.setBounds(250, 430, 100, 20);
      ca.setToolTipText("Click to exit this page");
      p1.add(ca);
   
      gr3.add(run);
      //gr3.add(bak);
      gr3.add(ca);

      /*
run1.setBounds(30, 470, 410, 50);
      run1.setFont(font2);
      run1.setLineWrap(true);
      run1.setWrapStyleWord(true);
      run1.setEditable(false);
      run1.setBackground(Color.YELLOW);*/
      
      p1.add(run1);
      pri.setVisible(true);
      p1.setVisible(true);

      run.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent evt){
                    try{
                       String occ = "Student";
                       String s = "insert into Visitors(Sur_Name, Other_Names, Occupation, Phone_Number, Email_Address, Contact_Address)"
                                +" values('"+sur1.getText()+"','"+oth1.getText()+"','"+occ+"','"+phone1.getText()+"','"+mail1.getText()+"','"+contact1.getText()+"');";
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       System.out.println("Driver Installed successfully");
                       Connection vis = DriverManager.getConnection("jdbc:odbc:ACM");
                       System.out.println("Connection established successfully"); 
                       Statement st = vis.createStatement();
                       st.executeUpdate(s);
                       vis.close();
                    }
                    catch(SQLException exc){
                       JOptionPane.showMessageDialog(null,"SQLException occured: Your name has been inputed before");
                    }
                    catch(ClassNotFoundException exc1){
                       System.out.println("ClassNotFoundException");
                    }
            
            if (ans1.isSelected()&&ans2.isSelected()){
            
               try{
                  String ya = "Yes";
                  String ba = choose.getSelectedItem().toString();
                  String sc = sch2.getText()+", "+addr2.getText();
                  String ins = "insert into Elementary(Sur_Name, Other_Names, School, Class, Computer_Studies_In_School, Home_Tutorials)"
                             +"values('"+sur1.getText()+"','"+oth1.getText()+"','"+sc+"','"+ba+"','"+ya+"','"+ya+"');"; 
                  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                  Connection c = DriverManager.getConnection("jdbc:odbc:ACM");
                  Statement stm = c.createStatement();
                  stm.executeUpdate(ins);
                  c.close();
               }
               catch(SQLException es1){
                  System.out.println("SQLException occured.");
               }
               catch(ClassNotFoundException es2){
                  System.out.println("ClassNotFoundException occured");
               }
            }

            
            else if (ans12.isSelected()&&ans2.isSelected()){
            
               try{
                  String na = "No";
                  String ya = "Yes";
                  String ba = choose.getSelectedItem().toString();
                  String sc = sch2.getText()+", "+addr2.getText();
                  String ins = "insert into Elementary(Sur_Name, Other_Names, School, Class, Computer_Studies_In_School, Home_Tutorials)"
                             +"values('"+sur1.getText()+"','"+oth1.getText()+"','"+sc+"','"+ba+"','"+na+"','"+ya+"');"; 
                  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                  Connection c = DriverManager.getConnection("jdbc:odbc:ACM");
                  Statement stm = c.createStatement();
                  stm.executeUpdate(ins);
                  c.close();
               }
               catch(SQLException es1){
                  System.out.println("SQLException occured.");
               }
               catch(ClassNotFoundException es2){
                  System.out.println("ClassNotFoundException occured");
               }
            }        

            
            else if (ans1.isSelected()&&ans22.isSelected()){
            
               try{
                  String na = "No";
                  String ya = "Yes";
                  String ba = choose.getSelectedItem().toString();
                  String sc = sch2.getText()+", "+addr2.getText();
                  String ins = "insert into Elementary(Sur_Name, Other_Names, School, Class, Computer_Studies_In_School, Home_Tutorials)"
                             +"values('"+sur1.getText()+"','"+oth1.getText()+"','"+sc+"','"+ba+"','"+ya+"','"+na+"');"; 
                  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                  Connection c = DriverManager.getConnection("jdbc:odbc:ACM");
                  Statement stm = c.createStatement();
                  stm.executeUpdate(ins);
                  c.close();
               }
               catch(SQLException es1){
                  System.out.println("SQLException occured.");
               }
               catch(ClassNotFoundException es2){
                  System.out.println("ClassNotFoundException occured");
               }
            }

            
            else if (ans12.isSelected()&&ans22.isSelected()){
            
               try{
                  String na = "No";
                  String ya = "Yes";
                  String ba = choose.getSelectedItem().toString();
                  String sc = sch2.getText()+", "+addr2.getText();
                  String ins = "insert into Elementary(Sur_Name, Other_Names, School, Class, Computer_Studies_In_School, Home_Tutorials)"
                             +"values('"+sur1.getText()+"','"+oth1.getText()+"','"+sc+"','"+ba+"','"+na+"','"+na+"');"; 
                  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                  Connection c = DriverManager.getConnection("jdbc:odbc:ACM");
                  Statement stm = c.createStatement();
                  stm.executeUpdate(ins);
                  c.close();
               }
               catch(SQLException es1){
                  System.out.println("SQLException occured.");
               }
               catch(ClassNotFoundException es2){
                  System.out.println("ClassNotFoundException occured");
               }
            }        
            pri.setVisible(false);
            
      }});

      /*bak.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent eva){
            pri.setVisible(false);
            win.setVisible(true);
      }});*/

      ca.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent evb){
            pri.setVisible(false);
      }});  
        
   }
}   
}//Student close
}//A close 
}//Identity close													
   
   //Application Entry Point
   public static void main(String[] args){
      new ACM();
   }

}// ACM close      