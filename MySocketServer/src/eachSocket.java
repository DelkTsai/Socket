import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

/*
 * 一个客户端对应一个处理的线程
 */
public class eachSocket extends Thread{
	private Socket socket;
	public eachSocket(Socket s){
		this.socket = s;
	}
	public void run() {
		try {
			BufferedReader br = 
					new BufferedReader(
							new InputStreamReader(
									socket.getInputStream(),"UTF-8"));
			System.out.print("客户端链接上了");
			String line = null;
			//从客户端输入流中读取数据，不为空
			while((line = br.readLine())!= null){
				System.out.print(line);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
