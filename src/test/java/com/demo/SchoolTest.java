package com.demo;

import com.demo.dao.SchoolRepository;
import com.demo.dto.response.SchoolRespDto;
import com.demo.entity.School;
import com.demo.mapper.SchoolMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2019/2/18.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SchoolTest {
    @Autowired
    private SchoolRepository schoolRepository;

    //@Test
    public void addSchool(){
        School school1 = new School();
        school1.setSchoolCode("0001");
        school1.setSchoolName("中心小学");
        schoolRepository.save(school1);

        School school2 = new School();
        school2.setSchoolCode("0002");
        school2.setSchoolName("阳光小学");
        schoolRepository.save(school2);

    }

   /* @Test
    public void shouldMapCarToDto() {

        School school = schoolRepository.findBySchoolCode("0001");


        SchoolRespDto schoolRespDto = SchoolMapper.MAPPER.schoolToSchoolRespDto(school);


        Assert.assertNotNull(schoolRespDto);
        Assert.assertEquals(schoolRespDto.getSchoolCode(),"0001");
        Assert.assertEquals(schoolRespDto.getSchoolName() ,"中心小学");
    }*/
}
