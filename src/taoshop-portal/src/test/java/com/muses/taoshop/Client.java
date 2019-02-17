package com.muses.taoshop;
public class Client
{
	public static void main(String a[])
	{
		Email email,copyEmail=null;

		email=new Email();

		try{
			copyEmail=(Email)email.deepClone();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


		System.out.println("email==copyEmail?");
		System.out.println(email==copyEmail);

		System.out.println("email.getAttachment==copyEmail.getAttachment?");
		System.out.println(email.getAttachment()==copyEmail.getAttachment());
	}
}