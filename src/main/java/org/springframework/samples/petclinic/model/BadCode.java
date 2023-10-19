package org.springframework.samples.petclinic.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BadCode {
    
// Leaking resources by not closing Closeable
    public String readFile(String fileName){ 
    BufferedReader br; 
    try { 
        br = new BufferedReader(new FileReader(fileName)); 
        final StringBuilder sb = new StringBuilder(); 
        String line = br.readLine(); 
 
        while (line != null) { 
            sb.append(line); 
            sb.append(System.lineSeparator()); 
            line = br.readLine(); 
        } 
        br.close(); 
        return sb.toString(); 
    } catch (IOException e) { 
        e.printStackTrace(); 
    } 
    return ""; 
} 
}
