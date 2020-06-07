package com.vmware.question.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.vmware.question.util.Status;

@Repository
public class StatusCache {
	
	private Map<String,Status> statusMap=null;
	
	      public StatusCache() {
	    	  statusMap=new HashMap<>();
	    	  dataInitization();
		}
	      
	     public Map<String,Status> getCache(){
	    	  return statusMap;
	      }
	     
	     
	     public void put(Path file) {
	    	 String filename=file.toString();
	    	 String uuid=filename.split("_")[0].split("/")[2];
	    	 statusMap.put(uuid,Status.SUCCESS);
	     }
	     public void dataInitization() {  
	    	 try {
				Files.list(Paths.get("//tmp//"))
				 .filter(file->file.toString().endsWith("output.txt"))
				 .forEach(e->put(e));
			} catch (IOException e) {
				e.printStackTrace();
			}
	     }
	      

}
