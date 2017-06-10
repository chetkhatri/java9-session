import java.io.*;
public class sample
{
	public static void main(String[] args) throws Exception{
	String[] str = {
		"/bin/sh",
		"-c",
		"echo $PPID"
	};
	
	Process p = Runtime.getRuntime().exec(str);
	if(0 == p.waitFor())
	{
		InputStream in = p.getInputStream();
		int count = in.available();
		byte[] outbytes = new byte[count];
		in.read(outbytes);
		String pidstr = new String(outbytes);
		System.out.println("pid: "+ pidstr);
	}
}
}
