package v05;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

/**
 * 바이트 스트림 테스트
 * 
 * @author insung
 *
 */
public class Client05 {
	public static void main(String args[]) {
		
		
		
		try {

			String serverIP = "127.0.0.1"; // 127.0.0.1 & localhost 본인
			System.out.println("서버에 연결중입니다. 서버 IP : " + serverIP);

			// 소켓을 생성하여 연결을 요청한다.
			Socket socket = new Socket(serverIP, 5000);

			// 소켓의 입/출력스트림을 얻는다.
			DataStreamUtil waver = new DataStreamUtil(socket);
			
			while( true ){	
				// 서버에 보낼 메시지 준비
				String sendData = "";
				//sendData = message01();
				sendData = message03( 1 );
				
				
				
				
				
				byte [] sendByteData = sendData.getBytes();
				int messageLength = sendByteData.length;
				
				
				
				System.out.println("size " + sendData.length() + " " + sendByteData.length);
				//System.out.println("서버로 전송 할 메시지 : " + sendData );
	
				// 서버로 데이터를 전송한다.
				
				long time01 = System.currentTimeMillis();
				waver.serveData( sendByteData );
				long time02 = System.currentTimeMillis();
				
				//System.out.println("send finish");
				
				// 소켓으로 부터 받은 데이터를 출력한다.
				String dataRead = waver.receiveData();
				long time03 = System.currentTimeMillis();
				
				//System.out.println("서버로부터 받은 메세지 : " + dataRead );
	
				System.out.println( time02 - time01);
				System.out.println( time03 - time02);
				System.out.println( time03 - time01);
				
				
			}
			// 스트림과 소켓을 닫는다.
			//System.out.println("연결을 종료합니다.");
			//waver.close();
			//socket.close();
			
		} catch (ConnectException ce) {
			System.out.println("ConnectException " + ce.getMessage() ); 
		} catch (IOException ie) {
			System.out.println("IOException " + ie.getMessage() ); 
		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage() ); 
		} // try - catch

	}
	
	private static String message01(){
		String result = "";
		
		for (int i = 0; i < 1025;i++) {
			result += "0";
		}
		
		return result;
	}
	
	private static String message02( int max){
		String result = "";
		String code = "";
		for (int i = 0; i < 256; i++) {
			char c = (char)i;
			code += String.valueOf(c);
		}
		
		System.out.println( "code : " + code + "\n length " + code.length());
		
		for (int i = 0; i < max;i++) {
			result += code;
		}
		System.out.println( result.length() );
		return result;
	}
	
	private static String message03( int max){
		String result = "";
		String code = "";
		for (int i = 0; i < 256; i++) {
			code += String.valueOf('A');
		}
		
		//System.out.println( "code : " + code + "\n length " + code.length());
		
		for (int i = 0; i < max;i++) {
			result += code;
		}
		//System.out.println( result.length() );
		return result;
	}
}
