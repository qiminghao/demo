package com.haohaoit.demo.repository.mybatis.po;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RunoobTbl implements Serializable {
    private Integer runoobId;

    private String runoobTitle;

    private String runoobAuthor;

    private LocalDate submissionDate;

    private static final long serialVersionUID = 1L;
}