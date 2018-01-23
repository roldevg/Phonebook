package com.getjavajob.roldukhine.jdbc;

import com.getjavajob.roldukhine.api.EmployeeDao;
import com.getjavajob.roldukhine.entity.Employee;
import com.getjavajob.roldukhine.entity.Phone;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:dao-context.xml", "classpath:dao-context-override.xml"})
@ActiveProfiles("jdbc")
public class EmployeeDaoJdbcImplTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testInsert() throws Exception {
        Employee employee = createTestEmployee();
        employeeDao.insert(employee);
        Assert.assertNotEquals(0, employee.getId());
    }

    @Test
    void testGetAllWithHibernate() {
        employeeDao.getAll();
    }

    @Test
    void testSelect() throws Exception {
        Employee employee = createTestEmployee();
        employee.setPhoneList(new ArrayList<Phone>());
        employeeDao.insert(employee);
        long id = employee.getId();
        employeeDao.get(id);
    }

    @Test
    void testDelete() throws Exception {
        Employee employee = new Employee();
        employee.setFirstName("Petrov");
        employee.setSecondName("Petrov");
        employee.setLastName("Petrov");
        employeeDao.insert(employee);
        employeeDao.delete(employee);
    }

    @Test
    void testUpdate() throws Exception {
        Employee employee = new Employee();
        employee.setFirstName("Petrov");
        employee.setSecondName("Petrov");
        employee.setLastName("Petrov");
        employee.setDepartment(null);
        employeeDao.insert(employee);
        Assert.assertEquals("Petrov", employee.getLastName());
        employeeDao.update(employee);
        employeeDao.delete(employee);
    }

    @Test
    void testUpdatePhoto() throws Exception {
        Employee employee = new Employee();
        employee.setFirstName("Petrov");
        employee.setSecondName("Petrov");
        employee.setLastName("Petrov");
        employeeDao.insert(employee);
        byte[] photo = new byte[10];
        employeeDao.updatePhoto(employee, photo);
        Employee employeeAfterUpdate = employeeDao.get(employee.getId());
        Assert.assertEquals(employeeAfterUpdate, employee);
    }

    private Employee createTestEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Ivan");
        employee.setSecondName("Petrovich");
        employee.setLastName("Petrov");
        employee.setEmail("ivan@petrov.ru");
        employee.setWorkAddress("SPB");
        employee.setHomeAddress("Moscow");
        employee.setSkype("petrovSkype");
        employee.setNote("note");
        return employee;
    }
}