package com.haniokasai.nukkit.EssentialPVP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;

public class mysql extends PluginBase implements Listener {


	public void mycreate(){
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
    }catch (Exception e){
    	this.getServer().getLogger().info("[EssentialPVP] sql driver error");
    	this.getServer().getLogger().info("Exception:" + e.getMessage());
      }



    String url = "jdbc:mysql://localhost/jdbctestdb";
    String user = "testuser";
    String password = "testpass";
    Connection conn = null;
    try{

      conn = DriverManager.getConnection(url, user, password);

    }catch (SQLException e){
    	this.getServer().getLogger().info("[EssentialPVP] sql connetcion error");
    	this.getServer().getLogger().info("SQLException:" + e.getMessage());
    }
    try {
    	  conn = DriverManager.getConnection(url, user, password);

    	  Statement stmt = conn.createStatement();
    	  String sql = "CREATE TABLE IF NOT EXISTS honey "
    	  		+ "(name VARCHAR(16) NOT NULL,"
    	  		+ "exp INT NOT NULL,"
    	  		+ "killc INT NOT NULL,"
    	  		+"renkill INT NOT NULL,"
    	  		+"level INT NOT NULL,"
    	  		+"des INT NOT NULL,"
    	  		+"flogin INT NOT NULL,"
    	  		+"login INT NOT NULL,"
    	  		+"ptitle VARCHAR(256) NOT NULL,)";
    	  stmt.executeQuery(sql);
    	}catch (SQLException e){
    		this.getServer().getLogger().info("SQLException:" + e.getMessage());
    	}
}
}