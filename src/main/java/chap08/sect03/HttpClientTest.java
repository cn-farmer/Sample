package chap08.sect03;
import java.net.URI;
import java.net.http.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.Flow;
public class HttpClientTest {
  public static void main(String[] args) throws Exception {
    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:5000")).build();
    var subscriber = HttpResponse.BodySubscribers.fromSubscriber(new MySubscriber());
    client.sendAsync(request, responseInfo -> subscriber).join();
  }
  static class MySubscriber implements Flow.Subscriber<List<ByteBuffer>> {
    Flow.Subscription subscription;
    public void onSubscribe(Flow.Subscription subscription) {
      this.subscription = subscription;
      subscription.request(1);
    }
    public void onNext(List<ByteBuffer> item) {
      for (ByteBuffer buffer : item) {
        System.out.print(Charset.defaultCharset().decode(buffer));
      }
      subscription.request(1);
    }
    public void onError(Throwable throwable) { }
    public void onComplete() { }
  }
}