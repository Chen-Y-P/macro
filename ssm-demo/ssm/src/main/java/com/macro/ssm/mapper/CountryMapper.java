package com.macro.ssm.mapper;

import com.macro.ssm.po.Country;
import com.macro.ssm.po.CountryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CountryMapper {
    long countByExample(CountryExample example);

    int deleteByExample(CountryExample example);

    int deleteByPrimaryKey(Short countryId);

    int insert(Country record);

    int insertSelective(Country record);

    List<Country> selectByExample(CountryExample example);

    Country selectByPrimaryKey(Short countryId);

    int updateByExampleSelective(@Param("record") Country record, @Param("example") CountryExample example);

    int updateByExample(@Param("record") Country record, @Param("example") CountryExample example);

    int updateByPrimaryKeySelective(Country record);

    int updateByPrimaryKey(Country record);
}