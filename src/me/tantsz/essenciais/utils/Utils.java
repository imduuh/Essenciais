package me.tantsz.essenciais.utils;

public class Utils {
	
    public static String getMensagem(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++)
        sb.append(String.valueOf(String.valueOf(String.valueOf(String.valueOf(args[i])))) + " "); 
        return sb.toString();
        }

}
