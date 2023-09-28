package com.HostelMgm;

import java.util.Scanner;

import org.apache.log4j.Logger;

import Exception.globalexception;
import serviceIMPL.loginnregisterIMPL;

/**
 * Hello world!
 *
 */
public class App 
{
	static Logger log=Logger.getLogger(App.class);
	static Scanner bs=new Scanner(System.in);
	static loginnregisterIMPL ln=new loginnregisterIMPL();
    public static void main( String[] args )throws globalexception 
    {
        log.info( "\t\t\t\t\t*******Welcome to Hostel Management********" );
        
        log.info("\nPress 1 for Registration \nPress 2 for Login");
        int ch=bs.nextInt();
        switch(ch) {
        case 1-> ln.registration();
        case 2-> ln.login();
        }
    }
}
