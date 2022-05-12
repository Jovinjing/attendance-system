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
 * 产品表
 */
@Data
@Alias("Department") //别名
public class Department extends Thing {

    @ApiModelProperty(value = "产品编号")
    private String depId;

    @ApiModelProperty(value = "产品名称")
    private String depName;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
    @Override
    public String getId() {
        return this.depId;
    }

    @Override
    public void setId(String id) {
        this.depId = id;
    }
    @Override
    public String toString() {
        return "dep";
    }

}
