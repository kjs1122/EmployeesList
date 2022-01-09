package controller.action;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeesFileDownLoadAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String file = request.getParameter("filename");
		String path = "upload";
		ServletContext context = request.getServletContext();
		String sDownloadPath = context.getRealPath(path);
		
		String sFilePath = sDownloadPath + "\\" + file;
		byte buffer[] = new byte[4096];
		
		FileInputStream fin = new FileInputStream(sFilePath);
		String sMimeType = request.getServletContext().getMimeType(sFilePath);
		System.out.println(sMimeType);
		response.setContentType(sMimeType);
		response.setHeader("Content-Disposition", "attachment; filename= " + file);
		
		ServletOutputStream fout = response.getOutputStream();
		
		int numRead;
		
		while((numRead = fin.read(buffer, 0, buffer.length)) != -1) {
			fout.write(buffer,0,numRead);
		}
		
		fout.flush();
		fout.close();
		fin.close();
	}

}
