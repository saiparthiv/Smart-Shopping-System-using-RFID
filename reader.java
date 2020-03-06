ion Port opening on reading RFID
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import com.fazecast.jSerialComm.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class NewClass
public static void main(String[] args) throws IOException
SerialPort[] ports = SerialPort.getCommPorts();
System.out.println("Select a port:");
int i = 1;
for(SerialPort port : ports)
System.out.println(i++ + ": " + port.getSystemPortName());
Scanner s = new Scanner(System.in);
int chosenPort = s.nextInt();
SerialPort serialPort = ports[chosenPort - 1];
if(serialPort.openPort())
System.out.println("Port opened successfully.");
else
System.out.println("Unable to open the port.");
return;
serialPort.setComPortTimeouts(SerialPort.TIMEOUTSCANNER; 0; 0);
Scanner data = new Scanner(serialPort.getInputStream());
String value;
FileWriter fw = new FileWriter("D:
myprojects
Port
port.txt", true);
BufferedWriter bw= new BufferedWriter(fw);
PrintWriter out=new PrintWriter(bw);
while(data.hasNext())
value = data.next();
System.out.println("Gas"+(String)data.nextLine()+""+"Temp "+(String)data.nextLine());
out.println( "Gas "+(String)data.nextLine()+""+"Temp "+(String)data.nextLine());
try
Class.forName("com.mysql.jdbc.Driver"); Connection con=(Connection)DriverManager.getConnection("PreparedStatement ps=con.prepareStatement("insert into po(portid,tempid)values(?,?)");
ps.setString(1,(String)data.nextLine());
ps.setString(2,(String)data.nextLine());
int x=ps.executeUpdate();
if(x!=0)
// tryvalue =
Integer.parseInt(data.nextLine());catch(Exception e)
// slider.setValue(value);
catch(Exception e)
System.out.println(e);
out.close();
data.close();
System.out.println("Done.");
