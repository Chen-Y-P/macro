package com.macro.ssm.mapper;

import com.macro.ssm.po.Country;
import com.macro.ssm.po.CountryExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-*.xml"})
public class CountryMapperTest {
    @Autowired
    private CountryMapper countryMapper;
    @Test
    public void deleteByExample() throws Exception {
        int count = countryMapper.deleteByPrimaryKey(new Short("114"));
        assertEquals(1,count);
    }

    @Test
    public void deleteByPrimaryKey() throws Exception {
        int count = countryMapper.deleteByPrimaryKey(new Short("113"));
        assertEquals(1,count);
    }

    @Test
    public void insert() throws Exception {
        Country country = new Country();
        country.setCountry("加拿大11");
        countryMapper.insert(country);
    }

    @Test
    public void insertSelective() throws Exception {
        Country country = new Country();
        country.setCountry("加拿大11");
        countryMapper.insertSelective(country);
        assertEquals(new Short("115"),country.getCountryId());
    }

    @Test
    public void selectByExample() throws Exception {
        CountryExample example = new CountryExample();
        CountryExample.Criteria criteria = example.createCriteria();
        criteria.andCountryEqualTo("中国");
        List<Country> countries = countryMapper.selectByExample(example);
        assertEquals(new Short("110"),countries.get(0).getCountryId());
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        Country country = countryMapper.selectByPrimaryKey((short) 110);
        assertEquals("中国",country.getCountry());
    }

    @Test
    public void updateByExample() throws Exception {
        Country country = new Country();
        country.setCountryId(new Short("112"));
        country.setCountry("加拿大");
        CountryExample example =new CountryExample();
        example.createCriteria().andCountryEqualTo("俄罗斯");
        int count = countryMapper.updateByExample(country, example);
        assertEquals(1,count);
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
        Country country = new Country();
        country.setCountryId(new Short("112"));
        country.setCountry("俄罗斯");
        int count = countryMapper.updateByPrimaryKey(country);
        assertEquals(1,count);
    }

}