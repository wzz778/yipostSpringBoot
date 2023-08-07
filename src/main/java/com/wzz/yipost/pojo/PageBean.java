package com.wzz.yipost.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total;//总页数
    private Long currentPage;//当前页
    private Long pageSize;//查询页数
    private Long allPage;//多少页
    private List rows;//数据列表
}
