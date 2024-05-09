package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import entity.Employee;

public class SocketClient {
    private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;

    public SocketClient(String ip, int port) {
        try {
            socket = new Socket(ip, port);
            System.out.println("socket client: " + socket);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean login(String username, String password) {
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                socket.getOutputStream()), true);
            writer.println("login");
            writer.println(username);
            writer.println(password);
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
            String response = reader.readLine();
            System.out.println("client: response: " + response);
            if (response.equals("login_success")) {
                return true;
            }
            return false;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

    public Employee getEmployee(String username) throws ClassNotFoundException {
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                socket.getOutputStream()), true);
            writer.println("get_employee");
            writer.println(username);

            // Use a separate InputStream for the ObjectInputStream
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Employee employee = (Employee) in.readObject();
            System.out.println("client: employee: " + employee);
            return employee;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    /*
     * Ready for use.
     */
    public void close() {
        try {
            // Send a message to tell the server to close the connection.
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                socket.getOutputStream()), true);

            if (socket != null && !socket.isClosed())
                socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}