package chap08.sect03;
import java.util.concurrent.Executors;
import com.sun.net.httpserver.*;
public class HttpServerTest {
  public static void main(String[] args) throws Exception {
    HttpServer server = HttpServer.create(new java.net.InetSocketAddress(5000), 0);
    server.setExecutor(Executors.newFixedThreadPool(5));
    server.createContext("/", new HttpHandler() {
      @Override
      public void handle(HttpExchange exchange) throws java.io.IOException {
        System.err.println(Thread.currentThread().getName());
        exchange.getRequestHeaders().entrySet().forEach(System.out::println);
        Headers headers = exchange.getResponseHeaders();
        headers.set("Content-Type", "text/stream");
        exchange.sendResponseHeaders(200, 0);
        java.io.OutputStream out = exchange.getResponseBody();
        for (int i = 0; i < 100; i++) {
          out.write(("hello server : " + new java.util.Date() + "\n").getBytes());
          out.flush();
          try { Thread.sleep(1000); } catch (Exception e) { e.printStackTrace(); }
        }
        out.close();
      }
    });
    server.start();
  }
}