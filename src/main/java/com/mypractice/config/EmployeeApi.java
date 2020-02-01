package com.mypractice.config;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mypractice.bean.Employee;

@Path("/api")
public class EmployeeApi {
	static List<Employee> lists = new ArrayList<Employee>();
	static {
		lists.add(new Employee(100, "Nasruddin khan", "Nasruddinkhan44@gmail.con"));
		lists.add(new Employee(101, "Akhsay Sawant", "Akhsay@gmail.con"));
		lists.add(new Employee(102, "Akhsay Kalambe", "Kalambe@gmail.con"));
	}

	@Path("employyes")
	// @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Employee> getEmployees() {
		System.out.println("jhfgjdhfg");
		return lists;
	}

	@Path("employyes/{id}")
	// @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee getEmployees(@PathParam("id") Integer empID) {
		Employee emps = null;
		for (Employee emp : lists) {
			if (emp.getEmpID() == empID) {
				emps = emp;
				break;
			}
		}

		return emps;
		// return lists.stream().filter(s -> s.getEmpID() == empID).findFirst().get();
	}

	@Path("employyes/add")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Employee> getEmployees(Employee employee) {
		lists.add(employee);
		return lists;
		// return lists.stream().filter(s -> s.getEmpID() == empID).findFirst().get();
	}

	@Path("employyes/update")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Employee> updateEmployees(Employee employee) {
		// lists.add(employee);
		Employee emps = null;
		for (Employee emp : lists) {
			if (emp.getEmpID() == employee.getEmpID()) {
				emps = emp;
				break;
			}
		}
		lists.remove(emps);
		lists.add(employee);
		return lists;
		// return lists.stream().filter(s -> s.getEmpID() == empID).findFirst().get();
	}
}
