package com.vmware.question.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.vmware.question.exception.RecordNotFoundException;
import com.vmware.question.repository.StatusCache;
import com.vmware.question.util.Status;

@Service
public class NumberService {
	
	@Autowired
	StatusCache statusCache;
	
	
	public Status getStatus(String uuid) {
		Status status=statusCache.getCache().get(uuid);
		if(status==null)
			throw new RecordNotFoundException();
		return status;
	}
	
	public String getOutput(String uuid) {
		Status status=getStatus(uuid);
		if(status!=Status.SUCCESS)
			return status.toString();
		String filename="/tmp/"+uuid+"_output.txt";
		BufferedReader brTest;
		String text=null;
		try {
			brTest = new BufferedReader(new FileReader(filename));
				text = brTest .readLine();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	    
		
		return text;
	}
	
	
	void storeResultOnFile(String uuid,String result) {
		String filename="/tmp/"+uuid+"_output.txt";
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream(filename), "utf-8"))) {
	   writer.write(result);
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	@Async
	public void executeTask(String goal,String step,String uuid) {
		
		statusCache.getCache().put(uuid,Status.IN_PROGRESS);
		try {
			//Integer n=Integer.valueOf(goal);
			BigInteger n = new BigInteger(goal);
			//Integer s=Integer.valueOf(step);
			BigInteger s = new BigInteger(step);
			StringBuilder sb=new StringBuilder(goal);
			for(BigInteger i=n.subtract(s);i.compareTo(BigInteger.ZERO)>=0;i=i.subtract(s)) {
				sb.append(","+i);
			}
			storeResultOnFile(uuid,sb.toString());
			statusCache.getCache().put(uuid,Status.SUCCESS);
			
		}catch(Exception e) {
			statusCache.getCache().put(uuid,Status.ERROR);
			e.printStackTrace();
		}
		
		
		
	}

}
