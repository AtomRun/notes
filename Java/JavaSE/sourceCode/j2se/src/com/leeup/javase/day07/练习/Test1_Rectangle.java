package com.leeup.javase.day07.练习;


public class Test1_Rectangle {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(10, 20);
		System.out.println("周长为："+rectangle.getLength());
		System.out.println("面积为："+rectangle.getArea());
	}
}

/**
 * 长方形类
 * @author 李闯
 *
 */
class Rectangle{
	
	private int width;
	private int height;
	
	public Rectangle() {
		
	}
	
	public Rectangle(int width,int height) {
		this.width = width;
		this.height = height;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return height;
	}
	
	//求周长方法
	public int getLength() {
		return (width+height) * 2;
	}
	
	//求面积方法
	public int getArea() {
		return width * height;
	}
}

