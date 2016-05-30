import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 线程监听，为每个链接来的客户端创建一个单独的线程
 */
public class ServerLister extends Thread{
	public void run() {
		try {
			//监听12345端口，与客户端对应
			ServerSocket serverSocket = new ServerSocket(12345);
			while(true){
				Socket socket = serverSocket.accept();
				new eachSocket(socket).start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
