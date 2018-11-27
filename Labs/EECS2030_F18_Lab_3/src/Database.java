import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* READ THE PDF INSTRUCTION BEFORE GETTING STARTED!
 * 
 * Resources:
 * 	- Tutorial Series on Java Collections (ArrayList and HashMap):
 * 		https://www.eecs.yorku.ca/~jackie/teaching/tutorials/index.html#java_collections
 *	- Recording of lecture on implementing compareTo and using Arrays.sort(...):
 *		https://youtu.be/mDpDRLEy-7Y
 */

public class Database {
	
	public static void main(String[] args) {
		/*
		Map<String, Double> h = new HashMap<String, Double>();
		h.put("Rajan", 100.0);
		h.put("Raja", 91.0);
		h.put("Raj",  1100.0);
		
		for(String val : h.keySet()) {
			System.out.println(val + " : " + h.get(val));
		}
		
		System.out.println();
		
		Set<Map.Entry<String, Double>> set = h.entrySet();
		for(Map.Entry<String, Double> mp : set) {
			System.out.println(mp.getKey() + " : " + mp.getValue());
		}
		
		System.out.println();
		
		TreeMap<String, Double> tmap = new TreeMap<>(h);
		System.out.println("Keys in ascending order: ");
		System.out.println(tmap);
		
		
		ArrayList<String> list1 = new ArrayList<>();
		Iterator<String> it1 = list1.iterator();
		while(it1.hasNext()) {
			System.out.println(it1.next());
		}
		*/
		
	}
	/*
	 * Each entry in a 'departments' map contains a unique department id and its
	 * associated information object.
	 */
	HashMap<Integer, DepartmentInfo> departments;

	/*
	 * Each entry in a 'employees' map contains a unique employee id and its
	 * associated information object.
	 */
	HashMap<String, EmployeeInfo> employees;

	/**
	 * Initialize an empty database.
	 */
	public Database() {
		/* Your Task */
		departments = new HashMap<Integer, DepartmentInfo>();
		employees = new HashMap<String, EmployeeInfo>();
	}

	/**
	 * Add a new employee entry.
	 * 
	 * @param id
	 *            id of the new employee
	 * @param info
	 *            information object of the new employee
	 * @throws IdAlreadyExistsExceptoin
	 *             if 'id' is an existing employee id
	 */
	public void addEmployee(String id, EmployeeInfo info) throws IdAlreadyExistsExceptoin {
		/* Your Task */
		if (employees.containsKey(id)) 
			throw new IdAlreadyExistsExceptoin("Id already exists");
	
		employees.put(id, info);
	}

	/**
	 * Remove an existing employee entry.
	 * 
	 * @param id
	 *            id of some employee
	 * @throws IdNotFoundException
	 *             if 'id' is not an existing employee id
	 */
	public void removeEmployee(String id) throws IdNotFoundException {
		/* Your Task */
		if (!employees.containsKey(id)) {
			throw new IdNotFoundException("Id not found in the map");
		} else {
			employees.remove(id);
		}
	}

	/**
	 * Add a new department entry.
	 * 
	 * @param id
	 *            id of the new department
	 * @param info
	 *            information object of the new department
	 * @throws IdAlreadyExistsExceptoin
	 *             if 'id' is an existing department id
	 */
	public void addDepartment(Integer id, DepartmentInfo info) throws IdAlreadyExistsExceptoin {
		/* Your Task */
		if (departments.containsKey(id)) {
			throw new IdAlreadyExistsExceptoin("Id already exists in the map");
		} else {
			departments.put(id, info);
		}
	}

	/**
	 * Remove an existing department entry.
	 * 
	 * @param id
	 *            id of some employee
	 * @throws IdNotFoundException
	 *             if 'id' is not an existing employee id
	 */
	public void removeDepartment(Integer id) throws IdNotFoundException {
		/* Your Task */
		if (!departments.containsKey(id)) {
			throw new IdNotFoundException("Id not found in the map");
		} else {
			departments.remove(id);
		}
	}

	/**
	 * Change the department of employee with id 'eid' to a new department with id
	 * 'did'.
	 * 
	 * You can assume that 'did' denotes a department different from the current
	 * department of the employee denoted by 'eid'.
	 * 
	 * @param eid
	 *            id of some employee
	 * @param did
	 *            id of some department
	 * @throws IdNotFoundException
	 *             if either eid is a non-existing employee id or did is a
	 *             non-existing department id.
	 */
	public void changeDepartment(String eid, Integer did) throws IdNotFoundException {
		/* Your Task */
		if (!employees.containsKey(eid) || !departments.containsKey(did)) {
			throw new IdNotFoundException("eid or did is/are non existing");
		}
		(employees.get(eid)).setDepartmentId(did);
	}

	/**
	 * Retrieve the name of employee with id 'id'.
	 * 
	 * @param id
	 *            id of some employee
	 * @return name of the employee with id 'id'
	 * @throws IdNotFoundException
	 *             if 'id' is not an existing employee id
	 */
	public String getEmployeeName(String id) throws IdNotFoundException {
		/* Your Task */
		if (!employees.containsKey(id)) {
			throw new IdNotFoundException("eid or did was not found");
		}
		return employees.get(id).getName();
	}

	/**
	 * Retrieve the names of all employees of the department with id 'id'. If 'id' a
	 * non-existing department id, then return an empty list.
	 * 
	 * @param id
	 *            id of some department
	 * @return List of names of employees whose home department has id 'id'
	 */
	public ArrayList<String> getEmployeeNames(Integer id) {
		/* Your Task */
		ArrayList<String> res = new ArrayList<String>();
		if (departments.containsKey(id)) {
			for (EmployeeInfo value : employees.values()) {
				if (value.getDepartmentId().equals(id)) {
					res.add(value.getName());
				}
			}
		}
		return res;
	}

	/**
	 * Retrieve an employee's department's information object.
	 * 
	 * @param id
	 *            id of some existing employee
	 * @return The information object of the employee's home department
	 * @throws IdNotFoundException
	 *             if 'id' is not an existing employee id
	 */
	public DepartmentInfo getDepartmentInfo(String id) throws IdNotFoundException {
		/* Your Task */

		if (!employees.containsKey(id)) {
			throw new IdNotFoundException("eid or did was not found");
		}
		Integer dId = employees.get(id).getDepartmentId();
		return departments.get(dId);
	}

	/**
	 * Retrieve a list, sorted in increasing order, the information objects of all
	 * stored employees.
	 * 
	 * Hints: 1. Override the 'comareTo' method in EmployeeInfo class. 2. Look up
	 * the Arrays.sort method in Java API.
	 * 
	 * @return A sorted list of information objects of all employees.
	 */
	public EmployeeInfo[] getSortedEmployeeInfo() {
		/* Your Task */
		EmployeeInfo[] x = new EmployeeInfo[employees.size()];
		int i = 0; // iterator for the array
		for (EmployeeInfo value : employees.values()) {
			if (i > employees.size())
				break;
			else
				x[i++] = value;
		}
		Arrays.sort(x);
		return x;
	}

	/**
	 * Retrieve the average salary of all employees in department with id 'id'.
	 * 
	 * @param id
	 *            id of some department
	 * @return average salary of all employees in department with id 'id'
	 * @throws IdNotFoundException
	 *             if id is not an existing department id
	 */
	public double getAverageSalary(Integer id) throws IdNotFoundException {
		/* Your Task */
		double total = 0.0;
		int counter = 0;
		if (!departments.containsKey(id)) {
			throw new IdNotFoundException("Id is not an existing department id");
		} else {
			for (EmployeeInfo value : employees.values()) {
				if (value.getDepartmentId().equals(id)) {
					total += value.getSalary();
					counter++;
				}
			}
		}
		return total / counter;
	}

	/**
	 * Retrieve the information object of the department with the highest average
	 * salary among its employees.
	 * 
	 * @return the information object of the department with the highest average
	 *         salary among its employees
	 * 
	 *         Hint: Use 'getAverageSalary(Integer id)' as a helper method.
	 */
	public DepartmentInfo getDepartmentOfHighestAverageSalary() {
		/* Your Task */
		// DepartmentInfo max = new DepartmentInfo("", "");
		double maxAvg = 0.0;
		Integer depKey = 0;
		for (EmployeeInfo value : employees.values()) {
			try {
				if (getAverageSalary(value.getDepartmentId()) > maxAvg) {
					maxAvg = getAverageSalary(value.getDepartmentId());
					depKey = value.getDepartmentId();
				}
			} catch (IdNotFoundException e) {
				e.printStackTrace();
			}
		}
		return departments.get(depKey);
	}
}
