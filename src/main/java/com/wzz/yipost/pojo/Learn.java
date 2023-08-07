package com.wzz.yipost.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 学习实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Learn {
    private Integer id; //ID
    private Integer userId;//对应的用户ID
    private String plan;
    private String content;
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
    private Integer learnTime; //学习时间
}
