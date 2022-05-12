package com.gxuwz.zjh.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gxuwz.zjh.entity.Leave;
import com.gxuwz.zjh.entity.Rest;
import com.gxuwz.zjh.entity.User;
import com.gxuwz.zjh.service.IRestService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/zjh/rest")
public class RestController {

    private final String LIST_ADMIN = "rest/rest_list";
    private final String LIST_USER = "rest/rest_list_user";
    private final String LIST_INST = "rest/rest_list_inst";

    @Autowired
    private IRestService iRestService;


    @ResponseBody
    @GetMapping(value = "/nextPage")
    public ModelAndView nextPage(ModelAndView modelAndView, Rest rest, Integer pageNumber,
                                 Page page, HttpServletRequest request, Integer index) {
        if (request.getSession().getAttribute("result") != null) {
            request.getSession().setAttribute("result", "");
        }
        if (rest.getRestId() == null) {
            return findRestAll(modelAndView, page, pageNumber, request, index);
        } else {
            return findRestById(modelAndView, rest, pageNumber, page, request, index);
        }
    }

    @GetMapping(value = "/findRestById")
    public ModelAndView findRestById(ModelAndView modelAndView, Rest rest, Integer pageNumber,
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
        QueryWrapper<Rest> wrapper = new QueryWrapper<>();
        // 判断是从哪个地方进来的
        if (index == 2) {

        } else if (index == 3) {
            if (request.getSession().getAttribute("user") != null) {
                User user = (User) request.getSession().getAttribute("user");
                wrapper.like("stu_no", user.getUserId());
            }
        }
        wrapper.orderByAsc("rest_id");
        String[] keysWord = null;
        // 对User进行模糊查询!!!
        if (rest != null & rest.getRestId() != null) {
            wrapper.like("rest_id", rest.getRestId());
            modelAndView.addObject("rest", rest);
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
        IPage<Rest> restIPage = iRestService.selectPage(page, wrapper);
        // 存放一个数组用来让foreach遍历
        int[] pagesList = new int[(int) restIPage.getPages()];
        for (int i = 0; i < (int) restIPage.getPages(); i++) {
            pagesList[i] = i + 1;
        }
        modelAndView.addObject("pagesList", pagesList);
        // 存放page，内有当前页数
        modelAndView.addObject("page", page);
        System.out.println("总条数" + restIPage.getTotal());
        System.out.println("总页数" + restIPage.getPages());
        // 存放总页数
        modelAndView.addObject("pages", (int) restIPage.getPages());
        modelAndView.addObject("numberPages", restIPage.getTotal());
        List<Rest> restList = restIPage.getRecords();
        System.out.println("restList = " + restList);
        modelAndView.addObject("restList", restList);
        if (index == 1) {
            modelAndView.setViewName(LIST_ADMIN);
        } else if (index == 2) {
            modelAndView.setViewName(LIST_INST);
        } else if (index == 3) {
            modelAndView.setViewName(LIST_USER);
        }
        return modelAndView;
    }


    @GetMapping(value = "/findRestAll")
    public ModelAndView findRestAll(ModelAndView modelAndView, Page page, Integer pageNumber,
                                    HttpServletRequest request, Integer index) {
        // 取出session 中的 index，并清空
        if (request.getSession().getAttribute("index") != null) {
            index = (Integer) request.getSession().getAttribute("index");
            request.getSession().setAttribute("index", null);
        }
        // 可以通过 wrapper 进行筛选!!!
        QueryWrapper<Rest> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("rest_id");
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
        IPage<Rest> restIPage = iRestService.selectPage(page, wrapper);
        HttpSession session = request.getSession();
        // 存放page，内有当前页数
        modelAndView.addObject("page", page);
        System.out.println("总条数" + restIPage.getTotal());
        System.out.println("总页数" + restIPage.getPages());
        // 存放总页数
        modelAndView.addObject("pages", (int) restIPage.getPages());
        // 存放一个数组用来让foreach遍历
        int[] pagesList = new int[(int) restIPage.getPages()];
        for (int i = 0; i < (int) restIPage.getPages(); i++) {
            pagesList[i] = i + 1;
        }
        modelAndView.addObject("pagesList", pagesList);
        modelAndView.addObject("numberPages", restIPage.getTotal());
        List<Rest> restList = restIPage.getRecords();
        System.out.println("restList = " + restList);
        modelAndView.addObject("restList", restList);
        if (index == 1) {
            modelAndView.setViewName(LIST_ADMIN);
        } else if (index == 2) {
            modelAndView.setViewName(LIST_INST);
        } else if (index == 3) {
            modelAndView.setViewName(LIST_USER);
        }
        return modelAndView;
    }

    @PostMapping(value = "/addEditRest")
    public String addEditRest(@Param("applyTime") String applyTime, @Param("auditTime") String auditTime,
                              Rest rest, HttpServletRequest request, Integer index) throws ParseException {
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

        rest.setApplyTime(applyTime1);
        rest.setAuditTime(auditTime1);

        Rest rest1 = iRestService.findById(rest);
        System.out.println("rest = " + rest);
        System.out.println("rest1 = " + rest1);

        // 接收参数传递 redirect
        request.getSession().setAttribute("index", index);

        if (index == 3) {
            rest.setStatus("未审批");
        }

        // 新增用户信息
        if (rest1 == null) {
            System.out.println("进入新增用户");
            try {
                iRestService.addObject(rest);
                request.getSession().setAttribute("result", "addTrue");
            } catch (Exception e) {
                request.getSession().setAttribute("result", "addFalse");
            }
        }
        // 修改用户信息
        if (rest1 != null) {
            System.out.println("进入修改用户");
            try {
                iRestService.updateById(rest);
                request.getSession().setAttribute("result", "editTrue");
            } catch (Exception e) {
                request.getSession().setAttribute("result", "editFalse");
            }
        }
        return "redirect:/zjh/rest/findRestAll";
    }


    @PostMapping(value = "/updateRest")
    public String updateRest(Rest rest, HttpServletRequest request, @Param("status2") Integer status) {

        if (status == 1) {
            rest.setStatus("通过");
        } else if (status == 2) {
            rest.setStatus("拒批");
        } else {
            rest.setStatus("未审批");
        }

        // 表明是从部门经理页面过来的
        request.getSession().setAttribute("index", 2);

        try {
            iRestService.updateById(rest);
            request.getSession().setAttribute("result", "editTrue");
        } catch (Exception e) {
            request.getSession().setAttribute("result", "editFalse");
        }
        return "redirect:/zjh/rest/findRestAll";
    }

}
