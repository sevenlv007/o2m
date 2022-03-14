package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Student;

/**
 * 学生信息表IIService接口
 * 
 * @author K7L
 * @date 2022-03-12
 */
public interface IStudentService 
{
    /**
     * 查询学生信息表II
     * 
     * @param id 学生信息表II主键
     * @return 学生信息表II
     */
    public Student selectStudentById(Long id);

    /**
     * 查询学生信息表II列表
     * 
     * @param student 学生信息表II
     * @return 学生信息表II集合
     */
    public List<Student> selectStudentList(Student student);

    /**
     * 新增学生信息表II
     * 
     * @param student 学生信息表II
     * @return 结果
     */
    public int insertStudent(Student student);

    /**
     * 修改学生信息表II
     * 
     * @param student 学生信息表II
     * @return 结果
     */
    public int updateStudent(Student student);

    /**
     * 批量删除学生信息表II
     * 
     * @param ids 需要删除的学生信息表II主键集合
     * @return 结果
     */
    public int deleteStudentByIds(String ids);

    /**
     * 删除学生信息表II信息
     * 
     * @param id 学生信息表II主键
     * @return 结果
     */
    public int deleteStudentById(Long id);
}
