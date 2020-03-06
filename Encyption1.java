import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.AlgorithmParameters;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
public class encryption1
void encr(String args) throws Exception
// file to be encrypted
String s=args;
// String ss=s[0].toString();
JOptionPane.showMessageDialog(null, s);
String s1=s;
// String s1="D:
file
file1
"+ss;
FileInputStream inFile = new FileInputStream(s1);
// encrypted file
// FileOutputStream outFile = new FileOutputStream("D:
file
ccaf
encrypt file
"+ss);
FileOutputStream outFile = new FileOutputStream(s1);
// FileOutputStream outFile = new FileOutputStream("D:
file
file1
en
"+ss);
// password to encrypt the file String password = "javapapers";
// password, iv and salt should be transferred to the other end // in a secure manner
// salt is used for encoding // writing it to a file // salt should be transferred to the
recipient securely // for decryption
byte[] salt = new byte[8];
SecureRandom secureRandom = new SecureRandom
secureRandom.nextBytes(salt);
FileOutputStream saltOutFile = new FileOutputStream("D:
myprojects
SmartCard
salt.enc");
// FileOutputStream saltOutFile = new FileOutputStream("D:
file
file1
salt.enc");
saltOutFile.write(salt);
saltOutFile.close();
SecretKeyFactory factory = SecretKeyFactory .getInstance("PBKDF2WithHmacSHA1");
KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
SecretKey secretKey = factory.generateSecret(keySpec);
SecretKey secret = new SecretKeySpec(secretKey.getEncoded(), "AES");
//
Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
cipher.init(Cipher.ENCRYPTMODE; secret);
AlgorithmParameters params = cipher.getParameters();
// iv adds randomness to the text and just makes the mechanism more
// secure // used while initializing the cipher // file to store the iv
FileOutputStream ivOutFile = new FileOutputStream("D:
myprojects
SmartCard
iv.enc");
byte[] iv = params.getParameterSpec(IvParameterSpec.class).getIV();
ivOutFile.write(iv);
ivOutFile.close();
//file encryption
byte[] input = new byte[64];
int bytesRead;
while ((bytesRead = inFile.read(input)) != -1) byte[] output = cipher.update(input, 0,
bytesRead);
if (output != null) outFile.write(output);
}
byte[] output = cipher.doFinal();
if (output != null) outFile.write(output);
inFile.close();
outFile.flush();
outFile.close();
System.out.println("File Encrypted.");
}
}
