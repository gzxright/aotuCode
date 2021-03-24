package com.changgou.order.controller;
import com.changgou.order.pojo.Customer;
import com.changgou.order.service.CustomerService;
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
@Api(value = "CustomerController")
@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /***
     * Customer分页条件搜索实现
     * @param customer
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Customer条件分页查询",notes = "分页条件查询Customer方法详情",tags = {"CustomerController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Customer对象",value = "传入JSON数据",required = false) Customer customer, @PathVariable  int page, @PathVariable  int size){
        //调用CustomerService实现分页条件查询Customer
        PageInfo<Customer> pageInfo = customerService.findPage(customer, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Customer分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Customer分页查询",notes = "分页查询Customer方法详情",tags = {"CustomerController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用CustomerService实现分页查询Customer
        PageInfo<Customer> pageInfo = customerService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param customer
     * @return
     */
    @ApiOperation(value = "Customer条件查询",notes = "条件查询Customer方法详情",tags = {"CustomerController"})
    @PostMapping(value = "/search" )
    public Result<List<Customer>> findList(@RequestBody(required = false) @ApiParam(name = "Customer对象",value = "传入JSON数据",required = false) Customer customer){
        //调用CustomerService实现条件查询Customer
        List<Customer> list = customerService.findList(customer);
        return new Result<List<Customer>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Customer根据ID删除",notes = "根据ID删除Customer方法详情",tags = {"CustomerController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable  id){
        //调用CustomerService实现根据主键删除
        customerService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Customer数据
     * @param customer
     * @param id
     * @return
     */
    @ApiOperation(value = "Customer根据ID修改",notes = "根据ID修改Customer方法详情",tags = {"CustomerController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Customer对象",value = "传入JSON数据",required = false) Customer customer,@PathVariable  id){
        //设置主键值
        customer.set(id);
        //调用CustomerService实现修改Customer
        customerService.update(customer);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Customer数据
     * @param customer
     * @return
     */
    @ApiOperation(value = "Customer添加",notes = "添加Customer方法详情",tags = {"CustomerController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Customer对象",value = "传入JSON数据",required = true) Customer customer){
        //调用CustomerService实现添加Customer
        customerService.add(customer);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Customer数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Customer根据ID查询",notes = "根据ID查询Customer方法详情",tags = {"CustomerController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "")
    @GetMapping("/{id}")
    public Result<Customer> findById(@PathVariable  id){
        //调用CustomerService实现根据主键查询Customer
        Customer customer = customerService.findById(id);
        return new Result<Customer>(true,StatusCode.OK,"查询成功",customer);
    }

    /***
     * 查询Customer全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Customer",notes = "查询所Customer有方法详情",tags = {"CustomerController"})
    @GetMapping
    public Result<List<Customer>> findAll(){
        //调用CustomerService实现查询所有Customer
        List<Customer> list = customerService.findAll();
        return new Result<List<Customer>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
