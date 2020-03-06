#include<liquidcrystal.h>
String inputString = ""; // a string to hold incoming data
void setup()
{
// initialize the LED pin as an output:
pinMode(smcrd, INPUT);
Serial.begin(9600);
// initialize the pushbutton pin as an input:
}
void loop() {
// set the cursor to column 0, line 1
// (note: line 1 is the second row, since counting begins with 0):
// print the number of seconds since reset:
if (stringComplete)
{
lcd.setCursor(15, 1);
lcd.print(inputString[9]);
// clear the string:
if(inputString[9]==’5’)
{
else if(inputString[9]==’9’)
{
Serial.println("Product:Googles ");
Serial.println("(specs) ");
Serial.println("Cost Price:Rs.2000");
}
else if(inputString[9]==’2’)
{
Serial.println("Product:Oil ");
Serial.println("weight:10 litres ");
Serial.println("Cost Price:Rs.3000");
}
}
else
{
}
inputString = "";
stringComplete = false;
}
delay(100);
}
void serialEvent()
{
while (Serial.available())
{
// get the new byte:
char inChar = Serial.read();
// add it to the inputString:
// if the incoming character is a newline, set a flag
// so the main loop can do something about it:
inputString += inChar;
// if the incoming character is a newline, set a flag
// so the main loop can do something about it:
if (inChar == ”)
{
delay(100);
}
}
