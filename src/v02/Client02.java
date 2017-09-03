package v02;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
/**
 * 에코 형상으로 수정
 * @author insung
 *
 */
public class Client02 {
	public static void main(String args[]){
		try {
			
			
			
            String serverIP = "127.0.0.1"; // 127.0.0.1 & localhost 본인
            System.out.println("서버에 연결중입니다. 서버 IP : " + serverIP);
             
            // 소켓을 생성하여 연결을 요청한다.
            Socket socket = new Socket(serverIP, 5000);
            
            // 소켓의 입/출력스트림을 얻는다.
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            
            // 서버에 보낼 메시지 준비
            String sendData = "send message from client ";
            System.out.println("서버로 전송 할 메시지 : " + sendData);
            
            // 서버로 데이터를 전송한다.
            dos.writeUTF(sendData);
            
            // 소켓으로 부터 받은 데이터를 출력한다.
            String readData = dis.readUTF();
            System.out.println("서버로부터 받은 메세지 : " + readData);          
            
            
            
            // 스트림과 소켓을 닫는다.
            System.out.println("연결을 종료합니다.");
            dis.close();
            socket.close();
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } // try - catch


		
	}
}
