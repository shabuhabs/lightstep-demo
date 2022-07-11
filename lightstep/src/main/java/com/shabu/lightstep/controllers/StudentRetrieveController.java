package com.shabu.lightstep.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shabu.lightstep.beans.Student;
import com.shabu.lightstep.beans.StudentRegistration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.*;
import java.io.*;
import java.util.*;


@Controller
public class StudentRetrieveController {

  @RequestMapping(method = RequestMethod.GET, value="/student/allstudent")

  @ResponseBody
  public List<Student> getAllStudents() {
	  
	  try {
		  
          URL urlObj = new URL("http://localhost:8081/student/allstudent");
          URLConnection urlCon = urlObj.openConnection();

          InputStream inputStream = urlCon.getInputStream();
          BufferedInputStream reader = new BufferedInputStream(inputStream);

          //BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(filePath));

          byte[] buffer = new byte[4096];
          int bytesRead = -1;

          while ((bytesRead = reader.read(buffer)) != -1) {
              //writer.write(buffer, 0, bytesRead);
          }

          //writer.close();
          reader.close();

          System.out.println("Web page accessed ");

      } catch (MalformedURLException e) {
          System.out.println("The specified URL is malformed: " + e.getMessage());
      } catch (IOException e) {
          System.out.println("An I/O error occurs: " + e.getMessage());
      }
	  
	  return StudentRegistration.getInstance().getStudentRecords();
	  
	  
  }

}
