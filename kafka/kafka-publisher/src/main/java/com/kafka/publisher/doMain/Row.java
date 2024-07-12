package com.kafka.publisher.doMain;

import cn.hutool.core.bean.BeanUtil;
import lombok.Data;

import java.io.Serializable;

/**
 * 数据封装
 * @param <T> 集合数据类型
 */
@Data
public class Row<T> implements Serializable {

    /**
     * 状态码
     */
    private int code;

    /**
     * 信息
     */
    private String msg;

    /**
     * 数据
     */
    private T row;

    protected Row(int code, String msg, T row) {
        this.code = code;
        this.msg = msg;
        this.row = row;
    }

    protected Row(T row){
        this.code = HttpStatus.SUCCESS;
        this.msg = "操作成功";
        this.row = row;
    }

    protected static  <T> Row<T> success(T row){
        return new Row<>(HttpStatus.SUCCESS, "操作成功", row);
    }


    /**
     * 是否成功
     * @param row 数据对象
     * @param <T> 泛型
     * @return true:成功 false:失败
     */
    public static <T> boolean isSuccess(Row<T> row){
        return BeanUtil.isNotEmpty(row) && row.getCode() > 199 && row.getCode() < 300 && BeanUtil.isNotEmpty(row.getRow());
    }


    /**
     * 是否失败
     * @param row 数据对象
     * @param <T> 泛型
     * @return true:失败 false:成功
     */
    public static <T> boolean isError(Row<T> row){
        return !isSuccess(row);
    }
}