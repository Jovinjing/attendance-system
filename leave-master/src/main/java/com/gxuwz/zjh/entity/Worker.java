package com.gxuwz.zjh.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * 工人表
 */
@Data
@Alias("Worker")
@TableName("sys_worker")
public class Worker extends Thing {
    @ApiModelProperty(value = "工号")
    private String stuId;

    @ApiModelProperty(value = "部门号")
    private String classId;

    @ApiModelProperty(value = "姓名")
    private String stuName;

    @ApiModelProperty(value = "性别")
    private int sex;

    @ApiModelProperty(value = "通讯地址")
    private String address;

    @ApiModelProperty(value = "工人电话")
    private String stuTel;

    @ApiModelProperty(value = "联系人")
    private String contact;

    @ApiModelProperty(value = "联系人电话")
    private String contactTel;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @Override
    public String getId() {
        return this.stuId;
    }

    @Override
    public void setId(String id) {
        this.stuId = id;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "stuId='" + stuId + '\'' +
                ", classId='" + classId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", stuTel='" + stuTel + '\'' +
                ", contact='" + contact + '\'' +
                ", contactTel='" + contactTel + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

