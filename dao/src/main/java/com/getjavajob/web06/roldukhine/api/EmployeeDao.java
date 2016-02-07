package com.getjavajob.web06.roldukhine.api;

import com.getjavajob.web06.roldukhine.entity.Employee;

public interface EmployeeDao extends CrudDao<Employee> {
    void delete(long id);

    String getTableName();

    void updatePhoto(Employee employee, byte[] photo);
}