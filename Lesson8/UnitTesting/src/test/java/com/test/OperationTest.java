package com.test;

import com.Employee;
import com.Operation;
import junit.framework.TestCase;
import org.junit.Test;

public class OperationTest extends TestCase {

    @Test
    public void testAdd(){
        Operation op = new Operation();
        int result = op.add(100,200);
        assertEquals(-100,result);
    }

    @Test
    public void testGetEmployeeDetails() {
        Operation op = new Operation();
        Employee emp = op.getEmployeeDetails();
        assertNotNull(emp);
        assertEquals(500.0f,emp.getSalary());
    }


}