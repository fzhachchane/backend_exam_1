package org.example.hello_world_ejb_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.hello_world_ejb_2.beans.EjbStateful;
import org.example.hello_world_ejb_2.model.CD;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    @EJB (beanName = "EjbStatefulBean")
    EjbStateful statefulBean;
    List<CD> currentCollection = statefulBean.getCDs();

    @EJB (beanName = "EjbStatelessBean")
    EjbStateful stateless;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");


    }

    public void destroy() {
    }
}