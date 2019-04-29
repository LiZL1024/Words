package com.neusoft;

import java.util.Scanner;

public class KeyWords 
{
	/*
	 * 此方法用来判断字符数组(a)中是否存在某特定字符(c)
	 * 若存在返回true，否则false
	 */
	public static boolean existChar(char[] a,char c)
	{
		boolean findFlag = false;
		for(int i=0;i<a.length;i++)
		{
			if(a[i] == c)
			{
				findFlag = true;
			}
		}
		return findFlag;
	}

	public static void main(String[] args) {
		//定义单词容器，使用字符串数组存放待猜测单词
		String[] words = {"extends","implement","class","interface","public","random","boolean","final"};
		//生成随机数,作为单词容器的下标，用以选中待猜测单词
		int randomIndex = (int)(Math.random() * words.length);
		//从单词容器中提取待猜测单词
		String chooseWord = words[randomIndex];
		//定义待猜测单词长度的变量
		int chooseWordLen = chooseWord.length();
		//定义用以显示未猜测完全的字符串数组
		char[] showWord = new char[chooseWordLen];
		
		//根据单词长度，给猜测者提示等数量的'-'
		for(int i=0;i<chooseWordLen;i++)
		{
			showWord[i] = '-';
		}
		//仅限5次机会
		int opportunity = 5;
		
		while(opportunity>0 && existChar(showWord, '-'))
		{
			//输出每次的猜测结果
			System.out.println(showWord);
			//获取键盘的输入
			String c = new Scanner(System.in).nextLine();
			boolean findFlag = false;
			//判断待猜测单词中是否有键盘输入的字符
			for(int i=0;i<showWord.length;i++)
			{
				if(chooseWord.charAt(i) == c.toCharArray()[0])
				{
					//如果有，改变标志位
					showWord[i] = c.toCharArray()[0];
					findFlag = true;
				}
			}
			
			//若猜错，机会减一
			if(!findFlag)
			{
				opportunity--;
				System.out.println("剩余机会次数："+opportunity);
			}
			
		}
		
		/*
		 * while循环结束后，此时如果opportunity(剩余可猜测次数)大于0，
		 * 说明已无‘-’存在，用户全部猜测正确
		 * 否则，猜单词失败
		 */
		if(opportunity>0)
		{
			System.out.println("恭喜，猜中！");
		}
		else
		{
			System.out.println("抱歉，未猜中！");
		}
	}
}
