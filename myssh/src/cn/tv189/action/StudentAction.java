package cn.tv189.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.tv189.domain.Student;
import cn.tv189.service.TestService;

public class StudentAction {
	
	private TestService testService;
	private Student s;
	public String execute(){
		System.out.println("调用成功");
//		ServletActionContext.getRequest()
		testService.doService();
		s = new Student();
		s.setId(1);
		s.setName("吴庆健");
		
		return "success";
	}
	
	
	
	
	
	
	
	
	public Student getS() {
		return s;
	}

	public void setS(Student s) {
		this.s = s;
	}

	public TestService getTestService() {
		return testService;
	}
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	
}
