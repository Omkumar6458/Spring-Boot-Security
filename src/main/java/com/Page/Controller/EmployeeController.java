package com.Page.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.Page.entity.Employee;
import com.Page.model.EmployeeModel;
import com.Page.repository.EmployeeRepository;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeRepository repository;

    @GetMapping("/index")
    public String getIndexPage() {
        return "index";
    }
    @GetMapping("/denied")
    public String accessDenied() {
        return "denied"; // resolves to /WEB-INF/views/denied.jsp
    }
    @GetMapping("/home")
    public String showHomePage() {
        return "home"; // Refers to index.html in src/main/resources/templates
    }
    @GetMapping("/login")
    public String home1() {
        return "login";  // will load index.jsp
    }

    
    @GetMapping("/login1")
    public String home2() {
        return "login1";  // will load index.jsp
    }
    @GetMapping("/login2")
    public String home3() {
        return "login2";  // will load index.jsp
    }
    
    
    
    @GetMapping("/")
    public String home() {
        return "index";  // will load index.jsp
    }

    
    @GetMapping("/addEmployee")
    public String getAddEmployeePage(Model model) {
        EmployeeModel empModel = new EmployeeModel();
        model.addAttribute("empModel", empModel);
        return "addEmployee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("empModel") EmployeeModel empModel, Model model) {
        Employee e = new Employee();
        BeanUtils.copyProperties(empModel, e);

        boolean flag = repository.existsById(e.getEmpno());

        if (flag) {
            model.addAttribute("message", "EMPLOYEE ALREADY EXISTS");
        } else {
            repository.save(e);
            model.addAttribute("message", "EMPLOYEE ADDED TO DATABASE");
        }
        return "index";
    }

    @GetMapping("/listEmployees")
    public String listEmployees(Model model) {
        List<Employee> emplist = repository.findAll();
        List<EmployeeModel> empModelList = new ArrayList<>();

        emplist.forEach(e -> {
            EmployeeModel emodel = new EmployeeModel();
            BeanUtils.copyProperties(e, emodel);  // ✅ fixed
            empModelList.add(emodel);
        });

        model.addAttribute("empModelList", empModelList);
        return "employeesList"; // ✅ match JSP name
    }

    @GetMapping("/editEmployee")
    public String editEmployeePage(@RequestParam("id") int empno, Model model) {
        Employee e = repository.findById(empno).get();
        EmployeeModel emodel = new EmployeeModel();

        BeanUtils.copyProperties(e, emodel); // ✅ fixed
        model.addAttribute("emodel", emodel);

        return "editEmployee";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("emodel") EmployeeModel emodel) {
        Employee e = new Employee();
        BeanUtils.copyProperties(emodel, e);
        repository.saveAndFlush(e);

        return "redirect:/listEmployees"; // ✅ fixed
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("id") int empno) {
        repository.deleteById(empno);
        return "redirect:/listEmployees"; // ✅ fixed
    }
}
