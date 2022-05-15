package com.gxuwz.zjh.controller;

import com.gxuwz.zjh.entity.Classes;
import com.gxuwz.zjh.entity.Leave;
import com.gxuwz.zjh.entity.Worker;
import com.gxuwz.zjh.service.IClassesService;
import com.gxuwz.zjh.service.ILeaveService;
import com.gxuwz.zjh.service.IWorkerService;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


@Controller
@RequestMapping("/zjh/excel")
public class ExcelController {

    @Autowired
    private ILeaveService iLeaveService;
    @Autowired
    private IClassesService iClassesService;
    @Autowired
    private IWorkerService iWorkerService;

    /**
     * 导出界面跳转
     * @param modelAndView
     * @return
     */
    @GetMapping("/excelList")
    public ModelAndView excelList(ModelAndView modelAndView, HttpServletRequest request){
        List<Classes> classesList = iClassesService.findAll();
        request.getSession().setAttribute("classesList", classesList);
        modelAndView.setViewName("excel/excel_list");
        return modelAndView;
    }

    @RequestMapping(value = "/UserExcelDownloads", method = RequestMethod.POST)
    public void downloadAllClassmate(HttpServletResponse response,@Param("classId") String classId) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("请假信息表");

        Worker worker = new Worker();
        worker.setClassId(classId);
        List<Worker> workerList = iWorkerService.findStudentByClassId(worker);
        List<Leave> leaveList = new LinkedList<>();
        for(Worker worker1 : workerList){
            Leave leave = new Leave();
            leave.setStuNo(worker1.getStuId());
            List<Leave> leaveList1 = iLeaveService.findLeaveByStuNo(leave);
            leaveList.addAll(leaveList1);
        }

        String fileName = "leave"  + ".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据

        int rowNum = 1;

        String[] headers = { "请假编号", "编码", "请假理由", "天数", "工号", "请假时间", "状态", "审核时间", "审核意见"};
        //headers表示excel表中第一行的表头

        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头

        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (Leave leave : leaveList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(leave.getLeaveId());
            row1.createCell(1).setCellValue(leave.getCourseId());
            row1.createCell(2).setCellValue(leave.getReason());
            row1.createCell(3).setCellValue(leave.getDayNum());
            row1.createCell(4).setCellValue(leave.getStuNo());
            row1.createCell(5).setCellValue(leave.getApplyTime());
            row1.createCell(6).setCellValue(leave.getStatus());
            row1.createCell(7).setCellValue(leave.getAuditTime());
            row1.createCell(8).setCellValue(leave.getOpinion());
            rowNum++;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }

}
