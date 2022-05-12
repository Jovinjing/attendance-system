package com.gxuwz.zjh.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * 部门经理表
 */
@Data
@Alias("Instructor") //别名
public class Instructor extends Thing {

    @ApiModelProperty(value = "辅导员工号")
    private String instId;

    @ApiModelProperty(value = "辅导员姓名")
    private String instName;

    @ApiModelProperty(value = "产品编号")
    private String depId;

    @ApiModelProperty(value = "联系电话")
    private String telephone;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @Override
    public String getId() {
        return this.instId;
    }

    @Override
    public void setId(String id) {
        this.instId = id;
    }

    @Override
    public String toString() {
        return "inst";
    }

}
