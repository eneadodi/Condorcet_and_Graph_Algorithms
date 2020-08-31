import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

//http://javatechniques.com/blog/faster-deep-copies-of-java-objects/
public class DeepCopy {
	
	public static Object deepCopy(Object orig){
		Object obj = null;
		try{
			FastByteArrayOutputStream fbos = new FastByteArrayOutputStream();
			ObjectOutputStream out =  new ObjectOutputStream(fbos);
	
			out.writeObject(orig);
			out.flush();
			out.close();
			
			ObjectInputStream in = new ObjectInputStream(fbos.getInputStream());
			obj = in.readObject();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}
		return obj;
	}
}
