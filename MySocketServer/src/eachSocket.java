import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

/*
 * һ���ͻ��˶�Ӧһ��������߳�
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
			System.out.print("�ͻ�����������");
			String line = null;
			//�ӿͻ����������ж�ȡ���ݣ���Ϊ��
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
