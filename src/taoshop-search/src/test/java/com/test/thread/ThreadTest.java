package com.test.thread;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <pre>
 *  TODO 类说明
 * </pre>
 *
 * @author nicky
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2018.06.18 14:51    修改内容:
 * </pre>
 */
@WebServlet(name = "/testThread")
public class ThreadTest extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName());

//        System.out.println(Thread.currentThread().getName());
        Thread t = new Thread();
        System.out.println(t.getName());

        Thread t1 = new Thread();
        System.out.println(t1.getName());
    }
}
