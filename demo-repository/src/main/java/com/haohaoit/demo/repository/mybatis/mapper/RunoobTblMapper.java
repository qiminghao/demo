package com.haohaoit.demo.repository.mybatis.mapper;

import com.haohaoit.demo.repository.mybatis.po.RunoobTbl;
import com.haohaoit.demo.repository.mybatis.po.RunoobTblExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RunoobTblMapper {
    long countByExample(RunoobTblExample example);

    int insert(RunoobTbl row);

    int insertSelective(RunoobTbl row);

    List<RunoobTbl> selectByExample(RunoobTblExample example);

    RunoobTbl selectByPrimaryKey(Integer runoobId);

    int updateByExampleSelective(@Param("row") RunoobTbl row, @Param("example") RunoobTblExample example);

    int updateByExample(@Param("row") RunoobTbl row, @Param("example") RunoobTblExample example);

    int updateByPrimaryKeySelective(RunoobTbl row);

    int updateByPrimaryKey(RunoobTbl row);

    int batchInsert(@Param("records") List<RunoobTbl> records);

    int batchInsertSelective(@Param("records") List<RunoobTbl> records);

    int batchUpsert(@Param("records") List<RunoobTbl> records);

    int deleteByExample(RunoobTblExample example);

    int deleteByPrimaryKey(@Param("id") Long id);

    int batchDeleteByPrimaryKey(@Param("ids") List<Long> ids);
}