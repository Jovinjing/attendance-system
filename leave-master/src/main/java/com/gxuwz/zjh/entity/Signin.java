package com.gxuwz.zjh.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Alias("Signin") //别名
public class Signin {
    @ApiModelProperty(value = "请假编号")
    private String signinId;

    @ApiModelProperty(value = "课程编码")
    private String courseId;

    @ApiModelProperty(value = "请假理由")
    private String reason;

    @ApiModelProperty(value = "天数")
    private String dayNum;

    @ApiModelProperty(value = "学号")
    private String stuNo;

    @ApiModelProperty(value = "请假时间")
    private String applyTime;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "审核时间")
    private String auditTime;

    @ApiModelProperty(value = "审核意见")
    private String opinion;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
