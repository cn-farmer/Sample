package chap06.sect02;
class InterruptAllMethod {
  public static void main(String[] args) throws InterruptedException {
    Thread.currentThread().interrupt();

    System.out.println("step1 : " + Thread.currentThread().isInterrupted());
    System.out.println("step2 : " + Thread.currentThread().isInterrupted());
    System.out.println("step3 : " + Thread.interrupted());
    System.out.println("step4 : " + Thread.interrupted());

    Thread subThread = new Thread(() -> {
      try {
        Thread.sleep(99999);
      } catch (InterruptedException e) { e.printStackTrace(); }
    });
    subThread.start();
    subThread.interrupt();
    System.out.println("step5 : " + subThread.isInterrupted());
    Thread.sleep(100);
    System.out.println("step6 : " + subThread.isInterrupted());
  }
}