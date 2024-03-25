package chap05.sect01 ;
public class MyByteArrayInputStream{
    byte buf[];  int pos, mark=0, count;
    public MyByteArrayInputStream(byte buf[]) {
        this.buf = buf;
        this.pos = 0;
        this.count = buf.length;
    }
    public int read() {
        return (pos < count) ? (buf[pos++] & 0xff) : -1;
    }
    public void mark() {
        mark = pos;
    }
    public void reset() {
        pos = mark;
    }
    public int available() {
        return count - pos;
    }
    public String toString() {
    	return java.util.Arrays.toString(buf)+" pos:"+pos+" count:"+count+" mark:"+mark;
    }
	public static void main(String[] args) {
		MyByteArrayInputStream stream = new MyByteArrayInputStream("abcd".getBytes());
		System.err.println("read:"+String.valueOf(stream.read()) + "\t" + stream);
		stream.mark();
		while( stream.available() > 0){
			System.out.println(String.valueOf(stream.read()) + stream);
		}
		stream.reset();
		System.err.println("reset:" + "\t" + stream);
	}
}