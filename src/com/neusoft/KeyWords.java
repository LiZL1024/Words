package com.neusoft;

import java.util.Scanner;

public class KeyWords 
{
	/*
	 * �˷��������ж��ַ�����(a)���Ƿ����ĳ�ض��ַ�(c)
	 * �����ڷ���true������false
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
		//���嵥��������ʹ���ַ��������Ŵ��²ⵥ��
		String[] words = {"extends","implement","class","interface","public","random","boolean","final"};
		//���������,��Ϊ�����������±꣬����ѡ�д��²ⵥ��
		int randomIndex = (int)(Math.random() * words.length);
		//�ӵ�����������ȡ���²ⵥ��
		String chooseWord = words[randomIndex];
		//������²ⵥ�ʳ��ȵı���
		int chooseWordLen = chooseWord.length();
		//����������ʾδ�²���ȫ���ַ�������
		char[] showWord = new char[chooseWordLen];
		
		//���ݵ��ʳ��ȣ����²�����ʾ��������'-'
		for(int i=0;i<chooseWordLen;i++)
		{
			showWord[i] = '-';
		}
		//����5�λ���
		int opportunity = 5;
		
		while(opportunity>0 && existChar(showWord, '-'))
		{
			//���ÿ�εĲ²���
			System.out.println(showWord);
			//��ȡ���̵�����
			String c = new Scanner(System.in).nextLine();
			boolean findFlag = false;
			//�жϴ��²ⵥ�����Ƿ��м���������ַ�
			for(int i=0;i<showWord.length;i++)
			{
				if(chooseWord.charAt(i) == c.toCharArray()[0])
				{
					//����У��ı��־λ
					showWord[i] = c.toCharArray()[0];
					findFlag = true;
				}
			}
			
			//���´������һ
			if(!findFlag)
			{
				opportunity--;
				System.out.println("ʣ����������"+opportunity);
			}
			
		}
		
		/*
		 * whileѭ�������󣬴�ʱ���opportunity(ʣ��ɲ²����)����0��
		 * ˵�����ޡ�-�����ڣ��û�ȫ���²���ȷ
		 * ���򣬲µ���ʧ��
		 */
		if(opportunity>0)
		{
			System.out.println("��ϲ�����У�");
		}
		else
		{
			System.out.println("��Ǹ��δ���У�");
		}
	}
}
