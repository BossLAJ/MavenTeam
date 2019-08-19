package com.liuaoji;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ReadData {
	
	private String readFile(String filename){
		
		StringBuilder result = new StringBuilder("");
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(filename).getFile());
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}
			scanner.close();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return result.toString();
	}
	
	
	
	public static void main(String[] args) {
		ReadData readData = new ReadData();
		String readFile = readData.readFile("data.txt");
		
		System.out.println(readFile);
		
		String[] lines = readFile.split("\n");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/1702dmaven?useSSL=false";
			String user="root";
			String password="root";
			Connection conn = DriverManager.getConnection(url,user,password);
			String sql = "insert into t_user (name,addr,pid) values(?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			for (String line : lines) {
				String[] str = line.split("\\|");
				ps.setString(1, str[1]);
				ps.setString(2, str[2]);
				if(str[3].equals("房屋建筑工程")){
					ps.setInt(3, 1);
				}else{
					if(str[3].equals("农田水利工程")){
						ps.setInt(3, 2);
					}else{
						ps.setInt(3, 3);
					}
				}
				ps.executeUpdate();
			}
			
			conn.close();
			
			System.out.println("干得漂亮");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

