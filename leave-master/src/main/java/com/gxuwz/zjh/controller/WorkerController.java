package com.gxuwz.zjh.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gxuwz.zjh.entity.Worker;
import com.gxuwz.zjh.service.IWorkerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/zjh/worker")
public class WorkerController extends AbstractController{

    @Autowired
    private IWorkerService iWorkerService;

    /**
     * 根据是否存在模糊查询内容跳转到不同的分页查询方法
     * @param modelAndView
     * @param worker
     * @param pageNumber
     * @param page
     * @param request
     * @return
     */

    @ResponseBody
    @GetMapping(value = "/nextPage")
    public ModelAndView nextPage(ModelAndView modelAndView, Worker worker, Integer pageNumber,
                                 Page page, HttpServletRequest request) {
        if(request.getSession().getAttribute("result") != null){
            request.getSession().setAttribute("result", "");
        }
        if(worker.getStuId() == null){
            return findWorkerAll(modelAndView, page, pageNumber, request);
        }else {
            return findWorkerById(modelAndView, worker, pageNumber, page, request);
        }
    }

    /**
     * 根据对应用户id查询信息
     * @param modelAndView
     * @param worker
     * @param pageNumber
     * @param page
     * @param request
     * @return
     */

    @GetMapping(value = "/findWorkerById")
    public ModelAndView findWorkerById(ModelAndView modelAndView, Worker worker, Integer pageNumber,
                                        Page page, HttpServletRequest request) {
        if(request.getSession().getAttribute("result") != null){
            request.getSession().setAttribute("result", "");
        }
        // 可以通过 wrapper 进行筛选!!!
        QueryWrapper<Worker> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("stu_id");
        String[] keysWord = null;
        // 对User进行模糊查询!!!
        if(worker != null & worker.getStuId() != null){
            wrapper.like("stu_id", worker.getStuId());
            modelAndView.addObject("Worker", worker);
        }
        // Current,页码 + Size,每页条数
        if(pageNumber == null){
            page.setCurrent(1);
        }else {
            page.setCurrent((long)pageNumber);
        }
        // 默认每页6行数据！
        page.setSize(6);
        // 调用分页查询方法！!
        IPage<Worker> WorkerIPage = iWorkerService.selectPage(page, wrapper);
        // 存放一个数组用来让foreach遍历
        int[] pagesList = new int[(int)WorkerIPage.getPages()];
        for(int i=0; i< (int)WorkerIPage.getPages(); i++){
            pagesList[i] = i+1;
        }
        modelAndView.addObject("pagesList", pagesList);
        // 存放page，内有当前页数
        modelAndView.addObject("page", page);
        System.out.println("总条数"+WorkerIPage.getTotal());
        System.out.println("总页数"+WorkerIPage.getPages());
        // 存放总页数
        modelAndView.addObject("pages", (int)WorkerIPage.getPages());
        modelAndView.addObject("numberPages", WorkerIPage.getTotal());
        List<Worker> workerList = WorkerIPage.getRecords();
        System.out.println("workerList = "+ workerList);
        modelAndView.addObject("workerList", workerList);

        modelAndView.setViewName("worker/worker_list");
        return modelAndView;
    }

    /**
     * 查询全部信息
     * @param modelAndView
     * @param page
     * @param pageNumber
     * @param request
     * @return ModelAndView
     */
    @GetMapping(value = "/findWorkerAll")
    public ModelAndView findWorkerAll(ModelAndView modelAndView, Page page, Integer pageNumber,
                                    HttpServletRequest request) {
        // 可以通过 wrapper 进行筛选!!!
        QueryWrapper<Worker> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("stu_id");
        // Current,页码 + Size,每页条数
        if(pageNumber == null){
            page.setCurrent(1);
        }else {
            page.setCurrent((long)pageNumber);
        }
        // 默认每页6行数据！
        page.setSize(6);
        // 调用分页查询方法！!
        IPage<Worker> WorkerIPage = iWorkerService.selectPage(page, wrapper);
        HttpSession session = request.getSession();
        // 存放page，内有当前页数
        modelAndView.addObject("page", page);
        System.out.println("总条数"+WorkerIPage.getTotal());
        System.out.println("总页数"+WorkerIPage.getPages());
        // 存放总页数
        modelAndView.addObject("pages", (int)WorkerIPage.getPages());
        // 存放一个数组用来让foreach遍历
        int[] pagesList = new int[(int)WorkerIPage.getPages()];
        for(int i=0; i< (int)WorkerIPage.getPages(); i++){
            pagesList[i] = i+1;
        }
        modelAndView.addObject("pagesList", pagesList);
        modelAndView.addObject("numberPages", WorkerIPage.getTotal());
        List<Worker> workerList = WorkerIPage.getRecords();
        System.out.println("workerList = "+ workerList);
        modelAndView.addObject("WorkerList", workerList);

        modelAndView.setViewName("Worker/Worker_list");
        return modelAndView;
    }

    /**
     * 添加信息 / 修改信息
     * @param worker
     * @return
     */
    @PostMapping(value = "/addEditWorker")
    public String addEditWorker(Worker worker, HttpServletRequest request) {
        Worker worker1 = iWorkerService.findById(worker);
        System.out.println("Worker = " + worker);
        System.out.println("Worker1 = " + worker1);
        // 新增用户信息
        if(worker1 == null){
            System.out.println("进入新增用户");
            try {
                iWorkerService.addObject(worker);
                request.getSession().setAttribute("result", "addTrue");
            }catch (Exception e){
                request.getSession().setAttribute("result", "addFalse");
            }
        }
        // 修改用户信息
        if(worker1 != null){
            System.out.println("进入修改用户");
            try {
                iWorkerService.updateById(worker);
                request.getSession().setAttribute("result", "editTrue");
            }catch (Exception e){
                request.getSession().setAttribute("result", "editFalse");
            }
        }
        return "redirect:/zjh/worker/findWorkerAll";
    }

    /**
     * 删除信息
     * @param stuId
     * @return
     */
    @GetMapping(value = "/deleteWorkerById")
    public String deleteWorkerById(HttpServletRequest request, @Param("stuId") String stuId) {
        Worker worker = new Worker();
        worker.setStuId(stuId);
        try {
            iWorkerService.deleteById(worker);
            request.getSession().setAttribute("result", "deleteTrue");
        }catch (Exception e){

        }
        return "redirect:/zjh/worker/findWorkerAll";
    }

}
