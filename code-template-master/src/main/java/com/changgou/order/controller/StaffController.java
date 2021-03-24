package com.changgou.order.controller;
import com.changgou.order.pojo.Staff;
import com.changgou.order.service.StaffService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/
@Api(value = "StaffController")
@RestController
@RequestMapping("/staff")
@CrossOrigin
public class StaffController {

    @Autowired
    private StaffService staffService;

    /***
     * Staff分页条件搜索实现
     * @param staff
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Staff条件分页查询",notes = "分页条件查询Staff方法详情",tags = {"StaffController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Staff对象",value = "传入JSON数据",required = false) Staff staff, @PathVariable  int page, @PathVariable  int size){
        //调用StaffService实现分页条件查询Staff
        PageInfo<Staff> pageInfo = staffService.findPage(staff, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Staff分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Staff分页查询",notes = "分页查询Staff方法详情",tags = {"StaffController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用StaffService实现分页查询Staff
        PageInfo<Staff> pageInfo = staffService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param staff
     * @return
     */
    @ApiOperation(value = "Staff条件查询",notes = "条件查询Staff方法详情",tags = {"StaffController"})
    @PostMapping(value = "/search" )
    public Result<List<Staff>> findList(@RequestBody(required = false) @ApiParam(name = "Staff对象",value = "传入JSON数据",required = false) Staff staff){
        //调用StaffService实现条件查询Staff
        List<Staff> list = staffService.findList(staff);
        return new Result<List<Staff>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Staff根据ID删除",notes = "根据ID删除Staff方法详情",tags = {"StaffController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用StaffService实现根据主键删除
        staffService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Staff数据
     * @param staff
     * @param id
     * @return
     */
    @ApiOperation(value = "Staff根据ID修改",notes = "根据ID修改Staff方法详情",tags = {"StaffController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Staff对象",value = "传入JSON数据",required = false) Staff staff,@PathVariable  id){
        //设置主键值
        staff.set(id);
        //调用StaffService实现修改Staff
        staffService.update(staff);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Staff数据
     * @param staff
     * @return
     */
    @ApiOperation(value = "Staff添加",notes = "添加Staff方法详情",tags = {"StaffController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Staff对象",value = "传入JSON数据",required = true) Staff staff){
        //调用StaffService实现添加Staff
        staffService.add(staff);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Staff数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Staff根据ID查询",notes = "根据ID查询Staff方法详情",tags = {"StaffController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<Staff> findById(@PathVariable  id){
        //调用StaffService实现根据主键查询Staff
        Staff staff = staffService.findById(id);
        return new Result<Staff>(true,StatusCode.OK,"查询成功",staff);
    }

    /***
     * 查询Staff全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Staff",notes = "查询所Staff有方法详情",tags = {"StaffController"})
    @GetMapping
    public Result<List<Staff>> findAll(){
        //调用StaffService实现查询所有Staff
        List<Staff> list = staffService.findAll();
        return new Result<List<Staff>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
