package com.learning.core.java.capture5.abstractDemo;

import com.learning.core.java.capture5.Person;

import java.time.LocalDate;
import java.util.Objects;

public class Employee extends Persion {

    /**
     * 受保护的实例字段；允许包内访问；可以限制避免滥用保护机制，不能通过派生子类来访问受保护的字段；
     * 建议尽量少用Protected，因为违背了封装
     *
     * 私有化访问 private;
     * 受保护的 ： protected;
     * 外部完全可见  public;
     * 本包可见： 不需要修饰符；
     */
    protected  double salary;
    private LocalDate localDate;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Employee(String name, double salary, LocalDate localDate) {
        super(name);
        this.salary = salary;
        this.localDate = localDate;
    }

    @Override
    public String getDescription() {
        return String.format("an employee with a salary of $%.2f",salary);
    }

    public void  raiseSalary(double byPercent){
        this.salary = this.salary * (1+byPercent/100);
    }


    /**
     * Equal方法比较
     * 1. 将显式参数命名为otherObject,稍后需要将他换算为另外一个Other的变量
     * 2. 判断身份，检测this == otherObject 是否相等，判断身份比判断字段开销小；
     * 3. 检测otherObject是否为null,如果是null，返回false;
     * 4. 比较this和otherObject类，如果equals的语义在子类中发生改变，则使用getClass检测
     *    如果所有的子类都由相等的语义，则可以用Instanceof检测
     * 5. 将otherObject强制转换成相应类型的变量
     * 6. 根据相等性判断，使用 == 比较基本类型字段，使用obejct.equal() 比较对象字段；
     *    对于数组类型的字段，可以使用静态的array.equals方法检测相应的数组元素是否相等。
     * @param otherObject
     * @return
     */
    public boolean equal(Object otherObject){

        if (this == otherObject) {
            return  true;
        }

        if (otherObject == null) {
            return  false;
        }

        if (getClass() != otherObject.getClass()) {
            return  false;
        }

        Employee other = (Employee)otherObject;

        //Objects.equals 这个是判断这两个值是否相等，然后可能为Null的值；

        return Objects.equals(this.salary,((Employee) otherObject).localDate) && Objects.equals(this.salary,super.getName());
    }

    public int hashCode(){

        // 建议如果重写hashCode的时候，使用Objects.hashCode();来；
        return Objects.hashCode(salary);
    }
}
