package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

import dao3.AccountDAO;
import dao3.BookRoomDAO;
import dao3.CustomerDAO;
import dao3.EmployeeDAO;
import dao3.RoomDAO;
import dao3.RoomStatusTypeDAO;
import entity.Customer;
import entity.Employee;
import entity.Room;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class ConnectionThread extends Thread {
    private Socket socket;
    private SocketServer socketServer;
    private Connection connection;
    private boolean isRunning;
    private AccountDAO dao_Acc;
    private EmployeeDAO dao_Emp;
    private RoomDAO dao_Room;
    
    public ConnectionThread(Socket socket, SocketServer socketServer) {
        this.socket = socket;
        this.socketServer = socketServer;
        connection = new Connection(socket);
        isRunning = true;
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("aaa");

        dao_Acc=new AccountDAO(entityFactory.createEntityManager());
        dao_Emp=new EmployeeDAO(entityFactory.createEntityManager());
        dao_Room=new RoomDAO(entityFactory.createEntityManager());
        // dao_Cus=new CustomerDAO();
        // dao_CusType=new CustomerTypeDAO();
        // dao_RoomStatusType=new RoomStatusTypeDAO();
        // dao_BookRoom=new BookRoomDAO();

    }

    @Override
    public void run() {
        while(isRunning) {
            if (socket.isClosed()) {
                isRunning = false;
                break;
            }
            
            //login:
            String username = null;
            String password = null;
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true, java.nio.charset.StandardCharsets.UTF_8);
                String command = reader.readLine();
                System.out.println("server: command: " + command);
                if (command.equals("findPass")) {
                    System.out.println("server: findPass");
                    username = reader.readLine();
                    password = dao_Acc.findPass(username);
                    System.out.println("server: password: " + password);
                    connection.send(password);
                }

                if (command.equals("get_employee")) {
                    username = reader.readLine();
                    Employee emp = dao_Emp.findEmpID(username);
                    if (emp != null) {
                        connection.sendObject(emp);
                    } else {
                        connection.send("employee_not_found");
                    }
                }

                if (command.equals("get_all_room")) {
                    System.out.println("server: get all room");
                    connection.sendList(dao_Room.getAllRooms());
                }
                
                if (command.equals("findRoomByIDLoaiPhong")){
                    System.out.println("server: findRoomByIDLoaiPhong");
                    String IDLoaiPhong = reader.readLine();
                    System.out.println("server: IDLoaiPhong: " + IDLoaiPhong);
                    connection.sendList(dao_Room.findRoomByIDLoaiPhong(IDLoaiPhong));
                }

                if (command.equals("findRoomByID")){
                    System.out.println("server: findRoomByID");
                    String IDPhong = reader.readLine();
                    connection.sendObject(dao_Room.findRoomById(IDPhong));
                }

                // if (command.equals("finRoomStatusTypeById")){
                //     System.out.println("server: finRoomStatusTypeById");
                //     String ID = reader.readLine();
            
                //     connection.sendObject(dao_RoomStatusType.finRoomStatusTypeById(ID));
                // }

                // if (command.equals("getCustomerByCCCD")){
                //     System.out.println("server: getCustomerByCCCD");
                //     String CCCD = reader.readLine();
                //     connection.sendObject(dao_Cus.getCustomerByCCCD(CCCD));
                // }

                // if (command.equals("addCustomer")){
                //     System.out.println("server: addCustomer");
                //     ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                //     Customer cus = (Customer) in.readObject();
                //     connection.sendBoolean(dao_Cus.add(cus));
                // }

                // if (command.equals("getalltbKhachHang")){
                //     System.out.println("server: getalltbKhachHang");
                //     connection.sendListCustomer(dao_Cus.getalltbKhachHang());
                // }

                // if(command.equals("findCusTypeID")){
                //     System.out.println("server: getCustomerTypeById");
                //     String ID = reader.readLine();
                //     connection.sendObject(dao_CusType.findCusTypeID(ID));
                // }
                
                // if(command.equals("getBookRoomById")){
                //     System.out.println("server: getBookRoomById");
                //     String ID = reader.readLine();
                //     connection.sendObject(dao_BookRoom.getBookRoomByID(ID));
                // }

                // if(command.equals("updateBookRoom")){
                //     System.out.println("server: updateBookRoom");
                //     ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                //     connection.sendBoolean(dao_BookRoom.updateBookRoom((entity.BookRoom) in.readObject()));
                // }

                // if(command.equals("getAllBookRoom")){
                //     System.out.println("server: getAllBookRoom");
                //     connection.sendListBookRoom(dao_BookRoom.getAlLBookRooms());
                // }
                
                // if(command.equals("getAlLBookRoomsWithStatus")){
                //     System.out.println("server: getAlLBookRoomsWithStatus");
                //     connection.sendListBookRoom(dao_BookRoom.getAlLBookRoomsWithStatus());
                // }

                if(command.equals("getMaPhong")){
                    System.out.println("server: getMaPhong");
                    connection.send(dao_Room.getMaPhong());
                }

                if (command.equals("add_room")) {
                    System.out.println("server: add_room");
                    try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
                        Room room = (Room) in.readObject(); // Nhận đối tượng Room từ client
                        System.out.println("Received room object: " + room);
                
                        boolean result = dao_Room.saveRoom(room); // Lưu phòng vào cơ sở dữ liệu
                        System.out.println("Save room result: " + result);
                        connection.sendBoolean(result); // Gửi phản hồi cho client
                    } catch (IOException | ClassNotFoundException e) {
                        System.err.println("Error processing add_room command: " + e.getMessage());
                        e.printStackTrace();
                        connection.sendBoolean(false); // Gửi phản hồi thất bại
                    }
                }
                if (command.equals("update_room")) {
                    System.out.println("server: update_room");
                    try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
                        Room room = (Room) in.readObject(); // Receive the updated Room object
                        System.out.println("Updating room: " + room);
                
                        dao_Room.updateRoom(room); // Update the room in the database
                        connection.sendBoolean(true); // Notify the client of success
                        System.out.println("Room updated successfully.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.err.println("Error processing update_room command: " + e.getMessage());
                        e.printStackTrace();
                        connection.sendBoolean(false); // Notify the client of failure
                    }
                }
                
                if (command.equals("delete_room")) {
                    System.out.println("server: delete_room");
                    try {
                        String roomId = reader.readLine(); // Read the room ID to delete
                        System.out.println("Deleting room with ID: " + roomId);
                
                        dao_Room.deleteRoom(roomId); // Delete the room from the database
                        connection.sendBoolean(true); // Notify the client of success
                        System.out.println("Room deleted successfully.");
                    } catch (IOException e) {
                        System.err.println("Error processing delete_room command: " + e.getMessage());
                        e.printStackTrace();
                        connection.sendBoolean(false); // Notify the client of failure
                    }
                }
            } catch (Exception e) {
				e.printStackTrace();
			}

        }
    }

    public Socket getSocket() {
        return socket;
    }

    public boolean isRunning() {
        return isRunning;
    }
    
    public void stopRunning() {
        isRunning = false;
        try {
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}