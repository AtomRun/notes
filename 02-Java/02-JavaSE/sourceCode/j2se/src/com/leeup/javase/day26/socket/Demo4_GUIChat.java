package com.leeup.javase.day26.socket;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

/**
 * gui聊天
 * @author 李闯
 *
 */
public class Demo4_GUIChat extends Frame{
	
	public Demo4_GUIChat() {
		init();
		southPanel();
	}

	public void southPanel() {
		Panel south = new Panel();		//创建南边的Panel
		TextField tf = new TextField(15);	//创建文本字段，存储IP地址
		Button send = new Button("发送");	//创建按钮
		Button log = new Button("记录");
		Button clear = new Button("清屏");
		Button shake = new Button("震动");
		south.add(tf);
		south.add(send);
		south.add(log);
		south.add(clear);
		south.add(shake);
		
		this.add(south,BorderLayout.SOUTH);		//将Panel放在Frame的南边
	}

	private void init() {
		this.setLocation(500,50);
		this.setSize(400,600);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Demo4_GUIChat();
	}
}
