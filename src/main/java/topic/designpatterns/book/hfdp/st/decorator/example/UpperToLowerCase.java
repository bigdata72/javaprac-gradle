package topic.designpatterns.book.hfdp.st.decorator.example;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UpperToLowerCase {
	public static void main(String[] args) {
		// read from Input Stream a line and convert all upper case character to lower case
		UpperToLowerCaseConverter conv = new UpperToLowerCaseConverter(
							new BufferedInputStream(System.in));
		System.out.println("Enter something");
		int c;
		try{
			while((c = conv.read()) != -1){
				System.out.print((char)c);
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
}
class UpperToLowerCaseConverter extends FilterInputStream {
	
	
	/**
	 * Creates a <code>FilterInputStream</code>
	 * by assigning the  argument <code>in</code>
	 * to the field <code>this.in</code> so as
	 * to remember it for later use.
	 *
	 * @param in the underlying input stream, or <code>null</code> if
	 *           this instance is to be created without an underlying stream.
	 */
	protected UpperToLowerCaseConverter(InputStream in) {
		super(in);
		
	}
	
	@Override
	public int read() throws IOException {
		int c = super.read();
		return (c == -1 ? c : Character.toLowerCase((char)c));
	}
	
	@Override
	public int read(byte[] b, int offset, int len) throws IOException {
		int result = super.read(b, offset, len);
		for(int i = offset; i < offset + result; i++ ){
			b[i] = (byte) Character.toLowerCase((char)b[i]);
		}
		return result;
	}
	
	
}
