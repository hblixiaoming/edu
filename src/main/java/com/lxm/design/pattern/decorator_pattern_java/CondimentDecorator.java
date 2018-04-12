package com.lxm.design.pattern.decorator_pattern_java;

/**
 * 这是一个调料类的基类，它和饮料类都继承Beverage目的是可以使用他替换饮料类
 * 也就是使用装饰者替换被装饰者。
 * @author lenovo
 *
 */
public abstract class CondimentDecorator extends Beverage{
	public abstract String getDescription();
}
