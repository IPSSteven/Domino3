package com.ibm.ereg.sync;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
	
	private Properties configProp = new Properties();
	private String configEnv = null;
	
	public static Properties readPropertiesFile(String fileName) throws IOException {
	      FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream(fileName);
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         fis.close();
	      }
	      return prop;
	   }
	
	public void loadProps1() {
		System.out.println("configEnv:**" + this.getConfigEnv() + "**");
		InputStream in = this.getClass().getResourceAsStream(this.getConfigEnv());
		try {
			configProp.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadProps2() {
		System.out.println("configEnv:**" + this.getConfigEnv() + "**");
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("config.properties");
		try {
			configProp.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getConfigEnv() {
		return configEnv;
	}

	public void setConfigEnv(String configEnv) {
		this.configEnv = configEnv;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getproperty(String propName) {
		return configProp.getProperty(propName);
	}

}