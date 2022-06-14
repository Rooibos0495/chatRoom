package com.example.my_books.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZhaoYuYang
 * @date 2022/4/15
 * @Description
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseModel <T extends Model<?>> extends Model<T>{

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 创建时间
     */
    @TableField(value = "center_time", fill = FieldFill.INSERT)
    private Date centerTime;

    /**
     * 更新时间
     */
    @TableField (value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableField ("is_delete")
    private Integer isDelete;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
