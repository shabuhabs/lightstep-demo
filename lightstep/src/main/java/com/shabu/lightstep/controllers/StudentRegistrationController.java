package com.shabu.lightstep.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import io.opentelemetry.extension.annotations.SpanAttribute;
import io.opentelemetry.extension.annotations.WithSpan;

import com.shabu.lightstep.beans.*;

@Controller
public class StudentRegistrationController {

  @RequestMapping(method = RequestMethod.POST, value="/register/student")

  @ResponseBody @WithSpan
  public StudentRegistrationReply registerStudent(@RequestBody @SpanAttribute("name") String name, @SpanAttribute("age")int age  ) {
  System.out.println("In registerStudent");
        StudentRegistrationReply stdregreply = new StudentRegistrationReply();  
        System.out.println("name= " + name + " age= " + age);
       // StudentRegistration.getInstance().add(student);
        //We are setting the below value just to reply a message back to the caller
       // stdregreply.setName(student.getName());
       // stdregreply.setAge(student.getAge());
       // stdregreply.setRegistrationNumber(student.getRegistrationNumber());
      //  stdregreply.setRegistrationStatus("Successful");

        return stdregreply;
  }

}
