import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * �̼߳�����Ϊÿ���������Ŀͻ��˴���һ���������߳�
 */
public class ServerLister extends Thread{
	public void run() {
		try {
			//����12345�˿ڣ���ͻ��˶�Ӧ
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
