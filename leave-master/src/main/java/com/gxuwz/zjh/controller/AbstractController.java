package com.gxuwz.zjh.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gxuwz.zjh.entity.Thing;
import com.gxuwz.zjh.service.baseServices.AbstractService;
import com.gxuwz.zjh.service.baseServices.SelectPageService;
import org.springframework.web.servlet.ModelAndView;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public abstract class AbstractController {
    private AbstractService abstractService;
    private SelectPageService selectPageService;

    /**
     * 根据是否存在模糊查询内容跳转到不同的分页查询方法
     *
     * @param modelAndView
     * @param thing
     * @param pageNumber
     * @param page
     * @param request
     * @return
     */
    public ModelAndView nextPage(ModelAndView modelAndView, Thing thing, Integer pageNumber,
                                 Page page, HttpServletRequest request) {
        if (request.getSession().getAttribute("result") != null) {
            request.getSession().setAttribute("result", "");
        }
        if (thing.getId() == null) {
            return findAll(modelAndView, page, pageNumber, request);
        } else {
            return findById(modelAndView, thing, pageNumber, page, request);
        }
    }

    /**
     * 根据对应id信息
     *
     * @param modelAndView
     * @param thing
     * @param pageNumber
     * @param page
     * @param request
     * @return
     */
    public ModelAndView findById(ModelAndView modelAndView, Thing thing, Integer pageNumber,
                                     Page page, HttpServletRequest request) {
        if (request.getSession().getAttribute("result") != null) {
            request.getSession().setAttribute("result", "");
        }

        // 可以通过 wrapper 进行筛选!!!
        QueryWrapper<Thing> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc(thing.toString()+"_id");
        String[] keysWord = null;
        // 对User进行模糊查询!!!
        if (thing != null & thing.getId() != null) {
            wrapper.like(thing.toString()+"_id", thing.getId());
            modelAndView.addObject(thing.toString(), thing);
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
        IPage<Thing> thingIPage = selectPageService.selectPage(page, wrapper);
        // 存放一个数组用来让foreach遍历
        int[] pagesList = new int[(int) thingIPage.getPages()];
        for (int i = 0; i < (int) thingIPage.getPages(); i++) {
            pagesList[i] = i + 1;
        }
        modelAndView.addObject("pagesList", pagesList);
        // 存放page，内有当前页数
        modelAndView.addObject("page", page);
        System.out.println("总条数" + thingIPage.getTotal());
        System.out.println("总页数" + thingIPage.getPages());
        // 存放总页数
        modelAndView.addObject("pages", (int) thingIPage.getPages());
        modelAndView.addObject("numberPages", thingIPage.getTotal());
        List<Thing> list = thingIPage.getRecords();
        System.out.println("list = " + list);
        modelAndView.addObject("list", list);

        modelAndView.setViewName(this.toString()+"/"+this.toString()+"_list");
        return modelAndView;
    }

    /**
     * 查询全部信息
     *
     * @param modelAndView
     * @param page
     * @param pageNumber
     * @param request
     * @return ModelAndView
     */
    public ModelAndView findAll(ModelAndView modelAndView, Page page, Integer pageNumber,
                                    HttpServletRequest request) {
        // 可以通过 wrapper 进行筛选!!!
        QueryWrapper<Thing> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc(this.toString()+"_id");
        // Current,页码 + Size,每页条数
        if (pageNumber == null) {
            page.setCurrent(1);
        } else {
            page.setCurrent((long) pageNumber);
        }
        // 默认每页6行数据！
        page.setSize(6);
        // 调用分页查询方法！!
        IPage<Thing> thingIPage = selectPageService.selectPage(page, wrapper);
        HttpSession session = request.getSession();
        // 存放page，内有当前页数
        modelAndView.addObject("page", page);
        System.out.println("总条数" + thingIPage.getTotal());
        System.out.println("总页数" + thingIPage.getPages());
        // 存放总页数
        modelAndView.addObject("pages", (int) thingIPage.getPages());
        // 存放一个数组用来让foreach遍历
        int[] pagesList = new int[(int) thingIPage.getPages()];
        for (int i = 0; i < (int) thingIPage.getPages(); i++) {
            pagesList[i] = i + 1;
        }
        modelAndView.addObject("pagesList", pagesList);
        modelAndView.addObject("numberPages", thingIPage.getTotal());
        List<Thing> list = thingIPage.getRecords();
        System.out.println("list = " + list);
        modelAndView.addObject("list", list);

        modelAndView.setViewName(this.toString()+"/"+this.toString()+"_list");
        return modelAndView;
    }

    /**
     * 添加信息 / 修改信息
     *
     * @param thing
     * @return
     */
    public String addEdit(Thing thing, HttpServletRequest request) {
        Thing thing1 = (Thing) abstractService.findById(thing);
        System.out.println(this.toString()+" = " + thing);
        System.out.println(this.toString()+"1 = " + thing1);
        // 新增用户信息
        if (thing1 == null) {
            System.out.println("进入新增");
            try {
                abstractService.addObject(thing);
                request.getSession().setAttribute("result", "addTrue");
            } catch (Exception e) {
                request.getSession().setAttribute("result", "addFalse");
            }
        }
        // 修改用户信息
        if (thing1 != null) {
            System.out.println("进入修改");
            try {
                abstractService.updateById(thing);
                request.getSession().setAttribute("result", "editTrue");
            } catch (Exception e) {
                request.getSession().setAttribute("result", "editFalse");
            }
        }
        return "redirect:/zjh/"+this.toString()+"/findAll";
    }

    /**
     * 删除信息
     *
     * @param Id
     * @return
     */
    public String deleteById(HttpServletRequest request, String Id) {
        Thing thing = new Thing() {};
        thing.setId(Id);
        try {
            abstractService.deleteById(thing);
            request.getSession().setAttribute("result", "deleteTrue");
        } catch (Exception e) {

        }
        return "redirect:/zjh/"+this.toString()+"/findAll";
    }
}
