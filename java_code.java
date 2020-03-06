import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import com.fazecast.jSerialComm.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Smart {
private static Connection con;
private static PreparedStatement ps = null;
public Smart() throws ClassNotFoundException, SQLException {
Class.forName("com.mysql.jdbc.Driver");
con = (Connection)
DriverManager.getConnection("jdbc:mysql://localhost:3306/trol", "root", "root");
}
public void delete() {
String sql = "DELETE FROM inventory";
try {
PreparedStatement pstmt = con.prepareStatement(sql);
// set the corresponding param //pstmt.setInt(1, id);
// execute the delete statement pstmt.executeUpdate();
} catch (SQLException e) {
System.out.println(e.getMessage());
} }
public static void main(String[] args) throws IOException,
ClassNotFoundException, SQLException {
Smart smat = new Smart();
smat.delete();
SerialPort[] ports = SerialPort.getCommPorts();
System.out.println("Select a port:");
int i = 1;
for (SerialPort port : ports) {
System.out.println(i++ + ": " + port.getSystemPortName());
}
Scanner s = new Scanner(System.in);
int chosenPort = s.nextInt();
SerialPort serialPort = ports[chosenPort - 1];
if (serialPort.openPort()) {
System.out.println("Port opened successfully.");
} else {
System.out.println("Unable to open the port."); return; }
serialPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
Scanner data = new Scanner(serialPort.getInputStream()); String value; //FileWriter
fw = new FileWriter("F:
Project
Troll
reading
data.txt", true); //BufferedWriter bw= new BufferedWriter(fw); //PrintWriter out=new
PrintWriter(bw);
while (data.hasNext()) {
value = data.nextLine();
String array1[] = value.split(",");
String[] name = array1[0].split(":");
System.out.println("" + name[0]);
String[] a;
String[] b;
String[] c;
String balance = "0";
if (name[0].equals("ProductName")) {
a = array1[0].split(":");
b = array1[1].split(":");
c = array1[2].split(":");
System.out.println("a = " + a[1]);
System.out.println("b = " + b[1]);
System.out.println("c = " + c[1]);
//select quanti from product where productname=’oil’;
// ps = con.prepareStatement("select quanti from product where productname=’"+a[1]+"’");
// Statement st = con.createStatement();
// String sql = ("select quanti from product where productname=’" + a[1] + "’");
// ResultSet rs = st.executeQuery(sql);
// if (rs.next()) {
// //int id = rs.getInt("firstcolumnname");
// str1 = rs.getString(1);
// }
//String balance = str1 - b[1];
int foo;
if(b[1].contains("kg")){
balance=b[1].replaceAll("kg", "");
foo=Integer.parseInt(balance);
}else{
balance=b[1].replaceAll("lit", "");
foo=Integer.parseInt(balance);
}
int bal=1000-foo;
ps = con.prepareStatement("insert into inventory(produt,qut,price,balance)values(?,?,?,?)");
ps.setString(1, a[1]);
ps.setString(2, b[1]);
ps.setString(3, c[1]);
ps.setString(4, String.valueOf(bal));
} else {
a = array1[0].split(":");
System.out.println("a = " + a[1]);
System.out.println("b = " + array1[1]);
System.out.println("c = " + array1[2]);
ps = con.prepareStatement("insert into inventory(produt,qut,price,balance)values(?,?,?,?)");
ps.setString(1, a[1]);
ps.setString(2, array1[1]);
ps.setString(3, array1[2]);
ps.setString(4, "0");
}
try {
int x = ps.executeUpdate();
if (x != 0) {
}
} catch (Exception e) {
System.out.println(e);
}
}
//out.close();
data.close();
System.out.println("Done.");
}
}
