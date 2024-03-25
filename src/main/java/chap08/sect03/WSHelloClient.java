package chap08.sect03;
import java.io.*;
import java.net.*;
public class WSHelloClient {
  public static void main(String[] args) throws MalformedURLException, IOException {
    URLConnection conn = new URL("http://127.0.0.1:5000/hello").openConnection();
    conn.setDoOutput(true);
    conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");

    StringBuilder sb = new StringBuilder();
    sb.append("<soapenv:Envelope ")
     .append("xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' ")
     .append("xmlns:myNS='http://sect03.chap08/'><soapenv:Header/><soapenv:Body>")
     .append("<myNS:sayHello><arg0>hello server</arg0></myNS:sayHello>")
     .append("</soapenv:Body></soapenv:Envelope>");

    OutputStream os = conn.getOutputStream();
    os.write(sb.toString().getBytes("utf-8"));

    var br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    System.out.println(br.readLine());
  }
}