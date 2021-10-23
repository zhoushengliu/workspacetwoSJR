package com.atguigu;

import com.atguigu.dao.UserMapper;
import com.atguigu.entity.User;
import com.atguigu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author 琉
 * @create 2021-10-22 20:01
 */
@SpringBootTest
public class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    //查询表中的所有数据
    @Test
    public  void  testSelectList(){
        //selectList()方法的参数：封装了查询条件
        //null：无任何查询条件
        List<User> users = userMapper.selectList(null);
        System.out.println("users = " + users);


    }

    //添加功能
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("laozhou");
        user.setAge(28);
        user.setEmail("234.qq.com");

        //看一下受影响的行数
        int insert = userMapper.insert(user);
        System.out.println("影响的行数" + insert);
        //id自动回填
        System.out.println("id:" + user.getId());

    }

    //查询功能
    @Test
    public void testSelect(){
        //按id查询
//        User user = userMapper.selectById(1);
//        System.out.println("user="+user);
//
//        //按id列表查询
//        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
//        System.out.println(users);

        //按指定条件查询
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","Tom");
        map.put("age","28");
        List<User> users1 = userMapper.selectByMap(map);
        System.out.println(users1);

    }

    //修改功能
    @Test
    public void testUpdate(){
        User user = new User();
        //根据id进行修改
        user.setId(5l);
        user.setAge(30);

        int id = userMapper.updateById(user);
        System.out.println("影响的行数:" + id);

    }


    //查询下表中的总数
    @Test
    public void testCount(){

        int count = userService.count();
        System.out.println("总记录数：" + count);
    }

    //批量插入
    @Test
    public void testSabeVatch(){
        // SQL长度有限制，海量数据插入单条SQL无法实行，
        // 因此MP将批量插入放在了通用Service中实现，而不是通用Mapper
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("jialing"+i);
            user.setAge(24+i);
            user.setEmail("6909@qq.com"+i);
            users.add(user);

            //最终的额打印如果放在这里的话就每次都过一遍循环最后就是15次了
            //所以必须把最终输出结果放在循环外面
        }
        userService.saveBatch(users);


    }










}
