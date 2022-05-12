package com.gxuwz.zjh.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gxuwz.zjh.entity.Rest;
import com.gxuwz.zjh.entity.Signin;
import com.gxuwz.zjh.entity.User;
import com.gxuwz.zjh.service.ISigninService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/zjh/signin")
public class SigninController {

    private final String LIST_ADMIN = "sigin/signin_list";
    private final String LIST_USER = "signin/signin_list_user";
    private final String LIST_INST = "signin/signin_list_inst";

    @Autowired
    ISigninService iSigninService;

    @GetMapping(value = "/findSigninById")
    public ModelAndView findSigninById(ModelAndView modelAndView, Signin signin, Integer pageNumber,
                                       Page page, HttpServletRequest request, Integer index) {
        // 取出session 中的 index，并清空
        if (request.getSession().getAttribute("index") != null) {
            index = (Integer) request.getSession().getAttribute("index");
            request.getSession().setAttribute("index", null);
        }
        if (request.getSession().getAttribute("result") != null) {
            request.getSession().setAttribute("result", "");
        }
        // 可以通过 wrapper 进行筛选!!!
        QueryWrapper<Signin> wrapper = new QueryWrapper<>();
        // 判断是从哪个地方进来的
        if (index == 2) {

        } else if (index == 3) {
            if (request.getSession().getAttribute("user") != null) {
                User user = (User) request.getSession().getAttribute("user");
                wrapper.like("stu_no", user.getUserId());
            }
        }
        wrapper.orderByAsc("signin_id");
        String[] keysWord = null;
        // 对User进行模糊查询!!!
        if (signin != null & signin.getSigninId() != null) {
            wrapper.like("signin_id", signin.getSigninId());
            modelAndView.addObject("signin", signin);
        }
        // Current,页码 + Size,每页条数
        if (pageNumber == null) {
            page.setCurrent(1);
        } else {
            page.setCurrent((long) pageNumber);
        }
        // 默认每页6行数据！
        page.setSize(6);
        // 调用分页查询方法！!
        IPage<Signin> signinIPage = iSigninService.selectPage(page, wrapper);
        // 存放一个数组用来让foreach遍历
        int[] pagesList = new int[(int) signinIPage.getPages()];
        for (int i = 0; i < (int) signinIPage.getPages(); i++) {
            pagesList[i] = i + 1;
        }
        modelAndView.addObject("pagesList", pagesList);
        // 存放page，内有当前页数
        modelAndView.addObject("page", page);
        System.out.println("总条数" + signinIPage.getTotal());
        System.out.println("总页数" + signinIPage.getPages());
        // 存放总页数
        modelAndView.addObject("pages", (int) signinIPage.getPages());
        modelAndView.addObject("numberPages", signinIPage.getTotal());
        List<Signin> signinList = signinIPage.getRecords();
        System.out.println("signinList = " + signinList);
        modelAndView.addObject("signinList", signinList);
        if (index == 1) {
            modelAndView.setViewName(LIST_ADMIN);
        } else if (index == 2) {
            modelAndView.setViewName(LIST_INST);
        } else if (index == 3) {
            modelAndView.setViewName(LIST_USER);
        }
        return modelAndView;
    }

    @GetMapping(value = "/findSigninAll")
    public ModelAndView findSigninAll(ModelAndView modelAndView, Page page, Integer pageNumber,
                                      HttpServletRequest request, Integer index) {
        // 取出session 中的 index，并清空
        if (request.getSession().getAttribute("index") != null) {
            index = (Integer) request.getSession().getAttribute("index");
            request.getSession().setAttribute("index", null);
        }
        // 可以通过 wrapper 进行筛选!!!
        QueryWrapper<Signin> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("signin_id");
        // 判断是从哪个地方进来的
        if (index == 2) {

        } else if (index == 3) {
            if (request.getSession().getAttribute("user") != null) {
                User user = (User) request.getSession().getAttribute("user");
                wrapper.like("stu_no", user.getUserId());
            }
        }
        // Current,页码 + Size,每页条数
        if (pageNumber == null) {
            page.setCurrent(1);
        } else {
            page.setCurrent((long) pageNumber);
        }
        // 默认每页6行数据！
        page.setSize(6);
        // 调用分页查询方法！!
        IPage<Signin> signinIPage = iSigninService.selectPage(page, wrapper);
        HttpSession session = request.getSession();
        // 存放page，内有当前页数
        modelAndView.addObject("page", page);
        System.out.println("总条数" + signinIPage.getTotal());
        System.out.println("总页数" + signinIPage.getPages());
        // 存放总页数
        modelAndView.addObject("pages", (int) signinIPage.getPages());
        // 存放一个数组用来让foreach遍历
        int[] pagesList = new int[(int) signinIPage.getPages()];
        for (int i = 0; i < (int) signinIPage.getPages(); i++) {
            pagesList[i] = i + 1;
        }
        modelAndView.addObject("pagesList", pagesList);
        modelAndView.addObject("numberPages", signinIPage.getTotal());
        List<Signin> signinList = signinIPage.getRecords();
        System.out.println("signinList = " + signinList);
        modelAndView.addObject("signinList", signinList);
        if (index == 1) {
            modelAndView.setViewName(LIST_ADMIN);
        } else if (index == 2) {
            modelAndView.setViewName(LIST_INST);
        } else if (index == 3) {
            modelAndView.setViewName(LIST_USER);
        }
        return modelAndView;
    }


    @PostMapping(value = "/addEditSignin")
    public String addEditSignin(@Param("applyTime") String applyTime, @Param("auditTime") String auditTime,
                                Signin signin, HttpServletRequest request, Integer index) throws ParseException {
        System.out.println("applyTime = " + applyTime);
        System.out.println("applyTime = " + auditTime);
        // 格式化日期时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String applyTime1 = null;
        String auditTime1 = null;
        if (applyTime != null) {
            Date time1 = formatter.parse(applyTime);
            applyTime1 = formatter.format(time1);
        }
        if (auditTime != null) {
            Date time2 = formatter.parse(auditTime);
            auditTime1 = formatter.format(time2);
        }
        System.out.println("applyTime1 = " + applyTime1);
        System.out.println("auditTime1 = " + auditTime1);

        signin.setApplyTime(applyTime1);
        signin.setAuditTime(auditTime1);

        Signin signin1 = iSigninService.findById(signin);
        System.out.println("rest = " + signin);
        System.out.println("rest1 = " + signin1);

        // 接收参数传递 redirect
        request.getSession().setAttribute("index", index);

        if (index == 3) {
            signin.setStatus("未审批");
        }

        // 新增用户信息
        if (signin1 == null) {
            System.out.println("进入新增用户");
            try {
                iSigninService.addObject(signin);
                request.getSession().setAttribute("result", "addTrue");
            } catch (Exception e) {
                request.getSession().setAttribute("result", "addFalse");
            }
        }

        return "redirect:/zjh/signin/findSigninAll";
    }
}
