package com.haniokasai.nukkit.EssentialPVP;

import java.io.File;
import java.util.LinkedHashMap;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;



public class Main extends PluginBase implements Listener{

	static Config config=null;

	public void onEnable(){

		this.getServer().getPluginManager().registerEvents(this, this);
		getDataFolder().mkdir();

		Config config = new Config(
                new File(this.getDataFolder(), "config.yml"),Config.YAML,
                new LinkedHashMap<String, Object>() {
                    {
                    	put("enable-team", true);
                    	put("2team(false =4)", true);
                    	put("enable-core", true);
                    	put("corehp", "10");
                    	put("killmoney", "5");
                    	put("breakcoremoney", "5");
                    	put("timelimit", "15");
                    	put("enable-timelimit", true);
                    	put("server-name", "[EssntialPVP]");
                    	put("database", "yaml");
                    	put("langfile", "en");
                    	put("/////core//////", "");
                    	put("core-a-id", "159");
                    	put("core-a-meta", "0");
                    	put("core-b-id", "159");
                    	put("core-b-meta", "1");
                    	put("core-c-id", "159");
                    	put("core-c-meta", "2");
                    	put("core-d-id", "159");
                    	put("core-d-meta", "3");
                    	put("teamaname", "a");
                    	put("teambname", "b");
                    	put("teamcname", "c");
                    	put("teamdname", "d");

                    }
                });
        config.save();

        mycreate  a = a;
        this.getServer().getLogger().info("[EssentialPVP] Loaded");

	}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	Config config = new Config(new File(this.getDataFolder(), "config.yml"));
        switch (command.getName()) {
            case "core":
        		if(!sender.hasPermission("essentialpvp.cmd.core")){
        			sender.sendMessage(TextFormat.RED + "You don't have permission to use this command.");
        			return false;
        		}else{
        			 //System.out.println(config.get("enable-core"));
        			if(!(boolean) config.get("enable-core")){
        				config.set("enable-core", true);
        				sender.sendMessage(TextFormat.GREEN +config.get("server-name")+"core will be true Next startup!");
        			}else{
        				sender.sendMessage(TextFormat.GREEN +config.get("server-name")+"core will be disable Next startup!");
        				config.set("enable-core", false);
        			}
        			config.save();
        		}
            break;
            case "corehp":
        		if(!sender.hasPermission("essentialpvp.cmd.corehp")){
        			sender.sendMessage(TextFormat.RED + "You don't have permission to use this command.");
        			return false;
        		}else{
        			try{
        				if(isNum(args[0])){
        				config.set("corehp",args[0]);
        				sender.sendMessage(TextFormat.GREEN + config.get("server-name")+"Corehp will be changed Next startup!");
        				}else{
        				return false;
        				}
        			} catch (Exception e) {
        				return false;
        			    }
        			config.save();
        		}
        		break;
            case "killmoney":
        		if(!sender.hasPermission("essentialpvp.cmd.killmoney")){
        			sender.sendMessage(TextFormat.RED + "You don't have permission to use this command.");
        			return false;
        		}else{
        			try{
        			if(isNum(args[0])){
        				config.set("killmoney",args[0]);
        				sender.sendMessage(TextFormat.GREEN + config.get("server-name")+"killmoney is changed!");
        			}else{
        				return false;
        			}
        			} catch (Exception e) {
        				return false;
        			    }
        			config.save();
        		}
        		break;
            case "bcmoney":
        		if(!sender.hasPermission("essentialpvp.cmd.bcmoney")){
        			sender.sendMessage(TextFormat.RED + "You don't have permission to use this command.");
        			return false;
        		}else{
        			try{
        			if(isNum(args[0])){
        				config.set("bcmoney",args[0]);
        				sender.sendMessage(TextFormat.GREEN + config.get("server-name")+"break core money is changed!");
        			}else{
        				return false;
        			}
        			} catch (Exception e) {
        				return false;
        			    }
        			config.save();
        		}
        	break;

            case "tlimit":
        		if(!sender.hasPermission("essentialpvp.cmd.tlimit")){
        			sender.sendMessage(TextFormat.RED + "You don't have permission to use this command.");
        			return false;
        		}else{
        			try{
        			if(isNum(args[0])){
        				config.set("tlimit",args[0]);
        				sender.sendMessage(TextFormat.GREEN + config.get("server-name")+"timelimit will be changed Next startup!");
        			}else{
        				return false;
        			}
        			} catch (Exception e) {
        				return false;
        			    }
        			config.save();
        		}
        	break;

        	case "servname":
            	if(!sender.hasPermission("essentialpvp.cmd.servname")){
            			sender.sendMessage(TextFormat.RED + "You don't have permission to use this command.");
            			return false;
            	}else{
            		try{
            			config.set("servname",args[0]);
            			sender.sendMessage(TextFormat.GREEN + config.get("server-name")+" server-name is changed!");
            		} catch (Exception e) {
            			return false;
            	    }
            			config.save();
            	}
            break;

        	case "team":
            	if(!sender.hasPermission("essentialpvp.cmd.team")){
            			sender.sendMessage(TextFormat.RED + "You don't have permission to use this command.");
            			return false;
            	}else{
            		try{
            			if(isNum(args[0]) & args[0] == "2"){
            				config.set("team",2);
            				sender.sendMessage(TextFormat.GREEN + config.get("server-name")+"team will be 2 Next startup!");
            			}
            			if(isNum(args[0]) & args[0] == "4"){
            				config.set("team",4);
            				sender.sendMessage(TextFormat.GREEN + config.get("server-name")+"team will be 4 Next startup!");
            			}
            			if(args[0]=="off"){
            				config.set("team",args[0]);
            				sender.sendMessage(TextFormat.GREEN + config.get("server-name")+"team will be disabled Next startup!");
            			}else{
            				return false;
            			}
            		} catch (Exception e) {
            			return false;
            	    }
            			config.save();
            	}
            break;

        }
        return true;
    }

/*apis*/
    static boolean isNum(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}