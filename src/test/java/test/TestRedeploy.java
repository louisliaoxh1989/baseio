package test;

import java.io.IOException;

import com.gifisan.nio.client.ClientConnector;
import com.gifisan.nio.client.ClientSession;
import com.gifisan.nio.common.CloseUtil;
import com.gifisan.nio.component.future.ReadFuture;

public class TestRedeploy {

	public static void main(String[] args) throws IOException {

		String serviceKey = "RedeployServlet";

		String param = "{username:\"admin\",password:\"admin100\"}";

		ClientConnector connector = ClientUtil.getClientConnector();
		connector.connect();
		ClientSession session = connector.getClientSession();

		ReadFuture future = session.request(serviceKey, param);
		System.out.println(future.getText());
		
		for (int i = 0; i < 100; i++) {
			
			future = session.request(serviceKey, param);
			
			
		}
		

		CloseUtil.close(connector);
	}
}
