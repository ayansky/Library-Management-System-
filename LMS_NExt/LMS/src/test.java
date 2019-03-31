
import java.awt.FileDialog;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

//test class contains the main method

public class test {
	
	public static void main(String[] args) throws Exception {
		
		//hardcoded main admin. Name: boss Password: aHead
		Users BOSS = new Users("boss", "aHead");
		
		//calling the Welcome Frame
		new FormWelcome();

	}

}
