package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.impl.BrandServiceImpl;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private BrandService brandService=new BrandServiceImpl();
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("brand selectAll");
        List<Brand> brands = brandService.selectAll();
        String jsonString = JSON.toJSONString(brands);
        //返回有中文
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //System.out.println("brand add");
        BufferedReader br = req.getReader();
        String params = br.readLine();
        Brand brand = JSON.parseObject(params, Brand.class);
        brandService.add(brand);
        resp.getWriter().write("success");
    }
    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        BufferedReader br = req.getReader();
        String params = br.readLine();
        int[] ids = JSON.parseObject(params, int[].class);
        brandService.deleteByIds(ids);
        resp.getWriter().write("success");
    }
    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        BufferedReader br = req.getReader();
        String params = br.readLine();
        int id = JSON.parseObject(params,int.class);
        brandService.deleteById(id);
        resp.getWriter().write("success");
    }
    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int pageSize = Integer.parseInt(_pageSize);
        int currentPage = Integer.parseInt(_currentPage);

        PageBean<Brand> pageBean = brandService.selectPage(currentPage, pageSize);
        String jsonString = JSON.toJSONString(pageBean);
        //返回有中文
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int pageSize = Integer.parseInt(_pageSize);
        int currentPage = Integer.parseInt(_currentPage);

        BufferedReader br = req.getReader();
        String params = br.readLine();

        Brand brand = JSON.parseObject(params, Brand.class);
        PageBean<Brand> pageBean = brandService.selectPageAndCondition(currentPage, pageSize,brand);
        String jsonString = JSON.toJSONString(pageBean);
        //返回有中文
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
}
