package com.employee.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Jobs {
    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    @Id
    private Long jobId;
    @ManyToOne
    @JoinColumn(name = "Employee_id", referencedColumnName = "id")
    private Employee employee;
    private double profit;

}
